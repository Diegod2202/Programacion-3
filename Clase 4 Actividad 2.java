class DosMayoresDivideYConquista {

    public static void main(String[] args) {
        int[] lista = {10, 5, 20, 15, 30, 25}; // Lista de números
        int[] resultado = encontrarDosMayores(lista, 0, lista.length - 1);

        System.out.println("Los dos números mayores son: " + resultado[0] + " y " + resultado[1]);
    }

    // Método para encontrar los dos números mayores usando Divide y Conquista
    public static int[] encontrarDosMayores(int[] lista, int inicio, int fin) {
        // Caso base: si solo hay un elemento
        if (inicio == fin) {
            return new int[]{lista[inicio], Integer.MIN_VALUE};
        }

        // Caso base: si hay dos elementos
        if (fin - inicio == 1) {
            if (lista[inicio] > lista[fin]) {
                return new int[]{lista[inicio], lista[fin]};
            } else {
                return new int[]{lista[fin], lista[inicio]};
            }
        }

        // Dividir la lista en dos mitades
        int medio = inicio + (fin - inicio) / 2;

        // Resolver recursivamente para cada mitad
        int[] maxIzquierda = encontrarDosMayores(lista, inicio, medio);
        int[] maxDerecha = encontrarDosMayores(lista, medio + 1, fin);

        // Combinar: encontrar los dos mayores entre las dos mitades
        int max1, max2;
        if (maxIzquierda[0] > maxDerecha[0]) {
            max1 = maxIzquierda[0];
            max2 = Math.max(maxIzquierda[1], maxDerecha[0]);
        } else {
            max1 = maxDerecha[0];
            max2 = Math.max(maxDerecha[1], maxIzquierda[0]);
        }

        return new int[]{max1, max2};
    }
}

