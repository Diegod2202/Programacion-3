package clase2;

public class clase2Actividad5 {

    public static int sumaRecursiva(int n) {
        if (n <= 0) return 0; // Caso base
        return n + sumaRecursiva(n - 1); // Llamada recursiva
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Suma de los primeros " + n + " números: " + sumaRecursiva(n));
    }
}
/*
Conclusión:
- La función sumaRecursiva(n) tiene una complejidad temporal de O(n) debido a la cantidad de llamadas recursivas necesarias.
- La complejidad espacial también es O(n) debido a la pila de llamadas recursivas
*/