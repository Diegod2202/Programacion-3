package Clase_8.Actividad_2;

import java.util.Arrays;

public class Main {

    static final int INF = 99999; // Representación de infinito (para rutas no existentes)

    public static void floydWarshall(int[][] tiempos, int numCentros) {
        int[][] distancias = new int[numCentros][numCentros];

        // Copiar la matriz de tiempos en la matriz de distancias
        for (int i = 0; i < numCentros; i++) {
            System.arraycopy(tiempos[i], 0, distancias[i], 0, numCentros);
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < numCentros; k++) {
            for (int i = 0; i < numCentros; i++) {
                for (int j = 0; j < numCentros; j++) {
                    if (distancias[i][k] != INF && distancias[k][j] != INF) {
                        distancias[i][j] = Math.min(distancias[i][j], distancias[i][k] + distancias[k][j]);
                    }
                }
            }
        }

        // Detectar ciclos negativos
        for (int i = 0; i < numCentros; i++) {
            if (distancias[i][i] < 0) {
                System.out.println("⚠️ Se ha detectado un ciclo negativo en el centro " + (i + 1));
                return;
            }
        }

        // Mostrar la matriz de distancias mínimas
        System.out.println("🚚 Tiempos mínimos de entrega entre centros de distribución:");
        imprimirMatriz(distancias, numCentros);
    }

    public static void imprimirMatriz(int[][] matriz, int numCentros) {
        for (int i = 0; i < numCentros; i++) {
            for (int j = 0; j < numCentros; j++) {
                if (matriz[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numCentros = 4; // Número de centros de distribución

        // Matriz de tiempos (INF si no hay conexión)
        int[][] tiempos = {
                {0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };

        floydWarshall(tiempos, numCentros);
    }
}