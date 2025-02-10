public class Quicksort {

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5}; // Array desordenado
        System.out.println("Array original:");
        imprimirArray(array);

        quicksort(array, 0, array.length - 1); // Llamada al método quicksort

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }

    // Método principal de Quicksort
    public static void quicksort(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            // Obtener el índice del pivote después de la partición
            int indicePivote = particion(array, inicio, fin);

            // Ordenar recursivamente los subarrays antes y después del pivote
            quicksort(array, inicio, indicePivote - 1);
            quicksort(array, indicePivote + 1, fin);
        }
    }

    // Método para realizar la partición
    private static int particion(int[] array, int inicio, int fin) {
        int pivote = array[fin]; // Elegir el último elemento como pivote
        int i = inicio - 1; // Índice del menor elemento

        for (int j = inicio; j < fin; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (array[j] <= pivote) {
                i++;
                intercambiar(array, i, j); // Intercambiar elementos
            }
        }

        // Intercambiar el pivote con el elemento en la posición i+1
        intercambiar(array, i + 1, fin);

        return i + 1; // Retornar el índice del pivote
    }

    // Método para intercambiar dos elementos del array
    private static void intercambiar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Método para imprimir el array
    public static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}