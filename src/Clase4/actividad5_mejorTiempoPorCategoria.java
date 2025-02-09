package Clase4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class actividad5_mejorTiempoPorCategoria {

    public static Map<String, Corredor> mejorTiempoPorCategoria(List<Corredor> corredores, int inicio, int fin) {
        if (inicio == fin) {
            Map<String, Corredor> resultado = new HashMap<>();
            resultado.put(corredores.get(inicio).categoria, corredores.get(inicio));
            return resultado;
        }

        int medio = (inicio + fin) / 2;

        Map<String, Corredor> mejorIzquierda = mejorTiempoPorCategoria(corredores, inicio, medio);
        Map<String, Corredor> mejorDerecha = mejorTiempoPorCategoria(corredores, medio + 1, fin);

        return combinarResultados(mejorIzquierda, mejorDerecha);
    }

    private static Map<String, Corredor> combinarResultados(Map<String, Corredor> mejorIzquierda, Map<String, Corredor> mejorDerecha) {
        Map<String, Corredor> resultado = new HashMap<>(mejorIzquierda);

        for (Map.Entry<String, Corredor> entrada : mejorDerecha.entrySet()) {
            String categoria = entrada.getKey();
            Corredor corredorDerecha = entrada.getValue();

            if (!resultado.containsKey(categoria) || corredorDerecha.tiempo < resultado.get(categoria).tiempo) {
                resultado.put(categoria, corredorDerecha);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        List<Corredor> corredores = new ArrayList<>();
        corredores.add(new Corredor("Damian", "Senior", 12.5));
        corredores.add(new Corredor("Carlos", "Junior", 11.3));
        corredores.add(new Corredor("Ana", "Senior", 10.8));
        corredores.add(new Corredor("Rodrigo", "Junior", 12.1));
        corredores.add(new Corredor("Carla", "Senior", 11.0));

        Map<String, Corredor> mejoresTiempos = mejorTiempoPorCategoria(corredores, 0, corredores.size() - 1);

        for (Map.Entry<String, Corredor> entrada : mejoresTiempos.entrySet()) {
            System.out.println("Categoría: " + entrada.getKey() + ", Mejor Corredor: " + entrada.getValue());
        }
    }

    static class Corredor {
        String nombre;
        String categoria;
        double tiempo;

        public Corredor(String nombre, String categoria, double tiempo) {
            this.nombre = nombre;
            this.categoria = categoria;
            this.tiempo = tiempo;
        }

        @Override
        public String toString() {
            return "Corredor{nombre='" + nombre + "', categoria='" + categoria + "', tiempo=" + tiempo + '}';
        }
    }
}