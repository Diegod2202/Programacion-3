package Clase4;

import java.util.Arrays;
import java.util.List;

public class Actividad2 {

    // Método principal para encontrar los dos números mayores
    public static int[] buscarDosNumerosMayores(List<Integer> numeros, int inicio, int fin) {
        // Caso base: si hay un solo número
        if (inicio == fin) {
            return new int[]{numeros.get(inicio), Integer.MIN_VALUE};
        }

        // Dividir: calcular el punto medio
        int medio = (inicio + fin) / 2;

        // Resolver recursivamente para ambas mitades
        int[] maxIzquierda = buscarDosNumerosMayores(numeros, inicio, medio);
        int[] maxDerecha = buscarDosNumerosMayores(numeros, medio + 1, fin);

        // Combinar: encontrar los dos números mayores entre las dos mitades
        int[] resultado = new int[2];
        int[] todos = {maxIzquierda[0], maxIzquierda[1], maxDerecha[0], maxDerecha[1]};
        Arrays.sort(todos);
        resultado[0] = todos[3];
        resultado[1] = todos[2];

        return resultado;
    }

    public static void main(String[] args) {
        // Crear una lista de números
        List<Integer> numeros = List.of(11, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Llamar al método recursivo para encontrar los dos números mayores
        int[] dosNumerosMayores = buscarDosNumerosMayores(numeros, 0, numeros.size() - 1);

        // Mostrar el resultado
        System.out.println("Dos números mayores: " + dosNumerosMayores[0] + ", " + dosNumerosMayores[1]);
    }
}