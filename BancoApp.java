import java.util.Scanner;

public class BancoApp {

    // Clase interna (NO es public)
    static class Cuenta {

        private double saldo;

        public Cuenta(double saldoInicial) {
            if (saldoInicial >= 0) {
                this.saldo = saldoInicial;
            } else {
                this.saldo = 0;
            }
        }

        public void depositar(double monto) {
            if (monto > 0) {
                saldo += monto;
                System.out.println("Depósito realizado con éxito.");
            } else {
                System.out.println("El monto debe ser mayor que 0.");
            }
        }

        public boolean retirar(double monto) {
            if (monto > 0 && monto <= saldo) {
                saldo -= monto;
                System.out.println("Retiro realizado con éxito.");
                return true;
            } else {
                System.out.println("Fondos insuficientes o monto inválido.");
                return false;
            }
        }

        public double getSaldo() {
            return saldo;
        }
    }

    // Método principal
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== BANCO EL AHORRADOR ===");
        System.out.print("Ingrese saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        Cuenta cuenta = new Cuenta(saldoInicial);

        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese monto a depositar: ");
                    double deposito = sc.nextDouble();
                    cuenta.depositar(deposito);
                    break;

                case 2:
                    System.out.print("Ingrese monto a retirar: ");
                    double retiro = sc.nextDouble();
                    cuenta.retirar(retiro);
                    break;

                case 3:
                    System.out.println("Saldo actual: $" + cuenta.getSaldo());
                    break;

                case 4:
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}