package com.example.demo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;

public class ParameterDataModelProperties {
    protected Individuo individuoOriginal;
    protected IntegerProperty vida;
    protected IntegerProperty probabilidadReproduccion;
    protected IntegerProperty probabilidadClonacion;
    protected StringProperty nombre;
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
    }

    public void setVida(int vida) {
        this.vida.set(vida);
    }
    public void setProbabilidadReproduccion(int probabilidadReproduccion) {
        this.probabilidadReproduccion.set(probabilidadReproduccion);
    }

    public void setProbabilidadClonacion(int probabilidadClonacion) {
        this.probabilidadClonacion.set(probabilidadClonacion);
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    public Property<Number> vidaProperty(){return vida;}
    public Property<Number> probabilidadReproduccionProperty(){return probabilidadReproduccion;}
    public Property<Number> probabilidadClonacionProperty(){return probabilidadClonacion;}
    public Property<String> nombreProperty(){return nombre;}
}
