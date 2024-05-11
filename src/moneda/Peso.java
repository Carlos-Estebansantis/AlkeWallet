package moneda;

public class Peso implements Moneda{
	@Override
	public double factorConversion() {
		return 1; // al ser peso (chileno) no requiere conversion ya que el monto a convertir esta en esa unidad de medida
	}

	@Override
	public double convertir(double monto) {
		return monto;
	}
}
