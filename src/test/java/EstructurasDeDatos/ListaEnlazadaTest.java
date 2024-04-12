package EstructurasDeDatos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazadaTest {

    @Test
    void isVacia() {
        ListaEnlazada <Integer> lista = new ListaEnlazada<>();
        assertTrue(lista.isVacia());
        lista.add(10);
        assertFalse(lista.isVacia());
    }

    @Test
    void getPrimero() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(23);
        assertEquals(23, lista.getPrimero().getDato());
    }

    @Test
    void getUltimo() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(32);
        lista.add(12);
        lista.add(23);
        assertEquals(23, lista.getUltimo().getDato());
    }

    @Test
    void add() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(32);
        lista.add(23);
        assertEquals(32,lista.getPrimero().getDato());
        assertEquals(23, lista.getUltimo().getDato());
    }

    @Test
    void insert() {
        ListaEnlazada <Integer> lista = new ListaEnlazada<>();
        lista.add(10);
        lista.add(20);
        lista.insert(15, 1);
        assertEquals(15, lista.getPrimero().getSiguiente().getDato());
    }
}