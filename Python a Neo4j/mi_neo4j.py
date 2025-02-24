from flask import Flask, request, jsonify
from flask_cors import CORS
from neo4j import GraphDatabase
from collections import deque

app = Flask(__name__)
CORS(app)

class Neo4jCRUD:
    def __init__(self, uri, user, password):
        self.driver = GraphDatabase.driver(uri, auth=(user, password))

    def close(self):
        self.driver.close()

    def create_person(self, name):
        with self.driver.session() as session:
            return session.execute_write(self._create_person, name)

    @staticmethod
    def _create_person(tx, name):
        query = "CREATE (p:Person {name: $name}) RETURN p"
        result = tx.run(query, name=name)
        record = result.single()
        return record["p"] if record else None

    def create_friendship(self, name1, name2):
        with self.driver.session() as session:
            return session.execute_write(self._create_friendship, name1, name2)

    @staticmethod
    def _create_friendship(tx, name1, name2):
        query = """
        MATCH (p1:Person {name: $name1}), (p2:Person {name: $name2})
        CREATE (p1)-[:FRIEND]->(p2)
        RETURN p1, p2
        """
        result = tx.run(query, name1=name1, name2=name2)
        return result.single()

    def get_friends(self, name):
        with self.driver.session() as session:
            return session.execute_read(self._get_friends, name)

    @staticmethod
    def _get_friends(tx, name):
        query = """
        MATCH (p:Person {name: $name})-[:FRIEND]->(friend)
        RETURN friend
        """
        result = tx.run(query, name=name)
        return [record["friend"] for record in result]

    def shortest_path(self, start_name, end_name):
        with self.driver.session() as session:
            # Obtener todos los datos de amistades
            query = """
            MATCH (p:Person)-[:FRIEND]->(friend:Person)
            RETURN p.name AS person, friend.name AS friend
            """
            result = session.run(query)
            
            # Construir el grafo en Python
            graph = {}
            for record in result:
                person = record["person"]
                friend = record["friend"]
                if person not in graph:
                    graph[person] = []
                if friend not in graph:
                    graph[friend] = []
                graph[person].append(friend)
            
            # Implementar BFS para encontrar el camino más corto
            def bfs(graph, start, end):
                queue = deque([(start, [start])])  # (nodo, camino)
                visited = set()
                
                while queue:
                    node, path = queue.popleft()
                    if node == end:
                        return path
                    if node not in visited:
                        visited.add(node)
                        for neighbor in graph.get(node, []):
                            queue.append((neighbor, path + [neighbor]))
                return None
            
            # Ejecutar BFS
            return bfs(graph, start_name, end_name)

    

neo4j_crud = Neo4jCRUD("neo4j+s://1af53478.databases.neo4j.io", "neo4j", "qJwl-ycQN4aZZOCz6HKWDIkB0j6aHssZ9pSxTVJhz7o")

# Endpoints
@app.route('/person', methods=['POST'])
def create_person():
    data = request.json
    name = data.get('name')
    if not name:
        return jsonify({"error": "Name is required"}), 400
    created_person = neo4j_crud.create_person(name)
    if created_person:
        return jsonify(dict(created_person)), 201
    else:
        return jsonify({"error": "Failed to create person"}), 500

@app.route('/friendship', methods=['POST'])
def create_friendship():
    data = request.json
    name1 = data.get('name1')
    name2 = data.get('name2')
    if not name1 or not name2:
        return jsonify({"error": "Both names are required"}), 400
    friendship = neo4j_crud.create_friendship(name1, name2)
    if friendship:
        return jsonify({"message": "Friendship created successfully"}), 201
    else:
        return jsonify({"error": "Failed to create friendship"}), 500

@app.route('/friends', methods=['GET'])
def get_friends():
    name = request.args.get('name')
    if not name:
        return jsonify({"error": "Name is required"}), 400
    friends = neo4j_crud.get_friends(name)
    if friends:
        return jsonify([dict(friend) for friend in friends])
    else:
        return jsonify({"error": "No friends found"}), 404

@app.route('/shortest-path', methods=['GET'])
def shortest_path():
    start_name = request.args.get('start')
    end_name = request.args.get('end')
    if not start_name or not end_name:
        return jsonify({"error": "Both start and end names are required"}), 400
    path = neo4j_crud.shortest_path(start_name, end_name)
    if path:
        return jsonify(path)
    else:
        return jsonify({"error": "No path found"}), 404

@app.route('/suggest-friends', methods=['GET'])
def suggest_friends():
    name = request.args.get('name')
    if not name:
        return jsonify({"error": "Name is required"}), 400
    suggestions = neo4j_crud.suggest_friends(name)
    if suggestions:
        return jsonify(suggestions)
    else:
        return jsonify({"error": "No suggestions found"}), 404

if __name__ == '__main__':
    app.run(debug=True)