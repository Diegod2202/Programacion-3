from neo4j import GraphDatabase

class Neo4jCRUD:
    def __init__(self, uri, user, password):
        self.driver = GraphDatabase.driver(uri, auth=(user, password))

    def close(self):
        self.driver.close()

    def create_person(self, name, age):
        with self.driver.session() as session:
            session.write_transaction(self._create_person, name, age)

    @staticmethod
    def _create_person(tx, name, age):
        query = (
            "CREATE (p:Person {name: $name, age: $age}) "
            "RETURN p"
        )
        result = tx.run(query, name=name, age=age)
        return result.single()[0]

    def read_person(self, name):
        with self.driver.session() as session:
            result = session.read_transaction(self._read_person, name)
            return result

    @staticmethod
    def _read_person(tx, name):
        query = "MATCH (p:Person {name: $name}) RETURN p"
        result = tx.run(query, name=name)
        return [record["p"] for record in result]

    def update_person_age(self, name, new_age):
        with self.driver.session() as session:
            session.write_transaction(self._update_person_age, name, new_age)

    @staticmethod
    def _update_person_age(tx, name, new_age):
        query = (
            "MATCH (p:Person {name: $name}) "
            "SET p.age = $new_age "
            "RETURN p"
        )
        result = tx.run(query, name=name, new_age=new_age)
        return result.single()[0]

    def delete_person(self, name):
        with self.driver.session() as session:
            session.write_transaction(self._delete_person, name)

    @staticmethod
    def _delete_person(tx, name):
        query = "MATCH (p:Person {name: $name}) DELETE p"
        tx.run(query, name=name)

if __name__ == "__main__":
    uri = "neo4j+s://94fcd69d.databases.neo4j.io"
    user = "neo4j"
    password = "pGUu2-8As179f9kruWulOyk1_r3Th6DaiwRFEFFXjbc"

    neo4j_crud = Neo4jCRUD(uri, user, password)

    # Crear una persona
    neo4j_crud.create_person("Alice", 30)

    # Leer una persona
    persons = neo4j_crud.read_person("Alice")
    for person in persons:
        print(person)

    # Actualizar la edad de una persona
    neo4j_crud.update_person_age("Alice", 31)

    # Leer de nuevo para verificar la actualización
    persons = neo4j_crud.read_person("Alice")
    for person in persons:
        print(person)

    # Eliminar una persona
    neo4j_crud.delete_person("Alice")

    neo4j_crud.close()





















