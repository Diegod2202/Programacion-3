class SudokuSolver {

    // Cambiar SIZE a 4
    private static final int SIZE = 4;

    public static void main(String[] args) {
        int[][] board = {
            {1, 0, 0, 0},
            {0, 0, 0, 2},
            {0, 0, 2, 0},
            {0, 1, 0, 0}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No existe solución para este Sudoku.");
        }
    }

    // Modificar isValid para subcuadros 2x2
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Verificar fila y columna
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Verificar subcuadro 2x2
        int startRow = row - row % 2;
        int startCol = col - col % 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Resto del código permanece igual
    ...
}