package cuentas;

public class CuentaCorriente extends Cuenta {
private double limiteSobregiro;

public CuentaCorriente(double saldoInicial, double limiteSobregiro) {
	super(saldoInicial);
	this.limiteSobregiro = limiteSobregiro;
}
@Override
public void retirar(double cantidad) {
  if (cantidad <= (super.consultaSaldo() + limiteSobregiro)) {
	   super.retirar(cantidad);
  }else {
	  System.out.println("No puede retirar, Excede el limite de sobregiro");
  }
}
}
