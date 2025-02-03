package Clase2;

public class Actividad5_SumaEnterosRecursion {
    public static void main(String[] args) {
        System.out.println(sumaEnteros(5));
    }

    public static int sumaEnteros(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumaEnteros(n - 1);
        }
    }
}

// complejidad temporal O(n) donde n es el numero de enteros a sumar
// analisis de recurrencia T(n) = T(n-1) + 1
