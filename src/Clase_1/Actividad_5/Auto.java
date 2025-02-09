package Clase_1.Actividad_5;

public class Auto extends Vehiculo {

    private int cantidadDePuertas;

    public Auto(String marca, String modelo, String patente, int cantidadDePuertas) {
        super(marca, modelo, patente);
        this.cantidadDePuertas = cantidadDePuertas;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Patente: " + getPatente());
        System.out.println("Cantidad de puertas: " + cantidadDePuertas);
    }
}
