package clase6;

import java.util.*;

class Arista implements Comparable<Arista> {
    int destino, peso;

    public Arista(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Arista otra) {
        return Integer.compare(this.peso, otra.peso);
    }
}

class Grafo {
    private int numVertices;
    private List<List<Arista>> listaAdyacencia;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        listaAdyacencia.get(origen).add(new Arista(destino, peso));
        listaAdyacencia.get(destino).add(new Arista(origen, peso)); // clase6.Grafo no dirigido
    }

    public void primMST() {
        PriorityQueue<Arista> pq = new PriorityQueue<>();
        boolean[] visitado = new boolean[numVertices];
        List<String> resultado = new ArrayList<>();
        int costoTotal = 0;

        // Empezamos desde el nodo 0
        visitado[0] = true;
        pq.addAll(listaAdyacencia.get(0));

        while (!pq.isEmpty()) {
            Arista aristaMinima = pq.poll();
            int destino = aristaMinima.destino;

            if (!visitado[destino]) {
                visitado[destino] = true;
                costoTotal += aristaMinima.peso;
                resultado.add("Conectar estación " + destino + " con costo " + aristaMinima.peso);
                pq.addAll(listaAdyacencia.get(destino));
            }
        }

        // Mostrar el resultado final
        System.out.println("Árbol de Recubrimiento Mínimo (MST) - Algoritmo de Prim:");
        for (String conexion : resultado) {
            System.out.println(conexion);
        }
        System.out.println("Costo total mínimo de la red: " + costoTotal);
    }
}

public class clase6actividad3 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(4); // 4 estaciones eléctricas

        // Agregar conexiones entre estaciones con sus costos
        grafo.agregarArista(0, 1, 1);
        grafo.agregarArista(0, 2, 4);
        grafo.agregarArista(1, 2, 3);
        grafo.agregarArista(1, 3, 2);
        grafo.agregarArista(2, 3, 5);

        // Ejecutar el Algoritmo de Prim
        grafo.primMST();
    }
}
