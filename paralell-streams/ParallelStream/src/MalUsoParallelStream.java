import java.util.ArrayList;
import java.util.List;

public class MalUsoParallelStream {

    private static int contador = 0;

    public static void main(String[] args) {

        // Modificar esto para cambiar el número de operaciones que va a realizar el programa.
        int numeroOperaciones = 100000;

        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < numeroOperaciones; i++) {
            numeros.add(i);
        }

        // Mal uso de parallelStream con error
        numeros.parallelStream().forEach(numero -> {
            // Operación: incrementar el número
            numero = numero + 1;

            // Efecto secundario: incrementar el contador global sin sincronización
            contador++;

            System.out.println("Número incrementado: " + numero);
        });

        System.out.println("Contador final: " + contador);
    }
}
