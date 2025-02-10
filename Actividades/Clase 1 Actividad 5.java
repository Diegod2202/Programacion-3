import java.util.ArrayList;
import java.util.List;

// Clase abstracta Vehiculo
abstract class Vehiculo {
    protected String matricula;
    protected String marca;
    protected String modelo;

    // Constructor
    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método abstracto para mostrar información del vehículo
    public abstract void mostrarInformacion();
}

// Clase Auto
class Auto extends Vehiculo {
    private int cantidadDePuertas;

    // Constructor
    public Auto(String matricula, String marca, String modelo, int cantidadDePuertas) {
        super(matricula, marca, modelo);
        this.cantidadDePuertas = cantidadDePuertas;
    }

    // Implementación del método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        System.out.println("Auto - Matrícula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", Puertas: " + cantidadDePuertas);
    }
}

// Clase Camion
class Camion extends Vehiculo {
    private double capacidadDeCarga; // en toneladas

    // Constructor
    public Camion(String matricula, String marca, String modelo, double capacidadDeCarga) {
        super(matricula, marca, modelo);
        this.capacidadDeCarga = capacidadDeCarga;
    }

    // Implementación del método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        System.out.println("Camión - Matrícula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", Capacidad de carga: " + capacidadDeCarga + " toneladas");
    }
}

// Clase Moto
class Moto extends Vehiculo {
    private String tipoDeMoto;

    // Constructor
    public Moto(String matricula, String marca, String modelo, String tipoDeMoto) {
        super(matricula, marca, modelo);
        this.tipoDeMoto = tipoDeMoto;
    }

    // Implementación del método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        System.out.println("Moto - Matrícula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", Tipo: " + tipoDeMoto);
    }
}

// Clase principal
public class Concesionario {
    public static void main(String[] args) {
        // Crear objetos de cada tipo de vehículo
        Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 4);
        Camion camion1 = new Camion("XYZ789", "Volvo", "FH16", 20.5);
        Moto moto1 = new Moto("DEF456", "Yamaha", "MT-07", "Deportiva");

        // Almacenar los vehículos en una lista
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto1);
        vehiculos.add(camion1);
        vehiculos.add(moto1);

        // Mostrar la información de todos los vehículos
        System.out.println("Información de los vehículos en el concesionario:");
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInformacion();
        }
    }
}
