package Tablero;

import EstructurasDeDatos.ListaSimple;
import comun.Posicion;
import individuo.Individuo;
import recurso.Recurso;


public class Casilla {
    private ListaSimple<Individuo> listaIndividuos;
    private ListaSimple<Recurso> listaRecursos;
    private Posicion posicion;


    public Casilla(Posicion posicion, ListaSimple<Individuo> listaIndividuos, ListaSimple<Recurso> listaRecursos){
        this.posicion = posicion;
        this.listaIndividuos = listaIndividuos;
        this.listaRecursos = listaRecursos;
    }

    public Casilla(){
        this.listaIndividuos = new ListaSimple<>(); // lista vacia
        this.listaRecursos = new ListaSimple<>(); // lista vacia
    }

    public Posicion getPosicion() {
        return posicion;
    }
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public ListaSimple<Individuo> getListaIndividuos() {
        return listaIndividuos;
    }
    public void setListaIndividuos(ListaSimple<Individuo> listaIndividuos) {
        this.listaIndividuos = listaIndividuos;
    }

    public ListaSimple<Recurso> getListaRecursos() {
        return listaRecursos;
    }
    public void setListaRecursos(ListaSimple<Recurso> listaRecursos) {
        this.listaRecursos = listaRecursos;
    }
}
