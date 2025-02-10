package Clase8;

public class logistica {
    final static int INF = 99999;
        public static void floydWarshall(int[][] graph) {
            int n = graph.length;
            int[][] dist = new int[n][n];

            // Inicializar la matriz de distancias con los valores del grafo
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = graph[i][j];
                }
            }

            // Aplicar el algoritmo de Floyd-Warshall
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
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

        public static void main(String[] args) {
            int[][] graph = {
                    {0, 3, INF, 5},
                    {2, 0, INF, 4},
                    {INF, 1, 0, INF},
                    {INF, INF, 2, 0}
            };

            floydWarshall(graph);
        }
    }
