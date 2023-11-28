import java.util.concurrent.CountDownLatch;
public class mecanismosAdicionales {


        public static void main(String[] args) throws InterruptedException {

            CountDownLatch latch = new CountDownLatch(3);

            // Hilos simulando tareas
            Thread task1 = new Thread(new Task(latch, "Task 1"));
            Thread task2 = new Thread(new Task(latch, "Task 2"));
            Thread task3 = new Thread(new Task(latch, "Task 3"));

            task1.start();
            task2.start();
            task3.start();

            // Esperar a que todas las tareas terminen
            latch.await();

            System.out.println("Todas las tareas han finalizado. Continuar con la siguiente fase.");
        }
    }

    class Task implements Runnable {
        private final CountDownLatch latch;
        private final String taskName;

        Task(CountDownLatch latch, String taskName) {
            this.latch = latch;
            this.taskName = taskName;
        }

        @Override
        public void run() {
            // Simular la ejecución de la tarea
            System.out.println(taskName + " en progreso...");
            try {
                Thread.sleep(2000); // Simulando el tiempo de ejecución
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(taskName + " completada.");
            latch.countDown(); // Decrementar el contador
        }



/*

            public static void main(String[] args) {
                // Punto de encuentro para tres hilos
                CyclicBarrier barrier = new CyclicBarrier(3, () ->
                        System.out.println("Todos los hilos han llegado al punto de encuentro. Continuar..."));

                // Hilos simulando tareas
                Thread task1 = new Thread(new Task(barrier, "Task 1"));
                Thread task2 = new Thread(new Task(barrier, "Task 2"));
                Thread task3 = new Thread(new Task(barrier, "Task 3"));

                task1.start();
                task2.start();
                task3.start();
            }
        }

        class Task implements Runnable {
            private final CyclicBarrier barrier;
            private final String taskName;

            Task(CyclicBarrier barrier, String taskName) {
                this.barrier = barrier;
                this.taskName = taskName;
            }

            @Override
            public void run() {
                // Simular la ejecución de la tarea
                System.out.println(taskName + " en progreso...");
                try {
                    Thread.sleep(2000); // Simulando el tiempo de ejecución
                    System.out.println(taskName + " ha llegado al punto de encuentro.");
                    barrier.await(); // Esperar a que los demás hilos lleguen al punto de encuentro
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(taskName + " continuando después del punto de encuentro.");
            }
        }


*/

    }

