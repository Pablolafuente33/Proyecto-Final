package EstructurasDeDatos;

public class HashMap <K , V>{
    private int max = 100;
    private NodoHM<K, V>[] tabla;
    public HashMap(){
        tabla = new NodoHM[max];
    }
    public void put (K clave, V value){
        int indice = hash(clave);
        NodoHM<K, V> newNodo = new NodoHM<>(clave, value);
        if (tabla[indice] == null){
            tabla[indice] = newNodo;
        } else {
            NodoHM<K,V> actual = tabla[indice];
            NodoHM<K,V> anterior = null;
            while (actual != null){
                if (actual.clave.equals(clave)){
                    actual.value = value; // Remplazamos el valor si la clave ya existe
                    return;
                }
                anterior = actual;
                actual = actual.siguiente;
            }
                    anterior.siguiente = newNodo; //Añadimos al final de la lista
        }
    }
    private int hash(K key) {
        return Math.abs(key.hashCode()) % max;
    }
    public V get(K clave){
        int indice = hash(clave);
        NodoHM<K,V> actual = tabla[indice];
        while (actual != null){
            if (actual.clave.equals(clave)){
                return actual.value;
            }
            actual = actual.siguiente;
        }
        return null; // Retornar null si la clave no existe
    }
    public void remove(K clave){
        int index = hash(clave);
        NodoHM<K, V> actual = tabla[index];
        NodoHM<K,V> anterior = null;
        while ( actual != null){
            if (actual.clave.equals(clave)){
                if (anterior == null){
                    tabla [index] = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }
}
