class FactorialLong {
    public static void main(String[] args) {
        int n = 20; 
        long factorial = calcularFactorial(n);

        if (factorial == -1) {
            System.out.println("El factorial de " + n + " es demasiado grande para ser almacenado en un long.");
        } else {
            System.out.println("El factorial de " + n + " es: " + factorial);
        }
    }

   
    public static long calcularFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }

        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            if (resultado > Long.MAX_VALUE / i) {
                return -1; 
            }
            resultado *= i;
        }
        return resultado;
    }
}