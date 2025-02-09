package Clase4;
import java.util.List;

public class actividad1_MaxScoring {

    // Método principal para encontrar el cliente con el scoring máximo
    public static Cliente buscarMaxScoring(List<Cliente> clientes, int inicio, int fin) {
        // Caso base: si hay un solo cliente
        if (inicio == fin) {
            return clientes.get(inicio);
        }

        // Dividir: calcular el punto medio
        int medio = (inicio + fin) / 2;

        // Resolver recursivamente para ambas mitades
        Cliente maxIzquierda = buscarMaxScoring(clientes, inicio, medio);
        Cliente maxDerecha = buscarMaxScoring(clientes, medio + 1, fin);

        // Combinar: retornar el cliente con mayor scoring entre las dos mitades
        return (maxIzquierda.scoring > maxDerecha.scoring) ? maxIzquierda : maxDerecha;
    }

    static class Cliente {
        int id;
        String nombre;
        double scoring;

        public Cliente(int id, String nombre, double scoring) {
            this.id = id;
            this.nombre = nombre;
            this.scoring = scoring;
        }
        public String toString() {
            return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + '}';
        }
    }


    public static void main(String[] args) {
        List<Cliente> clientes = List.of(
                new Cliente(1, "Ana", 75.5),
                new Cliente(2, "Andres", 82.3),
                new Cliente(3, "Lucas", 90.0),
                new Cliente(4, "Carla", 88.1),
                new Cliente(5, "Nicolas", 95.6)
        );

        // Llamar al método recursivo para encontrar el cliente con el scoring máximo
        Cliente clienteMaximo = buscarMaxScoring(clientes, 0, clientes.size() - 1);

        // Mostrar el resultado
        System.out.println("Cliente con el scoring máximo: " + clienteMaximo);
    }
}
