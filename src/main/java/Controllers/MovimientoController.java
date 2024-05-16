package Controllers;

import EstructurasDeDatos.ListaSimple;
import comun.Posicion;
import constantes.Constantes;
import individuo.Individuo;
import Tablero.Tablero;
import Tablero.Casilla;

public class MovimientoController {

    private static final ListaSimple<Integer> LISTA_MOVILIDAD = ListaSimple.of(-1,0,1);

    private static final int MAX_TAMAÑO_LISTAa_POSICIONES = 8;

    public static void accionMovimiento(Tablero tablero, Individuo individuo) {

        // Identificamos la casilla en la que se encuentra el individuo
        Casilla actualCasilla = BusquedaController.buscarIndividuo(tablero, individuo);

        // Identificamos el tipo del individuo
        Casilla casillaDestino = null;

        switch(individuo.getTipo()) {
            case Constantes.IND_BASICO:
                // movimiento aleatorio
                ListaSimple<int[]> posicionesPermitidasAleatorias = obtenerPosicionesPermitidas(actualCasilla,
                        tablero.getFilas(), tablero.getColumnas(), false);
                int[] nuevaPosicion = posicionesPermitidasAleatorias.get(
                        AleatoriedadController.generarRndInt(0, posicionesPermitidasAleatorias.getNumeroElementos()-1));
                casillaDestino = tablero.getCasillaFilaColumna(nuevaPosicion[0], nuevaPosicion[1]);
                break;
            case Constantes.IND_NORMAL:
                // movimiento en linea recta
                ListaSimple<int[]> posicionesPermitidasNormal = obtenerPosicionesPermitidas(actualCasilla,
                        tablero.getFilas(), tablero.getColumnas(), true);
                Posicion posicionMasCercanaNormal = hallarPosicionPermitidaMasCercanaRecurso(posicionesPermitidasNormal,
                        individuo.getFijadoRecursoPosicion());
                casillaDestino = tablero.getCasillaFilaColumna(posicionMasCercanaNormal.getX(), posicionMasCercanaNormal.getY());
                break;
            case Constantes.IND_AVANZADO:
                // movimiento diagonal
                ListaSimple<int[]> posicionesPermitidasAvanzado = obtenerPosicionesPermitidas(actualCasilla,
                        tablero.getFilas(), tablero.getColumnas(), false);
                Posicion posicionMasCercanaAvanzado = hallarPosicionPermitidaMasCercanaRecurso(posicionesPermitidasAvanzado,
                        individuo.getFijadoRecursoPosicion());
                casillaDestino = tablero.getCasillaFilaColumna(posicionMasCercanaAvanzado.getX(), posicionMasCercanaAvanzado.getY());
                break;
            default:
                System.out.println("accionMovimiento() -> Tipo de usuario no reconocido.");
                break;
        }

        movimientoIndividuo(individuo, actualCasilla, casillaDestino);
    }

    private static void movimientoIndividuo(Individuo individuo, Casilla casillaOrigen, Casilla casillaDestino) {
        casillaOrigen.getListaIndividuos().remove(individuo);
        casillaDestino.getListaIndividuos().add(individuo);
        individuo.setPosicion( casillaDestino.getPosicion());
        System.out.println("      Movimiento: El individuo " + individuo.getId() + " con tipo " + individuo.getTipo() + " se ha movido desde la posicion "
                + PrintController.printPosicion(casillaOrigen.getPosicion()) + " a la posicion "
                + PrintController.printPosicion(casillaDestino.getPosicion()) );
    }

    private static ListaSimple<int[]> obtenerPosicionesPermitidas(Casilla actualCasilla, int filas, int columnas, boolean lineaRecta) {
        // El objetivo de esta función es obtener las posiciones prohibidas,
        // para que los individuos no se caigan del tablero jejeje
        int x = actualCasilla.getPosicion().getX();
        int y = actualCasilla.getPosicion().getY();

        ListaSimple<int[]> posiciones = new ListaSimple<>(8);

        for(Integer movX : LISTA_MOVILIDAD) {
            for(Integer movY : LISTA_MOVILIDAD) {
                if ( (movX!=0 && movY!=0) && (x + movX<columnas) && (y + movY<filas)
                        && (x + movX>=0) && (y + movY>=0)) {
                    if (lineaRecta && (movX==0 || movY==0) ){
                        posiciones.add(new int[]{x + movX, y + movY});
                    } else {
                        posiciones.add(new int[]{x + movX, y + movY});
                    }
                }
            }
        }
        return posiciones;
    }

    private static Posicion hallarPosicionPermitidaMasCercanaRecurso(ListaSimple<int[]> posicionesPermitidas, Posicion recursoPosicion) {
        // Se calcula la distancia de todas las casillas posibles a la posicion del recurso

        double minDistancia = Double.MAX_VALUE;
        Posicion posicionPermitidaMasCercanaRecurso = null;
        for (int[] posPermitida : posicionesPermitidas) {
            Posicion actualPosicion = new Posicion( posPermitida[0], posPermitida[1]);
            double distancia = BusquedaController.calcularDistancia(actualPosicion, recursoPosicion);
            System.out.println("dist:" + distancia);
            if ( distancia<minDistancia ) {
                minDistancia = distancia;
                posicionPermitidaMasCercanaRecurso = actualPosicion;
            }
        }
        if (posicionPermitidaMasCercanaRecurso==null) {
            System.out.println("ver qqqq");
        }
        return posicionPermitidaMasCercanaRecurso;
    }
}
