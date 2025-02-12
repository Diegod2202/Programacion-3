import java.util.*;

class Corredor {
    String nombre;
    String categoria;
    int tiempo;

    public Corredor(String nombre, String categoria, int tiempo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tiempo = tiempo;
    }
}

public class CampeonatoAtletismo {

    public static void main(String[] args) {
        // Lista de corredores
        List<Corredor> corredores = Arrays.asList(
                new Corredor("Juan", "A", 300),
                new Corredor("Ana", "B", 280),
                new Corredor("Luis", "A", 290),
                new Corredor("Maria", "B", 270),
                new Corredor("Pedro", "C", 320)
        );

        // Encontrar los mejores tiempos por categoría
        Map<String, Corredor> mejoresTiempos = encontrarMejoresTiempos(corredores, 0, corredores.size() - 1);

        // Mostrar los resultados
        for (Map.Entry<String, Corredor> entry : mejoresTiempos.entrySet()) {
            System.out.println("Categoría: " + entry.getKey() +
                    ", Mejor Tiempo: " + entry.getValue().tiempo +
                    ", Corredor: " + entry.getValue().nombre);
        }
    }

    // Método para encontrar los mejores tiempos por categoría usando Divide y Conquista
    public static Map<String, Corredor> encontrarMejoresTiempos(List<Corredor> corredores, int inicio, int fin) {
        Map<String, Corredor> mejoresTiempos = new HashMap<>();

        // Caso base: un solo corredor
        if (inicio == fin) {
            Corredor corredor = corredores.get(inicio);
            mejoresTiempos.put(corredor.categoria, corredor);
            return mejoresTiempos;
        }

        // Dividir la lista en dos mitades
        int medio = inicio + (fin - inicio) / 2;

        // Resolver recursivamente para cada mitad
        Map<String, Corredor> mejoresIzquierda = encontrarMejoresTiempos(corredores, inicio, medio);
        Map<String, Corredor> mejoresDerecha = encontrarMejoresTiempos(corredores, medio + 1, fin);

        // Combinar: encontrar el mejor tiempo por categoría
        return combinarMejoresTiempos(mejoresIzquierda, mejoresDerecha);
    }

    // Método para combinar los mejores tiempos de ambas mitades
    private static Map<String, Corredor> combinarMejoresTiempos(Map<String, Corredor> mejoresIzquierda, Map<String, Corredor> mejoresDerecha) {
        Map<String, Corredor> mejoresCombinados = new HashMap<>();

        // Combinar los mejores tiempos de la mitad izquierda
        for (Map.Entry<String, Corredor> entry : mejoresIzquierda.entrySet()) {
            String categoria = entry.getKey();
            Corredor corredor = entry.getValue();

            if (!mejoresCombinados.containsKey(categoria) || corredor.tiempo < mejoresCombinados.get(categoria).tiempo) {
                mejoresCombinados.put(categoria, corredor);
            }
        }

        // Combinar los mejores tiempos de la mitad derecha
        for (Map.Entry<String, Corredor> entry : mejoresDerecha.entrySet()) {
            String categoria = entry.getKey();
            Corredor corredor = entry.getValue();

            if (!mejoresCombinados.containsKey(categoria) || corredor.tiempo < mejoresCombinados.get(categoria).tiempo) {
                mejoresCombinados.put(categoria, corredor);
            }
        }

        return mejoresCombinados;
    }
}