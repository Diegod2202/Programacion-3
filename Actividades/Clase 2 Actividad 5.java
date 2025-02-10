class SumaRecursiva {

    public static void main(String[] args) {
        int n = 10;
        int resultado = sumarNumeros(n);
        System.out.println("La suma de los primeros " + n + " números enteros es: " + resultado);
    }

    public static int sumarNumeros(int n) {
        if (n == 0) {
            return 0;
        }
       
        return n + sumarNumeros(n - 1);
    }
}