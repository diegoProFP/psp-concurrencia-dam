package concurrentLinkedQueue;

// Definición de la clase Tarea
public class Tarea {
    // Variable de instancia privada para almacenar el identificador de la tarea
    private int id;

    // Constructor de la clase que toma un identificador como parámetro
    public Tarea(int id) {
        this.id = id;
    }

    // Método público llamado ejecutar, que imprime un mensaje indicando que la tarea ha sido ejecutada
    public void ejecutar() {
        System.out.println("Tarea " + id + " ejecutada");
    }
}
