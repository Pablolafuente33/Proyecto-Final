package Recursos_Juego;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @Test
    public void testGetVida() {
        Biblioteca miBiblioteca = new Biblioteca(80, 25, 10, 5);
        assertEquals(80, miBiblioteca.getVida());
    }

    @Test
    public void testSetVida() {
        Biblioteca miBiblioteca = new Biblioteca(80, 25, 10, 5);
        miBiblioteca.setVida(90);
        assertEquals(90, miBiblioteca.getVida());
    }

    @Test
    public void testGetClonacion() {
        Biblioteca miBiblioteca = new Biblioteca(80, 25, 10, 5);
        assertEquals(5, miBiblioteca.getClonacion());
    }

    @Test
    public void testSetClonacion() {
        Biblioteca miBiblioteca = new Biblioteca(80, 25, 10, 5);
        miBiblioteca.setClonacion(8);
        assertEquals(8, miBiblioteca.getClonacion());
    }

    @Test
    public void testGetReproduccion() {
        Biblioteca miBiblioteca = new Biblioteca(80, 25, 10, 5);
        assertEquals(25, miBiblioteca.getReproduccion());
    }

    @Test
    public void testSetReproduccion() {
        Biblioteca miBiblioteca = new Biblioteca(80, 25, 10, 5);
        miBiblioteca.setReproduccion(30);
        assertEquals(30, miBiblioteca.getReproduccion());
    }

    @Test
    public void testGetMuerte() {
        Biblioteca miBiblioteca = new Biblioteca(80, 25, 10, 5);
        assertEquals(90, miBiblioteca.getMuerte());
    }

    @Test
    public void testSetMuerte() {
        Biblioteca miBiblioteca = new Biblioteca(80, 25, 10, 5);
        miBiblioteca.setMuerte(15);
        assertEquals(15, miBiblioteca.getMuerte());
    }
}