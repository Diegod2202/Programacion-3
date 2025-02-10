package clase8;

import java.util.Arrays;
import java.util.Scanner;

public class clase8actividad3 {
    static final int INF = 99999; // Representa infinito
    static int[][] next; // Matriz para reconstrucción de caminos

    public static void main(String[] args) {
        int V = 5; // Número de centros de distribución

        // Matriz de tiempos de viaje entre centros de distribución
        int[][] graph = {
                {0, 3, INF, 7, INF},
                {INF, 0, 2, INF, INF},
                {INF, INF, 0, 1, INF},
                {INF, INF, INF, 0, 2},
                {-4, INF, INF, INF, 0}  // Ruta con tiempo negativo
        };

        floydWarshall(graph, V);

        // Pedir origen y destino al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el nodo de origen (0-4): ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el nodo de destino (0-4): ");
        int destino = scanner.nextInt();
        scanner.close();

        // Imprimir el camino más corto entre origen y destino
        imprimirCamino(origen, destino);
    }

    static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];
        next = new int[V][V];

        // Inicialización de matrices
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j; // Siguiente nodo en el camino óptimo
                } else {
                    next[i][j] = -1;
                }
            }
        }

        // Algoritmo de Floyd-Warshall con reconstrucción de camino
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k]; // Actualizar el camino más corto
                    }
                }
            }
        }

        // Imprimir la matriz de distancias mínimas
        printSolution(dist, V);
    }

    static void imprimirCamino(int origen, int destino) {
        if (next[origen][destino] == -1) {
            System.out.println("No hay ruta entre " + origen + " y " + destino);
            return;
        }

        System.out.print("Camino más corto desde " + origen + " hasta " + destino + ": ");
        System.out.print(origen);
        while (origen != destino) {
            origen = next[origen][destino];
            System.out.print(" -> " + origen);
        }
        System.out.println();
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

