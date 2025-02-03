package Clase2.Actividad3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFacturacionConMaps {

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
            facturas.add(new Factura(2, 1, 150.0));
            facturas.add(new Factura(3, 2, 200.0));

            List<Cliente> clientes = new ArrayList<>();
            clientes.add(new Cliente(1, "Cliente A"));
            clientes.add(new Cliente(2, "Cliente B"));

            Map<Integer, ClienteImporte> resultadoMap = new HashMap<>();

            for (Factura factura : facturas) {
                resultadoMap.putIfAbsent(factura.idCliente, new ClienteImporte(factura.idCliente, "", 0));
                ClienteImporte ci = resultadoMap.get(factura.idCliente);
                ci.sumaImportes += factura.importe;
            }

            for (Cliente cliente : clientes) {
                ClienteImporte ci = resultadoMap.get(cliente.idCliente);
                if (ci != null) {
                    ci.nombre = cliente.nombre;
                }
            }

            for (ClienteImporte ci : resultadoMap.values()) {
                System.out.println(ci);
            }
        }
    }
}

//f(n) = 1 + 3
//complejidad asintotica O(1)
//o(n) = 1, c = 1