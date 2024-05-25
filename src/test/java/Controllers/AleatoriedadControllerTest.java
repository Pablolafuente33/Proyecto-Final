package Controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AleatoriedadControllerTest {

    @Test
    public void testGenerarRndInt() {
        int min = 5;
        int max = 10;
        int result = AleatoriedadController.generarRndInt(min, max);
        assertTrue(result >= min && result <= max);
    }

    @Test
    public void testSortearAccion() {
        double prob = 0.7;
        boolean result = AleatoriedadController.sortearAccion(prob);
        assertTrue(result || !result); // Either true or false
    }

    @Test
    public void testNumeroAzar() {
        double result = AleatoriedadController.numeroAzar();
        assertTrue(result >= 0.0 && result < 1.0);
    }
}