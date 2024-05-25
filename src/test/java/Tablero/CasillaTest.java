package Tablero;

import EstructurasDeDatos.ListaSimple;
import comun.Posicion;
import individuo.Individuo;
import org.junit.jupiter.api.Test;
import recurso.Recurso;

import static org.junit.jupiter.api.Assertions.*;

class CasillaTest {

    @Test
    public void testGetPosicion() {
        Posicion posicion = new Posicion(3, 4);
        Casilla miCasilla = new Casilla(posicion);
        assertEquals(posicion, miCasilla.getPosicion());
    }

    @Test
    public void testSetPosicion() {
        Posicion posicion = new Posicion(3, 4);
        Casilla miCasilla = new Casilla();
        miCasilla.setPosicion(posicion);
        assertEquals(posicion, miCasilla.getPosicion());
    }

    @Test
    public void testGetListaIndividuos() {
        Casilla miCasilla = new Casilla();
        assertNotNull(miCasilla.getListaIndividuos());
    }

    @Test
    public void testSetListaIndividuos() {
        ListaSimple<Individuo> individuos = new ListaSimple<>();
        Casilla miCasilla = new Casilla();
        miCasilla.setListaIndividuos(individuos);
        assertEquals(individuos, miCasilla.getListaIndividuos());
    }

    @Test
    public void testGetListaRecursos() {
        Casilla miCasilla = new Casilla();
        assertNotNull(miCasilla.getListaRecursos());
    }

    @Test
    public void testSetListaRecursos() {
        ListaSimple<Recurso> recursos = new ListaSimple<>();
        Casilla miCasilla = new Casilla();
        miCasilla.setListaRecursos(recursos);
        assertEquals(recursos, miCasilla.getListaRecursos());
    }
}