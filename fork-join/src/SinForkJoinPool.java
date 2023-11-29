import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SinForkJoinPool {

    public static void main(String[] args) throws IOException {
        File archivo = new File("archivo.txt");
        long tiempoInicio = System.currentTimeMillis();
        Scanner lector = new Scanner(archivo);

        while (lector.hasNextLine()) {
            String linea = lector.nextLine();
            System.out.println(linea);
            // Procesamos la linea
        }

        lector.close();

        long tiempoFin = System.currentTimeMillis();

        System.out.println("Tiempo de ejecución: " + (tiempoFin - tiempoInicio) + " milisegundos");
    }
}