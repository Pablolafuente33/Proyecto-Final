package com.example.demo;

import javafx.beans.property.*;

public class ParameterDataModelProperties {
    protected Individuo individuoOriginal;
    protected IntegerProperty vida = new SimpleIntegerProperty();
    protected IntegerProperty probabilidadReproduccion = new SimpleIntegerProperty();
    protected IntegerProperty probabilidadMuerte = new SimpleIntegerProperty();
    protected IntegerProperty probabilidadClonacion = new SimpleIntegerProperty();
    protected StringProperty nombre = new SimpleStringProperty();
    public ParameterDataModelProperties (Individuo individuoOriginal){
        setIndividuoOriginal(individuoOriginal);
    }
    public void setIndividuoOriginal(Individuo IndividuoOriginal) {
        this.individuoOriginal = individuoOriginal;
    }
    public void commit(){
        individuoOriginal.setVida(vida.get());
        individuoOriginal.setProbabilidadClonacion(probabilidadClonacion.get());
        individuoOriginal.setProbabilidadReproduccion(probabilidadReproduccion.get());
        individuoOriginal.setProbabilidadMuerte(probabilidadReproduccion.get());
    }
    public void rollback (){
        vida.set(individuoOriginal.getVida());
        probabilidadReproduccion.set(individuoOriginal.getProbabilidadReproduccion());
        probabilidadClonacion.set(individuoOriginal.getProbabilidadClonacion());
        probabilidadMuerte.set(individuoOriginal.getProbabilidadMuerte());
    }
    public void setVida(int vida) {
        this.vida.set(vida);
    }
    public void setProbabilidadReproduccion(int probabilidadReproduccion) {
        this.probabilidadReproduccion.set(probabilidadReproduccion);
    }
    public void setProbabilidadMuerte(int probabilidadReproduccion){
        this.probabilidadMuerte.set(probabilidadReproduccion);
    }

    public void setProbabilidadClonacion(int probabilidadClonacion) {
        this.probabilidadClonacion.set(probabilidadClonacion);
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    public Property<Number> vidaProperty(){return vida;}
    public Property<Number> probabilidadReproduccionProperty(){return probabilidadReproduccion;}
    public Property<Number> probabilidadMuerteProperty(){return probabilidadMuerte;}
    public Property<Number> probabilidadClonacionProperty(){return probabilidadClonacion;}
    public Property<String> nombreProperty(){return nombre;}

}
