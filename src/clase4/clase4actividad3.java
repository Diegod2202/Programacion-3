package clase4;

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
        return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + "}";
    }
}

public class clase4actividad3 {
    public static Cliente[] encontrarDosMaximos(Cliente[] clientes, int inicio, int fin) {
        // Caso base: si hay solo dos clientes, devolver el de mayor y el segundo mayor
        if (fin - inicio == 1) {
            if (clientes[inicio].scoring > clientes[fin].scoring) {
                return new Cliente[]{clientes[inicio], clientes[fin]};
            } else {
                return new Cliente[]{clientes[fin], clientes[inicio]};
            }
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;
        Cliente[] maxIzquierda = encontrarDosMaximos(clientes, inicio, medio);
        Cliente[] maxDerecha = encontrarDosMaximos(clientes, medio + 1, fin);

        // Fusionar los resultados
        Cliente mayor, segundoMayor;
        if (maxIzquierda[0].scoring > maxDerecha[0].scoring) {
            mayor = maxIzquierda[0];
            segundoMayor = (maxIzquierda[1].scoring > maxDerecha[0].scoring) ? maxIzquierda[1] : maxDerecha[0];
        } else {
            mayor = maxDerecha[0];
            segundoMayor = (maxDerecha[1].scoring > maxIzquierda[0].scoring) ? maxDerecha[1] : maxIzquierda[0];
        }

        return new Cliente[]{mayor, segundoMayor};
    }

    public static void main(String[] args) {
        // Lista de clientes
        Cliente[] clientes = {
                new Cliente(1, "Juan", 75),
                new Cliente(2, "Ana", 90),
                new Cliente(3, "Luis", 85),
                new Cliente(4, "Maria", 95),
                new Cliente(5, "Pedro", 88)
        };

        // Llamada a la función
        Cliente[] resultado = encontrarDosMaximos(clientes, 0, clientes.length - 1);

        System.out.println("Los dos clientes con mayor scoring son:");
        for (Cliente cliente : resultado) {
            System.out.println(cliente);
        }
    }
}
