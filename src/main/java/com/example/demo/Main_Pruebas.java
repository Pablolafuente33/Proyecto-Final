package com.example.demo;

import EstructurasDeDatos.ListaEnlazada;
import EstructurasDeDatos.Pila;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

public class Main_Pruebas {
    public void cicloJuego(){
        long tiempoInicial = System.nanoTime();
        AnimationTimer animationTimer = new AnimationTimer() {
            //Se ejecuta aproximadamente 60 veces por segundo (60 FPS)
            @Override
            public void handle(long tiempoActual) {
                double  tiempo = (tiempoActual - tiempoInicial)/1000000000;
                System.out.println(tiempo);
                actualizarEstado();
                pintar();
            }
        };
        animationTimer.start();//En esta linea comienza el ciclo de juego
    }
    public void actualizarEstado(){

    }
}

