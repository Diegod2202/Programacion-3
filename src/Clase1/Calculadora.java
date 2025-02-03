package Clase1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar el primer número
            double numero1 = pedirNumero(scanner, "Ingresa el primer número: ");

            // Solicitar el segundo número
            double numero2 = pedirNumero(scanner, "Ingresa el segundo número: ");

            // Solicitar la operación matemática
            System.out.println("Selecciona una operación:");
            System.out.println("1: Suma");
            System.out.println("2: Resta");
            System.out.println("3: Multiplicación");
            System.out.println("4:a División");
            int operacion = scanner.nextInt();

            // Realizar la operación seleccionada
            double resultado;
            switch (operacion) {
                case 1:
                    resultado = numero1 + numero2;
                    System.out.println("El resultado de la suma es: " + resultado);
                    break;
                case 2:
                    resultado = numero1 - numero2;
                    System.out.println("El resultado de la resta es: " + resultado);
                    break;
                case 3:
                    resultado = numero1 * numero2;
                    System.out.println("El resultado de la multiplicación es: " + resultado);
                    break;
                case 4:
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                        System.out.println("El resultado de la división es: " + resultado);
                    } else {
                        System.out.println("Error: No se puede dividir entre cero.");
                    }
                    break;
                default:
                    System.out.println("Operación no válida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingresa un número.");
        } finally {
            scanner.close();
        }
    }

    private static double pedirNumero(Scanner scanner, String mensaje) throws InputMismatchException {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }
}