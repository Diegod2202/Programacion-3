package Clase_5.Actividad_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Lista de monedas disponibles
        List<Integer> monedasDisponibles = new ArrayList<>();
        monedasDisponibles.add(10);
        monedasDisponibles.add(1);
        monedasDisponibles.add(5);
        monedasDisponibles.add(2);
        monedasDisponibles.add(10);
        monedasDisponibles.add(10);
        monedasDisponibles.add(5);
        monedasDisponibles.add(2);
        monedasDisponibles.add(5);
        monedasDisponibles.add(5);
        monedasDisponibles.add(5);
        monedasDisponibles.add(5);
        monedasDisponibles.add(5);
        monedasDisponibles.add(10);

        // Importe para el cual se necesita dar cambio
        int importe = 33;

        // Obtener el cambio
        List<Integer> cambio = darCambio(monedasDisponibles, importe);

        // Mostrar el resultado
        if (cambio != null) {
            System.out.println("Cambio para $" + importe + ": " + cambio);
        } else {
            System.out.println("No se puede dar cambio exacto para $" + importe);
        }
    }

    // Método para dar cambio usando un algoritmo greedy
    public static List<Integer> darCambio(List<Integer> monedasDisponibles, int importe) {
        // Ordenar las monedas en orden descendente
        Collections.sort(monedasDisponibles, Collections.reverseOrder());

        List<Integer> cambio = new ArrayList<>();
        int total = 0;

        // Recorrer las monedas disponibles
        for (int moneda : monedasDisponibles) {
            while (total + moneda <= importe) {
                cambio.add(moneda);
                total += moneda;
            }
        }

        // Verificar si se pudo dar el cambio exacto
        if (total == importe) {
            return cambio;
        } else {
            return null; // No se puede dar cambio exacto
        }
    }
}
