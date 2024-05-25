package Recursos_Juego;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesoroTest {

    @Test
    public void testGetVida() {
        Tesoro miTesoro = new Tesoro(300, 70, 40, 15);
        assertEquals(300, miTesoro.getVida());
    }

    @Test
    public void testSetVida() {
        Tesoro miTesoro = new Tesoro(300, 70, 40, 15);
        miTesoro.setVida(320);
        assertEquals(320, miTesoro.getVida());
    }

    @Test
    public void testGetClonacion() {
        Tesoro miTesoro = new Tesoro(300, 70, 40, 15);
        assertEquals(15, miTesoro.getClonacion());
    }

    @Test
    public void testSetClonacion() {
        Tesoro miTesoro = new Tesoro(300, 70, 40, 15);
        miTesoro.setClonacion(20);
        assertEquals(20, miTesoro.getClonacion());
    }

    @Test
    public void testGetReproduccion() {
        Tesoro miTesoro = new Tesoro(300, 70, 40, 15);
        assertEquals(70, miTesoro.getReproduccion());
    }

    @Test
    public void testSetReproduccion() {
        Tesoro miTesoro = new Tesoro(300, 70, 40, 15);
        miTesoro.setReproduccion(80);
        assertEquals(80, miTesoro.getReproduccion());
    }

    @Test
    public void testGetMuerte() {
        Tesoro miTesoro = new Tesoro(300, 70, 40, 15);
        assertEquals(40, miTesoro.getMuerte());
    }

    @Test
    public void testSetMuerte() {
        Tesoro miTesoro = new Tesoro(300, 70, 40, 15);
        miTesoro.setMuerte(50);
        assertEquals(50, miTesoro.getMuerte());
    }
}