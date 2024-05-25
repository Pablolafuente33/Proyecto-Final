package comun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosicionTest {

    @Test
    public void testGetX() {
        Posicion posicion = new Posicion(3, 5);
        assertEquals(3, posicion.getX());
    }

    @Test
    public void testSetX() {
        Posicion posicion = new Posicion(0, 0);
        posicion.setX(10);
        assertEquals(10, posicion.getX());
    }

    @Test
    public void testGetY() {
        Posicion posicion = new Posicion(2, 7);
        assertEquals(7, posicion.getY());
    }

    @Test
    public void testSetY() {
        Posicion posicion = new Posicion(0, 0);
        posicion.setY(8);
        assertEquals(8, posicion.getY());
    }
}