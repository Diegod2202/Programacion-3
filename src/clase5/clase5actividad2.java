package clase5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class clase5actividad2 {
    public static List<Integer> minimizarComprobantes(List<Integer> comprobantes, int monto) {
        // Ordenamos los comprobantes en orden descendente para usar los de mayor valor primero
        comprobantes.sort(Collections.reverseOrder());

        List<Integer> seleccionados = new ArrayList<>();
        int suma = 0;

        for (int comprobante : comprobantes) {
            if (suma + comprobante <= monto) {
                seleccionados.add(comprobante);
                suma += comprobante;
            }
            if (suma == monto) {
                return seleccionados; // Se encontró la combinación óptima
            }
        }
        // Si no se puede alcanzar el monto exacto, devolvemos una lista vacía
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Integer> comprobantes = List.of(100, 50, 20, 10, 5, 2, 1); // Ejemplo de valores de comprobantes
        int monto = 93; // Monto objetivo

        List<Integer> resultado = minimizarComprobantes(new ArrayList<>(comprobantes), monto);

        if (!resultado.isEmpty()) {
            System.out.println("Comprobantes utilizados: " + resultado);
        } else {
            System.out.println("No se puede alcanzar el monto exacto con los comprobantes disponibles.");
        }
    }
}

/* pseudocodigo:
Función minimizarComprobantes(comprobantes, monto)
    Ordenar comprobantes en orden descendente  // Estrategia Greedy: usar los de mayor valor primero

    Definir lista seleccionados vacía
    suma ← 0

    Para cada comprobante en comprobantes Hacer
        Si suma + comprobante ≤ monto Entonces
            Agregar comprobante a seleccionados
            suma ← suma + comprobante
        Fin Si

        Si suma == monto Entonces
            Retornar seleccionados  // Se encontró la combinación óptima
        Fin Si
    Fin Para

    // Si no se puede alcanzar el monto exacto, retornar lista vacía
    Retornar []
Fin Función

// Programa Principal
Inicio
    Definir lista comprobantes ← [100, 50, 20, 10, 5, 2, 1]  // Ejemplo de valores de comprobantes
    Definir monto ← 93  // Monto objetivo

    resultado ← minimizarComprobantes(comprobantes, monto)

    Si resultado ≠ [] Entonces
        Escribir "Comprobantes utilizados: ", resultado
    Sino
        Escribir "No se puede alcanzar el monto exacto con los comprobantes disponibles."
    Fin Si
Fin

 */
