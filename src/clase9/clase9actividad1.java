package clase9;

public class clase9actividad1 {
    public static int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }

        int n = prices.length;

        // Si K es mayor o igual a la mitad de los días, podemos hacer transacciones ilimitadas (caso trivial)
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // Matriz DP: dp[i][j] representa la máxima ganancia usando hasta i transacciones en j días
        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0]; // Variable para optimizar el cálculo
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        int k = 2; // Máximo número de transacciones permitidas
        int[] prices = {3, 2, 6, 5, 0, 3}; // Precios históricos de la acción

        int maxProfit = maxProfit(k, prices);
        System.out.println("La ganancia máxima con " + k + " transacciones es: " + maxProfit);
    }
}
