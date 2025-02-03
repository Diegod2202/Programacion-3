import java.util.Scanner;
public class clase1Actividad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un primer numero:");
        double numero1 = sc.nextInt();
        System.out.println("Ingrese un segundo numero:");
        double numero2 = sc.nextInt();
        System.out.print("Introduce la operación (suma (s), resta (r), multiplicacion (m), division (d)): ");
        char operacion = sc.next().charAt(0);

        double resultado = 0.0;

        switch (operacion) {
            case 's':
                resultado = numero1 + numero2;
                System.out.println("La suma entre " + numero1 + " y " + numero2 + " es: " + resultado);
                break;
            case 'r':
                resultado = numero1 - numero2;
                System.out.println("La resta entre " + numero1 + " y " + numero2 + " es: " + resultado);
                break;
            case 'm':
                resultado = numero1 * numero2;
                System.out.println("La multiplicacion entre " + numero1 + " y " + numero2 + " es: " + resultado);
                break;
            case 'd':
                resultado = numero1 / numero2;
                System.out.println("La division entre " + numero1 + " y " + numero2 + " es: " + resultado);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        sc.close();

    }
}
