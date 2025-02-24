package clase15;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class clase15Actividad3 {

    // Principio de Responsabilidad Única (SRP)
    class Sucursal {
        private String nombre;
        private double monto;

        public Sucursal(String nombre, double monto) {
            this.nombre = nombre;
            this.monto = monto;
        }

        public String getNombre() {
            return nombre;
        }

        public double getMonto() {
            return monto;
        }
    }

    // Principio de Abierto/Cerrado (OCP)
    class PlanificadorRecorrido {
        private double saldoInicial;
        private List<Sucursal> sucursales;

        public PlanificadorRecorrido(double saldoInicial, List<Sucursal> sucursales) {
            this.saldoInicial = saldoInicial;
            this.sucursales = new ArrayList<>(sucursales);
        }

        // Heurística: Ordenar sucursales por monto de cobro (de mayor a menor)
        private void ordenarSucursales() {
            Collections.sort(sucursales, Comparator.comparingDouble(Sucursal::getMonto).reversed());
        }

        // Planificar recorrido
        public List<Sucursal> planificarRecorrido() {
            ordenarSucursales();
            List<Sucursal> recorrido = new ArrayList<>();
            double saldoActual = saldoInicial;

            for (Sucursal sucursal : sucursales) {
                if (saldoActual + sucursal.getMonto() >= 0) {
                    recorrido.add(sucursal);
                    saldoActual += sucursal.getMonto();
                }
            }

            return recorrido;
        }
    }

    // Principio de Sustitución de Liskov (LSP) y Principio de Segregación de Interfaces (ISP)
    interface Reporte {
        void generarReporte(List<Sucursal> recorrido);
    }

    class ReporteTexto implements Reporte {
        @Override
        public void generarReporte(List<Sucursal> recorrido) {
            System.out.println("Recorrido planificado:");
            for (Sucursal sucursal : recorrido) {
                System.out.println("Sucursal: " + sucursal.getNombre() + ", Monto: " + sucursal.getMonto());
            }
        }
    }

    // Principio de Inversión de Dependencias (DIP)
    public class Main {
        public static void main(String[] args) {
            // Crear sucursales
            List<Sucursal> sucursales = new ArrayList<>();
            sucursales.add(new Sucursal("Sucursal A", 100));
            sucursales.add(new Sucursal("Sucursal B", -50));
            sucursales.add(new Sucursal("Sucursal C", 200));
            sucursales.add(new Sucursal("Sucursal D", -30));
            sucursales.add(new Sucursal("Sucursal E", 150));

            // Planificar recorrido con saldo inicial de 100
            PlanificadorRecorrido planificador = new PlanificadorRecorrido(100, sucursales);
            List<Sucursal> recorrido = planificador.planificarRecorrido();

            // Generar reporte
            Reporte reporte = new ReporteTexto();
            reporte.generarReporte(recorrido);
        }
    }
}
