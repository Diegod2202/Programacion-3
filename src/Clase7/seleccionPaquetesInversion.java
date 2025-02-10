package Clase7;

public class seleccionPaquetesInversion {
    public static int maxGanancia(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int p = 0; p <= presupuesto; p++) {
                if (costos[i - 1] <= p) {
                    dp[i][p] = Math.max(dp[i - 1][p], ganancias[i - 1] + dp[i - 1][p - costos[i - 1]]);
                } else {
                    dp[i][p] = dp[i - 1][p];
                }
            }
        }

        return dp[n][presupuesto];
    }

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;
        System.out.println("Ganancia máxima: " + maxGanancia(costos, ganancias, presupuesto));
    }
}