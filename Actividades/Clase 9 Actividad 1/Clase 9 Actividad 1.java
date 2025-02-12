import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
 
 
 
 class Accion {
    private int dia;
    private double precio;

    public Accion(int dia, double precio) {
        this.dia = dia;
        this.precio = precio;
    }

    public int getDia() {
        return dia;
    }

    public double getPrecio() {
        return precio;
    }
}

 class MaximizadorGanancias {

    public double maximizarGanancias(Accion[] acciones, int k) {
        int n = acciones.length;
        if (n == 0 || k == 0) {
            return 0;
        }

        // Crear una tabla para almacenar las ganancias máximas
        double[][] dp = new double[k + 1][n];

        // Rellenar la tabla utilizando programación dinámica
        for (int i = 1; i <= k; i++) {
            double maxDif = -acciones[0].getPrecio();
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], acciones[j].getPrecio() + maxDif);
                maxDif = Math.max(maxDif, dp[i - 1][j] - acciones[j].getPrecio());
            }
        }

        return dp[k][n - 1];
    }
}



class Main {

    public static void main(String[] args) {
        try {
            // Leer el archivo JSON con los datos históricos
            Gson gson = new Gson();
            Type tipoListaAcciones = new TypeToken<List<Accion>>() {}.getType();
            List<Accion> acciones = gson.fromJson(new FileReader("gson-2.8.2.json"), tipoListaAcciones);

            // Convertir la lista a un array
            Accion[] arrayAcciones = acciones.toArray(new Accion[0]);

            // Número máximo de transacciones
            int k = 2;

            // Calcular la máxima ganancia
            MaximizadorGanancias maximizador = new MaximizadorGanancias();
            double maximaGanancia = maximizador.maximizarGanancias(arrayAcciones, k);

            // Mostrar el resultado
            System.out.println("La máxima ganancia posible con " + k + " transacciones es: " + maximaGanancia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}