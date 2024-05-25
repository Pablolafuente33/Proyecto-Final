package Recursos_Juego;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PozoTest {

    @Test
    public void testGetVida() {
        Pozo miPozo = new Pozo(150, 60, 25, 10);
        assertEquals(150, miPozo.getVida());
    }

    @Test
    public void testSetVida() {
        Pozo miPozo = new Pozo(150, 60, 25, 10);
        miPozo.setVida(170);
        assertEquals(170, miPozo.getVida());
    }

    @Test
    public void testGetClonacion() {
        Pozo miPozo = new Pozo(150, 60, 25, 10);
        assertEquals(10, miPozo.getClonacion());
    }

    @Test
    public void testSetClonacion() {
        Pozo miPozo = new Pozo(150, 60, 25, 10);
        miPozo.setClonacion(15);
        assertEquals(15, miPozo.getClonacion());
    }

    @Test
    public void testGetReproduccion() {
        Pozo miPozo = new Pozo(150, 60, 25, 10);
        assertEquals(60, miPozo.getReproduccion());
    }

    @Test
    public void testSetReproduccion() {
        Pozo miPozo = new Pozo(150, 60, 25, 10);
        miPozo.setReproduccion(70);
        assertEquals(70, miPozo.getReproduccion());
    }

    @Test
    public void testGetMuerte() {
        Pozo miPozo = new Pozo(150, 60, 25, 10);
        assertEquals(25, miPozo.getMuerte());
    }

    @Test
    public void testSetMuerte() {
        Pozo miPozo = new Pozo(150, 60, 25, 10);
        miPozo.setMuerte(30);
        assertEquals(30, miPozo.getMuerte());
    }
}