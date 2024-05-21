package individuo;


import EstructurasDeDatos.ListaSimple;
import comun.Posicion;



public class Individuo {
    private String id;
    private int turnoGeneracion;
    private int turnosVida;
    private int maxTurnosVida;
    private int turnoMuerte;
    private double probabilidadReproduccion;
    private double probabilidadClonacion;
    private double probabilidadMuerte;
    private String tipo;
    private ListaSimple<String> operaciones;
    private Posicion fijadoRecursoPosicion;
    private Posicion posicion; // el control de las posiciones la lleva el objeto tablero, este atributo sólo es auxiliar


    public Individuo(String id, int turnoGeneracion, int turnosVida, double probabilidadReproduccion, double probabilidadClonacion,
                     String tipo) {
        this.id = id;
        this.turnoGeneracion = turnoGeneracion;
        this.turnosVida = turnosVida;
        this.maxTurnosVida = turnosVida;
        this.turnoMuerte = turnoGeneracion + turnosVida; // este sería el turno de muerte natural
        this.probabilidadReproduccion = probabilidadReproduccion;
        this.probabilidadMuerte = 1 - probabilidadReproduccion;
        this.probabilidadClonacion = probabilidadClonacion;
        this.tipo = tipo;
        this.operaciones = new ListaSimple<>();
        this.fijadoRecursoPosicion = null;
        this.posicion = null;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getTurnoGeneracion() {
        return turnoGeneracion;
    }
    public void setTurnoGeneracion(int turnoGeneracion) {
        this.turnoGeneracion = turnoGeneracion;
    }

    public int getTurnoMuerte() {
        return turnoMuerte;
    }
    public void setTurnoMuerte(int turnoMuerte) {
        this.turnoMuerte = turnoMuerte;
    }

    public int getTurnosVida() {
        return turnosVida;
    }
    public void setTurnosVida(int turnosVida) {
        this.turnosVida = turnosVida;
    }

    public double getProbabilidadReproduccion() {
        return probabilidadReproduccion;
    }
    public void setProbabilidadReproduccion(double probabilidadReproduccion) {
        this.probabilidadReproduccion = probabilidadReproduccion;
    }

    public double getProbabilidadMuerte(){
        return probabilidadMuerte;
    }
    public void setProbabilidadMuerte(double probabilidadReproduccion){
        this.probabilidadMuerte = probabilidadReproduccion;
    }

    public double getProbabilidadClonacion(){
        return probabilidadClonacion;
    }
    public void setProbabilidadClonacion(double probabilidadClonacion) {
        this.probabilidadClonacion = probabilidadClonacion;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ListaSimple<String> getOperaciones() {
        return operaciones;
    }
    public void setOperaciones(ListaSimple<String> operaciones) {
        this.operaciones = operaciones;
    }

    public Posicion getFijadoRecursoPosicion() {
        return fijadoRecursoPosicion;
    }
    public void setFijadoRecursoPosicion(Posicion fijadoRecursoPosicion) {
        this.fijadoRecursoPosicion = fijadoRecursoPosicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }
    public void setPosicion(Posicion pos) {
        this.posicion = pos;
    }

    public int getMaxTurnosVida() {
        return maxTurnosVida;
    }
    public void setMaxTurnosVida(int maxTurnosVida) {
        this.maxTurnosVida = maxTurnosVida;
    }

    /**
     public void pintar(GraphicsContext graficos){
     ;
     }*/
}