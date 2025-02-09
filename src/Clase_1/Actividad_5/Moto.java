package Clase_1.Actividad_5;

public class Moto extends Vehiculo{
    String TipoDeMoto;

    public Moto(String marca, String modelo, String patente, String tipoDeMoto) {
        super(marca, modelo, patente);
        TipoDeMoto = tipoDeMoto;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Patente: " + getPatente());
        System.out.println("Tipo de moto: " + TipoDeMoto);
    }
}
