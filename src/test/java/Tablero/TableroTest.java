package Tablero;

import EstructurasDeDatos.ListaSimple;
import individuo.Individuo;
import org.junit.jupiter.api.Test;
import recurso.Recurso;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {
    @Test
    public void testGetFilas() {
        Tablero tablero = new Tablero(5, 5);
        assertEquals(5, tablero.getFilas());
    }

    @Test
    public void testSetFilas() {
        Tablero tablero = new Tablero(5, 5);
        tablero.setFilas(6);
        assertEquals(6, tablero.getFilas());
    }

    @Test
    public void testGetColumnas() {
        Tablero tablero = new Tablero(5, 5);
        assertEquals(5, tablero.getColumnas());
    }

    @Test
    public void testSetColumnas() {
        Tablero tablero = new Tablero(5, 5);
        tablero.setColumnas(6);
        assertEquals(6, tablero.getColumnas());
    }

    @Test
    public void testGetCasillas() {
        Tablero tablero = new Tablero(5, 5);
        assertNotNull(tablero.getCasillas());
    }

    @Test
    public void testSetCasillas() {
        Tablero tablero = new Tablero(5, 5);
        ListaSimple<ListaSimple<Casilla>> casillas = new ListaSimple<>();
        tablero.setCasillas(casillas);
        assertEquals(casillas, tablero.getCasillas());
    }

    @Test
    public void testGetCasillaFilaColumna() {
        Tablero tablero = new Tablero(5, 5);
        Casilla casilla = tablero.getCasillaFilaColumna(2, 3);
        assertNotNull(casilla);
    }

    @Test
    public void testSetCasillaFilaColumna() {
        Tablero tablero = new Tablero(5, 5);
        Casilla nuevaCasilla = new Casilla();
        tablero.setCasillaFilaColumna(2, 3, nuevaCasilla);
        assertEquals(nuevaCasilla, tablero.getCasillaFilaColumna(2, 3));
    }

    @Test
    public void testGetListaTodosIndividuos() {
        Tablero tablero = new Tablero(5, 5);
        assertNotNull(tablero.getListaTodosIndividuos());
    }

    @Test
    public void testSetListaTodosIndividuos() {
        Tablero tablero = new Tablero(5, 5);
        ListaSimple<Individuo> individuos = new ListaSimple<>();
        tablero.setListaTodosIndividuos(individuos);
        assertEquals(individuos, tablero.getListaTodosIndividuos());
    }

    @Test
    public void testGetListaVivosIndividuos() {
        Tablero tablero = new Tablero(5, 5);
        assertNotNull(tablero.getListaVivosIndividuos());
    }

    @Test
    public void testSetListaVivosIndividuos() {
        Tablero tablero = new Tablero(5, 5);
        ListaSimple<Individuo> vivos = new ListaSimple<>();
        tablero.setListaVivosIndividuos(vivos);
        assertEquals(vivos, tablero.getListaVivosIndividuos());
    }

    @Test
    public void testGetListaMuertosIndividuos() {
        Tablero tablero = new Tablero(5, 5);
        assertNotNull(tablero.getListaMuertosIndividuos());
    }

    @Test
    public void testSetListaMuertosIndividuos() {
        Tablero tablero = new Tablero(5, 5);
        ListaSimple<Individuo> muertos = new ListaSimple<>();
        tablero.setListaMuertosIndividuos(muertos);
        assertEquals(muertos, tablero.getListaMuertosIndividuos());
    }

    @Test
    public void testGetListaRecursosUnicos() {
        Tablero tablero = new Tablero(5, 5);
        assertNotNull(tablero.getListaRecursosUnicos());
    }

    @Test
    public void testSetListaRecursosUnicos() {
        Tablero tablero = new Tablero(5, 5);
        ListaSimple<Recurso> recursos = new ListaSimple<>();
        tablero.setListaRecursosUnicos(recursos);
        assertEquals(recursos, tablero.getListaRecursosUnicos());
    }
}