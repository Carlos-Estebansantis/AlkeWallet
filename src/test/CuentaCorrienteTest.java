package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import cuentas.CuentaCorriente;

public class CuentaCorrienteTest {
    private CuentaCorriente cuenta;

    @Before
    public void setUp() {
        cuenta = new CuentaCorriente(1000.0, 500.0); // saldo inicial de 1000 y límite de sobregiro de 500
    }

    @Test
    public void testRetirarDentroDelLimite() {
        cuenta.retirar(800.0); // retirar 800, dentro del límite de sobregiro
        assertEquals(200.0, cuenta.consultaSaldo(), 0.01); // Después del retiro, el saldo debería ser 200
    }

    @Test
    public void testRetirarFueraDelLimite() {
        cuenta.retirar(1600.0); // intentar retirar 1600, fuera del límite de sobregiro
        assertEquals(1000.0, cuenta.consultaSaldo(), 0.01); // El saldo debería seguir siendo 1000, ya que no se pudo realizar el retiro
    }
}
