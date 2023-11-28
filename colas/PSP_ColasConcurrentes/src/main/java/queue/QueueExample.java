package queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        // Agregando elementos a la cola
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // Mostrando el tamaño de la cola
        System.out.println("Tamaño de la cola: " + queue.size());

        // Accediendo y mostrando el primer elemento de la cola sin eliminarlo
        System.out.println("Primer elemento de la cola: " + queue.peek());

        // Retirando elementos de la cola y mostrándolos
        System.out.println("Elementos retirados de la cola:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        // Mostrando el tamaño de la cola después de retirar elementos
        System.out.println("Tamaño final de la cola: " + queue.size());
    }
}
