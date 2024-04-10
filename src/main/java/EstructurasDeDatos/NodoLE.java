package EstructurasDeDatos;

public class NodoLE<T> {
    private T dato;
    private NodoLE siguiente;
    public NodoLE(T dato){
        this.dato = dato;
        this.siguiente = null;
    }
    public NodoLE<T> getSiguiente() {
        return siguiente;
    }
    public void insertarmeEn(NodoLE<T> siguiente) {
        this.siguiente = siguiente;
    }
    public Object getDato() {
        return dato;
    }
    public void setDato(T dato) {
        this.dato = dato;
    }
}
