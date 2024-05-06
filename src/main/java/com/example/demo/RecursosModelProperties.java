package com.example.demo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import Recursos_Juego.*;

public class RecursosModelProperties {
    protected Recurso  recursoOriginal;
    protected IntegerProperty vida = new SimpleIntegerProperty();
    protected IntegerProperty probabilidadReproduccion = new SimpleIntegerProperty();
    protected IntegerProperty probabilidadMuerte = new SimpleIntegerProperty();
    protected IntegerProperty probabilidadClonacion = new SimpleIntegerProperty();

    public RecursosModelProperties(Recurso recursoOriginal){
        setRecursoOriginal(recursoOriginal);
    }
    public void setRecursoOriginal(Recurso recursoOriginal){
        this.recursoOriginal = recursoOriginal;
    }
    public void commit(){
        recursoOriginal.setVida(vida.get());
        recursoOriginal.setClonacion(probabilidadClonacion.get());
        recursoOriginal.setReproduccion(probabilidadReproduccion.get());
        recursoOriginal.setMuerte(probabilidadReproduccion.get());
    }
    public void rollback (){
        vida.set(recursoOriginal.getVida());
        probabilidadClonacion.set(recursoOriginal.getClonacion());
        probabilidadReproduccion.set(recursoOriginal.getReproduccion());
        probabilidadMuerte.set(recursoOriginal.getMuerte());
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

    public Property<Number> vidaRecursoProperty(){return vida;}
    public Property<Number> probabilidadRecursoReproduccionProperty(){return probabilidadReproduccion;}
    public Property<Number> probabilidadRecursoMuerteProperty(){return probabilidadMuerte;}
    public Property<Number> probabilidadRecursoClonacionProperty(){return probabilidadClonacion;}
}
