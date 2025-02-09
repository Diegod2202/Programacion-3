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
