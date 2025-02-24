package clase12;

import java.util.*;

class clase12Actividad1 {
    private int V; // Número de vértices
    private LinkedList<Integer> adj[]; // Lista de adyacencia

    clase12Actividad1(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // Añadir w a la lista de v
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        clase12Actividad1 g = new clase12Actividad1(9);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 8);

        System.out.println("Recorrido DFS comenzando desde el nodo 0:");
        g.DFS(0);
    }
}
