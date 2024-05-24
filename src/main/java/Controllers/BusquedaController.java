package Controllers;

import EstructurasDeDatos.ListaSimple;
import Tablero.Casilla;
import comun.Posicion;
import individuo.Individuo;
import Tablero.Tablero;
import recurso.Recurso;

public class BusquedaController {

    public static Casilla buscarIndividuo(Tablero tablero, Individuo individuo) {
        for (int i=0; i<tablero.getFilas(); ++i) {
            for (int j=0; j<tablero.getColumnas(); ++j) {
                Casilla cas = tablero.getCasillaFilaColumna(i,j);
                if ( cas.getListaIndividuos().indexOf(individuo)>=0 ) {
                    return cas;
                }
            }
        }
        // usuario no encontrado
        return null;
    }

    public static Casilla buscarRecurso(Tablero tablero, Recurso recurso) {
        for (int i=0; i<tablero.getFilas(); ++i) {
            for (int j=0; j<tablero.getColumnas(); ++j) {
                Casilla cas = tablero.getCasillaFilaColumna(i,j);
                if ( cas.getListaRecursos().contains(recurso) ) {
                    return cas;
                }
            }
        }
        // recurso no encontrado
        return null;
    }

    public static Casilla buscarCasillaRecursoMasCercano(Posicion actPos, ListaSimple<Casilla> listaPosiblesCasillas) {
        double distancia = 0.0;
        Casilla casillaRecursoMasCercano = null;
        for (Casilla casilla : listaPosiblesCasillas) {
            double dist = calcularDistancia(actPos, casilla.getPosicion());
            if (Double.compare(0.0, distancia)==0 || Double.compare(dist, distancia)<0 ) {
                casillaRecursoMasCercano = casilla;
            }
        }
        return casillaRecursoMasCercano;
    }

    public static double calcularDistancia(Posicion actPos, Posicion destPos) {
        return Math.sqrt( Math.pow(actPos.getX()*1.0 - destPos.getX()*1.0,2) +
                Math.pow(actPos.getY()*1.0 - destPos.getY()*1.0,2));
    }
}
