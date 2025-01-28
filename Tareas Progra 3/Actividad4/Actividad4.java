import java.util.Scanner;
public class Actividad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un numero entero: ");

        int numero = sc.nextInt();

        for (int i = 1; i <= numero; i++) {
            if (i % 2 == 0) {
                System.out.println("El numero: " + i + " es par");
            } else {
                System.out.println("El numero: " + i + " es impar");
            }
        }
    }
}