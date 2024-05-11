package aplicacion;

import java.util.Scanner;
import moneda.Euro;
import moneda.Moneda;
import moneda.Peso;
import moneda.Usd;
import cuentas.CuentaAhorro;
import cuentas.CuentaCorriente;


public class main {
    public static void main(String[] args) {
              Scanner scanner = new Scanner(System.in);
        double saldoInicial, cantidad, tasaInteres, limiteSobregiro;

        // ingresar saldo inicial y límite de sobregiro para CTA CTE
        saldoInicial = solicitarValor(scanner, "Ingrese el saldo inicial de la cuenta corriente:");
        limiteSobregiro = solicitarValor(scanner, "Ingrese el límite de sobregiro para la cuenta corriente:");
        // Crear cuenta corriente con los valores ingresados
        CuentaCorriente cuentaCorriente = new CuentaCorriente(saldoInicial, limiteSobregiro);

        // ingresar saldo inicial y tasa la de interés para la cuenta de ahorro
        saldoInicial = solicitarValor(scanner, "Ingrese el saldo inicial de la cuenta de ahorro:");
        tasaInteres = solicitarValor(scanner, "Ingrese la tasa de interés para la cuenta de ahorro:");
        // Crear cuenta de ahorro con los valores ingresados
        CuentaAhorro cuentaAhorro = new CuentaAhorro(saldoInicial, tasaInteres);

        // comienza la construccion del menu declarando la variable que utizaremos en el menu
        int opcion = -1;
        // while del menu en donde se podra seleccionar distina opciones
        while (opcion != 0) {
            // Despliega las opciones del menú
            mostrarMenu();
            opcion = scanner.nextInt();
            // Realiza proceso de la seleccion eleguida por el usuario 
            switch (opcion) {
                case 1, 2, 4, 5 -> {
                    // Solicitar y realizar depósito o retiro en la cta cte o de ahorro
                    cantidad = solicitarValor(scanner, (opcion == 1 || opcion == 4) ? "Ingrese la cantidad a depositar:" : "Ingrese la cantidad a retirar:");
                    if (opcion == 1) cuentaCorriente.depositar(cantidad);
                    else if (opcion == 2) cuentaCorriente.retirar(cantidad);
                    else if (opcion == 4) cuentaAhorro.depositar(cantidad);
                    else cuentaAhorro.retirar(cantidad);
                }
                case 3 -> System.out.println("Saldo actual de la cuenta corriente: " + cuentaCorriente.consultaSaldo());
                case 6 -> System.out.println("Saldo actual de la cuenta de ahorro: " + cuentaAhorro.consultaSaldo());
                case 7, 8, 9 -> {
                    // Proceso de conversión de saldo a la moneda seleccionada
                    Moneda moneda = null;
                    String nombreMoneda = "";
                    if (opcion == 7) {
                        moneda = new Peso();
                        nombreMoneda = "Peso $ ";
                    } else if (opcion == 8) {
                        moneda = new Usd();
                        nombreMoneda = "Dólar USD";
                    } else if (opcion == 9) {
                        moneda = new Euro();
                        nombreMoneda = "Euro EUR";
                    }
                    double saldoConvertido = moneda.convertir(cuentaCorriente.consultaSaldo());
                   
                    // Despliega el saldo convertido junto con el nombre de la moneda
                    System.out.println("El saldo convertido a " + nombreMoneda + " es: $" + saldoConvertido);
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        }
        // Se Cierra el scanner 
        scanner.close();
    }

    // Método para mostrar las opciones del menú
    private static void mostrarMenu() {
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Depositar en cuenta corriente");
        System.out.println("2. Retirar de cuenta corriente");
        System.out.println("3. Consultar saldo de cuenta corriente");
        System.out.println("4. Depositar en cuenta de ahorro");
        System.out.println("5. Retirar de cuenta de ahorro");
        System.out.println("6. Consultar saldo de cuenta de ahorro");
        System.out.println("7. Convertir saldo a Peso $ ");
        System.out.println("8. Convertir saldo a Dólar USD");
        System.out.println("9. Convertir saldo a Euro EUR");
        System.out.println("0. Salir");
    }

    // Este metodo se utiliza para solicitar un valor al usuario
    private static double solicitarValor(Scanner scanner, String mensaje) {
        System.out.println(mensaje);
        return scanner.nextDouble();
    }
}