package ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PriorityExample {


    /*La inversión de prioridades puede ocurrir cuando un hilo de baja prioridad
     * tiene un recurso bloqueado y un hilo de alta prioridad está esperando para adquirirlo.
     *  La utilización de ReentrantLock con prioridades puede abordar este problema.
     *   Aquí un ejemplo simple:
     */


    private static final Lock lock = new ReentrantLock(true); // true para habilitar la asignación de prioridades

    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("High Priority Thread: Lock adquirido");
                // Realizar operaciones críticas
            } finally {
                lock.unlock();
                System.out.println("High Priority Thread: Lock liberado");
            }
        });
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);

        Thread lowPriorityThread = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Low Priority Thread: Lock adquirido");
                // Realizar operaciones críticas
            } finally {
                lock.unlock();
                System.out.println("Low Priority Thread: Lock liberado");
            }
        });
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        lowPriorityThread.start();
        highPriorityThread.start();
    }
}