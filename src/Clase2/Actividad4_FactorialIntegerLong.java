package Clase2;
import java.math.BigInteger;

public class Actividad4_FactorialIntegerLong {

    public static long factorialLong(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static BigInteger factorialBigInteger(int n) {
        BigInteger resultado = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }

    public static void main(String[] args) {
        int numberLong = 20; // Example number for long
        int numberBigInteger = 100; // Example number for BigInteger

        System.out.println("Factorial de " + numberLong + " usando long es: " + factorialLong(numberLong));
        System.out.println("Factorial of " + numberBigInteger + " usando BigInteger es: " + factorialBigInteger(numberBigInteger));
    }
}
//long: Más rápido pero limitado a números más pequeños.
//BigInteger: Más lento pero puede manejar números muy grandes.