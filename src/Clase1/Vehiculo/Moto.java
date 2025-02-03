package Clase1.Vehiculo;

public class Moto extends Vehiculo{
    private String tipoDeMoto;

    public Moto(String marca, String modelo, String matricula, String tipoDeMoto) {
        super(marca, modelo, matricula);
        this.tipoDeMoto = tipoDeMoto;
    }

    public String getCilindrada() {
        return tipoDeMoto;
    }

    @Override
    public String toString() {
        return "Moto [Marca: " + marca + ", Modelo: " + modelo + ", Matrícula: " + matricula + ", Tipo: " + tipoDeMoto + "]";
    }
}
