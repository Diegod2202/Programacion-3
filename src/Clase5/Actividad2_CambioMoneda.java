package Clase5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class actividad2_cambioMoneda {

    public static List<Comprobante> minimizarComprobantes(List<Comprobante> comprobantes, double monto) {
        // Ordenar los comprobantes por valor en orden descendente
        comprobantes.sort(new Comparator<Comprobante>() {
            @Override
            public int compare(Comprobante c1, Comprobante c2) {
                return Double.compare(c2.valor, c1.valor);
            }
        });

        List<Comprobante> resultado = new ArrayList<>();
        double suma = 0;

        // Seleccionar los comprobantes necesarios
        for (Comprobante comprobante : comprobantes) {
            if (suma + comprobante.valor <= monto) {
                resultado.add(comprobante);
                suma += comprobante.valor;
            }
            if (suma == monto) {
                break;
            }
        }

        return resultado;
    }
    static class Comprobante {
        String tipo;
        double valor;

        public Comprobante(String tipo, double valor) {
            this.tipo = tipo;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "Comprobante{tipo='" + tipo + "', valor=" + valor + '}';
        }
    }

    public static void main(String[] args) {
        List<Comprobante> comprobantes = new ArrayList<>();
        comprobantes.add(new Comprobante("Moneda", 50));
        comprobantes.add(new Comprobante("Cheque", 100));
        comprobantes.add(new Comprobante("Bono", 200));
        comprobantes.add(new Comprobante("Documento", 20));

        double monto = 270;
        List<Comprobante> resultado = minimizarComprobantes(comprobantes, monto);

        System.out.println("Comprobantes seleccionados:");
        for (Comprobante comprobante : resultado) {
            System.out.println(comprobante);
        }
    }
}