package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovimientoTest {

    @Test
    public void testGetX() {
        Movimiento movimiento = new Movimiento(3.0f, 4.0f);
        assertEquals(3.0f, movimiento.getX());
    }

    @Test
    public void testGetY() {
        Movimiento movimiento = new Movimiento(3.0f, 4.0f);
        assertEquals(4.0f, movimiento.getY());
    }

    @Test
    public void testGetXY() {
        Movimiento movimiento = new Movimiento(3.0f, 4.0f);
        float[] expectedXY = {3.0f, 4.0f};
        assertArrayEquals(expectedXY, movimiento.getXY());
    }

    @Test
    public void testSetXY() {
        Movimiento movimiento = new Movimiento(3.0f, 4.0f);
        movimiento.setXY(5.0f, 6.0f);
        float[] expectedXY = {5.0f, 6.0f};
        assertArrayEquals(expectedXY, movimiento.getXY());
    }
}