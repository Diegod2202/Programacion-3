package Clase8;
import java.util.Scanner;
public class logisticaScanner {
        final static int INF = 99999;

        public static void floydWarshall(int[][] graph, int[][] next) {
            int n = graph.length;
            int[][] dist = new int[n][n];

            // Inicializar la matriz de distancias y la matriz de siguiente
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = graph[i][j];
                    if (graph[i][j] != INF && i != j) {
                        next[i][j] = j;
                    }
                }
            }

            // Aplicar el algoritmo de Floyd-Warshall
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            next[i][j] = next[i][k];
                        }
                    }
                }
            }

            // Verificar ciclos negativos
            for (int i = 0; i < n; i++) {
                if (dist[i][i] < 0) {
                    System.out.println("El grafo contiene un ciclo negativo.");
                    return;
                }
            }

            // Imprimir la matriz de distancias
            printSolution(dist);
        }

        public static void printSolution(int[][] dist) {
            int n = dist.length;
            System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] == INF) {
                        System.out.print("INF ");
                    } else {
                        System.out.print(dist[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }

        public static void printPath(int[][] next, int u, int v) {
            if (next[u][v] == -1) {
                System.out.println("No hay camino disponible.");
                return;
            }
            System.out.print("El camino más corto de " + u + " a " + v + " es: ");
            while (u != v) {
                System.out.print(u + " -> ");
                u = next[u][v];
            }
            System.out.println(v);
        }

        public static void main(String[] args) {
            int[][] graph = {
                    {0, 3, INF, 5},
                    {2, 0, INF, 4},
                    {INF, 1, 0, INF},
                    {INF, INF, 2, 0}
            };

            int n = graph.length;
            int[][] next = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    next[i][j] = -1;
                }
            }

            floydWarshall(graph, next);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el vértice de origen: ");
            int origen = scanner.nextInt();
            System.out.print("Ingrese el vértice de destino: ");
            int destino = scanner.nextInt();

            printPath(next, origen, destino);
        }
    }
