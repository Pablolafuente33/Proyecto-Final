package Recursos_Juego;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MontañaTest {

    @Test
    public void testGetVida() {
        Montaña miMontaña = new Montaña(200, 50, 30, 20);
        assertEquals(200, miMontaña.getVida());
    }

    @Test
    public void testSetVida() {
        Montaña miMontaña = new Montaña(200, 50, 30, 20);
        miMontaña.setVida(220);
        assertEquals(220, miMontaña.getVida());
    }

    @Test
    public void testGetClonacion() {
        Montaña miMontaña = new Montaña(200, 50, 30, 20);
        assertEquals(20, miMontaña.getClonacion());
    }

    @Test
    public void testSetClonacion() {
        Montaña miMontaña = new Montaña(200, 50, 30, 20);
        miMontaña.setClonacion(25);
        assertEquals(25, miMontaña.getClonacion());
    }

    @Test
    public void testGetReproduccion() {
        Montaña miMontaña = new Montaña(200, 50, 30, 20);
        assertEquals(50, miMontaña.getReproduccion());
    }

    @Test
    public void testSetReproduccion() {
        Montaña miMontaña = new Montaña(200, 50, 30, 20);
        miMontaña.setReproduccion(60);
        assertEquals(60, miMontaña.getReproduccion());
    }

    @Test
    public void testGetMuerte() {
        Montaña miMontaña = new Montaña(200, 50, 30, 20);
        assertEquals(30, miMontaña.getMuerte());
    }

    @Test
    public void testSetMuerte() {
        Montaña miMontaña = new Montaña(200, 50, 30, 20);
        miMontaña.setMuerte(40);
        assertEquals(40, miMontaña.getMuerte());
    }
}