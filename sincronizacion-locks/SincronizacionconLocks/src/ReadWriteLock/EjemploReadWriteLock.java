package ReadWriteLock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class RecursoCompartido {
    private int valor = 0;
    private final ReadWriteLock candadoLecturaEscritura = new ReentrantReadWriteLock();

    public int leerDesdeRecursoCompartido() {
        candadoLecturaEscritura.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " está leyendo desde el recurso compartido: " + valor);
            return valor;
        } finally {
            candadoLecturaEscritura.readLock().unlock();
        }
    }

    public void escribirEnRecursoCompartido(int nuevoValor) {
        candadoLecturaEscritura.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " está escribiendo en el recurso compartido: " + nuevoValor);
            valor = nuevoValor;
        } finally {
            candadoLecturaEscritura.writeLock().unlock();
        }
    }
}

public class EjemploReadWriteLock {
    public static void main(String[] args) {
        RecursoCompartido recursoCompartido = new RecursoCompartido();

        // Crear hilos para lectura
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                recursoCompartido.leerDesdeRecursoCompartido();
            }).start();
        }

        // Crear hilos para escritura
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                recursoCompartido.escribirEnRecursoCompartido((int) (Math.random() * 100));
            }).start();
        }
    }
}
