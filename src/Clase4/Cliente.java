package Clase4;

public class Cliente {
    int id;
    String nombre;
    double scoring;

    public Cliente(int id, String nombre, double scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + '}';
    }
}
