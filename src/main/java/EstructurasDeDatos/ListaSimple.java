package EstructurasDeDatos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaSimple<T> implements Iterable<T>{
    private NodoLS[] elemento;
    private int max = 100;

    public ListaSimple(int max) {
        this.max = max;
        this.elemento = new NodoLS[max];
    }

    public ListaSimple(){
        this.elemento = new NodoLS[max];
    }


    public NodoLS[] getElemento() {
        return elemento;
    }
    public void setElemento(NodoLS[] elemento) {
        this.elemento = elemento;
    }

    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public boolean isVacia(){
        return elemento[0] == null;
    }
    public void vaciar(){
        int i = 0;
        while (elemento[i] != null){
            elemento[i] = null;
            i++;
        }
    }
    public T get(int index) {
        if (index < 0 || index >= getNumeroElementos()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites de la lista");
        }
        return (T) elemento[index].getObject();
    }
    public void set(int index, T value) {
        if (index < 0 || index >= getNumeroElementos()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites de la lista");
        }
        elemento[index] = new NodoLS<>(value);
    }
    public void add(T o){
        int i = 0;
        if (getNumeroElementos() == max){
            max += 50;
        }
        while (i < max && elemento[i] != null){
            i++;
        }
        elemento[i] = new NodoLS<>(o);
    }
    public NodoLS<T> getSiguiente(NodoLS<T> el){
        NodoLS<T> elDevuelto = null;
        for (int i = 0; i < max - 1; i++){
            if (elemento[i] != null && elemento[i+1] != null && elemento[i].getObject() == el.getObject()){
                elDevuelto = elemento[i+1];
            };
        }
        return elDevuelto;
    }
    public int getNumeroElementos(){
        if(elemento[0] == null){
            return 0;
        }else {
            int i = 1;
            NodoLS<T> el = elemento[i - 1];
            while (this.getSiguiente(el) != null){
                el = this.getSiguiente(el);
                i ++;
            }
            return i;
        }
    }
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = 0;
            @Override
            public boolean hasNext() {
                return pos < getNumeroElementos();
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return (T) elemento[pos ++].getObject();
            }
        };
    }
    public boolean remove(T o) {
        boolean removed = false;
        for (int i = 0; i < max; i++) {
            if (elemento[i] != null && elemento[i].getObject().equals(o)) {
                elemento[i] = null;
                removed = true;
                break;
            }
        }
        if (removed) {
            for (int i = 0; i < max - 1; i++) {
                if (elemento[i] == null) {
                    elemento[i] = elemento[i + 1];
                    elemento[i + 1] = null;
                }
            }
        }
        return removed;
    }
    public ListaSimple<T> reverse() {
        int numElementos = getNumeroElementos();
        ListaSimple<T> listaReversa = new ListaSimple<>();
        for (int i = numElementos - 1; i >= 0; i--) {
            listaReversa.add((T) elemento[i].getObject());
        }
        return listaReversa;
    }
    public NodoLS<T> getFirst() {
        if (elemento[0] != null) {
            return elemento[0];
        } else {
            return null;
        }
    }
    public NodoLS<T> getLast() {
        int numElementos = getNumeroElementos();
        if (numElementos > 0) {
            return elemento[numElementos - 1];
        } else {
            return null;
        }
    }
    public boolean contains(T dato) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(dato)) {
                return true;
            }
        }
        return false;
    }
    public void addAll(ListaSimple<T> otraLista) {
        Iterator<T> iterator = otraLista.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
    }
    public static <T> ListaSimple<T> of(T... elementos) {
        ListaSimple<T> lista = new ListaSimple<>();
        for (T elemento : elementos) {
            lista.add(elemento);
        }
        return lista;
    }
    public int indexOf(T o) {
        for (int i = 0; i < getNumeroElementos(); i++) {
            if (elemento[i] != null && elemento[i].getObject().equals(o)) {
                return i;
            }
        }
        return -1;
    }
}
