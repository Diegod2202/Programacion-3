package Clase11;

class clase11Actividad3 {

    private static final int TAMANO_OFICINA = 4;
    private static char[][] oficina = new char[TAMANO_OFICINA][TAMANO_OFICINA];

    public static void main(String[] args) {
        System.out.println("Combinaciones válidas de computadoras (C) e impresoras (I) en una oficina de 4x4:");
        encontrarCombinacionesValidas(0);
    }

    private static void encontrarCombinacionesValidas(int fila) {
        if (fila == TAMANO_OFICINA) {
            imprimirOficina();
            return;
        }

        for (int columna = 0; columna < TAMANO_OFICINA; columna++) {
            if (esPosicionValida(fila, columna, 'C')) {
                oficina[fila][columna] = 'C'; // Colocar computadora
                if (colocarImpresoras(fila)) {
                    encontrarCombinacionesValidas(fila + 1);
                }
                oficina[fila][columna] = '\0'; // Retroceder (Backtracking)
            }
        }
    }

    private static boolean colocarImpresoras(int fila) {
        if (fila == TAMANO_OFICINA) {
            return true;
        }

        for (int columna = 0; columna < TAMANO_OFICINA; columna++) {
            if (esPosicionValida(fila, columna, 'I')) {
                oficina[fila][columna] = 'I'; // Colocar impresora
                if (colocarImpresoras(fila + 1)) {
                    return true;
                }
                oficina[fila][columna] = '\0'; // Retroceder (Backtracking)
            }
        }
        return false;
    }

    private static boolean esPosicionValida(int fila, int columna, char elemento) {
        // Verificar si la fila o columna ya tienen un elemento del mismo tipo
        for (int i = 0; i < TAMANO_OFICINA; i++) {
            if (oficina[fila][i] == elemento || oficina[i][columna] == elemento) {
                return false;
            }
        }
        return true;
    }

    private static void imprimirOficina() {
        for (char[] fila : oficina) {
            for (char celda : fila) {
                System.out.print((celda == '\0' ? "-" : celda) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
