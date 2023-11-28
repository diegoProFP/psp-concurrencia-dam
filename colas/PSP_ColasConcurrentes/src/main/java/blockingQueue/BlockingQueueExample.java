package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {
        // Crear una cola bloqueante con una capacidad de 3
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // Crear un productor y un consumidor
        Thread producerThread = new Thread(new Producer(blockingQueue));
        Thread consumerThread = new Thread(new Consumer(blockingQueue));

        // Iniciar los hilos
        producerThread.start();
        consumerThread.start();
    }
}
