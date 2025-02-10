class MultiplicacionMatrices {

    public static void main(String[] args) {
        int[][] matrizA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; 
        int[][] matrizB = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}}; 
        int n = matrizA.length; 

        int[][] resultado = new int[n][n];

       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i][j] = 0; 
                for (int k = 0; k < n; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j]; 
                }
            }
        }

        System.out.println("Matriz resultante de la multiplicación:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }
}