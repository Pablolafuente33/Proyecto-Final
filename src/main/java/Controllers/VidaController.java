package Controllers;

import EstructurasDeDatos.ListaSimple;
import Tablero.Casilla;
import Tablero.Tablero;
import comun.Posicion;
import constantes.Constantes;
import individuo.Individuo;
import individuo.PropertiesNuevosIndividuos;
import recurso.Recurso;

public class VidaController {

    public static void actualizarTurnosVidaIndividuos(Tablero tablero, Casilla cas, int turno) {
        ListaSimple<Individuo> individuosMuertos = new ListaSimple<>();
        for (Individuo individuo : cas.getListaIndividuos()) {
            int actualTurnosVida = individuo.getTurnosVida();
            individuo.setTurnosVida(actualTurnosVida-1);
            if (individuo.getTurnosVida()<=0) {
                individuosMuertos.add(individuo);
            } else {
                double actualProbReproduccion = individuo.getProbabilidadReproduccion();
                individuo.setProbabilidadReproduccion(actualProbReproduccion*0.9);

                double actualProbClonacion = individuo.getProbabilidadClonacion();
                individuo.setProbabilidadClonacion(actualProbClonacion*0.9);
            }
        }
        for (Individuo indMuerto : individuosMuertos) {
            muerteIndividuo(tablero, cas, indMuerto, turno);
        }
    }

    public static void muerteIndividuo(Tablero tablero, Casilla cas, Individuo individuo, int turnoMuerte) {
        individuo.setTurnoMuerte(turnoMuerte);
        cas.getListaIndividuos().remove(individuo);
        tablero.getListaMuertosIndividuos().add(individuo);
        tablero.getListaVivosIndividuos().remove(individuo);
        tablero.getListaOperacionesMuerte().add(individuo.getId());
        System.out.println("El individuo " + individuo.getId() + " ha fallecido.");
    }


    public static void actualizarTurnosVidaRecursos(Tablero tablero, Casilla cas) {
        ListaSimple<Recurso> recursosAgotados = new ListaSimple<>();
        for (Recurso recurso : cas.getListaRecursos()) {
            int actualTurnosVida = recurso.getTurnosVida();
            recurso.setTurnosVida(actualTurnosVida-1);
            if (recurso.getTurnosVida()<=0) {
                recursosAgotados.add(recurso);
            }
        }
        for (Recurso recAgotado: recursosAgotados) {
            muerteRecurso(tablero, cas, recAgotado);
        }
    }

    public static void muerteRecurso(Tablero tablero, Casilla cas, Recurso recurso) {
        cas.getListaRecursos().remove(recurso);
        tablero.getListaRecursosOFF().add(recurso);
        tablero.getListaRecursosON().remove(recurso);
        System.out.println("Se ha agotado un recurso de categoria " + recurso.getNombre());
    }

    public static void nacimientoRecurso(Tablero tablero, Recurso recurso) {
        System.out.println("Ha aparecido un nuevo recurso " + recurso.getNombre());
        tablero.getListaRecursosON().add(recurso);
    }

    public static void iteraccionIndividuoRecurso(Tablero tablero, Casilla cas, int turno) {
        ListaSimple<Individuo> individuosMuertos = new ListaSimple<>();
        for (Recurso recurso : cas.getListaRecursos()) {
            for (Individuo individuo : cas.getListaIndividuos()) {
                individuo.setTurnosVida( individuo.getTurnosVida() + recurso.getTurnosVidaInd());
                individuo.setProbabilidadReproduccion( individuo.getProbabilidadReproduccion() +
                        recurso.getProbReproduccionInd());
                individuo.setProbabilidadClonacion( individuo.getProbabilidadClonacion() +
                        recurso.getProbClonacionInd());
                individuo.getOperaciones().add(Constantes.OPER_ITERACCION + "-" + recurso.getNombre());
                System.out.println("      Iteraccion recursos -- individuos: el usuario " + individuo.getId() +
                        " ha interaccionado con el recurso de categoria " + recurso.getNombre());
                individuo.setFijadoRecursoPosicion(null);
                tablero.getListaOperacionesIteraccionRecurso().add(individuo.getId()+"--"+recurso.getNombre());
                if (individuo.getTurnosVida()<=0) {
                    individuosMuertos.add(individuo);
                }
            }
        }
        for (Individuo indMuerto : individuosMuertos) {
            muerteIndividuo(tablero, cas, indMuerto, turno);
        }
    }

