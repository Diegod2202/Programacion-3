package clase5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Producto {
    double peso, valor, ratio;

    public Producto(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
        this.ratio = valor / peso; // Valor por unidad de peso
    }

    @Override
    public String toString() {
        return "Producto{peso=" + peso + ", valor=" + valor + ", ratio=" + ratio + "}";
    }
}

public class clase5actividad3 {
    public static List<String> maximizarCarga(List<Producto> productos, double capacidad) {
        // Ordenamos los productos por valor por unidad de peso en orden descendente
        productos.sort((a, b) -> Double.compare(b.ratio, a.ratio));

        List<String> cargaSeleccionada = new ArrayList<>();
        double valorTotal = 0.0;

        for (Producto producto : productos) {
            if (capacidad >= producto.peso) {
                // Se puede cargar todo el producto
                capacidad -= producto.peso;
                valorTotal += producto.valor;
                cargaSeleccionada.add("Producto completo: " + producto);
            } else {
                // Se carga solo una fracción del producto
                double fraccion = capacidad / producto.peso;
                valorTotal += producto.valor * fraccion;
                cargaSeleccionada.add("Fracción " + fraccion * 100 + "% de " + producto);
                break; // Ya no queda más espacio
            }
        }

        cargaSeleccionada.add("Valor total optimizado: " + valorTotal);
        return cargaSeleccionada;
    }

    public static void main(String[] args) {
        List<Producto> productos = List.of(
                new Producto(10, 60),  // Peso 10, valor 60
                new Producto(20, 100), // Peso 20, valor 100
                new Producto(30, 120)  // Peso 30, valor 120
        );
        double capacidad = 50; // Capacidad del camión

        List<String> resultado = maximizarCarga(new ArrayList<>(productos), capacidad);
        resultado.forEach(System.out::println);
    }
}
