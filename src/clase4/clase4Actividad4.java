package clase4;

import java.util.ArrayList;
import java.util.List;

public class clase4Actividad4 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        numeros.add(1);
        numeros.add(21);
        numeros.add(33);
        numeros.add(40);
        numeros.add(2);
        numeros.add(50);
        numeros.add(10);

        System.out.println(obtenerMayores(numeros, 5));
    }

    public static List<Integer> obtenerMayores(List<Integer> numeros, int n){
        int size = numeros.size();

        Integer[] array = numeros.toArray(new Integer[size]);


        return numeros;
    }}

/* Pseudocódigo:

Inicio
    Definir lista numeros como una lista vacía

    // Agregar elementos a la lista
    Agregar 1 a numeros
    Agregar 21 a numeros
    Agregar 33 a numeros
    Agregar 40 a numeros
    Agregar 2 a numeros
    Agregar 50 a numeros
    Agregar 10 a numeros

    // Llamada a la función para obtener los mayores
    Escribir obtenerMayores(numeros, 5)
Fin

Función obtenerMayores(numeros, n)
    size ← Tamaño de numeros

    // Convertir lista a arreglo
    array ← Convertir numeros a un arreglo de enteros

    Retornar numeros // (Actualmente la función aún no está implementada)
Fin Función
*/