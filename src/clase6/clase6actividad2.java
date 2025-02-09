package clase6;

import java.util.ArrayList;
import java.util.List;

class GrafoMatriz {
    private int[][] matriz;
    private int numVertices;

    // Inicialización del grafo con 'numVertices' nodos
    public GrafoMatriz(int numVertices) {
        this.numVertices = numVertices;
        this.matriz = new int[numVertices][numVertices]; // Matriz NxN inicializada en 0
    }

    // Agregar arista de 'origen' a 'destino'
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 1;
        } else {
            System.out.println("Error: Índices fuera de rango.");
        }
    }

    // Eliminar arista de 'origen' a 'destino'
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 0;
        } else {
            System.out.println("Error: Índices fuera de rango.");
        }
    }

    // Verificar si existe una arista de 'origen' a 'destino'
    public boolean verificarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return matriz[origen][destino] == 1;
        }
        return false;
    }

    // Obtener nodos adyacentes de un vértice dado
    public List<Integer> listarAdyacentes(int nodo) {
        List<Integer> adyacentes = new ArrayList<>();
        if (nodo >= 0 && nodo < numVertices) {
            for (int j = 0; j < numVertices; j++) {
                if (matriz[nodo][j] == 1) {
                    adyacentes.add(j);
                }
            }
        }
        return adyacentes;
    }

    // Contar el grado de salida (número de aristas que salen de un nodo)
    public int contarGradoSalida(int nodo) {
        int grado = 0;
        if (nodo >= 0 && nodo < numVertices) {
            for (int j = 0; j < numVertices; j++) {
                if (matriz[nodo][j] == 1) {
                    grado++;
                }
            }
        }
        return grado;
    }

    // Contar el grado de entrada (número de aristas que entran a un nodo)
    public int contarGradoEntrada(int nodo) {
        int grado = 0;
        if (nodo >= 0 && nodo < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[i][nodo] == 1) {
                    grado++;
                }
            }
        }
        return grado;
    }

    // Imprimir la matriz de adyacencia
    public void imprimirMatriz() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // MAIN: Prueba del Grafo
    public static void main(String[] args) {
        GrafoMatriz grafo = new GrafoMatriz(4); // Crear un grafo de 4 nodos

        // Agregar aristas
        grafo.agregarArista(0, 1);
        grafo.agregarArista(2, 0);
        grafo.agregarArista(2, 3);

        // Imprimir la matriz
        grafo.imprimirMatriz();

        // Verificar aristas
        System.out.println("¿Existe arista 0 → 1? " + grafo.verificarArista(0, 1)); // true
        System.out.println("¿Existe arista 1 → 3? " + grafo.verificarArista(1, 3)); // false

        // Listar adyacentes
        System.out.println("Nodos adyacentes a 2: " + grafo.listarAdyacentes(2)); // [0, 3]

        // Contar grados
        System.out.println("Grado de salida de 2: " + grafo.contarGradoSalida(2)); // 2
        System.out.println("Grado de entrada a 0: " + grafo.contarGradoEntrada(0)); // 1

        // Eliminar una arista y volver a imprimir
        grafo.eliminarArista(2, 3);
        grafo.imprimirMatriz();
    }
}
