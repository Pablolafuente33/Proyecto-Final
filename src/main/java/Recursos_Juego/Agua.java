package Recursos_Juego;

public class Agua extends Recurso {
    private int vida;
    private int clonacion;
    private int reproduccion;
    private int muerte;

    public Agua (int vida, int clonacion,int muerte,  int reproduccion){
        super(vida, clonacion, muerte, reproduccion);
        this.vida = vida;
        this.clonacion = clonacion;
        this.reproduccion = reproduccion;
        this.muerte = 100 - reproduccion;

        //Establecemos las propiedades de la clase base (Recurso)
        setVidaPropertie(vida);
        setReproduccionPropertie(reproduccion);
        setMuertePropertie(100 - reproduccion);
        setClonacionPropertie(clonacion);
    }
    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }
    @Override
    public int getVida() {
        return vida;
    }
    @Override
    public int getClonacion() {
        return clonacion;
    }
    @Override
    public void setClonacion(int clonacion) {
        this.clonacion = clonacion;
    }
    @Override
    public int getReproduccion() {
        return reproduccion;
    }
    @Override
    public void setReproduccion(int reproduccion) {
        this.reproduccion = reproduccion;
    }
    @Override
    public int getMuerte() {
        return muerte;
    }
    @Override
    public void setMuerte(int muerte) {
        this.muerte = muerte;
    }
}
