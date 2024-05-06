package Recursos_Juego;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Recurso {
    protected int vidaPropertie;
    protected int reproduccionPropertie;
    protected int muertePropertie;
    protected int clonacionPropertie;
    public Recurso(int vida, int reproduccion, int muerte, int clonacion){
        this.vidaPropertie = vida;
        this.reproduccionPropertie = reproduccion;
        this.muertePropertie  = muerte;
        this.clonacionPropertie = clonacion;
    }

    public int getVidaPropertie() {
        return vidaPropertie;
    }
    public void setVidaPropertie(int vidaPropertie) {
        this.vidaPropertie = vidaPropertie;
    }

    public int getReproduccionPropertie() {
        return reproduccionPropertie;
    }
    public void setReproduccionPropertie(int probabilidadReproduccion) {
        this.reproduccionPropertie  = reproduccionPropertie;
    }

    public int getMuertePropertie() {
        return muertePropertie;
    }
    public void setMuertePropertie(int muertePropertie) {
        this.muertePropertie = muertePropertie;
    }

    public int getClonacionPropertie() {
        return clonacionPropertie;
    }
    public void setClonacionPropertie(int clonacionPropertie) {
        this.clonacionPropertie = clonacionPropertie;
    }

    public abstract void setVida(int vida);

    public abstract int getVida();

    public abstract int getClonacion();

    public abstract void setClonacion(int clonacion);

    public abstract int getReproduccion();

    public abstract void setReproduccion(int reproduccion);

    public abstract int getMuerte();

    public abstract void setMuerte(int muerte);
}
