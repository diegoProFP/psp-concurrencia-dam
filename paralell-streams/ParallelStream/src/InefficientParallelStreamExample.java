import java.util.ArrayList;
import java.util.List;

public class InefficientParallelStreamExample {
    public static void main(String[] args) {
        // Crear una lista de números
        List<Integer> numbers = new ArrayList<>();

        // Modificar esto para cambiar el número de operaciones que va a realizar el programa.
        int numerosContar = 1000;

        for (int i = 1; i <= 1000; i++) {
            numbers.add(i);
        }

        // Medir el tiempo con paralelismo
        long startTime = System.currentTimeMillis();
        parallelProcessing(numbers);
        long endTime = System.currentTimeMillis();
        long tiempoSinParal = endTime - startTime;
        System.out.println("Tiempo con paralelismo: " + tiempoSinParal + " ms");

        // Medir el tiempo sin paralelismo
        startTime = System.currentTimeMillis();
        sequentialProcessing(numbers);
        endTime = System.currentTimeMillis();
        long tiempoConParal = endTime - startTime;
        System.out.println("Tiempo sin paralelismo: " + tiempoConParal + " ms");

        double porcentajeEficiencia = ((1 - ((double) tiempoConParal / tiempoSinParal)) * 100);
        String porcentajeRedondeado = String.format("%.2f", porcentajeEficiencia);
        System.out.println("\nPorcentaje de eficiencia: " + porcentajeRedondeado + "%");
    }

    // Procesamiento secuencial de una operación sencilla
    private static void sequentialProcessing(List<Integer> numbers) {
        int result = numbers.stream()
                .map(InefficientParallelStreamExample::simpleOperation)
                .reduce(0, Integer::sum);
        System.out.println("Resultado sin paralelismo: " + result);
    }

    // Procesamiento paralelo menos eficiente para una operación sencilla
    private static void parallelProcessing(List<Integer> numbers) {
        int result = numbers.parallelStream()
                .map(InefficientParallelStreamExample::simpleOperation)
                .reduce(0, Integer::sum);
        System.out.println("Resultado con paralelismo: " + result);
    }

    // Simula una operación sencilla que no se beneficia del paralelismo
    private static int simpleOperation(int num) {
        // Agregamos una espera para simular una operación más rápida
        return num + 1;
    }
}
