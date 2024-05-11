package moneda;

public class Usd implements Moneda {
	@Override
	public double factorConversion() {
		return 932.44;
		// el valor del dolar (USD) fue del dia 11-05-2024
	}
 @Override
 public double convertir(double monto) {
	 return monto / factorConversion();
 }
}
