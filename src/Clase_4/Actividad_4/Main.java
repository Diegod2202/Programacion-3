package Clase_4.Actividad_4;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] lista = {10, 5, 20, 15, 30, 25}; // Lista de números
        int n = 3; // Número de elementos máximos a encontrar

        List<Integer> maximos = encontrarNMaximos(lista, 0, lista.length - 1, n);

        System.out.println("Los " + n + " elementos más grandes son: " + maximos);
    }

    // Método para encontrar los "n" elementos más grandes usando Divide y Conquista
    public static List<Integer> encontrarNMaximos(int[] lista, int inicio, int fin, int n) {
        List<Integer> maximos = new ArrayList<>();

        // Caso base: no se requieren elementos
        if (n <= 0) {
            return maximos;
        }

        // Caso base: un solo elemento
        if (inicio == fin) {
            maximos.add(lista[inicio]);
            return maximos;
        }

        // Dividir la lista en dos mitades
        int medio = inicio + (fin - inicio) / 2;

        // Resolver recursivamente para cada mitad
        List<Integer> maximosIzquierda = encontrarNMaximos(lista, inicio, medio, n);
        List<Integer> maximosDerecha = encontrarNMaximos(lista, medio + 1, fin, n);

        // Combinar: encontrar los "n" máximos entre las dos mitades
        return combinarMaximos(maximosIzquierda, maximosDerecha, n);
    }

    // Método para combinar los máximos de ambas mitades
    private static List<Integer> combinarMaximos(List<Integer> maximosIzquierda, List<Integer> maximosDerecha, int n) {
        List<Integer> maximosCombinados = new ArrayList<>();
        int i = 0, j = 0;

        // Combinar los máximos de ambas mitades hasta obtener "n" elementos
        while (i < maximosIzquierda.size() && j < maximosDerecha.size() && maximosCombinados.size() < n) {
            if (maximosIzquierda.get(i) > maximosDerecha.get(j)) {
                maximosCombinados.add(maximosIzquierda.get(i));
                i++;
            } else {
                maximosCombinados.add(maximosDerecha.get(j));
                j++;
            }
        }

        // Agregar los elementos restantes de la mitad izquierda
        while (i < maximosIzquierda.size() && maximosCombinados.size() < n) {
            maximosCombinados.add(maximosIzquierda.get(i));
            i++;
        }

        // Agregar los elementos restantes de la mitad derecha
        while (j < maximosDerecha.size() && maximosCombinados.size() < n) {
            maximosCombinados.add(maximosDerecha.get(j));
            j++;
        }

        return maximosCombinados;
    }
}
