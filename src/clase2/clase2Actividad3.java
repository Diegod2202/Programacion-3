package clase2;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class Factura {
    int idFactura;
    int idCliente;
    double importe;

    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}

class Cliente {
    int idCliente;
    String nombre;

    public Cliente(int idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }
}

public class clase2Actividad3 {
    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 101, 500.0));
        facturas.add(new Factura(2, 102, 700.0));
        facturas.add(new Factura(3, 101, 300.0));
        facturas.add(new Factura(4, 103, 900.0));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(101, "Juan"));
        clientes.add(new Cliente(102, "Maria"));
        clientes.add(new Cliente(103, "Pedro"));

        // Implementación sin Maps (O(n^2))
        List<String> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            double total = 0;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    total += factura.importe;
                }
            }
            resultado.add(cliente.idCliente + ", " + cliente.nombre + ", " + total);
        }

        System.out.println("Resultado sin Map:");
        for (String res : resultado) {
            System.out.println(res);
        }

        // Implementación con Maps (O(n))
        Map<Integer, Double> sumaImportes = new HashMap<>();
        for (Factura factura : facturas) {
            sumaImportes.put(factura.idCliente, sumaImportes.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        System.out.println("\nResultado con Map:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.idCliente + ", " + cliente.nombre + ", " + sumaImportes.getOrDefault(cliente.idCliente, 0.0));
        }
    }
}

// La versión con Map es más eficiente al reducir la complejidad de búsqueda y suma.