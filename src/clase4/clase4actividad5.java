package clase4;

import java.util.*;

class Corredor {
    String nombre;
    String categoria;
    int tiempo; // Tiempo en segundos

    public Corredor(String nombre, String categoria, int tiempo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Corredor{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", tiempo=" + tiempo +
                '}';
    }
}

public class clase4actividad5 {
    public static Map<String, Corredor> encontrarMejorTiempo(Corredor[] corredores, int inicio, int fin) {
        // Caso base: si hay un solo corredor, es el mejor de su categoría
        if (inicio == fin) {
            Map<String, Corredor> resultado = new HashMap<>();
            resultado.put(corredores[inicio].categoria, corredores[inicio]);
            return resultado;
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;
        Map<String, Corredor> mejoresIzquierda = encontrarMejorTiempo(corredores, inicio, medio);
        Map<String, Corredor> mejoresDerecha = encontrarMejorTiempo(corredores, medio + 1, fin);

        // Fusionar los resultados
        Map<String, Corredor> mejoresTiempos = new HashMap<>(mejoresIzquierda);
        for (String categoria : mejoresDerecha.keySet()) {
            if (!mejoresTiempos.containsKey(categoria) ||
                    mejoresDerecha.get(categoria).tiempo < mejoresTiempos.get(categoria).tiempo) {
                mejoresTiempos.put(categoria, mejoresDerecha.get(categoria));
            }
        }

        return mejoresTiempos;
    }

    public static void main(String[] args) {
        // Lista de corredores
        Corredor[] corredores = {
                new Corredor("Juan", "100m", 12),
                new Corredor("Ana", "200m", 24),
                new Corredor("Luis", "100m", 11),
                new Corredor("Maria", "200m", 22),
                new Corredor("Pedro", "100m", 13),
                new Corredor("Carlos", "400m", 50),
                new Corredor("Laura", "400m", 48)
        };

        // Llamada a la función
        Map<String, Corredor> resultado = encontrarMejorTiempo(corredores, 0, corredores.length - 1);

        // Mostrar los mejores tiempos por categoría
        System.out.println("Mejores tiempos por categoría:");
        for (String categoria : resultado.keySet()) {
            System.out.println("Categoría: " + categoria + " - " + resultado.get(categoria));
        }
    }
}
