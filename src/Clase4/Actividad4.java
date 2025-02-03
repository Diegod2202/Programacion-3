package Clase4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Actividad4 {

    public static List<Integer> encontrarElementosMayores(List<Integer> list, int n) {
        if (list.size() <= n) {
            return new ArrayList<>(list);
        } else {
            int mitad = list.size() / 2;
            List<Integer> izquierda = encontrarElementosMayores(list.subList(0, mitad), n);
            List<Integer> derecha = encontrarElementosMayores(list.subList(mitad, list.size()), n);
            return unirMayores(izquierda, derecha, n);
        }
    }

    private static List<Integer> unirMayores(List<Integer> izquierda, List<Integer> derecha, int n) {
        List<Integer> merged = new ArrayList<>(izquierda);
        merged.addAll(derecha);
        Collections.sort(merged, Collections.reverseOrder());
        return merged.subList(0, n);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(10, 7, 8, 9, 11, 5, 11, 13, 6);
        int n = 3;
        List<Integer> resultado = encontrarElementosMayores(list, n);
        System.out.println("Los " + n + " números mas grandes son: " + resultado);
    }
}