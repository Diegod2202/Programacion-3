package Clase6;

import java.util.ArrayList;
import java.util.List;

public class grafo {
    private int[][] matrizAdyacencia;
    private int numVertices;

    // Inicialización del Grafo
    public grafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    // Agregar Arista
    public void agregarArista(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 1;
    }

    // Eliminar Arista
    public void eliminarArista(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 0;
    }

    // Verificar Arista
    public boolean verificarArista(int origen, int destino) {
        return matrizAdyacencia[origen][destino] == 1;
    }

    // Listar Adyacentes
    public List<Integer> listarAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[vertice][i] == 1) {
                adyacentes.add(i);
            }
        }
        return adyacentes;
    }

    // Contar Grado de Salida
    public int contarGradoSalida(int vertice) {
        int gradoSalida = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[vertice][i] == 1) {
                gradoSalida++;
            }
        }
        return gradoSalida;
    }

    // Contar Grado de Entrada
    public int contarGradoEntrada(int vertice) {
        int gradoEntrada = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[i][vertice] == 1) {
                gradoEntrada++;
            }
        }
        return gradoEntrada;
    }

    public static void main(String[] args) {
        grafo grafo = new grafo(5);

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);

        System.out.println("Arista entre 0 y 1: " + grafo.verificarArista(0, 1));
        System.out.println("Adyacentes de 0: " + grafo.listarAdyacentes(0));
        System.out.println("Grado de salida de 0: " + grafo.contarGradoSalida(0));
        System.out.println("Grado de entrada de 3: " + grafo.contarGradoEntrada(3));

        grafo.eliminarArista(0, 1);
        System.out.println("Arista entre 0 y 1 después de eliminar: " + grafo.verificarArista(0, 1));
    }
}