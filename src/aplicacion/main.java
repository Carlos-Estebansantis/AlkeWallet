package aplicacion;

import java.util.Scanner;

import cuentas.CuentaAhorro;
import cuentas.CuentaCorriente;

public class main {

	public static void main(String[] args) {
		// se crea scanner para el ingreso de informacion
		Scanner scanner=new Scanner(System.in);
		double saldoInicial, cantidad, tasaInteres, limiteSobregiro;
		// se solicta el saldo inicial de la cta cte
		saldoInicial = solicitaValor(scanner, "Ingrese el saldo inicial de la CTA CTE :");
		// se solicita ingresar el limite del sobregiro de la CTA CTE
		limiteSobregiro = solicitaValor(scanner,"Ingrese el limite de sobregiro de la CTA. CTE. : ");
		
		// con los valor ya ingresados se crea la cuenta corriente
		CuentaCorriente cuetaCorriente = new CuentaCorriente(saldoInicial, limiteSobregiro);
		
		// se solicita el saldo incial y tasa de interes para la cuenta de ahorro
		saldoInicial = solicitaValor (scanner, "Ingrese el saldo inicial de la cuenta de ahorros: ");
		tasaInteres = solicitaValor(scanner, "Ingrese la tasa de interes para la cuenta de ahorro : ");
		
		CuentaAhorro cuentaAhorro = new CuentaAhorro(saldoInicial, tasaInteres);
		
		// se comienza armar el menu
		int opcion = -1;
		// comienza el ciclo del menu
		while (opcion != 0) {
			
			mostrarMenu();
			opcion = scanner.nextInt();
			switch (opcion) {
			case 1, 2, 3, 4, 5 -> {
				cantidad = solicitaValor(scanner, (opcion== 1 || opcion == 4)? "Ingrese cantidad a depositar")
			}
			}
		}
	}


}
