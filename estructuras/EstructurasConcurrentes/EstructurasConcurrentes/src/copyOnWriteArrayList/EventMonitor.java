package copyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

// Clase principal que contiene el monitor de eventos
public class EventMonitor {
    private final CopyOnWriteArrayList<Evento> eventos; // Lista de eventos (segura para escritura concurrente)

    // Constructor de la clase, inicializa la lista de eventos
    public EventMonitor() {
        this.eventos = new CopyOnWriteArrayList<>();
    }

    // Método para agregar un evento a la lista
    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    // Método para procesar eventos en bucle infinito
    public void procesarEventos() {
        // Múltiples hilos pueden llamar a este método para procesar eventos
        while (true) {
            // Itera sobre la lista de eventos
            for (Evento evento : eventos) {
                // Realiza alguna operación con el evento (en este caso, simplemente imprimir)
                System.out.println("Procesando evento: " + evento.getDescripcion());
            }

            try {
                Thread.sleep(1000); // Espera entre iteraciones
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método principal (punto de entrada) para ejecutar el programa
    public static void main(String[] args) {
        EventMonitor eventMonitor = new EventMonitor(); // Instancia del monitor de eventos

        // Hilo que agrega eventos a la lista
        Thread hiloAgregador = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                eventMonitor.agregarEvento(new Evento("Evento " + i));
                try {
                    Thread.sleep(500); // Simula ciertos intervalos de tiempo entre eventos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Hilo que procesa eventos llamando al método procesarEventos()
        Thread hiloProcesador = new Thread(eventMonitor::procesarEventos);

        // Inicia los hilos
        hiloAgregador.start();
        hiloProcesador.start();
    }

    // Clase interna que representa un evento
    static class Evento {
        private final String descripcion;

        // Constructor de la clase Evento
        public Evento(String descripcion) {
            this.descripcion = descripcion;
        }

        // Método para obtener la descripción del evento
        public String getDescripcion() {
            return descripcion;
        }
    }
}
