import java.util.ArrayList;
import java.util.List;

public class BuenUsoParallelStream {

    private static int contador = 0;

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        // Modificar esto para cambiar el número de operaciones que va a realizar el programa.
        int numerosContar = 100000;

        for (int i = 0; i < numerosContar; i++) {
            numeros.add(i);
        }

        // Mal uso de parallelStream
        numeros.parallelStream().forEach(numero -> {
            // Operación: incrementar el número
            numero = numero + 1;

            // Efecto secundario: incrementar el contador global
            incrementarContador();

            System.out.println("Número incrementado: " + numero);
        });

        System.out.println("Contador final: " + contador);
    }

    private static synchronized void incrementarContador() {
        contador++;
    }
}
