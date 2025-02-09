package Clase_1.Actividad_5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Auto("Toyota", "Corolla", "ABC123", 4));
        vehiculos.add(new Camion("Volvo", "FH16", "DEF456", 20000));
        vehiculos.add(new Moto("Yamaha", "MT-07", "GHI789", "Deportiva"));


        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInfo();
            System.out.println();
        }
    }
}
