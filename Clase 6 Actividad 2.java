class Grafo {
    private int[][] matrizAdyacencia;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 1;
    }

    public void eliminarArista(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 0;
    }

    public boolean verificarArista(int origen, int destino) {
        return matrizAdyacencia[origen][destino] == 1;
    }

    public void listarAdyacentes(int vertice) {
        System.out.print("Vertices adyacentes a " + vertice + ": ");
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[vertice][i] == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public int contarGradoSalida(int vertice) {
        int gradoSalida = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[vertice][i] == 1) {
                gradoSalida++;
            }
        }
        return gradoSalida;
    }

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
        Grafo grafo = new Grafo(5);
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 0);
        grafo.agregarArista(2, 3);

        System.out.println("Verificar arista (0, 1): " + grafo.verificarArista(0, 1));
        System.out.println("Verificar arista (1, 3): " + grafo.verificarArista(1, 3));

        grafo.listarAdyacentes(2);

        System.out.println("Grado de salida del vertice 2: " + grafo.contarGradoSalida(2));
        System.out.println("Grado de entrada del vertice 2: " + grafo.contarGradoEntrada(2));

        grafo.eliminarArista(2, 0);
        System.out.println("Verificar arista (2, 0) después de eliminar: " + grafo.verificarArista(2, 0));
    }
}