package blockingQueue;

import java.util.concurrent.BlockingQueue;

// Clase Productor
class Producer implements Runnable {
    private BlockingQueue<String> blockingQueue;

    // Constructor del productor
    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    // Método run del productor
    @Override
    public void run() {
        try {
            // Produciendo elementos y poniéndolos en la cola
            for (int i = 1; i <= 5; i++) {
                String element = "Elemento " + i;
                System.out.println("Productor produce: " + element+" y el tamaño de la cola actualmente es: "+blockingQueue.size());
                blockingQueue.put(element); // Poner el elemento en la cola
                Thread.sleep(1000); // Simula la producción de un elemento cada segundo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

