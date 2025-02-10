package clase4;

class Cliente1 {
    int id;
    String nombre;
    int scoring;

    public Cliente1(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "clase2.Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + "}";
    }
}

public class clase4actividad1 {
    public static Cliente1 encontrarMaxScoring(Cliente1[] clientes, int inicio, int fin) {
        // Caso base: si hay un solo cliente, es el máximo
        if (inicio == fin) {
            return clientes[inicio];
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;
        Cliente1 maxIzquierda = encontrarMaxScoring(clientes, inicio, medio);
        Cliente1 maxDerecha = encontrarMaxScoring(clientes, medio + 1, fin);

        // Comparar los máximos de cada mitad y devolver el mayor
        return (maxIzquierda.scoring >= maxDerecha.scoring) ? maxIzquierda : maxDerecha;
    }

    public static void main(String[] args) {
        // Lista de clientes
        Cliente1[] clientes = {
                new Cliente1(1, "Juan", 75),
                new Cliente1(2, "Ana", 90),
                new Cliente1(3, "Luis", 85),
                new Cliente1(4, "Maria", 95),
                new Cliente1(5, "Pedro", 88)
        };

        // Llamada a la función
        Cliente1 clienteMaximo = encontrarMaxScoring(clientes, 0, clientes.length - 1);
        System.out.println("clase2.Cliente con máximo scoring: " + clienteMaximo);
    }
}
