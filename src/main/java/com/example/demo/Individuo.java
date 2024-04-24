package com.example.demo;

public class Individuo {
    private int id;
    private int generacion;
    private int Vida;
    private int probabilidadReproduccion;
    private int probabilidadClonacion;
    private int probabilidadMuerte = 100 - probabilidadReproduccion;
    private String tipo;

    public Individuo(int id, int generacion, int turnosVida, int probabilidadReproduccion, int probabilidadClonacion, String tipo) {
        this.id = id;
        this.generacion = generacion;
        this.Vida = turnosVida;
        this.probabilidadReproduccion = probabilidadReproduccion;
        this.probabilidadMuerte = 100 - probabilidadReproduccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int turnosVida) {
        this.Vida = turnosVida;
    }

    public int getProbabilidadReproduccion() {
        return probabilidadReproduccion;
    }

    public void setProbabilidadReproduccion(int probabilidadReproduccion) {
        this.probabilidadReproduccion = probabilidadReproduccion;
    }
    public int getProbabilidadMuerte(){
        return 100 - probabilidadMuerte;
    }
    public void setProbabilidadMuerte(int probabilidadReproduccion){
        this.probabilidadMuerte = 100 - probabilidadReproduccion;
    }
    public int getProbabilidadClonacion() {
        return probabilidadClonacion;
    }

    public void setProbabilidadClonacion(int probabilidadClonacion) {
        this.probabilidadClonacion = probabilidadClonacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

