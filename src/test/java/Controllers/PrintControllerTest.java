package Controllers;

import comun.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintControllerTest {

    @Test
    public void testPrintPosicion() {
        Posicion posicion1 = new Posicion(3, 5);
        String resultado1 = PrintController.printPosicion(posicion1);
        assertEquals("3,5", resultado1);

        Posicion posicion2 = new Posicion(0, 0);
        String resultado2 = PrintController.printPosicion(posicion2);
        assertEquals("0,0", resultado2);

        Posicion posicion3 = new Posicion(-2, 7);
        String resultado3 = PrintController.printPosicion(posicion3);
        assertEquals("-2,7", resultado3);
    }
}