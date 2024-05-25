package Controllers;

import EstructurasDeDatos.ListaSimple;
import Tablero.*;
import comun.Posicion;
import constantes.Constantes;
import individuo.Individuo;
import org.junit.jupiter.api.Test;
import recurso.Recurso;

import static org.junit.jupiter.api.Assertions.*;

class RecursoControllerTest {

    @Test
    public void testSortearNuevoRecurso() {
        Recurso recurso1 = new Recurso("Agua", 100, 0.5, 2, 0.0, 0.0, 0.0); // Crear un recurso con probabilidad de aparición 0.3
        Recurso recurso2 = new Recurso("Comida", 100, 0.5, 10, 0.0, 0.0, 0.0); // Crear otro recurso con probabilidad de aparición 0.5
        ListaSimple<Recurso> recursos = new ListaSimple<>();
        recursos.add(recurso1);
        recursos.add(recurso2);

        Recurso resultado = RecursoController.sortearNuevoRecurso(recursos);

        // Verificar que el recurso sorteado es uno de los dos posibles
        assertTrue(resultado == recurso1 || resultado == recurso2);
    }
}