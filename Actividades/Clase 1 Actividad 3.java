import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double numero2 = scanner.nextDouble();

   
        System.out.print("Ingrese la operación (suma, resta, multiplicacion, division): ");
        String operacion = scanner.next();

        double resultado = Operaciones.realizarOperacion(numero1, numero2, operacion);

        if (!Double.isNaN(resultado)) {
            System.out.println("El resultado de la " + operacion + " es: " + resultado);
        } else {
            System.out.println("Operación no válida.");
        }

        scanner.close();
    }
}

class Operaciones {

    public static double realizarOperacion(double numero1, double numero2, String operacion) {
        switch (operacion.toLowerCase()) {
            case "suma":
                return sumar(numero1, numero2);
            case "resta":
                return restar(numero1, numero2);
            case "multiplicacion":
                return multiplicar(numero1, numero2);
            case "division":
                return dividir(numero1, numero2);
            default:
                return Double.NaN; 
        }
    }


    private static double sumar(double numero1, double numero2) {
        return numero1 + numero2;
    }


    private static double restar(double numero1, double numero2) {
        return numero1 - numero2;
    }

    private static double multiplicar(double numero1, double numero2) {
        return numero1 * numero2;
    }

  
    private static double dividir(double numero1, double numero2) {
        if (numero2 != 0) {
            return numero1 / numero2;
        } else {
            System.out.println("Error: No se puede dividir por cero.");
            return Double.NaN;
        }
    }
}