package clase1;

import java.util.ArrayList;
import java.util.List;

abstract class Vehiculo {
    private String marca;
    private String modelo;
    private String matricula;

    public Vehiculo(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    // Método abstracto para forzar a las subclases a implementar su propia lógica
    public abstract void mostrarInformacion();

    // Método base para mostrar información común
    protected void mostrarDatosBase() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Matrícula: " + matricula);
    }
}

// Clase clase1.Auto que hereda de clase1.Vehiculo
class Auto extends Vehiculo {
    private int cantidadDePuertas;

    public Auto(String marca, String modelo, String matricula, int cantidadDePuertas) {
        super(marca, modelo, matricula);
        this.cantidadDePuertas = cantidadDePuertas;
    }

    @Override
    public void mostrarInformacion() {
        mostrarDatosBase();
        System.out.println("Cantidad de puertas: " + cantidadDePuertas);
    }
}

// Clase clase1.Camion que hereda de clase1.Vehiculo
class Camion extends Vehiculo {
    private double capacidadDeCarga; // en toneladas

    public Camion(String marca, String modelo, String matricula, double capacidadDeCarga) {
        super(marca, modelo, matricula);
        this.capacidadDeCarga = capacidadDeCarga;
    }

    @Override
    public void mostrarInformacion() {
        mostrarDatosBase();
        System.out.println("Capacidad de carga: " + capacidadDeCarga + " toneladas");
    }
}

// Clase clase1.Moto que hereda de clase1.Vehiculo
class Moto extends Vehiculo {
    private String tipoDeMoto;

    public Moto(String marca, String modelo, String matricula, String tipoDeMoto) {
        super(marca, modelo, matricula);
        this.tipoDeMoto = tipoDeMoto;
    }

    @Override
    public void mostrarInformacion() {
        mostrarDatosBase();
        System.out.println("Tipo de clase1.moto: " + tipoDeMoto);
    }
}

// Clase principal
public class clase1Actividad5continuacion {
    public static void main(String[] args) {
        // Lista para almacenar vehículos
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        // Creación de objetos
        listaVehiculos.add(new Auto("Toyota", "Corolla", "ABC123", 4));
        listaVehiculos.add(new Camion("Volvo", "FH16", "DEF456", 18.5));
        listaVehiculos.add(new Moto("Yamaha", "YZF-R3", "GHI789", "Deportiva"));

        // Mostrar información de todos los vehículos
        System.out.println("Información de los vehículos:");
        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println("-------------------------------");
            vehiculo.mostrarInformacion();
        }
    }
}
