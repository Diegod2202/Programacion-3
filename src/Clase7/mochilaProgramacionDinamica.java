package Clase7;

public class mochilaProgramacionDinamica {
    public static int mochila(int[] pesos, int[] valores, int capacidad) {
            int n = pesos.length;
            int[][] dp = new int[n + 1][capacidad + 1];

            for (int i = 1; i <= n; i++) {
                for (int w = 0; w <= capacidad; w++) {
                    if (pesos[i - 1] <= w) {
                        dp[i][w] = Math.max(dp[i - 1][w], valores[i - 1] + dp[i - 1][w - pesos[i - 1]]);
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }

            return dp[n][capacidad];
        }

        public static void main(String[] args) {
            int[] pesos = {1, 2, 3, 2, 2};
            int[] valores = {8, 4, 0, 5, 3};
            int capacidad = 6;
            System.out.println("Valor máximo (Programación Dinámica): " + mochila(pesos, valores, capacidad));
        }
    }

