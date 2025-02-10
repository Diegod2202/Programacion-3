package Clase_7.Actividad_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();
        if(num1 == 0) {
            System.out.println("El numero 0 no esta definido ni como par ni como impar.");
            return;
        }
        if(num1 < 0){
            int num = Math.abs(num1);
            for(int i = 1; i <= num; i++){
                if(i%2 == 0){
                    System.out.println("-" + i + " es par.");
                } else {
                    System.out.println("-" +i + " es impar.");
                }
            }
        }
        for(int i = 1; i <= num1; i++){
            if(i%2 == 0){
                System.out.println(i + " es par.");
            } else {
                System.out.println(i + " es impar.");
            }
        }
    }
}
