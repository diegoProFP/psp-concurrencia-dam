package ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentHashMap;

public class GestionCuentas {
    // ConcurrentHashMap se utiliza para almacenar las cuentas bancarias de forma segura en entornos concurrentes.
    private final ConcurrentHashMap<String, CuentaBancaria> cuentas;

    // Constructor que inicializa el ConcurrentHashMap para almacenar las cuentas.
    public GestionCuentas() {
        this.cuentas = new ConcurrentHashMap<>();
    }

    // Método para abrir una nueva cuenta bancaria con un saldo inicial.
    public void abrirCuenta(String numeroCuenta, double saldoInicial) {
        CuentaBancaria nuevaCuenta = new CuentaBancaria(numeroCuenta, saldoInicial);
        cuentas.put(numeroCuenta, nuevaCuenta);
    }

    // Método para realizar una transacción en una cuenta bancaria especificada.
    public void realizarTransaccion(String numeroCuenta, double monto) {
        CuentaBancaria cuenta = cuentas.get(numeroCuenta);

        // Verificar si la cuenta existe antes de realizar la transacción.
        if (cuenta != null) {
            cuenta.realizarTransaccion(monto);
        }
    }

    // Método para obtener el saldo de una cuenta bancaria especificada.
    public double obtenerSaldo(String numeroCuenta) {
        CuentaBancaria cuenta = cuentas.get(numeroCuenta);

        // Devolver el saldo de la cuenta si existe, de lo contrario, devolver 0.0.
        return (cuenta != null) ? cuenta.getSaldo() : 0.0;
    }

    // Método principal para probar el sistema.
    public static void main(String[] args) {
        GestionCuentas gestionCuentas = new GestionCuentas();

        // Abrir cuentas con saldos iniciales.
        gestionCuentas.abrirCuenta("123456", 1000.0);
        gestionCuentas.abrirCuenta("789012", 1500.0);

        // Crear threads para realizar transacciones simultáneas en las cuentas.
        Thread transaccion1 = new Thread(() -> gestionCuentas.realizarTransaccion("123456", 200.0));
        Thread transaccion2 = new Thread(() -> gestionCuentas.realizarTransaccion("789012", -300.0));
        transaccion1.start();
        transaccion2.start();

        // Esperar a que las transacciones terminen.
        try {
            transaccion1.join();
            transaccion2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obtener saldos después de las transacciones y mostrarlos.
        System.out.println("Saldo de la cuenta 123456: " + gestionCuentas.obtenerSaldo("123456"));
        System.out.println("Saldo de la cuenta 789012: " + gestionCuentas.obtenerSaldo("789012"));
    }

    // Clase interna que representa una cuenta bancaria.
    static class CuentaBancaria {
        private double saldo;

        // Constructor para inicializar una cuenta bancaria con un saldo inicial.
        public CuentaBancaria(String numeroCuenta, double saldoInicial) {
            this.saldo = saldoInicial;
        }

        // Método para simular el procesamiento de una transacción y actualizar el saldo.
        public void realizarTransaccion(double monto) {
            // Simular procesamiento de transacción
            try {
                Thread.sleep(100); // Simular procesamiento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Realizar la transacción actualizando el saldo.
            this.saldo += monto;
        }

        // Método para obtener el saldo actual de la cuenta.
        public double getSaldo() {
            return saldo;
        }
    }
}
