package individuo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesNuevosIndividuosTest {

    @Test
    void testGetProbabilidadMejora() {
        PropertiesNuevosIndividuos individuos = new PropertiesNuevosIndividuos(0.8, 10, 0.5, 0.2);
        assertEquals(0.8, individuos.getprobabilidadMejora());
    }

    @Test
    void testSetTurnosVida() {
        PropertiesNuevosIndividuos individuos = new PropertiesNuevosIndividuos(0.7, 15, 0.6, 0.3);
        individuos.setTurnosVida(20);
        assertEquals(20, individuos.getTurnosVida());
    }

    @Test
    void testGetProbabilidadReproduccion() {
        PropertiesNuevosIndividuos individuos = new PropertiesNuevosIndividuos(0.9, 12, 0.7, 0.4);
        assertEquals(0.7, individuos.getProbabilidadReproduccion());
    }

}