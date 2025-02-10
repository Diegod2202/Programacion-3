class PromedioMatriz {

    public static void main(String[] args) {
        int[][] mat = {{4, 5, 6}, {7, 8, 9}, {5, 6, 7}}; 
        int n = mat.length; 
        int totalElementos = n * n; 
        int suma = 0;
        int contadorInstrucciones = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                suma += mat[i][j]; 
                contadorInstrucciones += 2; 
            }
            contadorInstrucciones++; 
        }
        contadorInstrucciones++; 

        double promedio = (double) suma / totalElementos;
        contadorInstrucciones += 2; 

        System.out.println("El promedio de la matriz es: " + promedio);
        System.out.println("Número total de instrucciones ejecutadas: " + contadorInstrucciones);
    }
}

