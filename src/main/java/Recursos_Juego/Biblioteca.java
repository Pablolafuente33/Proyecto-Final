package Recursos_Juego;

public class Biblioteca extends Recurso {
    private int vida;
    private int clonacion;
    private int reproduccion;
    private int muerte;
    public Biblioteca(int vida, int reproduccion, int muerte, int clonacion){
        super(vida, reproduccion,muerte,clonacion);
        this.vida = vida;
        this.clonacion = clonacion;
        this.reproduccion = reproduccion;
        this.muerte = 100 - muerte;

        setVidaPropertie(vida);
        setReproduccionPropertie(reproduccion);
        setMuertePropertie(muerte);
        setClonacionPropertie(clonacion);
    }

    @Override
    public int getVida() {
        return vida;
    }
    @Override
    public void setVida(int vida) {
        this.vida = vida;
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
