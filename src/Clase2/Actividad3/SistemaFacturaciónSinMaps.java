package Clase2.Actividad3;

import java.util.ArrayList;
import java.util.List;

public class SistemaFacturaciónSinMaps {
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

    class ClienteImporte {
        int idCliente;
        String nombre;
        double sumaImportes;

        public ClienteImporte(int idCliente, String nombre, double sumaImportes) {
            this.idCliente = idCliente;
            this.nombre = nombre;
            this.sumaImportes = sumaImportes;
        }

        @Override
        public String toString() {
            return "ClienteImporte [idCliente=" + idCliente + ", nombre=" + nombre + ", sumaImportes=" + sumaImportes + "]";
        }
    }

    public void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 1, 100.0));
        facturas.add(new Factura(2, 1, 200.0));
        facturas.add(new Factura(3, 2, 300.0));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan"));
        clientes.add(new Cliente(2, "Pedro"));

        List<ClienteImporte> clientesImportes = new ArrayList<>();
        for (Cliente cliente : clientes) {
            double sumaImportes = 0;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    sumaImportes += factura.importe;
                }
            }
            clientesImportes.add(new ClienteImporte(cliente.idCliente, cliente.nombre, sumaImportes));
        }

        for (ClienteImporte clienteImporte : clientesImportes) {
            System.out.println(clienteImporte);
        }
    }
}
//f(n)= 1 + 3 + 3n + 1 + n(3 + 3n + 1 + 2n + n) + 1 + n + 1 + n = 5 + 3n + 3 + 3n^2 + n + 2n + n^2 + n + 2 = 5 + 3n + 3 + 4n^2 + 4n + 3 = 4n^2 + 4n + 8
//complejidad asintotica O(n^2) donde n es el numero de facturas y clientes
//c = 4, n0 = 1