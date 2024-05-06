package EstructurasDeDatos;

public class Pila <T> {
    private NodoLE<T> cima;
    public Pila (){
        this.cima = null;
    }
    public Pila (NodoLE <T> nodo){
        this.cima = nodo;
    }
    public boolean isVacia(){
        return cima == null;
    }
    public void push(T dato){
        NodoLE<T> nodo = new NodoLE<>(dato);
        if (cima != null){
            nodo.setSiguiente(cima);
        }
        cima = nodo;
    }
    public T pop(){
            if(isVacia()){
                throw new RuntimeException("La pila está vacia");
            }
            T datoCima = (T) cima.getDato();
            cima = cima.getSiguiente();
        return datoCima;
    }
    public void vaciar(){
        while (!isVacia()){
            pop();
        }
    }
}
