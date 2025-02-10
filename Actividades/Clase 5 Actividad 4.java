import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GreedyFlorist {

    public static int getMinimumCost(int k, int[] c) {
        // Ordenar el arreglo de precios en orden descendente
        Arrays.sort(c);
        reverseArray(c);

        int totalCost = 0;
        int purchases = 0;

        // Recorrer las flores y calcular el costo total
        for (int i = 0; i < c.length; i++) {
            if (i % k == 0) {
                purchases++;
            }
            totalCost += purchases * c[i];
        }

        return totalCost;
    }

    // Método para invertir un arreglo
    private static void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la entrada
        int n = scanner.nextInt(); // Número de flores
        int k = scanner.nextInt(); // Número de amigos

        int[] c = new int[n]; // Precios de las flores
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        // Calcular el costo mínimo
        int minimumCost = getMinimumCost(k, c);

        // Imprimir el resultado
        System.out.println(minimumCost);

        scanner.close();
    }
}