import java.util.ArrayList;
import java.util.List;

public class Actividad5 {
    public static void main(String[] args) {

        Auto auto = new Auto("ABC123", "Toyota", "Corolla", 4);
        Camion camion = new Camion("XYZ987", "Scania", "R450", 20000);
        Moto moto = new Moto("DEF456", "Honda", "CBR1000RR", "Deportiva");

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(auto);
        vehiculos.add(camion);
        vehiculos.add(moto);

        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " - " + vehiculo.getMatricula());
            switch(vehiculo.soyTipo()){
                case "Auto":
                    System.out.println("Cantidad de puertas: " + ((Auto) vehiculo).getCantidadDePuertas());
                    break;
                case "Camion":
                    System.out.println("Capacidad de carga: " + ((Camion) vehiculo).getCapacidadDeCarga());
                    break;
                case "Moto":
                    System.out.println("Tipo de moto: " + ((Moto) vehiculo).getTipoDeMoto());
                    break;
            }
        }
    }
}