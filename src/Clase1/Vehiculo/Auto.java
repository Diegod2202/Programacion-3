package Clase1.Vehiculo;

public class Auto extends Vehiculo{
    private int cantidadDePuertas;

    public Auto(String marca, String modelo, String matricula, int puertas, String color) {
        super(marca, modelo, matricula);
        this.cantidadDePuertas = puertas;
    }

    public int getPuertas() {
        return cantidadDePuertas;
    }

    @Override
    public String toString() {
        return "Auto [Marca: " + marca + ", Modelo: " + modelo + ", Matrícula: " + matricula + ", Puertas: " + cantidadDePuertas + "]";
    }
}
