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
        if (primero == null) {
            return null;
        }
        NodoLE<T> i = primero;
        while (i.getSiguiente() != null){
            NodoLE<T> ultimo = i.getSiguiente();
        }
        return i;
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
        if (pos == 0){
            nodo.insertarmeEn(primero);
            primero = nodo;
        } else{
            int i = 0;
            NodoLE <T> anterior = null;
            NodoLE <T> actual = primero;
            while (actual != null && i < pos){
               anterior = actual;
               actual = actual.getSiguiente();
               i++;
            }
            if (i == pos){
                anterior.insertarmeEn(nodo);
                nodo.insertarmeEn(actual);
            }else {
                throw new IndexOutOfBoundsException("Posicion fuera de rango");
            }
        }
    }
}
