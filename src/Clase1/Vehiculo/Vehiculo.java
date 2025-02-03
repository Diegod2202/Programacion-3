package Clase1.Vehiculo;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String matricula;


    public Vehiculo(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public abstract String toString();

    public void mostrarInformacion() {
        System.out.println(this.toString());
    }
}