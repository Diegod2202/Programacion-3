package Clase4;
import java.util.Arrays;
import java.util.List;

public class actividad3_ClientesMayorScoring {
        public static class Cliente {
            int id;
            String nombre;
            double scoring;

            public Cliente(int id, String nombre, double scoring) {
                this.id = id;
                this.nombre = nombre;
                this.scoring = scoring;
            }

            @Override
            public String toString() {
                return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + '}';
            }
        }

        // Método principal para encontrar los dos clientes con los scoring máximos
        public static Cliente[] buscarDosClientesMaxScoring(List<Cliente> clientes, int inicio, int fin) {
            // Caso base: si hay un solo cliente
            if (inicio == fin) {
                return new Cliente[]{clientes.get(inicio), new Cliente(-1, "Dummy", Double.MIN_VALUE)};
            }

            // Dividir: calcular el punto medio
            int medio = (inicio + fin) / 2;

            // Resolver recursivamente para ambas mitades
            Cliente[] maxIzquierda = buscarDosClientesMaxScoring(clientes, inicio, medio);
            Cliente[] maxDerecha = buscarDosClientesMaxScoring(clientes, medio + 1, fin);

            // Combinar: encontrar los dos clientes con los scoring máximos entre las dos mitades
            Cliente[] resultado = new Cliente[2];
            Cliente[] todos = {maxIzquierda[0], maxIzquierda[1], maxDerecha[0], maxDerecha[1]};
            Arrays.sort(todos, (a, b) -> Double.compare(b.scoring, a.scoring));
            resultado[0] = todos[0];
            resultado[1] = todos[1];

            return resultado;
        }

        public static void main(String[] args) {
            // Crear una lista de clientes
            List<Cliente> clientes = List.of(
                    new Cliente(1, "Ana", 75.5),
                    new Cliente(2, "Andres", 82.3),
                    new Cliente(3, "Lucas", 90.0),
                    new Cliente(4, "Carla", 88.1),
                    new Cliente(5, "Nicolas", 95.6)
            );

            // Llamar al método recursivo para encontrar los dos clientes con los scoring máximos
            Cliente[] dosClientesMaximos = buscarDosClientesMaxScoring(clientes, 0, clientes.size() - 1);

            // Mostrar el resultado
            System.out.println("Dos clientes con los scoring máximos: " + dosClientesMaximos[0] + ", " + dosClientesMaximos[1]);
        }
    }

    // complejidad algoritmica: O(n log n) porque se divide el arreglo en dos mitades en cada llamada recursiva

