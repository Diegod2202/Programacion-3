public class Actividad1 {
    public static void main(String[] args) {
        int[][] mat= {{4,5,6},{7,8,9},{5,6,7}}; // 1
        int acum=0; // 1
        int cant = 0; // 1
        for (int i = 0 ; i<mat.length ; i++){ // 1 + n + 2n = 3n + 1
            for (int j = 0 ; j<mat[i].length ; j++){ // 3n + 1
                acum+=mat[i][j]; // 3n
                cant++; // 2n
            }
        }
       float promedio = (float)acum/cant; // 3
        System.out.println(promedio); // 1
    }
}

// f(n) = 1 + 1 + 1 + 3n + 1 + n (3n + 1 + 3n + 2n) + 3 + 1 = 8 + 5n + 8n^2
// 8n^2 + 5n + 8
// 8n^2 + 5n + 8 <= c * n^2
// 8n^2 / n^2 + 5n / n^2 + 8 / n^2  <= c * n^2 / n^2
// 8 + 5 / n + 8 /n^2 <= c
// vemos para n=1
// 8 + 5 + 8 <= c
// 21 <= c
// f(n) = 8n^2 + 5n + 8 pertenece a O(n^2) con c=21 y n0=1