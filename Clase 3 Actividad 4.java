class MergeSort {

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5}; // Array desordenado
        System.out.println("Array original:");
        imprimirArray(array);

        mergeSort(array, 0, array.length - 1); // Llamada al método mergeSort

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }

    // Método principal de Merge Sort
    public static void mergeSort(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            // Encontrar el punto medio del array
            int medio = inicio + (fin - inicio) / 2;

            // Ordenar recursivamente las dos mitades
            mergeSort(array, inicio, medio);
            mergeSort(array, medio + 1, fin);

            // Combinar las dos mitades ordenadas
            combinar(array, inicio, medio, fin);
        }
    }

    // Método para combinar dos subarrays ordenados
    private static void combinar(int[] array, int inicio, int medio, int fin) {
        // Tamaños de los subarrays
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        // Arrays temporales para almacenar las mitades
        int[] izquierda = new int[n1];
        int[] derecha = new int[n2];

        // Copiar datos a los arrays temporales
        for (int i = 0; i < n1; i++) {
            izquierda[i] = array[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            derecha[j] = array[medio + 1 + j];
        }

        // Índices iniciales de los subarrays
        int i = 0, j = 0;

        // Índice inicial del array combinado
        int k = inicio;

        // Combinar los subarrays ordenados
        while (i < n1 && j < n2) {
            if (izquierda[i] <= derecha[j]) {
                array[k] = izquierda[i];
                i++;
            } else {
                array[k] = derecha[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de izquierda (si los hay)
        while (i < n1) {
            array[k] = izquierda[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de derecha (si los hay)
        while (j < n2) {
            array[k] = derecha[j];
            j++;
            k++;
        }
    }

    // Método para imprimir el array
    public static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}