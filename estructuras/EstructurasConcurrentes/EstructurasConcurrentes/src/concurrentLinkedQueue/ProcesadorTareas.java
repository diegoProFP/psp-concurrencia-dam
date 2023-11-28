package concurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ProcesadorTareas {
    private final ConcurrentLinkedQueue<Tarea> colaTareas;

    // Constructor de la clase ProcesadorTareas
    public ProcesadorTareas() {
        colaTareas = new ConcurrentLinkedQueue<>();
    }

    // Método para añadir una tarea a la cola de tareas
    public void añadirTarea(Tarea tarea) {
        colaTareas.add(tarea);
    }

    // Método para obtener y eliminar la primera tarea de la cola
    public Tarea getTarea() {
        return colaTareas.poll();
    }

    // Método para procesar todas las tareas en la cola
    public void procesarTareas() {
        while (!colaTareas.isEmpty()) {
            Tarea tarea = getTarea();
            tarea.ejecutar(); // Ejecuta la tarea
        }
    }

    // Método main, punto de entrada del programa
    public static void main(String[] args) {
        // Crear un objeto de la clase ProcesadorTareas
        ProcesadorTareas procesadorTareas = new ProcesadorTareas();

        // Añadir 10 tareas al procesadorTareas
        for (int i = 0; i < 10; i++) {
            procesadorTareas.añadirTarea(new Tarea(i));
        }

        // Procesar todas las tareas en el procesadorTareas
        procesadorTareas.procesarTareas();
    }
}
