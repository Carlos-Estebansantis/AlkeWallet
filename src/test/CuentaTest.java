package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import cuentas.Cuenta;

public class CuentaTest {
    private Cuenta cuenta;

    @Before
    public void setUp() {
        cuenta = new Cuenta(1000.0); // saldo inicial de 1000
    }

    @Test
    public void testDepositar() {
        cuenta.depositar(500.0); // depositar 500
        assertEquals(1500.0, cuenta.consultaSaldo(), 0.01); // Después del depósito, el saldo debería ser 1500
    }

    @Test
    public void testRetirarSaldoSuficiente() {
        cuenta.retirar(500.0); // retirar 500
        assertEquals(500.0, cuenta.consultaSaldo(), 0.01); // Después del retiro, el saldo debería ser 500
    }

    @Test
    public void testRetirarSaldoInsuficiente() {
        cuenta.retirar(1500.0); // intentar retirar 1500, más de lo que hay en la cuenta
        assertEquals(1000.0, cuenta.consultaSaldo(), 0.01); // El saldo debería seguir siendo 1000, ya que no se pudo realizar el retiro
    }
}
