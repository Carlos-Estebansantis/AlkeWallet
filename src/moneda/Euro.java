package moneda;

public class Euro implements Moneda {
	
	@Override
	public double factorConversion() {
		return 1005.96 ;  
		// el valor del auro fue del dia 11-05-2024
	}

	@Override
	public double convertir(double monto) {
		return monto / factorConversion();		
	}
}
