package EstructurasDeDatos;

public class Vertice <T> {
    T data;
    ListaSimple<Arco<T>> arcosEntrada;
    ListaSimple<Arco<T>> arcosSalida;

    public Vertice(T data) {
        this.data = data;
        this.arcosEntrada = new ListaSimple<>();
        this.arcosSalida = new ListaSimple<>();
    }

    public Vertice() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListaSimple<Arco<T>> getArcosEntrada() {
        return arcosEntrada;
    }

    public ListaSimple<Arco<T>> getArcosSalida() {
        return arcosSalida;
    }

    public void setArcosEntrada(ListaSimple<Arco<T>> arcosEntrada) {
        this.arcosEntrada = arcosEntrada;
    }

    public void setArcosSalida(ListaSimple<Arco<T>> arcosSalida) {
        this.arcosSalida = arcosSalida;
    }

    public void addOutEdge(Arco<T> arco) {
        this.arcosSalida.add(arco);
    }

    public void addInEdge(Arco<T> arco) {
        this.arcosEntrada.add(arco);
    }
}
