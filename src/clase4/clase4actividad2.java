package clase4;

import java.util.Arrays;

public class clase4actividad2 {
    public static int[] encontrarDosMayores(int[] nums, int inicio, int fin) {
        // Caso base: si hay solo dos elementos, devolver el mayor y el segundo mayor
        if (fin - inicio == 1) {
            if (nums[inicio] > nums[fin]) {
                return new int[]{nums[inicio], nums[fin]};
            } else {
                return new int[]{nums[fin], nums[inicio]};
            }
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;
        int[] maxIzquierda = encontrarDosMayores(nums, inicio, medio);
        int[] maxDerecha = encontrarDosMayores(nums, medio + 1, fin);

        // Fusionar los resultados para obtener los dos mayores
        int mayor, segundoMayor;
        if (maxIzquierda[0] > maxDerecha[0]) {
            mayor = maxIzquierda[0];
            segundoMayor = Math.max(maxIzquierda[1], maxDerecha[0]);
        } else {
            mayor = maxDerecha[0];
            segundoMayor = Math.max(maxDerecha[1], maxIzquierda[0]);
        }

        return new int[]{mayor, segundoMayor};
    }

    public static void main(String[] args) {
        int[] numeros = {12, 34, 56, 78, 23, 89, 90, 45};

        // Llamada a la función
        int[] resultado = encontrarDosMayores(numeros, 0, numeros.length - 1);

        System.out.println("Los dos números mayores son: " + Arrays.toString(resultado));
    }
}
