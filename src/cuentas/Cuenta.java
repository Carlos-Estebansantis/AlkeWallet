package cuentas;

public class Cuenta  implements CuentaBancaria {

	private double saldo;

// construtor de saldo 
public Cuenta(double saldoInicial) {
	this.saldo = saldoInicial;
}

// funcion @Override para llamar a los metodos 
@Override
public void depositar(double cantidad) {
	saldo += cantidad;
     }
@Override
public void retirar(double cantidad) {
	if (cantidad <= saldo) {
		saldo-= cantidad;
	}else {
		System.out.println(" saldo Isuficiente ");
		}
    }
 @Override
public double consultaSaldo() {
	return saldo;
}
}
