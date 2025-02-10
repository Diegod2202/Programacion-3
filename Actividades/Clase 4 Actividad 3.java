class Cliente {
    int id;
    String nombre;
    int scoring;

    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", scoring=" + scoring +
                '}';
    }
}

public class DosMaximosScoringDivideYConquista {

    public static void main(String[] args) {
        // Lista de clientes
        Cliente[] clientes = {
                new Cliente(1, "Juan", 85),
                new Cliente(2, "Ana", 90),
                new Cliente(3, "Luis", 78),
                new Cliente(4, "Maria", 95),
                new Cliente(5, "Pedro", 88)
        };

        // Encontrar los dos clientes con los scoring máximos
        Cliente[] resultado = encontrarDosMaximosScoring(clientes, 0, clientes.length - 1);

        // Mostrar el resultado
        System.out.println("El cliente con el scoring máximo es: " + resultado[0]);
        System.out.println("El segundo cliente con el scoring máximo es: " + resultado[1]);
    }

    // Método para encontrar los dos clientes con los scoring máximos usando Divide y Conquista
    public static Cliente[] encontrarDosMaximosScoring(Cliente[] clientes, int inicio, int fin) {
        // Caso base: si solo hay un cliente
        if (inicio == fin) {
            return new Cliente[]{clientes[inicio], null};
        }

        // Caso base: si hay dos clientes
        if (fin - inicio == 1) {
            if (clientes[inicio].scoring > clientes[fin].scoring) {
                return new Cliente[]{clientes[inicio], clientes[fin]};
            } else {
                return new Cliente[]{clientes[fin], clientes[inicio]};
            }
        }

        // Dividir la lista en dos mitades
        int medio = inicio + (fin - inicio) / 2;

        // Resolver recursivamente para cada mitad
        Cliente[] maxIzquierda = encontrarDosMaximosScoring(clientes, inicio, medio);
        Cliente[] maxDerecha = encontrarDosMaximosScoring(clientes, medio + 1, fin);

        // Combinar: encontrar los dos clientes con los scoring máximos entre las dos mitades
        Cliente max1, max2;
        if (maxIzquierda[0].scoring > maxDerecha[0].scoring) {
            max1 = maxIzquierda[0];
            max2 = (maxIzquierda[1] != null && maxIzquierda[1].scoring > maxDerecha[0].scoring) ? maxIzquierda[1] : maxDerecha[0];
        } else {
            max1 = maxDerecha[0];
            max2 = (maxDerecha[1] != null && maxDerecha[1].scoring > maxIzquierda[0].scoring) ? maxDerecha[1] : maxIzquierda[0];
        }

        return new Cliente[]{max1, max2};
    }
}