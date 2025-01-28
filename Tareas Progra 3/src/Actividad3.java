import java.util.Scanner;

public class Actividad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el primer número
        System.out.print("Ingresa el primer número: ");
        double numero1 = scanner.nextDouble();

        // Solicitar el segundo número
        System.out.print("Ingresa el segundo número: ");
        double numero2 = scanner.nextDouble();

        // Solicitar la operación matemática
        System.out.print("Selecciona una operación (suma, resta, multiplicacion, division): ");
        String operacion = scanner.next().toLowerCase();

        // Realizar la operación seleccionada
        double resultado;
        switch (operacion) {
            case "suma":
                resultado = numero1 + numero2;
                System.out.println("El resultado de la suma es: " + resultado);
                break;
            case "resta":
                resultado = numero1 - numero2;
                System.out.println("El resultado de la resta es: " + resultado);
                break;
            case "multiplicacion":
                resultado = numero1 * numero2;
                System.out.println("El resultado de la multiplicación es: " + resultado);
                break;
            case "division":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                    System.out.println("El resultado de la división es: " + resultado);
                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                }
                break;
            default:
                System.out.println("Operación no válida.");
        }

        scanner.close();
    }
}
