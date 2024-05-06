package EstructurasDeDatos;

public class NodoLS<T> {
    private T object;
    public NodoLS(T object){
        this.object = object;
    }

    public T getObject() {
        return object;
    }
    public void setObject(T object) {
        this.object = object;
    }
}
