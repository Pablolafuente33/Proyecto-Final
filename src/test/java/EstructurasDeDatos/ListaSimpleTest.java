package EstructurasDeDatos;

import Recursos_Juego.Comida;
import Recursos_Juego.Montaña;
import Recursos_Juego.Pozo;
import org.controlsfx.control.ListActionView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaSimpleTest {

    @Test
    void getMax() {
    }

    @Test
    void setMax() {
    }

    @Test
    void isVacia() {
    }

    @Test
    void vaciar() {
    }

    @Test
    void add() {
        Pozo pozo = new Pozo(10,1,0);
        Montaña montaña = new Montaña(102,43,55);
        Comida comida = new Comida(1,34,22);
        ListaSimple lista1 = new ListaSimple();
        lista1.add(pozo);
        lista1.add(montaña);
        lista1.add(comida);
        Assertions.assertEquals(3, lista1.getNumeroElementos());
        Assertions.assertEquals("Pozo", lista1.getElemento()[0].getObject().toString());
        Assertions.assertEquals("Montaña", lista1.getElemento()[1].getObject().toString());
    }

    @Test
    void getNumeroElementos() {
        Pozo pozo = new Pozo(10,1,0);
        Montaña montaña = new Montaña(102,43,55);
        Comida comida = new Comida(1,34,22);
        ListaSimple lista1 = new ListaSimple();
        lista1.add(pozo);
        lista1.add(montaña);
        lista1.add(comida);
        ListaSimple lista2 = new ListaSimple();
        Assertions.assertEquals(3, lista1.getNumeroElementos());
        Assertions.assertEquals(0, lista2.getNumeroElementos());
    }
}