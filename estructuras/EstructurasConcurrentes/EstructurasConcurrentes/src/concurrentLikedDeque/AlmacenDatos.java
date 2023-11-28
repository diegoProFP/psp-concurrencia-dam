package concurrentLikedDeque;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class AlmacenDatos {
    // Declaración de una clase que almacena datos de manera concurrente.
    private final ConcurrentLinkedDeque<Dato> datos;

    // Constructor que inicializa la cola concurrente de datos.
    public AlmacenDatos() {
        datos = new ConcurrentLinkedDeque<>();
    }

    // Método para añadir un dato a la cola concurrente.
    public void añadirDato(Dato dato) {
        datos.add(dato);
    }

    // Método para obtener un dato de la cola concurrente basado en la posición.
    public Dato obtenerDato(int posicion) {
        // Verifica si la posición está fuera de los límites.
        if (posicion < 0 || posicion >= datos.size()) {
            return null;
        }

        // Utiliza un iterador para recorrer la cola concurrente.
        Iterator<Dato> iterator = datos.iterator();
        for (int i = 0; i < posicion; i++) {
            iterator.next();
        }

        // Retorna el dato en la posición deseada.
        return iterator.next();
    }

    // Método principal utilizado para probar la funcionalidad de la clase.
    public static void main(String[] args) {
        // Crear una instancia de AlmacenDatos.
        AlmacenDatos almacenDatos = new AlmacenDatos();

        // Añadir datos a la cola concurrente.
        for (int i = 0; i < 10; i++) {
            almacenDatos.añadirDato(new Dato(i));
        }

        // Obtener e imprimir los valores de los datos en la cola concurrente.
        for (int i = 0; i < 10; i++) {
            System.out.println(almacenDatos.obtenerDato(i).getValor());
        }
    }

    // Clase interna que representa un dato almacenado en la cola concurrente.
    public static class Dato {
        private int valor;

        // Constructor que inicializa el valor del dato.
        public Dato(int valor) {
            this.valor = valor;
        }

        // Método para obtener el valor del dato.
        public int getValor() {
            return valor;
        }
    }
}