    public static Individuo reproduccionIndividuos(Tablero tablero, Individuo ind1, Individuo ind2,
                                                   PropertiesNuevosIndividuos propNuevosInd, int turno) {
        String tipoNuevoInd = null;
        if (ind1.getTipo().equals(ind2.getTipo())) {
            tipoNuevoInd = ind1.getTipo();
        } else {
            String mejorTipoInd = null;
            String peorTipoInd = null;
            if (Constantes.PRIORIDAD_TIPOS_INDIVIDUOS.indexOf(ind1.getTipo()) >
                    Constantes.PRIORIDAD_TIPOS_INDIVIDUOS.indexOf(ind2.getTipo()) ) {
                mejorTipoInd = ind1.getTipo();
                peorTipoInd = ind2.getTipo();
            } else {
                mejorTipoInd = ind2.getTipo();
                peorTipoInd = ind1.getTipo();
            }
            if ( AleatoriedadController.sortearAccion(propNuevosInd.getprobabilidadMejora()) ) {
                tipoNuevoInd = mejorTipoInd;
            } else {
                tipoNuevoInd = peorTipoInd;
            }
        }

        Individuo nuevoIndividuo = new Individuo(ind1.getId().substring(3) + "_" + ind2.getId().substring(3), turno,
                propNuevosInd.getTurnosVida(), propNuevosInd.getProbabilidadReproduccion(),
                propNuevosInd.getProbabilidadClonacion(), tipoNuevoInd);
        nuevoIndividuo.setPosicion(ind1.getPosicion());
        return nuevoIndividuo;
    }

    public static Individuo clonacionIndividuos(Tablero tablero, Individuo ind, int turno) {
        if ( AleatoriedadController.sortearAccion(ind.getProbabilidadClonacion()) ) {
            Individuo clonadoIndividuo = new Individuo(ind.getId() + "_" + "c" + turno, turno,
                    ind.getTurnosVida(), ind.getProbabilidadReproduccion(),
                    ind.getProbabilidadClonacion(), ind.getTipo());
            clonadoIndividuo.setPosicion(ind.getPosicion());
            tablero.getListaOperacionesClonacion().add(ind.getId());
            return clonadoIndividuo;
        }
        return null;
    }

    public static void nacimientoIndividuo(Tablero tablero, Individuo individuo) {
        Posicion posicionIndNacido = individuo.getPosicion();
        tablero.getCasillaFilaColumna(posicionIndNacido.getX(), posicionIndNacido.getY())
                .getListaIndividuos().add(individuo);
        tablero.getListaTodosIndividuos().add(individuo);
        tablero.getListaVivosIndividuos().add(individuo);
        tablero.getListaOperacionesNacimiento().add(individuo.getId());
        System.out.println("Ha nacido el individuo " + individuo.getId());
    }

    public static void limpiarViejosIndividuos(Tablero tablero, Casilla cas, int turno) {
        while (cas.getListaIndividuos().getNumeroElementos()>3) {
            Individuo viejoIndividuo = buscarMasViejoIndividuo(cas.getListaIndividuos());
            muerteIndividuo(tablero, cas, viejoIndividuo, turno);
            cas.getListaIndividuos().remove(viejoIndividuo);
        }
    }

    private static Individuo buscarMasViejoIndividuo(ListaSimple<Individuo> individuos) {
        Individuo viejoInd = individuos.get(0);
        int menosTurnosVida = viejoInd.getTurnosVida();
        for (int i=1; i<individuos.getNumeroElementos(); ++i) {
            if (individuos.get(i).getTurnosVida() < menosTurnosVida) {
                menosTurnosVida = individuos.get(i).getTurnosVida();
                viejoInd = individuos.get(i);
            }
        }
        return viejoInd;
    }
}
