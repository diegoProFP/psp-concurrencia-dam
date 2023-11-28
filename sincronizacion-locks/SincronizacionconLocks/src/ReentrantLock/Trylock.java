package ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class Trylock {
    private static final Lock lock = new ReentrantLock();

    /*En este escenario, tryLock() puede ser útil cuando un hilo necesita adquirir un lock,
     *  pero no desea esperar indefinidamente si el lock ya está en uso. Si no puede adquirir el lock de inmediato,
     *  puede esperar un tiempo determinado antes de continuar con su ejecución o realizar alguna acción alternativa.
     *   Aquí tenéis  un ejemplo simplificado:
     */

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            if (lock.tryLock()) {
                try {
                    // Operaciones críticas
                    System.out.println("Thread 1: Lock adquirido");
                } finally {
                    lock.unlock();
                }
            } else {
                // Acciones alternativas si no se puede adquirir el lock
                System.out.println("Thread 1: No se pudo adquirir el lock");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                // Intenta adquirir el lock durante un tiempo limitado
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    try {
                        // Operaciones críticas
                        System.out.println("Thread 2: Lock adquirido");
                    } finally {
                        lock.unlock();
                    }
                } else {
                    // Acciones alternativas si no se puede adquirir el lock en el tiempo especificado
                    System.out.println("Thread 2: No se pudo adquirir el lock a tiempo");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}