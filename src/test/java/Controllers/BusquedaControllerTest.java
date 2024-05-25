package Controllers;

import EstructurasDeDatos.ListaSimple;
import Tablero.*;
import comun.Posicion;
import constantes.Constantes;
import individuo.Individuo;
import org.junit.jupiter.api.Test;
import recurso.Recurso;

import static org.junit.jupiter.api.Assertions.*;

class BusquedaControllerTest {

    @Test
    public void testBuscarIndividuo() {
        Tablero tablero = new Tablero(5, 5); // Crear un tablero de 5x5 (por ejemplo)
        Individuo individuo = new Individuo("Individuo", 0, 10, 0.95, 0.95, Constantes.IND_BASICO); // Crear un individuo (por ejemplo)
        Casilla casilla = new Casilla(new Posicion(2, 3)); // Crear una casilla con el individuo en la posición (2, 3)
        casilla.getListaIndividuos().add(individuo);
        tablero.setCasillaFilaColumna(2, 3, casilla);

        Casilla resultado = BusquedaController.buscarIndividuo(tablero, individuo);
        assertEquals(casilla, resultado);
    }
    @Test
    public void testBuscarRecurso() {
        Tablero tablero = new Tablero(5, 5); // Crear un tablero de 5x5 (por ejemplo)
        Recurso recurso = new Recurso("Agua", 100, 0.5, 2, 0.0, 0.0, 0.0); // Crear un recurso (por ejemplo)
        Casilla casilla = new Casilla(new Posicion(1, 3));// Crear una casilla con el recurso en la posición (1, 4)
        casilla.getListaRecursos().add(recurso);
        tablero.setCasillaFilaColumna(1, 3, casilla);

        Casilla resultado = BusquedaController.buscarRecurso(tablero, recurso);
        assertEquals(1, 1);
    }

    @Test
    public void testBuscarCasillaRecursoMasCercano() {
        Posicion actPos = new Posicion(3, 2); // Posición actual (3, 2)
        ListaSimple<Casilla> listaPosiblesCasillas = new ListaSimple<>();
        listaPosiblesCasillas.add(new Casilla(new Posicion(2, 3))); // Casilla 1 en (2, 3)
        listaPosiblesCasillas.add(new Casilla(new Posicion(4, 1))); // Casilla 2 en (4, 1)

        Casilla resultado = BusquedaController.buscarCasillaRecursoMasCercano(actPos, listaPosiblesCasillas);
        assertEquals(1,1);
    }

    @Test
    public void testCalcularDistancia() {
        Posicion actPos = new Posicion(1, 1); // Posición actual (1, 1)
        Posicion destPos = new Posicion(4, 5); // Posición destino (4, 5)

        double distancia = BusquedaController.calcularDistancia(actPos, destPos);
        assertEquals(5.0, distancia, 0.001); // Aproximadamente 5.0
    }
}