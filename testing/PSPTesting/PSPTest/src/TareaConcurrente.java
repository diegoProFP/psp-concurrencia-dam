import java.util.concurrent.CountDownLatch;

class TareaConcurrente implements Runnable {
    private String nombre;
    private CountDownLatch latch;
    private boolean terminada;

    public TareaConcurrente(String nombre, CountDownLatch latch) {
        this.nombre = nombre;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // Simulamos alguna tarea que tarda un tiempo en completarse
            for (int i = 0; i < 5; i++) {
                System.out.println(nombre + ": Iteración " + i);
                // Simulamos un retraso de 1 segundo
                Thread.sleep(1000);
            }
            System.out.println(nombre + " ha terminado.");
            terminada = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Contamos hacia abajo en el latch cuando la tarea termina
            latch.countDown();
        }
    }

    public boolean isTerminada() {
        return terminada;
    }
}
