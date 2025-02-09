 class vehiculo{
        private String marca;
        private String modelo;
        private String matricula;

        public vehiculo(String marca, String modelo, String matricula) {
            this.marca = marca;
            this.modelo = modelo;
            this.matricula = matricula;
        }

        public void mostrarInformacion(){
            System.out.println("Marca: " + marca);
            System.out.println("Modelo: " + modelo);
            System.out.println("Matricula: " + matricula);
        }
    }

    class auto extends vehiculo{
        private int cantidadDePuertas;
        public auto(String marca, String modelo, String matricula, int cantidadDePuertas) {
            super(marca, modelo, matricula);
            this.cantidadDePuertas = cantidadDePuertas;
        }

        public void mostrarInformacion(){
            super.mostrarInformacion();
            System.out.println("Cantidad de Puertas: " + cantidadDePuertas);
        }
    }

    class camion extends vehiculo{
        private int capacidadDeCarga;
        public camion(String marca, String modelo, String matricula, int capacidadDeCarga) {
            super(marca, modelo, matricula);
            this.capacidadDeCarga = capacidadDeCarga;
        }
        public void mostrarInformacion(){
            super.mostrarInformacion();
            System.out.println("Capacidad de Carga: " + capacidadDeCarga);
        }
    }

    class moto extends vehiculo{
        private String tipoDeMoto;
        public moto(String marca, String modelo, String matricula, String tipoDeMoto) {
            super(marca, modelo, matricula);
            this.tipoDeMoto = tipoDeMoto;
        }
        public void mostrarInformacion(){
            super.mostrarInformacion();
            System.out.println("Tipo de Moto: " + tipoDeMoto);
        }
    }

public class clase1Actividad5{
    public static void main(String[] args) {
            moto moto = new moto("Honda", "600C", "kui727", "Deportiva");
            auto auto = new auto("Peugeot", "208", "iuk272", 4);
            camion camion = new camion("Iveco", "Loco", "jef202", 200);

        System.out.println("Informacion de Moto");
            moto.mostrarInformacion();
        System.out.println();
        System.out.println("Informacion de Auto");
            auto.mostrarInformacion();
        System.out.println();
        System.out.println("Informacion de Camion");
            camion.mostrarInformacion();
        }
    }
