import java.util.Arrays;

public class CambioMonedaExtranjera {

    public static int cambioMonedaExtranjera(int[] comprobantes, int valorObjetivo) {
        int[] dp = new int[valorObjetivo + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  // No se necesitan comprobantes para alcanzar el valor 0

        for (int i = 1; i <= valorObjetivo; i++) {
            for (int comprobante : comprobantes) {
                if (comprobante <= i && dp[i - comprobante] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - comprobante] + 1);
                }
            }
        }

        return dp[valorObjetivo] == Integer.MAX_VALUE ? -1 : dp[valorObjetivo];
    }

    public static void main(String[] args) {
        int[] comprobantes = {1, 2, 5, 10, 20, 50, 100};
        int valorObjetivo = 98;

        int resultado = cambioMonedaExtranjera(comprobantes, valorObjetivo);

        if (resultado == -1) {
            System.out.println("No es posible alcanzar el valor objetivo con los comprobantes dados.");
        } else {
            System.out.println("El mínimo número de comprobantes necesarios es: " + resultado);
        }
    }
}