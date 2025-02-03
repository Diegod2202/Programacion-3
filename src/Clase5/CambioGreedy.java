package Clase5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CambioGreedy {

    public static List<Integer> cambioGreedy(List<Integer> monedas, int monto) {
        Collections.sort(monedas, Collections.reverseOrder());
        List<Integer> resultado = new ArrayList<>();
        for (int moneda : monedas) {
            while (monto >= moneda) {
                resultado.add(moneda);
                monto -= moneda;
            }
        }
        if (monto != 0) {
            throw new IllegalArgumentException("No se puede dar el cambio exacto");
        }

        return resultado;
    }

    public static void main(String[] args) {
        List<Integer> monedas = new ArrayList<>(List.of(10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 5, 10));
        int monto = 33;
        try {
            List<Integer> cambio = cambioGreedy(monedas, monto);
            System.out.println("Cambio: " + cambio);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}