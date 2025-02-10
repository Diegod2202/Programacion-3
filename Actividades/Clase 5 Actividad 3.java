import java.util.Arrays;
import java.util.Comparator;

class Elemento {
    double peso;
    double valor;

    public Elemento(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }
}

public class CamionDistribuidora {

    public static double maximizarValorCamion(Elemento[] elementos, double capacidad) {
        // Calcular el valor por unidad de peso para cada elemento
        for (Elemento elemento : elementos) {
            elemento.valor = elemento.valor / elemento.peso;
        }

        // Ordenar los elementos en orden descendente según valor por unidad de peso
        Arrays.sort(elementos, new Comparator<Elemento>()