package Clase11;

class clase11Actividad1 {

    private static final int TAMANO_TABLERO = 4;
    private static int[][] tablero = new int[TAMANO_TABLERO][TAMANO_TABLERO];

    public static void main(String[] args) {
        System.out.println("Configuraciones válidas para 2 reinas en un tablero de 4x4:");
        encontrarConfiguracionesValidas(0, 0);
    }

    private static void encontrarConfiguracionesValidas(int reinasColocadas, int filaInicio) {
        if (reinasColocadas == 2) {
            imprimirTablero();
            return;
        }

        for (int fila = filaInicio; fila < TAMANO_TABLERO; fila++) {
            for (int columna = 0; columna < TAMANO_TABLERO; columna++) {
                if (esPosicionSegura(fila, columna)) {
                    tablero[fila][columna] = 1; // Colocar reina
                    encontrarConfiguracionesValidas(reinasColocadas + 1, fila + 1);
                    tablero[fila][columna] = 0; // Retroceder (Backtracking)
                }
            }
        }
    }

    private static boolean esPosicionSegura(int fila, int columna) {
        // Verificar misma columna
        for (int i = 0; i < fila; i++) {
            if (tablero[i][columna] == 1) {
                return false;
            }
        }

        // Verificar diagonal superior izquierda
        for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        // Verificar diagonal superior derecha
        for (int i = fila, j = columna; i >= 0 && j < TAMANO_TABLERO; i--, j++) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void imprimirTablero() {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
