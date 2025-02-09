import java.util.Scanner;

public class ParImpar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar un número entero al usuario
        System.out.print("Ingrese un número entero: ");
        int n = scanner.nextInt();

        // Validar que el número sea positivo
        if (n < 1) {
            System.out.println("Por favor, ingrese un número mayor o igual a 1.");
        } else {
            // Imprimir los números del 1 al n indicando si son pares o impares
            for (int i = 1; i <= n; i++) {
                if (esPar(i)) {
                    System.out.println(i + " es par.");
                } else {
                    System.out.println(i + " es impar.");
                }
            }
        }

        scanner.close();
    }

    // Método para determinar si un número es par
    private static boolean esPar(int numero) {
        return numero % 2 == 0;
    }
}