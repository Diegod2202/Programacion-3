public class Actividad2_2 {
    public static void main(String[] args) {
        int[][] mat1= {{1,2},{3,4}};
        int[][] mat2= {{1,2},{3,4}};

        if (mat1.length != mat2[0].length) {
            System.out.println("Las matrices no se pueden multiplicar");
            return;
        }

        int[][] mat3 = new int[mat1.length][mat2[0].length];

        // hasta aca tenemos 11 aprox

        // Multiplicar las matrices
        for (int i = 0; i < mat1.length; i++) {  // 1 + n + 1 + 2n = 3n + 2
            for (int j = 0; j < mat2[0].length; j++) { // 3n + 2
                for (int k = 0; k < mat1[0].length; k++) { // 3n + 2
                    mat3[i][j] += mat1[i][k] * mat2[k][j]; // 3n
                }
            }
        }

        // Imprimir la matriz resultante
        for (int i = 0; i < mat3.length; i++) { // 3n + 2
            for (int j = 0; j < mat3[0].length; j++) { // 3n + 2
                System.out.print(mat3[i][j] + " "); // 2n
            }
            System.out.println(); // 1
        }
    }
}

// f(n) =