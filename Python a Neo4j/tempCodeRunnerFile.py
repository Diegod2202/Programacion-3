from flask import Flask, request, jsonify
from flask_cors import CORS  # Importar CORS
from neo4j import GraphDatabase

app = Flask(__name__)
CORS(app)  # Habilitar CORS para todas las rutas

class Neo4jCRUD:
    def __init__(self, uri, user, password):
        self.driver = GraphDatabase.driver(uri, auth=(user, password))

    def close(self):
        self.driver.close()

    def create_person(self, name, age):
        with self.driver.session() as session:
            return session.execute_write(self._create_person, name, age)

    @staticmethod
    def _create_person(tx, name, age):
        query = "CREATE (p:Person {name: $name, age: $age}) RETURN p"
        result = tx.run(query, name=name, age=age)
        record = result.single()
        return record["p"] if record else None

    def read_person(self, name):
        with self.driver.session() as session:
            return session.execute_read(self._read_person, name)

    @staticmethod
    def _read_person(tx, name):
        query = "MATCH (p:Person {name: $name}) RETURN p"
        result = tx.run(query, name=name)
        return [record["p"] for record in result]

    def update_person_age(self, name, new_age):
        with self.driver.session() as session:
            return session.execute_write(self._update_person_age, name, new_age)

    @staticmethod
    def _update_person_age(tx, name, new_age):
        query = "MATCH (p:Person {name: $name}) SET p.age = $new_age RETURN p"
        result = tx.run(query, name=name, new_age=new_age)
        record = result.single()
        return record["p"] if record else None

    def delete_person(self, name):
        with self.driver.session() as session:
            session.execute_write(self._delete_person, name)

    @staticmethod
    def _delete_person(tx, name):
        query = "MATCH (p:Person {name: $name}) DELETE p"
        tx.run(query, name=name)

neo4j_crud = Neo4jCRUD("neo4j+s://1af53478.databases.neo4j.io", "neo4j", "qJwl-ycQN4aZZOCz6HKWDIkB0j6aHssZ9pSxTVJhz7o")

@app.route('/person', methods=['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'])
def handle_person():
    if request.method == 'OPTIONS':
        # Respuesta para solicitudes CORS preflight
        return jsonify({"message": "OK"}), 200
    elif request.method == 'GET':
        name = request.args.get('name')
        persons = neo4j_crud.read_person(name)
        if persons:
            return jsonify([dict(person) for person in persons])
        else:
            return jsonify({"error": "Person not found"}), 404
    elif request.method == 'POST':
        data = request.json
        name = data.get('name')
        age = data.get('age')
        if not name or not age:
            return jsonify({"error": "Name and age are required"}), 400
        created_person = neo4j_crud.create_person(name, age)
        if created_person:
            return jsonify(dict(created_person)), 201
        else:
            return jsonify({"error": "Failed to create person"}), 500
    elif request.method == 'PUT':
        data = request.json
        name = data.get('name')
        new_age = data.get('age')
        updated_person = neo4j_crud.update_person_age(name, new_age)
        if updated_person:
            return jsonify(dict(updated_person))
        else:
            return jsonify({"error": "Person not found"}), 404
    elif request.method == 'DELETE':
        name = request.args.get('name')
        if not name:
            return jsonify({"error": "Name is required"}), 400
        neo4j_crud.delete_person(name)
        return jsonify({"message": "Person deleted successfully"}), 200

if __name__ == '__main__':
    app.run(debug=True)