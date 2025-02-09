import java.util.Arrays;
import java.util.Collections;

public class ProblemaDelCambio {

    // Función para calcular el cambio usando un algoritmo greedy
    public static void calcularCambio(int cantidad, Integer[] monedas) {
        // Ordenar las monedas en orden descendente
        Arrays.sort(monedas, Collections.reverseOrder());

        System.out.println("Monedas disponibles: " + Arrays.toString(monedas));
        System.out.println("Cambio a dar: " + cantidad + " centavos");

        int[] contadorMonedas = new int[monedas.length]; // Para contar cuántas monedas de cada tipo se usan

        // Recorrer las monedas y calcular el cambio
        for (int i = 0; i < monedas.length; i++) {
            if (cantidad >= monedas[i]) {
                contadorMonedas[i] = cantidad / monedas[i]; // Cantidad de monedas de este tipo
                cantidad = cantidad % monedas[i]; // Actualizar la cantidad restante
            }
        }

        // Mostrar el resultado
        if (cantidad == 0) {
            System.out.println("Cambio óptimo:");
            for (int i = 0; i < monedas.length; i++) {
                if (contadorMonedas[i] > 0) {
                    System.out.println(contadorMonedas[i] + " moneda(s) de " + monedas[i] + " centavos");
                }
            }
        } else {
            System.out.println("No se puede dar el cambio exacto con las monedas disponibles.");
        }
    }

    public static void main(String[] args) {
        // Denominaciones de monedas disponibles (en centavos)
        Integer[] monedas = {1, 5, 10, 25}; // Monedas de 1, 5, 10 y 25 centavos

        // Cantidad de cambio a dar (en centavos)
        int cantidad = 36; // Cambio de 36 centavos

        // Calcular el cambio
        calcularCambio(cantidad, monedas);
    }
}