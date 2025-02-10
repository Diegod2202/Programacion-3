package clase2;

public class clase2Actividad2 {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] B = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int n = A.length;
        int[][] C = new int[n][n]; // Matriz resultado

        for (int i = 0; i < n; i++) { // 1 + (n+1) + n = 2 + 2n
            for (int j = 0; j < n; j++) { // 1 + (n+1) + n = 2 + 2n
                C[i][j] = 0; // 1 operación
                for (int k = 0; k < n; k++) { // 1 + (n+1) + n = 2 + 2n
                    C[i][j] += A[i][k] * B[k][j]; // 2 operaciones por iteración -> 2n^3 en total
                }
            }
        }

        // Imprimir matriz resultante
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}

