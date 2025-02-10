package clase2;

public class clase2Actividad1 {
    public static void main(String[] args) {
        int[][] mat = {{4,5,6},{7,8,9},{5,6,7}};
        System.out.println(calcularPromedio(mat));
    }
    public static float calcularPromedio(int[][] arr) {
        int total = 0; // 1
        int largo = 0; // 1
        float promedio = 0; // 1
        for (int i = 0; i < arr.length; i++) { // 1 + (n+1) + n = 2 + 2n
            for (int j = 0; j < arr[i].length; j++) { // 1 + (n+1) + n = 2 + 2n
                total += arr[i][j]; // 2n
                largo++; // 2n
            }
        }
        return promedio = total / largo; // 2n
    }
}

// f(n) = 1 + 1 + 1 + (1 + n + 2n + 1 + n + 2n + 2n) + 2n + 2n
// f(n) =
// f(n) = 12n + 5
//int[][] mat = {{4,5,6},{7,8,9},{5,6,7}}
//Realizar un programa en java para calcular el promedio
//para los cálculos, asumir que la matriz es cuadrada
//realizar el conteo de instrucciones
//calcular la complejidad asintótica