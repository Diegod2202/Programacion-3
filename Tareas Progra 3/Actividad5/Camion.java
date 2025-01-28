public class Camion extends Vehiculo{

    private double capacidadDeCarga;

    public Camion(String matricula, String marca, String modelo, double capacidadDeCarga) {
        super(matricula, marca, modelo);
        this.capacidadDeCarga = capacidadDeCarga;
    }

    public double getCapacidadDeCarga() {
        return capacidadDeCarga;
    }
    @Override
    public String soyTipo() {
        return "Camion";
    }
}
