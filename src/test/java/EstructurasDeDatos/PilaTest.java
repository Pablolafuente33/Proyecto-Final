package EstructurasDeDatos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilaTest {
    @Test
    void isVacia() {
        Pila <Integer> pila = new Pila<>();
        assertTrue(pila.isVacia());
        pila.push(10);
        assertFalse(pila.isVacia());
    }
    @Test
    void push() {
        Pila<Integer> pila = new Pila<>();
        pila.push(10);
        pila.push(20);
        assertEquals(20, pila.pop());
        assertEquals(10, pila.pop());
    }
    @Test
    void pop() {
        Pila<Integer> pila = new Pila<>();
        pila.push(10);
        pila.push(20);
        assertEquals(20, pila.pop());
        assertEquals(10, pila.pop());

    }
    @Test
    void vaciar() {
        Pila<Integer> pila = new Pila<>();
        pila.push(10);
        pila.push(20);
        pila.vaciar();
        assertTrue(pila.isVacia());
    }
}