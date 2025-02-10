package Clase_8.Actividad_3;
import java.util.Scanner;

public class Main {
    static final int INF = 99999;

    public static void floydWarshall(int[][] tiempos, int numCentros) {
        int[][] distancias = new int[numCentros][numCentros];
        int[][] siguiente = new int[numCentros][numCentros];

        for (int i = 0; i < numCentros; i++) {
            for (int j = 0; j < numCentros; j++) {
                distancias[i][j] = tiempos[i][j];
                siguiente[i][j] = (tiempos[i][j] != INF && i != j) ? j : -1;
            }
        }

        for (int k = 0; k < numCentros; k++) {
            for (int i = 0; i < numCentros; i++) {
                for (int j = 0; j < numCentros; j++) {
                    if (distancias[i][k] != INF && distancias[k][j] != INF &&
                            distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        siguiente[i][j] = siguiente[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < numCentros; i++) {
            if (distancias[i][i] < 0) {
                System.out.println("⚠️ Se ha detectado un ciclo negativo en el centro " + (i + 1));
                return;
            }
        }

        System.out.println("\n🚛 Tiempos mínimos de entrega entre centros:");
        imprimirMatriz(distancias);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el centro de origen (1-" + numCentros + "): ");
        int origen = scanner.nextInt() - 1;
        System.out.print("Ingrese el centro de destino (1-" + numCentros + "): ");
        int destino = scanner.nextInt() - 1;

        if (siguiente[origen][destino] == -1) {
            System.out.println("No hay ruta disponible entre los centros seleccionados.");
        } else {
            System.out.println("\n⏳ Tiempo mínimo: " + distancias[origen][destino] + " minutos");
            System.out.print("Ruta óptima: ");
            imprimirCamino(origen, destino, siguiente);
            System.out.println();
        }

        scanner.close();
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print((valor == INF ? "INF" : valor) + "\t");
            }
            System.out.println();
        }
    }

    public static void imprimirCamino(int origen, int destino, int[][] siguiente) {
        if (siguiente[origen][destino] == -1) {
            System.out.print("No hay camino.");
            return;
        }
        System.out.print((origen + 1) + " → ");
        while (origen != destino) {
            origen = siguiente[origen][destino];
            System.out.print((origen + 1) + (origen == destino ? "" : " → "));
        }
    }
}
