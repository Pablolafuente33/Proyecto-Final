package Tablero;
import EstructurasDeDatos.ListaSimple;
public class Tablero {
    private int filas;
    private int columnas;
    public Tablero (int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
}
