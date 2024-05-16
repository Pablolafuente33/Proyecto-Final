package Controllers;


import EstructurasDeDatos.ListaSimple;
import individuo.Individuo;
import recurso.Recurso;
import Tablero.Tablero;
import Tablero.Casilla;
import constantes.Constantes;

public class RecursoController {

    public static void fijarRecursoIndividuo(Tablero tablero, Individuo individuo) {
        ListaSimple<Recurso> listaPosiblesRecursos = tablero.getListaRecursosON();

        // Se identifican todas las posibles casillas a las que puede moverse el individuo
        ListaSimple<Casilla> listaPosiblesCasillas = new ListaSimple<>(tablero.getListaRecursosON().getNumeroElementos());
        for (Recurso recurso : listaPosiblesRecursos) {
            Casilla casillaRecurso = BusquedaController.buscarRecurso(tablero, recurso);
            if (casillaRecurso.getPosicion() != individuo.getPosicion()) {
                listaPosiblesCasillas.add(casillaRecurso);
            }
        }

        // Se comprueba el tipo de individuo, la fijacion de los recursos depende del tipo del individuo
        Casilla proximoDestino = null;
        if (individuo.getTipo().equals(Constantes.IND_AVANZADO)) {
            // Se busca la casilla donde se encuentra el recurso mas cercano
            proximoDestino = BusquedaController.buscarCasillaRecursoMasCercano(individuo.getPosicion(),
                    listaPosiblesCasillas);
        } else {
            int i = AleatoriedadController.generarRndInt(0, listaPosiblesCasillas.getNumeroElementos()-1);
            proximoDestino = listaPosiblesCasillas.get(i);
        }
        System.out.println("      Fijacion recurso: El individuo " + individuo.getId() + " con tipo " + individuo.getTipo() +
                " ha fijado el destino en el recurso con posicion "
                + PrintController.printPosicion(proximoDestino.getPosicion()) );
        individuo.setFijadoRecursoPosicion( proximoDestino.getPosicion());
    }

    public static Recurso sortearNuevoRecurso(ListaSimple<Recurso> recursos) {

        // Antes de sortear el recurso que aparecera, debemos normalizar las probabilidades
        double sumProbAparicionRecurso = 0.0;
        for (Recurso recurso : recursos) {
            sumProbAparicionRecurso += recurso.getProbAparicion();
        }

        double probAnteriorRecurso = 0.0;
        ListaSimple<Double> rangoProbAparicion = new ListaSimple<>();
        for (Recurso recurso : recursos) {
            Double probAparicionRecursoActual = probAnteriorRecurso +
                    recurso.getProbAparicion()/sumProbAparicionRecurso;
            rangoProbAparicion.add(probAparicionRecursoActual);
            probAnteriorRecurso = probAparicionRecursoActual;
        }

        // Elegimos un número al azar
        double numAzar = AleatoriedadController.numeroAzar();
        // Se debe elegir el recurso nuevo
        Recurso recursoAparecido = null;
        if(numAzar<=rangoProbAparicion.get(0)) {
            recursoAparecido = recursos.get(0);
        } else if(numAzar>rangoProbAparicion.get(0) && numAzar<=rangoProbAparicion.get(1)) {
            recursoAparecido = recursos.get(1);
        } else if(numAzar>rangoProbAparicion.get(1) && numAzar<=rangoProbAparicion.get(2)) {
            recursoAparecido = recursos.get(2);
        } else if(numAzar>rangoProbAparicion.get(2) && numAzar<=rangoProbAparicion.get(3)) {
            recursoAparecido = recursos.get(3);
        } else if(numAzar>rangoProbAparicion.get(3) && numAzar<=rangoProbAparicion.get(4)) {
            recursoAparecido = recursos.get(4);
        } else {
            recursoAparecido = recursos.get(5);
        }
        return recursoAparecido;
    }
}
