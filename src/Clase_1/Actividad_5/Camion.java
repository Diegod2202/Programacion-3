package Clase_1.Actividad_5;

public class Camion extends Vehiculo {
   private int capacidadDeCarga;

    public Camion(String marca, String modelo, String patente, int capacidadDeCarga) {
        super(marca, modelo, patente);
        this.capacidadDeCarga = capacidadDeCarga;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Patente: " + getPatente());
        System.out.println("Capacidad de carga: " + capacidadDeCarga);
    }
}
