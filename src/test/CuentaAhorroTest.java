package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import cuentas.CuentaAhorro;

public class CuentaAhorroTest {
    private CuentaAhorro cuenta;

    @Before
    public void setUp() {
        cuenta = new CuentaAhorro(1000.0, 0.05); // saldo inicial de 1000 y tasa de interés del 5%
    }

    @Test
    public void testAplicarInteres() {
        cuenta.aplicarInteres();
        assertEquals(1050.0, cuenta.consultaSaldo(), 0.01); // El saldo debería ser 1050 después de aplicar el interés
    }

    @Test
    public void testRetirar() {
        cuenta.retirar(500.0); // retirar 500
        assertEquals(480.0, cuenta.consultaSaldo(), 0.01); // después del retiro y el cargo debiera ser 490, el saldo se deja 480 para forzar el error
    }
}
