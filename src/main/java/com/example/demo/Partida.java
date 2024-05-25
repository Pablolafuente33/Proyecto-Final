package com.example.demo;

public class Partida {
    //Tablero
    private int medidaColumnas;
    private int medidaFilas;
    //Agua
    private int medidaAguaVida;
    private double medidaAguaClonacion;
    private double medidaAguaReproduccion;
    private double medidaAguaMuerte;
    //Biblioteca
    private int medidaBibliotecaVida;
    private double medidaBibliotecaClonacion;
    private double medidaBibliotecaReproduccion;
    private double medidaBibliotecaMuerte;

    //Comida
    private int medidaComidaVida;
    private double medidaComidaClonacion;
    private double medidaComidaReproduccion;
    private double medidaComidaMuerte;
    //Montaña
    private int medidaMontañaVida;
    private double medidaMontañaClonacion;
    private double medidaMontañaReproduccion;
    private double medidaMontañaMuerte;
    //Tesoro
    private int medidaTesoroVida;
    private double medidaTesoroClonacion;
    private double medidaTesoroReproduccion;
    private double medidaTesoroMuerte;
    //Pozo
    private int medidaPozoVida;
    private double medidaPozoClonacion;
    private double medidaPozoReproduccion;
    private double medidaPozoMuerte;
    //Individuo
    private int medidaIndividuoVida;
    private double medidaIndividuoClonacion;
    private double medidaIndividuoReproduccion;
    private double medidaIndividuoMuerte;

    public Partida(int medidaColumnas, int medidaFilas, int medidaAguaVida, double medidaAguaClonacion, double medidaAguaReproduccion, double medidaAguaMuerte,int medidaBibliotecaVida, double medidaBibliotecaClonacion, double medidaBibliotecaReproduccion, double medidaBibliotecaMuerte,
                   int medidaComidaVida, double medidaComidaClonacion, double medidaComidaReproduccion, double medidaComidaMuerte, int medidaMontañaVida, double medidaMontañaClonacion, double medidaMontañaReproduccion, double medidaMontañaMuerte, int medidaPozoVida, double medidaPozoClonacion, double medidaPozoReproduccion, double medidaPozoMuerte,
                   int medidaTesoroVida, double medidaTesoroClonacion, double medidaTesoroReproduccion, double medidaTesoroMuerte, int medidaIndividuoVida, double medidaIndividuoClonacion, double medidaIndividuoReproduccion, double medidaIndividuoMuerte) {
        this.medidaColumnas = medidaColumnas;
        this.medidaFilas = medidaFilas;
        this.medidaAguaVida = medidaAguaVida;
        this.medidaAguaClonacion = medidaAguaClonacion;
        this.medidaAguaReproduccion = medidaAguaReproduccion;
        this.medidaAguaMuerte = medidaAguaMuerte;

        this.medidaBibliotecaVida = medidaBibliotecaVida;
        this.medidaBibliotecaClonacion = medidaBibliotecaClonacion;
        this.medidaBibliotecaReproduccion = medidaBibliotecaReproduccion;
        this.medidaBibliotecaMuerte = medidaBibliotecaMuerte;

        this.medidaComidaVida = medidaComidaVida;
        this.medidaComidaClonacion = medidaComidaClonacion;
        this.medidaComidaReproduccion = medidaComidaReproduccion;
        this.medidaComidaMuerte = medidaComidaMuerte;

        this.medidaMontañaVida = medidaMontañaVida;
        this.medidaMontañaClonacion = medidaMontañaClonacion;
        this.medidaMontañaReproduccion = medidaMontañaReproduccion;
        this.medidaMontañaMuerte = medidaMontañaMuerte;

        this.medidaPozoVida = medidaPozoVida;
        this.medidaPozoClonacion = medidaPozoClonacion;
        this.medidaPozoReproduccion = medidaPozoReproduccion;
        this.medidaPozoMuerte = medidaPozoMuerte;

        this.medidaTesoroVida = medidaTesoroVida;
        this.medidaTesoroClonacion = medidaTesoroClonacion;
        this.medidaTesoroReproduccion = medidaTesoroReproduccion;
        this.medidaTesoroMuerte = medidaTesoroMuerte;

        this.medidaIndividuoVida = medidaIndividuoVida;
        this.medidaIndividuoClonacion = medidaIndividuoClonacion;
        this.medidaIndividuoReproduccion = medidaIndividuoReproduccion;
        this.medidaIndividuoMuerte = medidaIndividuoMuerte;
    }

    public int getMedidaColumnas() {
        return medidaColumnas;
    }
    public int getMedidaFilas() {
        return medidaFilas;
    }
}
