package clase6;

import java.util.*;

class Conexion implements Comparable<Conexion> {  // clase6.Arista -> clase6.Conexion
    int destino, tiempo;  // peso -> tiempo

    public Conexion(int destino, int tiempo) {
        this.destino = destino;
        this.tiempo = tiempo;
    }

    @Override
    public int compareTo(Conexion otra) {
        return Integer.compare(this.tiempo, otra.tiempo);
    }
}

class RedLogistica {  // clase6.Grafo -> clase6.RedLogistica
    private int numCentros;  // numVertices -> numCentros
    private List<List<Conexion>> mapaRutas;  // listaAdyacencia -> mapaRutas

    public RedLogistica(int numCentros) {
        this.numCentros = numCentros;
        mapaRutas = new ArrayList<>();
        for (int i = 0; i < numCentros; i++) {
            mapaRutas.add(new ArrayList<>());
        }
    }

    public void agregarRuta(int origen, int destino, int tiempo) {  // agregarArista -> agregarRuta
        mapaRutas.get(origen).add(new Conexion(destino, tiempo));
        mapaRutas.get(destino).add(new Conexion(origen, tiempo)); // Red bidireccional
    }

    public void calcularRutaOptima(int centroInicial) {  // dijkstra() -> calcularRutaOptima()
        PriorityQueue<Conexion> pq = new PriorityQueue<>();
        int[] tiemposMinimos = new int[numCentros];  // distancias -> tiemposMinimos
        Arrays.fill(tiemposMinimos, Integer.MAX_VALUE);
        tiemposMinimos[centroInicial] = 0;
        pq.add(new Conexion(centroInicial, 0));

        while (!pq.isEmpty()) {
            Conexion actual = pq.poll();
            int centroActual = actual.destino;

            for (Conexion ruta : mapaRutas.get(centroActual)) {
                int nuevoTiempo = tiemposMinimos[centroActual] + ruta.tiempo;
                if (nuevoTiempo < tiemposMinimos[ruta.destino]) {
                    tiemposMinimos[ruta.destino] = nuevoTiempo;
                    pq.add(new Conexion(ruta.destino, nuevoTiempo));
                }
            }
        }

        // Mostrar resultado
        System.out.println("Tiempo mínimo de entrega desde el centro principal:");
        for (int i = 0; i < numCentros; i++) {
            System.out.println("Centro " + i + " -> Tiempo: " + tiemposMinimos[i] + " minutos");
        }
    }
}

public class clase6actividad4 {  // Main -> PlanificadorRutas
    public static void main(String[] args) {
        RedLogistica red = new RedLogistica(4); // 4 centros de distribución

        // Agregar conexiones entre centros con tiempos de viaje (en minutos)
        red.agregarRuta(0, 1, 10);
        red.agregarRuta(0, 2, 5);
        red.agregarRuta(1, 2, 2);
        red.agregarRuta(1, 3, 1);
        red.agregarRuta(2, 3, 8);

        // Ejecutar el Algoritmo de Dijkstra desde el centro 0 (A)
        red.calcularRutaOptima(0);
    }
}
