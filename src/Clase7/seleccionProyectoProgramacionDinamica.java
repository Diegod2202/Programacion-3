package Clase7;

public class seleccionProyectoProgramacionDinamica {
    public static int seleccionProyecto(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int p = 0; p <= presupuesto; p++) {
                if (costos[i - 1] <= p) {
                    dp[i][p] = Math.max(dp[i - 1][p], beneficios[i - 1] + dp[i - 1][p - costos[i - 1]]);
                } else {
                    dp[i][p] = dp[i - 1][p];
                }
            }
        }
        return dp[n][presupuesto];
    }

    public static void main(String[] args) {
        int[] costos = {1, 2, 3, 2, 2};
        int[] beneficios = {8, 4, 0, 5, 3};
        int presupuesto = 6;
        System.out.println("Beneficio máximo (Programación Dinámica): " + seleccionProyecto(costos, beneficios, presupuesto));
    }
}
