import org.junit.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.junit.Assert.assertTrue;

public class TestConcurrencia {

    @Test
    public void testConcurrencia() throws InterruptedException {
        // Contador para esperar a que todos los hilos terminen
        CountDownLatch latch = new CountDownLatch(3);

        // ExecutorService con un pool de 3 hilos
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Tareas concurrentes
        TareaConcurrente tarea1 = new TareaConcurrente("Tarea 1", latch);
        TareaConcurrente tarea2 = new TareaConcurrente("Tarea 2", latch);
        TareaConcurrente tarea3 = new TareaConcurrente("Tarea 3", latch);

        // Ejecutamos las tareas
        executorService.submit(tarea1);
        executorService.submit(tarea2);
        executorService.submit(tarea3);

        // Esperamos a que todos los hilos terminen
        latch.await();

        // Realizamos las aserciones después de que todos los hilos han terminado
        assertTrue(tarea1.isTerminada());
        assertTrue(tarea2.isTerminada());
        assertTrue(tarea3.isTerminada());

        // Cerramos el ExecutorService
        executorService.shutdown();
    }
}
