package EstructurasDeDatos;

public class ListaEnlazada <T>{
    private NodoLE<T> primero;
    public ListaEnlazada(){
        this.primero = null;
    }
    public ListaEnlazada(NodoLE<T> primero){
        this.primero = primero;
    }
    public boolean isVacia(){
        return primero == null;
    }
    public NodoLE<T> getPrimero(){
        return primero;
    }
    public NodoLE<T> getUltimo(){
        NodoLE<T> i = primero;
        while (i != null && i.getSiguiente() != null){
            NodoLE<T> ultimo = i.getSiguiente();
            return ultimo;
        }
        return null;
    }
    public void add (T dato){
        NodoLE<T> nodo = new NodoLE<>(dato);
        if (primero == null){
            this. primero = nodo;
        }else {
            getUltimo().insertarmeEn(nodo);
        }
    }
    public void insert (T dato, int pos){
        NodoLE<T> nodo = new NodoLE<>(dato);
    }
}
