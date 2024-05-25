package Controllers;

import EstructurasDeDatos.ListaSimple;
import Tablero.*;
import comun.Posicion;
import constantes.Constantes;
import individuo.Individuo;
import org.junit.jupiter.api.Test;
import recurso.Recurso;

import static org.junit.jupiter.api.Assertions.*;

class VidaControllerTest {

    private Tablero tablero;
    private Casilla casilla;

    @Test
    void testActualizarTurnosVidaIndividuos() {
        tablero = new Tablero(5,5);
        casilla = new Casilla();
        // Arrange
        ListaSimple<Individuo> individuos = new ListaSimple<>();
        individuos.add(new Individuo("Ind1", 0, 10, 0.95, 0.95, Constantes.IND_BASICO)); // Turnos de vida: 3
        individuos.add(new Individuo("Ind2", 0, 10, 0.95, 0.95, Constantes.IND_NORMAL)); // Turnos de vida: 2
        individuos.add(new Individuo("Ind3", 0, 5, 0.95, 0.95, Constantes.IND_AVANZADO)); // Turnos de vida: 0 (muerto)
        individuos.add(new Individuo("Ind4", 0, 100, 0.95, 0.5, Constantes.IND_BASICO)); // Turnos de vida: -1 (muerto)
        casilla.setListaIndividuos(individuos);

        // Act
        VidaController.actualizarTurnosVidaIndividuos(tablero, casilla, 1);

        // Assert
        assertEquals(4, casilla.getListaIndividuos().getNumeroElementos());
        assertEquals(9, casilla.getListaIndividuos().get(0).getTurnosVida());
        assertEquals(9, casilla.getListaIndividuos().get(1).getTurnosVida());
    }



    @Test
    void testMuerteIndividuo() {
        tablero = new Tablero(5,5);
        casilla = new Casilla();
        // Arrange
        Individuo individuo = new Individuo("Ind1", 0, 3, 0.95, 0.95, Constantes.IND_BASICO); // Turnos de vida: 3
        casilla.setListaIndividuos(new ListaSimple<>());
        casilla.getListaIndividuos().add(individuo);
        tablero.setListaMuertosIndividuos(new ListaSimple<>());
        tablero.setListaVivosIndividuos(new ListaSimple<>());
        tablero.setListaOperacionesMuerte(new ListaSimple<>());

        // Act
        VidaController.muerteIndividuo(tablero, casilla, individuo, 2);

        // Assert
        assertEquals(0, casilla.getListaIndividuos().getNumeroElementos());
        assertEquals(1, tablero.getListaMuertosIndividuos().getNumeroElementos());
        assertEquals(0, tablero.getListaVivosIndividuos().getNumeroElementos());
        assertEquals(1, tablero.getListaOperacionesMuerte().getNumeroElementos());
        assertEquals("Ind1", tablero.getListaOperacionesMuerte().get(0));
    }

    @Test
    void testActualizarTurnosVidaRecursos() {
        tablero = new Tablero(5,5);
        casilla = new Casilla();
        // Arrange
        ListaSimple<Recurso> recursos = new ListaSimple<Recurso>();
        recursos.add(new Recurso("Agua", 3, 0.5, 3, 0.0, 0.0, 0.0)); // Turnos de vida: 3
        recursos.add(new Recurso("Comida", 2, 0.5, 2, 0.0, 0.0, 0.0)); // Turnos de vida: 2
        recursos.add(new Recurso("Montaña", 0, 0.5, 0, 0.0, 0.0, 0.0)); // Turnos de vida: 0 (agotado)
        recursos.add(new Recurso("Tesoro", -1, 0.5, -1, 0.1, 0.0, 0.0)); // Turnos de vida: -1 (agotado)
        casilla.setListaRecursos(recursos);

        // Act
        VidaController.actualizarTurnosVidaRecursos(tablero, casilla);

        // Assert
        assertEquals(2, casilla.getListaRecursos().getNumeroElementos());
        assertEquals(2, casilla.getListaRecursos().get(0).getTurnosVida());
        assertEquals(1, casilla.getListaRecursos().get(1).getTurnosVida());
    }
}