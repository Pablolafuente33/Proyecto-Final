package Simulacion;

import Controllers.*;
import EstructurasDeDatos.ListaSimple;
import Tablero.Tablero;
import Tablero.Casilla;
import constantes.Constantes;
import individuo.Individuo;
import individuo.PropertiesNuevosIndividuos;
import recurso.Recurso;


public class SimulacionJuego {

    public static void main(String[] args) {

        /** Se inicializa el tablero NxM */
        int turno = 0;
        int maximoTurnos = 100;
        int n = 10;
        int m = 10;
        Tablero tablero = new Tablero(n,m);
        System.out.println("Tablero listo, comienza el juego!!");

        // Properties nuevos Individuos
        PropertiesNuevosIndividuos propestiesNuevosIndividuos = new PropertiesNuevosIndividuos(
                0.5, 10, 0.5, 0.1);

        double probAparicionNuevoRecurso = 0.25;

        /** Se recogen los valores del menú para los individuos y recursos */
        // Como no tenemos esos valores al comienzo de esta simulación se eligen

        //Recursos
        Recurso agua = new Recurso("Agua", 100, 0.5, 2, 0.0, 0.0, 0.0);
        Recurso comida = new Recurso("Comida", 100, 0.5, 10, 0.0, 0.0, 0.0);
        Recurso montaña = new Recurso("Montaña", 100, 0.5, -2, 0.0, 0.0, 0.0);
        Recurso tesoro = new Recurso("Tesoro", 100, 0.5, 0, 0.1, 0.0, 0.0);
        Recurso biblioteca = new Recurso("Biblioteca", 100, 0.5, 0, 0.0, 0.0, 0.1);
        Recurso pozo = new Recurso("Pozo", 100, 0.5, Integer.MAX_VALUE, 0.0, 0.0, 0.0);

        // Individuos
        Individuo pascual = new Individuo("Pascual", 0, 10, 0.95, 0.95, Constantes.IND_BASICO);
        Individuo pingo = new Individuo("Pingo", 0, 10, 0.95, 0.95, Constantes.IND_NORMAL);
        Individuo polis = new Individuo("Polis", 0, 5, 0.95, 0.95, Constantes.IND_AVANZADO);
        Individuo panties = new Individuo("Panties", 0, 100, 0.95, 0.5, Constantes.IND_BASICO);
        Individuo mapi = new Individuo("Mapi", 0, 100, 0.5, 0.95, Constantes.IND_NORMAL);
        Individuo sharky = new Individuo("Sharky", 0, 5, 0.5, 0.5, Constantes.IND_AVANZADO);

        /** Se colocan los recursos e individuos en el tablero*/
        // Las posiciones no pueden ser nulas
        ListaSimple<Recurso> listaRecursos = ListaSimple.of(agua, comida, montaña, tesoro, biblioteca, pozo);
        tablero.setListaRecursosUnicos(listaRecursos);
        tablero.getListaRecursosON().addAll(listaRecursos);

        tablero.getListaVivosIndividuos().add(pascual);
        tablero.getListaVivosIndividuos().add(pingo);
        tablero.getListaVivosIndividuos().add(polis);
        tablero.getListaVivosIndividuos().add(mapi);
        tablero.getListaVivosIndividuos().add(panties);
        tablero.getListaVivosIndividuos().add(sharky);

        tablero.getListaTodosIndividuos().addAll(tablero.getListaVivosIndividuos());

        tablero.getCasillaFilaColumna(2, 7).getListaIndividuos().add(pascual);
        tablero.getCasillaFilaColumna(5, 5).getListaIndividuos().add(pingo);
        tablero.getCasillaFilaColumna(9, 8).getListaIndividuos().add(polis);
        tablero.getCasillaFilaColumna(4, 4).getListaIndividuos().add(panties);
        tablero.getCasillaFilaColumna(1, 6).getListaIndividuos().add(mapi);
        tablero.getCasillaFilaColumna(2, 2).getListaIndividuos().add(sharky);

        tablero.getCasillaFilaColumna(1, 4).getListaRecursos().add(agua);
        tablero.getCasillaFilaColumna(3, 8).getListaRecursos().add(comida);
        tablero.getCasillaFilaColumna(7, 0).getListaRecursos().add(montaña);
        tablero.getCasillaFilaColumna(5, 4).getListaRecursos().add(tesoro);
        tablero.getCasillaFilaColumna(9, 0).getListaRecursos().add(biblioteca);
        tablero.getCasillaFilaColumna(6, 6).getListaRecursos().add(pozo);

        while ( tablero.getListaVivosIndividuos().getNumeroElementos()>1 && turno<maximoTurnos ) {
            ++turno;
            System.out.println("Comienza el turno: " + turno);

            /** En primer lugar, actualizamos los turnos de vida de los individuos y recursos */
            System.out.println(" ---> Actualizacion de turnos de vida");
            for (int i=0; i<tablero.getFilas(); ++i) {
                for (int j=0; j<tablero.getColumnas(); ++j) {
                    Casilla cas = tablero.getCasillaFilaColumna(i,j);
                    VidaController.actualizarTurnosVidaIndividuos(tablero, cas, turno);
                    VidaController.actualizarTurnosVidaRecursos(tablero, cas);
                }
            }

            /** Luego, los individuos realizan sus movimientos*/
            System.out.println(" ---> Movimiento");
            if (tablero.getListaVivosIndividuos()!=null && !tablero.getListaVivosIndividuos().isVacia()) {
                for (int i=0; i<tablero.getListaVivosIndividuos().getNumeroElementos(); ++i) {
                    // Fijamos la posicion en el individuo
                    Individuo individuo = tablero.getListaVivosIndividuos().get(i);
                    Casilla casillaInd = BusquedaController.buscarIndividuo(tablero, individuo);
                    individuo.setPosicion(casillaInd.getPosicion());
                    // Se fijan los recursos en el caso de que procedan
                    if ((individuo.getTipo().equals(Constantes.IND_NORMAL) || individuo.getTipo().equals(Constantes.IND_AVANZADO))
                            && individuo.getFijadoRecursoPosicion() == null) {
                        // Se fija el recurso al cual se va mover el usuario normal o avanzado.
                        RecursoController.fijarRecursoIndividuo(tablero, individuo);
                    }
                    // El usuario realiza la accion de movimiento
                    MovimientoController.accionMovimiento(tablero, individuo);
                }
            }

            /** Comprobamos la interacción de los recursos con los individuos */
            System.out.println(" ---> Iteraccion recursos -- individuos");
            for (int i=0; i<tablero.getFilas(); ++i) {
                for (int j=0; j<tablero.getColumnas(); ++j) {
                    Casilla cas = tablero.getCasillaFilaColumna(i,j);
                    if ( !cas.getListaIndividuos().isVacia() && !cas.getListaRecursos().isVacia() ) {
                        VidaController.iteraccionIndividuoRecurso( tablero, cas, turno);
                    }
                }
            }

            /** Reproduccion y clonacion */
            System.out.println(" ---> Reproduccion y clonacion");
            for (int i=0; i<tablero.getFilas(); ++i) {
                for (int j=0; j<tablero.getColumnas(); ++j) {
                    Casilla cas = tablero.getCasillaFilaColumna(i,j);
                    ListaSimple<Individuo> nuevosIndividuos = new ListaSimple<>();

                    if ( !cas.getListaIndividuos().isVacia() && cas.getListaIndividuos().getNumeroElementos()>2 ) {
                        // Comprobamos que individuos son los que se van a reproducir
                        ListaSimple<Individuo> indReproductores = new ListaSimple<>();
                        for (int k=0; k<nuevosIndividuos.getNumeroElementos(); ++k) {
                            Individuo ind = nuevosIndividuos.get(k);
                            if (AleatoriedadController.sortearAccion(ind.getProbabilidadReproduccion())) {
                                // El usuario actual es reproductor
                                indReproductores.add(ind);
                            }
                        }
                        // Comprobamos que los usuarios que se pueden reproducir sean al menos 2 individuos
                        if( indReproductores.getNumeroElementos()>=2 ){
                            // En el caso de que los 3 individuos de la casilla se puedan reproducir, se sacrifica al 3º individuo
                            if ( indReproductores.getNumeroElementos()==3) {
                                VidaController.muerteIndividuo(tablero, cas, indReproductores.get(2), turno);
                            }
                            // Se reproducen los dos individuos
                            Individuo nacidoInd = VidaController.reproduccionIndividuos(tablero, cas.getListaIndividuos().get(0),
                                    cas.getListaIndividuos().get(1), propestiesNuevosIndividuos, turno);
                            nuevosIndividuos.add(nacidoInd);
                        } else {
                            // No se reproduce ningun individuo en la casilla actual, luego todos mueren
                            ListaSimple<Individuo> indSacrificados = new ListaSimple<>();
                            indSacrificados.addAll(cas.getListaIndividuos());
                            for (int k=0; k<indSacrificados.getNumeroElementos(); ++k) {
                                Individuo indSacr = indSacrificados.get(k);
                                VidaController.muerteIndividuo(tablero, cas, indSacr, turno);
                            }
                        }

                    }

                    // Se comprueba si algun individuo se clona así mismo
                    for (int k=0; k<cas.getListaIndividuos().getNumeroElementos(); ++k) {
                        Individuo individuo = cas.getListaIndividuos().get(k);
                        Individuo clonadoInd = VidaController.clonacionIndividuos(tablero, individuo, turno);
                        if (clonadoInd != null) {
                            nuevosIndividuos.add(clonadoInd);
                        }
                    }

                    // Nacen los individuos clonados y nacidos por reproduccion
                    for (int k=0; k<nuevosIndividuos.getNumeroElementos(); ++k) {
                        Individuo nInd = nuevosIndividuos.get(k);
                        VidaController.nacimientoIndividuo(tablero, nInd);
                    }

                    // Se limpian hasta dejar sólo los tres individuos más jóvenes
                    if (cas.getListaIndividuos().getNumeroElementos()>3) {
                        VidaController.limpiarViejosIndividuos(tablero, cas, turno);
                    }

                    // Se comprueba si en la casilla actual debe aparecer un recurso más
                    if (cas.getListaRecursos().getNumeroElementos()<3 &&
                            AleatoriedadController.sortearAccion(probAparicionNuevoRecurso)) {
                        // Debe aparecer un nuevo recurso en esta casilla
                        Recurso nuevoRecurso = RecursoController.sortearNuevoRecurso(tablero.getListaRecursosUnicos());
                        VidaController.nacimientoRecurso(tablero, nuevoRecurso);
                    }
                }
            }
            System.out.println("Siguiente turno");


        }

        System.out.println("Juego terminado!!");
        System.out.println("listaOperacionesReproducccion: " + tablero.getListaOperacionesReproducccion().toString());
        System.out.println("listaOperacionesClonacion: " + tablero.getListaOperacionesClonacion().toString());
        System.out.println("listaOperacionesNacimiento: " + tablero.getListaOperacionesNacimiento().toString());
        System.out.println("listaOperacionesMuerte: " + tablero.getListaOperacionesMuerte().toString());
        System.out.println("listaOperacionesIteraccionRecurso: " + tablero.getListaOperacionesIteraccionRecurso().toString());

    }
}