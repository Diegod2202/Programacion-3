package Clase_6.Actividad_3;


import java.util.*;

class EstacionElectrica {
    private String nombre;
    private List<Conexion> conexiones;

    public EstacionElectrica(String nombre) {
        this.nombre = nombre;
        this.conexiones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Conexion> getConexiones() {
        return conexiones;
    }

    public void agregarConexion(Conexion conexion) {
        conexiones.add(conexion);
    }
}

class Conexion {
    private EstacionElectrica destino;
    private int costo;

    public Conexion(EstacionElectrica destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }

    public EstacionElectrica getDestino() {
        return destino;
    }

    public int getCosto() {
        return costo;
    }
}

class RedDistribucionElectrica {
    private Map<String, EstacionElectrica> estaciones;

    public RedDistribucionElectrica() {
        this.estaciones = new HashMap<>();
    }

    public void agregarEstacion(String nombre) {
        estaciones.put(nombre, new EstacionElectrica(nombre));
    }

    public void agregarConexion(String origen, String destino, int costo) {
        EstacionElectrica estacionOrigen = estaciones.get(origen);
        EstacionElectrica estacionDestino = estaciones.get(destino);
        if (estacionOrigen != null && estacionDestino != null) {
            estacionOrigen.agregarConexion(new Conexion(estacionDestino, costo));
            estacionDestino.agregarConexion(new Conexion(estacionOrigen, costo));
        }
    }

    public Set<Conexion> aplicarAlgoritmoDePrim() {
        Set<Conexion> resultado = new HashSet<>();
        PriorityQueue<Conexion> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Conexion::getCosto));
        Set<EstacionElectrica> visitados = new HashSet<>();

        EstacionElectrica estacionInicial = estaciones.values().iterator().next();
        visitados.add(estacionInicial);
        colaPrioridad.addAll(estacionInicial.getConexiones());

        while (!colaPrioridad.isEmpty()) {
            Conexion conexion = colaPrioridad.poll();
            if (visitados.contains(conexion.getDestino())) {
                continue;
            }
            resultado.add(conexion);
            visitados.add(conexion.getDestino());
            for (Conexion siguienteConexion : conexion.getDestino().getConexiones()) {
                if (!visitados.contains(siguienteConexion.getDestino())) {
                    colaPrioridad.add(siguienteConexion);
                }
            }
        }
        return resultado;
    }

    public int calcularCostoTotal(Set<Conexion> conexiones) {
        return conexiones.stream().mapToInt(Conexion::getCosto).sum();
    }
}

public class Main {
    public static void main(String[] args) {
        RedDistribucionElectrica red = new RedDistribucionElectrica();
        red.agregarEstacion("A");
        red.agregarEstacion("B");
        red.agregarEstacion("C");
        red.agregarEstacion("D");
        red.agregarConexion("A", "B", 10);
        red.agregarConexion("A", "C", 15);
        red.agregarConexion("B", "D", 12);
        red.agregarConexion("C", "D", 10);

        Set<Conexion> arbolRecubrimientoMinimo = red.aplicarAlgoritmoDePrim();
        int costoTotal = red.calcularCostoTotal(arbolRecubrimientoMinimo);

        System.out.println("Conexiones del Árbol de Recubrimiento Mínimo:");
        for (Conexion conexion : arbolRecubrimientoMinimo) {
            System.out.println(conexion.getDestino().getNombre() + " - Costo: " + conexion.getCosto());
        }
        System.out.println("Costo Total: " + costoTotal);
    }
}