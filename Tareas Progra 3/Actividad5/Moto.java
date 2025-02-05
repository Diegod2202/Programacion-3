public class Moto extends Vehiculo{

    private String tipoDeMoto;

    public Moto(String matricula, String marca, String modelo, String tipoDeMoto) {
        super(matricula, marca, modelo);
        this.tipoDeMoto = tipoDeMoto;
    }

    public String getTipoDeMoto() {
        return tipoDeMoto;
    }

    @Override
    public String soyTipo() {
        return "Moto";
    }
}
