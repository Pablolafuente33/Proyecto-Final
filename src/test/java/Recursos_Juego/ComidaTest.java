package Recursos_Juego;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComidaTest {

    @Test
    public void testGetVida() {
        Comida miComida = new Comida(100, 40, 20, 10);
        assertEquals(100, miComida.getVida());
    }

    @Test
    public void testSetVida() {
        Comida miComida = new Comida(100, 40, 20, 10);
        miComida.setVida(120);
        assertEquals(120, miComida.getVida());
    }

    @Test
    public void testGetClonacion() {
        Comida miComida = new Comida(100, 40, 20, 10);
        assertEquals(10, miComida.getClonacion());
    }

    @Test
    public void testSetClonacion() {
        Comida miComida = new Comida(100, 40, 20, 10);
        miComida.setClonacion(15);
        assertEquals(15, miComida.getClonacion());
    }

    @Test
    public void testGetReproduccion() {
        Comida miComida = new Comida(100, 40, 20, 10);
        assertEquals(40, miComida.getReproduccion());
    }

    @Test
    public void testSetReproduccion() {
        Comida miComida = new Comida(100, 40, 20, 10);
        miComida.setReproduccion(50);
        assertEquals(50, miComida.getReproduccion());
    }

    @Test
    public void testGetMuerte() {
        Comida miComida = new Comida(100, 40, 20, 10);
        assertEquals(20, miComida.getMuerte());
    }

    @Test
    public void testSetMuerte() {
        Comida miComida = new Comida(100, 40, 20, 10);
        miComida.setMuerte(30);
        assertEquals(30, miComida.getMuerte());
    }
}