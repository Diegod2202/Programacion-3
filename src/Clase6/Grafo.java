package Clase6;

import java.util.ArrayList;
import java.util.List;

    public class Grafo {
        public static void main(String[] args) {
            int numVertices = 4;
            List<List<Integer>> grafo = new ArrayList<>();

            // Agregar listas de adyacencia para cada vértice
            for (int i = 0; i < numVertices; i++) {
                grafo.add(new ArrayList<>());
            }

            // Agregar aristas
            grafo.get(0).add(1); // A - B
            grafo.get(0).add(2); // A - C
            grafo.get(1).add(3); // B - D
            grafo.get(2).add(3); // C - D

            // Imprimir la lista de adyacencia
            for (int i = 0; i < grafo.size(); i++) {
                System.out.println("Vértice " + i + ": " + grafo.get(i));
            }
        }
    }

