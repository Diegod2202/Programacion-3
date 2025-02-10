package Clase5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class actividad3_camion {
        public static List<Item> cargarCamion(List<Item> items, double capacidad) {
            // Ordenar los elementos por valor por unidad de peso en orden descendente
            items.sort(Comparator.comparingDouble(Item::getValorPorPeso).reversed());
            System.out.println("Elementos ordenados:" + items);
            System.out.println("Capacidad: " + capacidad);

            List<Item> resultado = new ArrayList<>();
            System.out.println("Resultado: " + resultado);
            double pesoRestante = capacidad;
            System.out.println("Peso restante: " + pesoRestante);
            for (Item item : items) {
                System.out.println(item);
                if (pesoRestante == 0) break;
                if (item.peso <= pesoRestante) {
                    resultado.add(item);
                    System.out.println("resultado: " + resultado);
                    pesoRestante -= item.peso;
                    System.out.println("Peso restante: " + pesoRestante);
                } else {
                    // Agregar una fracción del elemento
                    double fraccion = pesoRestante / item.peso;
                    System.out.println("Fraccion: " + fraccion +"  " + item.peso);
                    resultado.add(new Item(pesoRestante, item.valor * fraccion));

                    pesoRestante = 0;
                }
            }
            return resultado;
        }

        static class Item {
            double peso;
            double valor;

            public Item(double peso, double valor) {
                this.peso = peso;
                this.valor = valor;
            }

            public double getValorPorPeso() {
                return valor / peso;
            }
            public String toString() {
                return "Item {peso=" + peso + ", valor=" + valor + ", valorPorPeso=" + getValorPorPeso() + "}";
            }
        }

            public static void main(String[] args) {
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
//complejidad algoritmo: O(n log n) donde n es el tamaño de la lista de items que se ordena}
