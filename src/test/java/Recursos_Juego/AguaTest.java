package Recursos_Juego;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AguaTest {

    @Test
    public void testGetVida() {
        Agua miAgua = new Agua(50, 10, 20, 30);
        assertEquals(50, miAgua.getVida());
    }

    @Test
    public void testSetVida() {
        Agua miAgua = new Agua(50, 10, 20, 30);
        miAgua.setVida(60);
        assertEquals(60, miAgua.getVida());
    }

    @Test
    public void testGetClonacion() {
        Agua miAgua = new Agua(50, 10, 20, 30);
        assertEquals(10, miAgua.getClonacion());
    }

    @Test
    public void testSetClonacion() {
        Agua miAgua = new Agua(50, 10, 20, 30);
        miAgua.setClonacion(15);
        assertEquals(15, miAgua.getClonacion());
    }

    @Test
    public void testGetReproduccion() {
        Agua miAgua = new Agua(50, 10, 20, 30);
        assertEquals(30, miAgua.getReproduccion());
    }

    @Test
    public void testSetReproduccion() {
        Agua miAgua = new Agua(50, 10, 20, 30);
        miAgua.setReproduccion(40);
        assertEquals(40, miAgua.getReproduccion());
    }

    @Test
    public void testGetMuerte() {
        Agua miAgua = new Agua(50, 10, 20, 30);
        assertEquals(70, miAgua.getMuerte());
    }

    @Test
    public void testSetMuerte() {
        Agua miAgua = new Agua(50, 10, 20, 30);
        miAgua.setMuerte(80);
        assertEquals(80, miAgua.getMuerte());
    }
}