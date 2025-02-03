package Clase2;

public class Actividad1_Matriz {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};//1
        int suma= 0;//1
        int cantidadElementos= 0; //1
        for (int i = 0; i < matriz.length; i++) { //1 + 2n + n = 3n + 1
            for (int j = 0; j < matriz[i].length; j++) { //3n + 1
                suma += matriz[i][j]; // 2n
                cantidadElementos++; // n
            }
        }
        int promedio = suma/cantidadElementos; //2
        System.out.println(promedio); //1
    }
    // f(n)= 3 + 3n + 1 + n (3n + 1 + 2n + n) + 2 + 1 = 3n + n (6n + 1) + 7= 3n + 6n^2 + n + 7 = 6n^2 + 4n + 7
    // complejidad asintotica O(n*m) donde n es el numero de filas y m es el numero de columnas
    // ecnontrar la constante c y el n0
    // c = 6, n0 = 1
}