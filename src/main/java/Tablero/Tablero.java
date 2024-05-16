package Tablero;
import EstructurasDeDatos.ListaSimple;
import comun.Posicion;
import individuo.Individuo;
import recurso.Recurso;

public class Tablero {
    private int filas;
    private int columnas;
    private ListaSimple<ListaSimple<Casilla>> casillas;

    private ListaSimple<Individuo> listaTodosIndividuos = new ListaSimple<>();
    private ListaSimple<Individuo> listaVivosIndividuos = new ListaSimple<>();
    private ListaSimple<Individuo> listaMuertosIndividuos = new ListaSimple<>();

    private ListaSimple<Recurso> listaRecursosUnicos = new ListaSimple<>();
    private ListaSimple<Recurso> listaRecursosON = new ListaSimple<>();
    private ListaSimple<Recurso> listaRecursosOFF = new ListaSimple<>();

    private ListaSimple<String> listaOperacionesReproducccion = new ListaSimple<>();
    private ListaSimple<String> listaOperacionesClonacion = new ListaSimple<>();
    private ListaSimple<String> listaOperacionesNacimiento = new ListaSimple<>();
    private ListaSimple<String> listaOperacionesMuerte = new ListaSimple<>();
    private ListaSimple<String> listaOperacionesIteraccionRecurso = new ListaSimple<>();

    public Tablero(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;

        // Creamos el tablero
        ListaSimple<ListaSimple<Casilla>> casillas = new ListaSimple<>(filas);
        for (int i=0; i<filas; ++i) {
            ListaSimple<Casilla> fila = new ListaSimple<>(columnas);
            for (int j=0; j<columnas; ++j) {
                Casilla casilla = new Casilla(new Posicion(i, j), new ListaSimple<>(), new ListaSimple<>());
                fila.add(casilla);
            }
            casillas.add(fila);
        }
        this.casillas = casillas;
        System.out.println("Tablero creado con N=" + filas + " filas y M=" + columnas + " columnas.");

        this.listaTodosIndividuos = new ListaSimple<>();
        this.listaVivosIndividuos = new ListaSimple<>();
        this.listaMuertosIndividuos = new ListaSimple<>();

        this.listaRecursosUnicos = new ListaSimple<>();
        this.listaRecursosON = new ListaSimple<>();
        this.listaRecursosOFF = new ListaSimple<>();

    }

    public int getFilas() {
        return filas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public ListaSimple<ListaSimple<Casilla>> getCasillas() {
        return casillas;
    }
    public void setCasillas(ListaSimple<ListaSimple<Casilla>> casillas) {
        this.casillas = casillas;
    }

    public Casilla getCasillaFilaColumna(int fila, int columna) {
        return casillas.get(fila).get(columna);
    }
    public void setCasillaFilaColumna(int fila, int columna, Casilla casilla) {
        ListaSimple<Casilla> filaModificada = casillas.get(fila);
        filaModificada.set(columna, casilla);
        casillas.set(fila, filaModificada);
        setCasillas(casillas);
    }

    public ListaSimple<Individuo> getListaTodosIndividuos() {
        return listaTodosIndividuos;
    }
    public void setListaTodosIndividuos(ListaSimple<Individuo> individuos) {
        this.listaTodosIndividuos = individuos;
    }

    public ListaSimple<Individuo> getListaVivosIndividuos() {
        return listaVivosIndividuos;
    }
    public void setListaVivosIndividuos(ListaSimple<Individuo> listaVivosIndividuos) {
        this.listaVivosIndividuos = listaVivosIndividuos;
    }

    public ListaSimple<Individuo> getListaMuertosIndividuos() {
        return listaMuertosIndividuos;
    }
    public void setListaMuertosIndividuos(ListaSimple<Individuo> individuos) {
        this.listaMuertosIndividuos = individuos;
    }

    public ListaSimple<Recurso> getListaRecursosUnicos() {
        return listaRecursosUnicos;
    }
    public void setListaRecursosUnicos(ListaSimple<Recurso> listaRecursosUnicos) {
        this.listaRecursosUnicos = listaRecursosUnicos;
    }

    public ListaSimple<Recurso> getListaRecursosON() {
        return listaRecursosON;
    }
    public void setListaRecursosON(ListaSimple<Recurso> listaRecursosON) {
        this.listaRecursosON = listaRecursosON;
    }

    public ListaSimple<Recurso> getListaRecursosOFF() {
        return listaRecursosOFF;
    }
    public void setListaRecursosOFF(ListaSimple<Recurso> listaRecursosOFF) {
        this.listaRecursosOFF = listaRecursosOFF;
    }

    public ListaSimple<String> getListaOperacionesReproducccion() {
        return listaOperacionesReproducccion;
    }
    public void setListaOperacionesReproducccion(ListaSimple<String> listaOperacionesReproducccion) {
        this.listaOperacionesReproducccion = listaOperacionesReproducccion;
    }

    public ListaSimple<String> getListaOperacionesClonacion() {
        return listaOperacionesClonacion;
    }
    public void setListaOperacionesClonacion(ListaSimple<String> listaOperacionesClonacion) {
        this.listaOperacionesClonacion = listaOperacionesClonacion;
    }

    public ListaSimple<String> getListaOperacionesNacimiento() {
        return listaOperacionesNacimiento;
    }
    public void setListaOperacionesNacimiento(ListaSimple<String> listaOperacionesNacimiento) {
        this.listaOperacionesNacimiento = listaOperacionesNacimiento;
    }
    public ListaSimple<String> getListaOperacionesIteraccionRecurso() {
        return listaOperacionesIteraccionRecurso;
    }
    public void setListaOperacionesIteraccionRecurso(ListaSimple<String> listaOperacionesIteraccionRecurso) {
        this.listaOperacionesIteraccionRecurso = listaOperacionesIteraccionRecurso;
    }

    public ListaSimple<String> getListaOperacionesMuerte() {
        return listaOperacionesMuerte;
    }
    public void setListaOperacionesMuerte(ListaSimple<String> listaOperacionesMuerte) {
        this.listaOperacionesMuerte = listaOperacionesMuerte;
    }
}