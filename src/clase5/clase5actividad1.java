package clase5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class clase5actividad1 {
    public static List<Integer> darCambio(List<Integer> monedas, int importe) {
        // Ordenamos las monedas en orden descendente para aplicar el método greedy
        monedas.sort(Collections.reverseOrder());

        List<Integer> cambio = new ArrayList<>();
        int suma = 0;

        for (int moneda : monedas) {
            if (suma + moneda <= importe) {
                cambio.add(moneda);
                suma += moneda;
            }
            if (suma == importe) {
                return cambio; // Se encontró el cambio exacto
            }
        }
        // Si no se puede dar el cambio exacto, devolvemos una lista nula
        return null;
    }

    public static void main(String[] args) {
        List<Integer> monedas = List.of(10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 10);
        int importe = 33;

        List<Integer> resultado = darCambio(new ArrayList<>(monedas), importe);

        if (resultado != null) {
            System.out.println("Cambio entregado: " + resultado);
        } else {
            System.out.println("No se puede dar el cambio exacto.");
        }
    }
}

/* pseudocódigo:
Función darCambio(monedas, importe)
    Ordenar monedas en orden descendente  // Método greedy: usar las monedas más grandes primero

    Definir lista cambio vacía
    suma ← 0

    Para cada moneda en monedas Hacer
        Si suma + moneda ≤ importe Entonces
            Agregar moneda a cambio
            suma ← suma + moneda
        Fin Si

        Si suma == importe Entonces
            Retornar cambio  // Se encontró el cambio exacto
        Fin Si
    Fin Para

    // Si no se puede dar el cambio exacto, retornar una lista nula
    Retornar null
Fin Función

// Programa Principal
Inicio
    Definir lista monedas ← [10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 10]
    Definir importe ← 33

    resultado ← darCambio(monedas, importe)

    Si resultado ≠ null Entonces
        Escribir "Cambio entregado: ", resultado
    Sino
        Escribir "No se puede dar el cambio exacto."
    Fin Si
Fin

 */