package com.example.demo;

public class Movimiento {
    private float y;
    private float x;
    public Movimiento(float X, float Y){
        this.x = X;
        this.y = Y;
    }

    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float[] getXY(){
        float [] XY = new float [2];
        XY[0] = x;
        XY[1] = y;
        return XY;
    }
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
        float[] XY = new float [2];
        XY[0] = x;
        XY[1] = y;
    }
    public void movimientoBasico(){

    }
    public void movimientoNormal(){

    }
    public void movimientoAvanzado(){}
}
