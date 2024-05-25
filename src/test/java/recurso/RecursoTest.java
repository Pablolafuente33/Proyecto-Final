package recurso;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoTest {

    @Test
    public void testGetTurnosVida() {
        Recurso miRecurso = new Recurso("Ejemplo", 10, 0.5, 5, 0.3, 0.1, 0.2);
        assertEquals(10, miRecurso.getTurnosVida());
    }

    @Test
    public void testSetTurnosVida() {
        Recurso miRecurso = new Recurso("Ejemplo", 10, 0.5, 5, 0.3, 0.1, 0.2);
        miRecurso.setTurnosVida(8);
        assertEquals(8, miRecurso.getTurnosVida());
    }

    @Test
    public void testGetProbAparicion() {
        Recurso miRecurso = new Recurso("Ejemplo", 10, 0.5, 5, 0.3, 0.1, 0.2);
        assertEquals(0.5, miRecurso.getProbAparicion(), 0.001);
    }

    @Test
    public void testSetProbAparicion() {
        Recurso miRecurso = new Recurso("Ejemplo", 10, 0.5, 5, 0.3, 0.1, 0.2);
        miRecurso.setProbAparicion(0.7);
        assertEquals(0.7, miRecurso.getProbAparicion(), 0.001);
    }
}