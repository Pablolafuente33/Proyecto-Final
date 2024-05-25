package EstructurasDeDatos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoLETest {

    @Test
    void getSiguiente() {
    }

    @Test
    void insertarmeEn() {
    }

    @Test
    void getDato() {
        NodoLE<Integer> nodo = new NodoLE<>(23);
        assertEquals(23, nodo.getDato());
    }

    @Test
    void setDato() {
        NodoLE<Integer> nodo = new NodoLE<>(23);
        nodo.setDato(33);
        assertEquals(33, nodo.getDato());
    }
}