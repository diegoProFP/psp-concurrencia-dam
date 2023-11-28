import java.util.ArrayList;
import java.util.List;

public class EfficientParallelStreamExample {
    public static void main(String[] args) {
        // Crear una lista de números

        // Modificar esto para cambiar el número de operaciones que va a realizar el programa.
        int numerosContar = 1000;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= numerosContar; i++) {
            numbers.add(i);
        }

        // Medir el tiempo sin paralelismo
        long startTime = System.currentTimeMillis();
        sequentialProcessing(numbers);
        long endTime = System.currentTimeMillis();
        long tiempoSinParal = endTime - startTime;
        System.out.println("Tiempo sin paralelismo: " + tiempoSinParal + " ms");

        // Medir el tiempo con paralelismo
        startTime = System.currentTimeMillis();
        parallelProcessing(numbers);
        endTime = System.currentTimeMillis();
        long tiempoConParal = endTime - startTime;
        System.out.println("Tiempo con paralelismo: " + tiempoConParal + " ms");

        double porcentajeEficiencia = ((1 - ((double) tiempoConParal / tiempoSinParal)) * 100);
        String porcentajeRedondeado = String.format("%.2f", porcentajeEficiencia);
        System.out.println("\nPorcentaje de eficiencia: " + porcentajeRedondeado + "%");

    }

    // Procesamiento secuencial
    private static void sequentialProcessing(List<Integer> numbers) {
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Suma sin paralelismo: " + sum);
    }

    // Procesamiento paralelo
    private static void parallelProcessing(List<Integer> numbers) {
        int sum = numbers.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Suma con paralelismo: " + sum);
    }
}
