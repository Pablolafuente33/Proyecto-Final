package individuo;

import comun.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {

    @Test
    void testGetId() {
        Individuo individuo = new Individuo("ID123", 1, 10, 0.5, 0.2, "TipoA");
        assertEquals("ID123", individuo.getId());
    }

    @Test
    void testSetTurnoGeneracion() {
        Individuo individuo = new Individuo("ID456", 2, 15, 0.7, 0.1, "TipoB");
        individuo.setTurnoGeneracion(3);
        assertEquals(3, individuo.getTurnoGeneracion());
    }

    @Test
    void testProbabilidadReproduccion() {
        Individuo individuo = new Individuo("ID789", 4, 20, 0.6, 0.3, "TipoC");
        assertEquals(0.6, individuo.getProbabilidadReproduccion());
    }

    @Test
    void testSetProbabilidadMuerte() {
        Individuo individuo = new Individuo("ID987", 5, 25, 0.4, 0.5, "TipoD");
        individuo.setProbabilidadMuerte(0.3);
        assertEquals(0.3, individuo.getProbabilidadMuerte());
    }

    @Test
    void testSetFijadoRecursoPosicion() {
        Individuo individuo = new Individuo("ID654", 6, 30, 0.8, 0.2, "TipoE");
        Posicion posicion = new Posicion(10, 20);
        individuo.setFijadoRecursoPosicion(posicion);
        assertEquals(posicion, individuo.getFijadoRecursoPosicion());
    }
}