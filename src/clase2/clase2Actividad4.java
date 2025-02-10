package clase2;

import java.math.BigInteger;

public class clase2Actividad4 {
    public static long factorialLong(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Método para calcular factorial con BigInteger (sin límite práctico)
    public static BigInteger factorialBigInteger(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }

    public static void main(String[] args) {
        int numero = 20;

        // Factorial con long
        System.out.println("Factorial de " + numero + " con long: " + factorialLong(numero));

        // Factorial con BigInteger
        numero = 100; // Cambiamos a 100! para probar BigInteger
        System.out.println("Factorial de " + numero + " con BigInteger: " + factorialBigInteger(numero));
    }
}

//long sirve hasta 20! porque 21! excede su capacidad.
//BigInteger es ideal para valores grandes porque no tiene límite.