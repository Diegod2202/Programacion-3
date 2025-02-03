package Clase1.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        Auto auto = new Auto("Ford", "Fiesta", "ABC123", 4, "Rojo");
        Camion camion = new Camion("Scania", "R500", "DEF456", 40, "Azul");
        Moto moto = new Moto("Honda", "CBR", "GHI789", "Deportiva");

        vehiculos.add(auto);
        vehiculos.add(camion);
        vehiculos.add(moto);
    }
}
