package cuentas;

public class CuentaAhorro extends Cuenta {
 private double tasaInteres;
 
 // constructor de tasa de  interes
 
 public CuentaAhorro(double saldoInicial, double tasaInteres) {
	 super(saldoInicial);
	 this.tasaInteres = tasaInteres ;
	  }
 // metodo donde se aplica el interes especifico
  public void aplicarInteres() {
	  double intereses = super.consultaSaldo() * tasaInteres;
	  super.depositar(intereses);
	  
  }
  
  // sobreescribe el metodo retirar para agregar el cmapo retiro
  
  public void retirar(double cantidad) {
	  super.retirar(cantidad);
	  // se aplica un cargo por retiro en la cuenta de ahorro 
	  super.retirar(cantidad * 0.02); 
	  
  }
}
