package cuentas;

public interface CuentaBancaria {

	void depositar(double cantidad);
	void retirar(double cantidad);
	double consultaSaldo();
}