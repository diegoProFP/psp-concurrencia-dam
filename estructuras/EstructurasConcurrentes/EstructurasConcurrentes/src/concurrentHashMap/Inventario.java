package concurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class Inventario {
    // ConcurrentHashMap para almacenar las existencias de productos de manera segura en entornos concurrentes
    private final ConcurrentHashMap<String, Integer> existencias;

    // Constructor que inicializa el ConcurrentHashMap
    public Inventario() {
        this.existencias = new ConcurrentHashMap<>();
    }

    // Método para agregar un producto al inventario con una cantidad inicial
    public void agregarProducto(String producto, int cantidadInicial) {
        existencias.put(producto, cantidadInicial);
    }

    // Método para obtener la existencia actual de un producto
    public int obtenerExistencia(String producto) {
        // Si el producto no está en el inventario, se devuelve 0
        return existencias.getOrDefault(producto, 0);
    }

    // Método para vender una cantidad específica de un producto
    public void venderProducto(String producto, int cantidad) {
        // Utiliza el método compute de ConcurrentHashMap para actualizar la cantidad de existencias de un producto
        // Si el producto no existe, o si la cantidad vendida es mayor que la existencia actual, no se realiza ninguna actualización
        existencias.compute(producto, (key, value) -> (value == null) ? null : value - cantidad);
    }

    // Método principal para probar el código
    public static void main(String[] args) {
        // Crear una instancia de la clase Inventario
        Inventario inventario = new Inventario();

        // Agregar productos al inventario con cantidades iniciales
        inventario.agregarProducto("ProductoA", 100);
        inventario.agregarProducto("ProductoB", 50);

        // Crear hilos para simular ventas concurrentes
        Thread hiloVenta1 = new Thread(() -> {
            inventario.venderProducto("ProductoA", 20);
        });

        Thread hiloVenta2 = new Thread(() -> {
            inventario.venderProducto("ProductoB", 10);
        });

        // Iniciar los hilos
        hiloVenta1.start();
        hiloVenta2.start();

        try {
            // Esperar a que los hilos de venta terminen antes de continuar
            hiloVenta1.join();
            hiloVenta2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obtener existencias después de las ventas y mostrar en la consola
        System.out.println("Existencias después de las ventas:");
        System.out.println("ProductoA: " + inventario.obtenerExistencia("ProductoA"));
        System.out.println("ProductoB: " + inventario.obtenerExistencia("ProductoB"));
    }
}
