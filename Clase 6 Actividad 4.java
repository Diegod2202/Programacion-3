import java.util.*;

class CentroDistribucion {
    private String nombre;
    private Map<CentroDistribucion, Integer> rutas;

    public CentroDistribucion(String nombre) {
        this.nombre = nombre;
        this.rutas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Map<CentroDistribucion, Integer> getRutas() {
        return rutas;
    }

    public void agregarRuta(CentroDistribucion destino, int tiempo) {
        rutas.put(destino, tiempo);
    }
}

class Dijkstra {
    public Map<CentroDistribucion, Integer> calcularTiemposMinimos(CentroDistribucion origen) {
        Map<CentroDistribucion, Integer> tiemposMinimos = new HashMap<>();
        PriorityQueue<CentroDistribucion> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(tiemposMinimos::get));
        Set<CentroDistribucion> visitados = new HashSet<>();

        tiemposMinimos.put(origen, 0);
        colaPrioridad.add(origen);

        while (!colaPrioridad.isEmpty()) {
            CentroDistribucion actual = colaPrioridad.poll();
            visitados.add(actual);

            for (Map.Entry<CentroDistribucion, Integer> entrada : actual.getRutas().entrySet()) {
                CentroDistribucion vecino = entrada.getKey();
                int tiempo = entrada.getValue();

                if (!visitados.contains(vecino)) {
                    int nuevoTiempo = tiemposMinimos.get(actual) + tiempo;
                    if (nuevoTiempo < tiemposMinimos.getOrDefault(vecino, Integer.MAX_VALUE)) {
                        tiemposMinimos.put(vecino, nuevoTiempo);
                        colaPrioridad.add(vecino);
                    }
                }
            }
        }

        return tiemposMinimos;
    }
}

public class Logistica {
    public static void main(String[] args) {
        CentroDistribucion centroA = new CentroDistribucion("Centro A");
        CentroDistribucion centroB = new CentroDistribucion("Centro B");
        CentroDistribucion centroC = new CentroDistribucion("Centro C");
        CentroDistribucion centroD = new CentroDistribucion("Centro D");

        centroA.agregarRuta(centroB, 10);
        centroA.agregarRuta(centroC, 15);
        centroB.agregarRuta(centroD, 12);
        centroC.agregarRuta(centroD, 10);

        Dijkstra dijkstra = new Dijkstra();
        Map<CentroDistribucion, Integer> tiemposMinimos = dijkstra.calcularTiemposMinimos(centroA);

        for (Map.Entry<CentroDistribucion, Integer> entrada : tiemposMinimos.entrySet()) {
            System.out.println("Tiempo mínimo desde " + centroA.getNombre() + " hasta " + entrada.getKey().getNombre() + ": " + entrada.getValue() + " minutos");
        }
    }
}