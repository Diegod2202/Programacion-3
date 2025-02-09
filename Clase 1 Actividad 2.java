public class Main {

    public static void main(String[] args) {
        // Declaración de variables
        int edad = 38; 
        double altura = 1,88; 
        char inicial = 'M'; 
        String ciudad = "Capital Federal"; 

        // Operaciones
        int sumaEdad = Operaciones.sumarEdad(edad, 5); 
        double alturaDoble = Operaciones.multiplicarAltura(altura); 
        String mensajeInicial = Operaciones.crearMensajeInicial(inicial); 

        // Impresión de resultados
        System.out.println("Resultado de sumar 5 a la edad: " + sumaEdad);
        System.out.println("Resultado de multiplicar la altura por 2: " + alturaDoble);
        System.out.println(mensajeInicial);
        System.out.println("Ciudad de residencia: " + ciudad);
    }
}

class Operaciones {

    public static int sumarEdad(int edad, int numero) {
        return edad + numero;
    }

    public static double multiplicarAltura(double altura) {
        return altura * 2;
    }

    public static String crearMensajeInicial(char inicial) {
        return "Tu inicial es " + inicial;
    }
}