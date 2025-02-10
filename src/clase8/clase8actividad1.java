package clase8;

import java.util.Arrays;

public class clase8actividad1 {
    static final int INF = 99999; // Un valor alto para representar "infinito"

    public static void main(String[] args) {
        // Número de nodos
        int V = 4;

        // Matriz de adyacencia inicial con pesos dados
        int[][] graph = {
                {0, 2, INF, 5},  // Nodo 1 -> (2,2), (4,5)
                {INF, 0, INF, 4}, // Nodo 2 -> (4,4)
                {INF, INF, 0, INF}, // Nodo 3 -> No tiene conexiones directas
                {INF, INF, 2, 0}  // Nodo 4 -> (3,2)
        };

        floydWarshall(graph, V);
    }

    static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];

        // Copiamos la matriz de adyacencia en la matriz de distancias
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

        // Mostrar la matriz resultante con las distancias más cortas
        printSolution(dist, V);
    }

    static void printSolution(int[][] dist, int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de nodos:");
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
