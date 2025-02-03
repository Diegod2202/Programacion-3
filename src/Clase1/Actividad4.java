package Clase1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Actividad4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar un número entero al usuario
            System.out.print("Ingresa un número entero: ");
            int n = scanner.nextInt();

            // Imprimir los números del 1 al n indicando si son pares o impares
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " es par");
                } else {
                    System.out.println(i + " es impar");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingresa un número entero.");
        } finally {
            scanner.close();
        }
    }
}