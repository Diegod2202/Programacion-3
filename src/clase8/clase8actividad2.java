package clase8;

import java.util.Arrays;

public class clase8actividad2 {
    static final int INF = 99999; // Representa infinito

    public static void main(String[] args) {
        int V = 5; // Número de centros de distribución

        // Matriz de tiempo de viaje entre centros de distribución
        int[][] graph = {
                {0, 3, INF, 7, INF},
                {INF, 0, 2, INF, INF},
                {INF, INF, 0, 1, INF},
                {INF, INF, INF, 0, 2},
                {-4, INF, INF, INF, 0}  // Ruta con tiempo negativo
        };

        floydWarshall(graph, V);
    }

    static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];

        // Copiamos la matriz original
        for (int i = 0; i < V; i++)
            System.arraycopy(graph[i], 0, dist[i], 0, V);

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Verificar si hay ciclos negativos
        if (hasNegativeCycle(dist, V)) {
            System.out.println("¡Se ha detectado un ciclo negativo en las rutas!");
        } else {
            printSolution(dist, V);
        }
    }

    static boolean hasNegativeCycle(int[][] dist, int V) {
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) { // Si la diagonal tiene valores negativos, hay ciclo negativo
                return true;
            }
        }
        return false;
    }

    static void printSolution(int[][] dist, int V) {
        System.out.println("Matriz de tiempos mínimos entre centros de distribución:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
