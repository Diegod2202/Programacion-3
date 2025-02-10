package Clase6;

import java.util.*;

public class dijkstra {

    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        List<List<Edge>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int source, int target, int weight) {
            adjList.get(source).add(new Edge(target, weight));
        }

        void dijkstra(int startVertex) {
            int[] distances = new int[vertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startVertex] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(e -> e.weight));
            pq.add(new Edge(startVertex, 0));

            boolean[] visited = new boolean[vertices];

            while (!pq.isEmpty()) {
                int u = pq.poll().target;

                if (visited[u]) continue;
                visited[u] = true;

                for (Edge edge : adjList.get(u)) {
                    int v = edge.target;
                    int weight = edge.weight;

                    if (!visited[v] && distances[u] + weight < distances[v]) {
                        distances[v] = distances[u] + weight;
                        pq.add(new Edge(v, distances[v]));
                    }
                }
            }

            printSolution(distances, startVertex);
        }

        void printSolution(int[] distances, int startVertex) {
            System.out.println("Distancia desde el centro de distribución " + startVertex);
            for (int i = 0; i < vertices; i++) {
                System.out.println("Hasta la ciudad " + i + " es " + distances[i] + " minutos");
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        // Añadir aristas al grafo (centro de distribución, otro centro, tiempo de viaje en minutos)
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 15);
        graph.addEdge(1, 3, 12);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 5);

        graph.dijkstra(0);  // Ejecutar Dijkstra desde el centro de distribución principal (vértice 0)
    }
}