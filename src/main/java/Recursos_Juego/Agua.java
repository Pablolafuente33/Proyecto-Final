package Recursos_Juego;

public class Agua {
    protected int turnosDeVida;
    protected int clonacion;
    protected int reproduccion;
    protected int muerte;
    public Agua (int turnosDeVida, int clonacion, int reproduccion){
        this.turnosDeVida = turnosDeVida;
        this.clonacion = clonacion;
        this.reproduccion = reproduccion;
        this.muerte = 100 - reproduccion;
    }

    public void setTurnosDeVida(int turnosDeVida) {
        this.turnosDeVida = turnosDeVida;
    }
    public int getTurnosDeVida() {
        return turnosDeVida;
    }

    public int getClonacion() {
        return clonacion;
    }
    public void setClonacion(int clonacion) {
        this.clonacion = clonacion;
    }

    public int getReproduccion() {
        return reproduccion;
    }
    public void setReproduccion(int reproduccion) {
        this.reproduccion = reproduccion;
    }

    public int getMuerte() {
        return muerte;
    }
    public void setMuerte(int muerte) {
        this.muerte = muerte;
    }
}
