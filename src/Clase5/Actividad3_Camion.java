package Clase5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Actividad3_Camion {

    class Item {
        double peso;
        double valor;

        public Item(double peso, double valor) {
            this.peso = peso;
            this.valor = valor;
        }

        public double getValorPorPeso() {
            return valor / peso;
        }
    }

    public class FraccionariaMochila {

        public List<Item> cargarCamion(List<Item> items, double capacidad) {
            // Ordenar los elementos por valor por unidad de peso en orden descendente
            Collections.sort(items, Comparator.comparingDouble(Item::getValorPorPeso).reversed());

            List<Item> resultado = new ArrayList<>();
            double pesoRestante = capacidad;

            for (Item item : items) {
                if (pesoRestante == 0) break;

                if (item.peso <= pesoRestante) {
                    resultado.add(item);
                    pesoRestante -= item.peso;
                } else {
                    // Agregar una fracción del elemento
                    double fraccion = pesoRestante / item.peso;
                    resultado.add(new Item(pesoRestante, item.valor * fraccion));
                    pesoRestante = 0;
                }
            }

            return resultado;
        }

        public void main(String[] args) {
            List<Item> items = new ArrayList<>();
            items.add(new Item(10, 60));
            items.add(new Item(20, 100));
            items.add(new Item(30, 120));

            double capacidad = 50;
            List<Item> resultado = cargarCamion(items, capacidad);

            System.out.println("Elementos seleccionados:");
            for (Item item : resultado) {
                System.out.println("Peso: " + item.peso + ", Valor: " + item.valor);
            }
        }
    }

}
