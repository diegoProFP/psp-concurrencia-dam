package delayQueruExample;

import java.util.concurrent.DelayQueue;

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> queue = new DelayQueue<>();

        // Agregamos dos elementos con diferentes tiempos de espera
        queue.put(new DelayedElement("Tarea 1", 5000)); // Espera 2 segundos
        queue.put(new DelayedElement("Tarea 2", 2000)); // Espera 5 segundos

        // Retiramos los elementos cuando expira su tiempo
        while (!queue.isEmpty()) {
            System.out.println(queue.take().data);
        }
    }
}
