package Clase7;

public class mochilaFuerzaBruta {
        public static int mochila(int[] pesos, int[] valores, int capacidad) {
            return mochilaaux(pesos, valores, capacidad, 0);
        }

        private static int mochilaaux(int[] pesos, int[] valores, int capacidad, int indice) {
            if (indice == pesos.length || capacidad == 0) {
                return 0;
            }

            if (pesos[indice] > capacidad) {
                return mochilaaux(pesos, valores, capacidad, indice + 1);
            } else {
                int include = valores[indice] + mochilaaux(pesos, valores, capacidad - pesos[indice], indice + 1);
                int exclude = mochilaaux(pesos, valores, capacidad, indice + 1);
                return Math.max(include, exclude);
            }
        }

        public static void main(String[] args) {
            int[] weights = {1, 2, 3, 2, 2};
            int[] values = {8, 4, 0, 5, 3};
            int capacity = 6;
            System.out.println("Maximum value (Brute Force): " + mochila(weights, values, capacity));
        }
    }

