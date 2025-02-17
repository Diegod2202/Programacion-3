package clase9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import org.json.JSONObject;

public class clase9actividad2 {

    private static final String API_KEY = "1LZBZ5IRQ7LU0UV2"; // Tu API Key de Alpha Vantage

    public static int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }

        int n = prices.length;
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][n - 1];
    }

    public static int[] getStockPrices(String symbol) {
        try {
            String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + API_KEY + "&outputsize=compact";
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            if (!jsonResponse.has("Time Series (Daily)")) {
                System.out.println("Error: No se encontraron datos para la acción " + symbol);
                return new int[0];
            }

            JSONObject timeSeries = jsonResponse.getJSONObject("Time Series (Daily)");

            List<Integer> pricesList = new ArrayList<>();
            for (String date : timeSeries.keySet()) {
                double closePrice = timeSeries.getJSONObject(date).getDouble("4. close");
                pricesList.add((int) closePrice);
            }

            Collections.reverse(pricesList);
            return pricesList.stream().mapToInt(i -> i).toArray();
        } catch (Exception e) {
            System.out.println("Error al obtener los datos de la acción: " + e.getMessage());
            return new int[0];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el símbolo de la acción (ejemplo: AAPL, TSLA, GOOGL): ");
        String symbol = scanner.next().toUpperCase();

        System.out.print("Ingrese el número máximo de transacciones permitidas: ");
        int k = scanner.nextInt();

        int[] prices = getStockPrices(symbol);
        if (prices.length == 0) {
            System.out.println("No se encontraron precios para la acción.");
            return;
        }

        int maxProfit = maxProfit(k, prices);
        System.out.println("La ganancia máxima con " + k + " transacciones para " + symbol + " es: " + maxProfit);
    }
}
