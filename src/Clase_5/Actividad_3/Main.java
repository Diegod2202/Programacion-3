package Clase_5.Actividad_3;

import java.util.Arrays;
import java.util.Comparator;

class Elemento {
    double peso;
    double valor;

    public Elemento(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }
}

public class Main {

    public static double maximizarValorCamion(Elemento[] elementos, double capacidad) {
        // Calcular el valor por unidad de peso para cada elemento
        for (Elemento elemento : elementos) {
            elemento.valor = elemento.valor / elemento.peso;
        }
        Arrays.sort(elementos, new Comparator<Elemento>() {
            @Override
            public int compare(Elemento o1, Elemento o2) {
                return Double.compare(o2.valor, o1.valor);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        double valorTotal = 0;
        double pesoActual = 0;

        for (Elemento elemento : elementos) {
            if (pesoActual + elemento.peso <= capacidad) {
                pesoActual += elemento.peso;
                valorTotal += elemento.valor * elemento.peso;
            } else {
                double pesoRestante = capacidad - pesoActual;
                valorTotal += elemento.valor * pesoRestante;
                break;
            }
        }

        return valorTotal;
    }
}