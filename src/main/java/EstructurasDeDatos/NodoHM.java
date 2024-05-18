package EstructurasDeDatos;

public class NodoHM<K, V> {
     K clave;
     V value;
     NodoHM<K, V> siguiente;
    public NodoHM(K clave, V value){
        this.clave = clave;
        this.value = value;
        this.siguiente = null;
    }
}
