package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import moneda.Usd;

public class UsdTest {

    @Test
    public void testFactorConversion() {
        Usd usd = new Usd();
        assertEquals(932.44, usd.factorConversion(), 0.01); // Verifica que el factor de conversión sea el esperado
    }

    @Test
    public void testConvertir() {
        Usd usd = new Usd();
        double monto = 2000.0;
        assertEquals(2.1450913, usd.convertir(monto), 0.001); // Verifica que la conversión de monto sea la esperada, se cambia el factor de 0.01 a 0.001 para ver el error
    }
}

