package blockingQueue;

import java.util.concurrent.BlockingQueue;

// Clase Consumidor
class Consumer implements Runnable {
    private BlockingQueue<String> blockingQueue;

    // Constructor del consumidor
    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    // Método run del consumidor
    @Override
    public void run() {
        try {
            // Consumiendo elementos de la cola
            Thread.sleep(10000);
            for (int i = 1; i <= 5; i++) {
                String element = blockingQueue.take(); // Tomar un elemento de la cola
                System.out.println("Consumidor consume: " + element +" y el tamaño de la cola actualmente es: "+blockingQueue.size());
                Thread.sleep(2000); // Simula el consumo de un elemento cada dos segundos
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}