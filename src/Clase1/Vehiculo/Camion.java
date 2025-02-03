package Clase1.Vehiculo;

public class Camion extends Vehiculo{
    private int capacidadDeCarga;

    public Camion(String marca, String modelo, String matricula, int capacidad, String color) {
        super(marca, modelo, matricula);
        this.capacidadDeCarga = capacidad;
    }

    public int getCapacidad() {
        return capacidadDeCarga;
    }

    @Override
    public String toString() {
        return "Camión [Marca: " + marca + ", Modelo: " + modelo + ", Matrícula: " + matricula + ", Capacidad de Carga: " + capacidadDeCarga + " toneladas]";
    }
}
