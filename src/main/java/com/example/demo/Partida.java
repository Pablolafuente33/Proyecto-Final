package com.example.demo;

import EstructurasDeDatos.ListaSimple;
import individuo.Individuo;

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
    private ListaSimple<Individuo> listaIndividuos;

    public ListaSimple<Individuo> getListaIndividuos() {
        return listaIndividuos;
    }

    public Partida(int medidaColumnas, int medidaFilas, int medidaAguaVida, double medidaAguaClonacion, double medidaAguaReproduccion, double medidaAguaMuerte, int medidaBibliotecaVida, double medidaBibliotecaClonacion, double medidaBibliotecaReproduccion, double medidaBibliotecaMuerte,
                   int medidaComidaVida, double medidaComidaClonacion, double medidaComidaReproduccion, double medidaComidaMuerte, int medidaMontañaVida, double medidaMontañaClonacion, double medidaMontañaReproduccion, double medidaMontañaMuerte, int medidaPozoVida, double medidaPozoClonacion, double medidaPozoReproduccion, double medidaPozoMuerte,
                   int medidaTesoroVida, double medidaTesoroClonacion, double medidaTesoroReproduccion, double medidaTesoroMuerte, int medidaIndividuoVida, double medidaIndividuoClonacion, double medidaIndividuoReproduccion, double medidaIndividuoMuerte, ListaSimple<Individuo> listaIndividuos) {
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

        this.listaIndividuos = listaIndividuos;
    }

    public int getMedidaColumnas() {
        return medidaColumnas;
    }
    public int getMedidaFilas() {
        return medidaFilas;
    }

    public void setMedidaColumnas(int medidaColumnas) {
        this.medidaColumnas = medidaColumnas;
    }

    public void setMedidaFilas(int medidaFilas) {
        this.medidaFilas = medidaFilas;
    }

    public int getMedidaAguaVida() {
        return medidaAguaVida;
    }

    public void setMedidaAguaVida(int medidaAguaVida) {
        this.medidaAguaVida = medidaAguaVida;
    }

    public double getMedidaAguaClonacion() {
        return medidaAguaClonacion;
    }

    public void setMedidaAguaClonacion(double medidaAguaClonacion) {
        this.medidaAguaClonacion = medidaAguaClonacion;
    }

    public double getMedidaAguaReproduccion() {
        return medidaAguaReproduccion;
    }

    public void setMedidaAguaReproduccion(double medidaAguaReproduccion) {
        this.medidaAguaReproduccion = medidaAguaReproduccion;
    }

    public double getMedidaAguaMuerte() {
        return medidaAguaMuerte;
    }

    public void setMedidaAguaMuerte(double medidaAguaMuerte) {
        this.medidaAguaMuerte = medidaAguaMuerte;
    }

    public int getMedidaBibliotecaVida() {
        return medidaBibliotecaVida;
    }

    public void setMedidaBibliotecaVida(int medidaBibliotecaVida) {
        this.medidaBibliotecaVida = medidaBibliotecaVida;
    }

    public double getMedidaBibliotecaClonacion() {
        return medidaBibliotecaClonacion;
    }

    public void setMedidaBibliotecaClonacion(double medidaBibliotecaClonacion) {
        this.medidaBibliotecaClonacion = medidaBibliotecaClonacion;
    }

    public double getMedidaBibliotecaReproduccion() {
        return medidaBibliotecaReproduccion;
    }

    public void setMedidaBibliotecaReproduccion(double medidaBibliotecaReproduccion) {
        this.medidaBibliotecaReproduccion = medidaBibliotecaReproduccion;
    }

    public double getMedidaBibliotecaMuerte() {
        return medidaBibliotecaMuerte;
    }

    public void setMedidaBibliotecaMuerte(double medidaBibliotecaMuerte) {
        this.medidaBibliotecaMuerte = medidaBibliotecaMuerte;
    }

    public int getMedidaComidaVida() {
        return medidaComidaVida;
    }

    public void setMedidaComidaVida(int medidaComidaVida) {
        this.medidaComidaVida = medidaComidaVida;
    }

    public double getMedidaComidaClonacion() {
        return medidaComidaClonacion;
    }

    public void setMedidaComidaClonacion(double medidaComidaClonacion) {
        this.medidaComidaClonacion = medidaComidaClonacion;
    }

    public double getMedidaComidaReproduccion() {
        return medidaComidaReproduccion;
    }

    public void setMedidaComidaReproduccion(double medidaComidaReproduccion) {
        this.medidaComidaReproduccion = medidaComidaReproduccion;
    }

    public double getMedidaComidaMuerte() {
        return medidaComidaMuerte;
    }

    public void setMedidaComidaMuerte(double medidaComidaMuerte) {
        this.medidaComidaMuerte = medidaComidaMuerte;
    }

    public int getMedidaMontañaVida() {
        return medidaMontañaVida;
    }

    public void setMedidaMontañaVida(int medidaMontañaVida) {
        this.medidaMontañaVida = medidaMontañaVida;
    }

    public double getMedidaMontañaClonacion() {
        return medidaMontañaClonacion;
    }

    public void setMedidaMontañaClonacion(double medidaMontañaClonacion) {
        this.medidaMontañaClonacion = medidaMontañaClonacion;
    }

    public double getMedidaMontañaReproduccion() {
        return medidaMontañaReproduccion;
    }

    public void setMedidaMontañaReproduccion(double medidaMontañaReproduccion) {
        this.medidaMontañaReproduccion = medidaMontañaReproduccion;
    }

    public double getMedidaMontañaMuerte() {
        return medidaMontañaMuerte;
    }

    public void setMedidaMontañaMuerte(double medidaMontañaMuerte) {
        this.medidaMontañaMuerte = medidaMontañaMuerte;
    }

    public int getMedidaTesoroVida() {
        return medidaTesoroVida;
    }

    public void setMedidaTesoroVida(int medidaTesoroVida) {
        this.medidaTesoroVida = medidaTesoroVida;
    }

    public double getMedidaTesoroClonacion() {
        return medidaTesoroClonacion;
    }

    public void setMedidaTesoroClonacion(double medidaTesoroClonacion) {
        this.medidaTesoroClonacion = medidaTesoroClonacion;
    }

    public double getMedidaTesoroReproduccion() {
        return medidaTesoroReproduccion;
    }

    public void setMedidaTesoroReproduccion(double medidaTesoroReproduccion) {
        this.medidaTesoroReproduccion = medidaTesoroReproduccion;
    }

    public double getMedidaTesoroMuerte() {
        return medidaTesoroMuerte;
    }

    public void setMedidaTesoroMuerte(double medidaTesoroMuerte) {
        this.medidaTesoroMuerte = medidaTesoroMuerte;
    }

    public int getMedidaPozoVida() {
        return medidaPozoVida;
    }

    public void setMedidaPozoVida(int medidaPozoVida) {
        this.medidaPozoVida = medidaPozoVida;
    }

    public double getMedidaPozoClonacion() {
        return medidaPozoClonacion;
    }

    public void setMedidaPozoClonacion(double medidaPozoClonacion) {
        this.medidaPozoClonacion = medidaPozoClonacion;
    }

    public double getMedidaPozoReproduccion() {
        return medidaPozoReproduccion;
    }

    public void setMedidaPozoReproduccion(double medidaPozoReproduccion) {
        this.medidaPozoReproduccion = medidaPozoReproduccion;
    }

    public double getMedidaPozoMuerte() {
        return medidaPozoMuerte;
    }

    public void setMedidaPozoMuerte(double medidaPozoMuerte) {
        this.medidaPozoMuerte = medidaPozoMuerte;
    }

    public int getMedidaIndividuoVida() {
        return medidaIndividuoVida;
    }

    public void setMedidaIndividuoVida(int medidaIndividuoVida) {
        this.medidaIndividuoVida = medidaIndividuoVida;
    }

    public double getMedidaIndividuoClonacion() {
        return medidaIndividuoClonacion;
    }

    public void setMedidaIndividuoClonacion(double medidaIndividuoClonacion) {
        this.medidaIndividuoClonacion = medidaIndividuoClonacion;
    }

    public double getMedidaIndividuoReproduccion() {
        return medidaIndividuoReproduccion;
    }

    public void setMedidaIndividuoReproduccion(double medidaIndividuoReproduccion) {
        this.medidaIndividuoReproduccion = medidaIndividuoReproduccion;
    }

    public double getMedidaIndividuoMuerte() {
        return medidaIndividuoMuerte;
    }

    public void setMedidaIndividuoMuerte(double medidaIndividuoMuerte) {
        this.medidaIndividuoMuerte = medidaIndividuoMuerte;
    }
}
