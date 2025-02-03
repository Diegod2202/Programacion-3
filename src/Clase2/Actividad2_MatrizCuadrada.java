package Clase2;

public class Actividad2_MatrizCuadrada {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}};//1
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
}

//f(n) = 3 + 3n + 1 + n(3n + 1 + 2n + n) + 2 + 1 = 3 + 3n + 1 + 3n^2 + n + 2n + n^2 + 2 + 1 = 4 + 3n + 4n^2 + n = 4n^2 + 4n + 4
//complejidad asintotica O(n^2) donde n es el numero de filas y columnas
//encontrar la constante c y el n0
//c = 4, n0 = 1
