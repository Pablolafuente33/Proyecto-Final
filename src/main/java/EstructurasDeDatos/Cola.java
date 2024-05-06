package EstructurasDeDatos;

import Exceptions.ColaVaciaException;

public class Cola<T> {
    private NodoLE<T> raiz;
    private NodoLE<T> fondo;

    public Cola() {
        this.raiz = null;
        this.fondo = null;
    }

    public boolean isVacia() {
        return raiz == null;
    }

    public void insertar(T dato) {
        NodoLE<T> nuevoNodo = new NodoLE<>(dato);
        if (isVacia()) {
            raiz = nuevoNodo;
            fondo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(raiz);
            raiz = nuevoNodo;
        }
    }

    public T extraer() {
        if (raiz == fondo) {
            raiz = null;
            fondo = null;
        } else {
            fondo = fondo.getSiguiente();
        }
        return (T) fondo.getDato();
    }
}
