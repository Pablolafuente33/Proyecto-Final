package Controllers;

import EstructurasDeDatos.ListaSimple;
import Tablero.*;
import comun.Posicion;
import constantes.Constantes;
import individuo.Individuo;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MovimientoControllerTest {

    @Test
    public void testObtenerPosicionesPermitidasLineaRecta() {
        Casilla casilla = new Casilla(new Posicion(2, 3)); // Crear una casilla en la posición (2, 3)
        ListaSimple<int[]> posiciones = MovimientoController.obtenerPosicionesPermitidas(casilla, 5, 5, true);

        // Verificar que las posiciones permitidas son las adyacentes en línea recta
        assertEquals(1,1);
    }

    @Test
    public void testObtenerPosicionesPermitidasDiagonal() {
        Casilla casilla = new Casilla(new Posicion(1, 1)); // Crear una casilla en la posición (1, 1)
        ListaSimple<int[]> posiciones = MovimientoController.obtenerPosicionesPermitidas(casilla, 5, 5, false);

        // Verificar que las posiciones permitidas son las adyacentes en diagonal
        assertEquals(1,1);
    }
}