package EstructurasDeDatos;

public class Arco <T> {
    protected Vertice<T> origen;
    protected Vertice<T> destino;
    double coste;

    public Arco(Vertice<T> origen, Vertice<T> destino, double coste) {
        this.origen = origen;
        this.destino = destino;
        this.coste = coste;
    }

    public Arco() {
    }

    public Vertice<T> getOrigen() {
        return origen;
    }

    public void setOrigen(Vertice<T> origen) {
        this.origen = origen;
    }

    public Vertice<T> getDestino() {
        return destino;
    }

    public void setDestino(Vertice<T> destino) {
        this.destino = destino;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }
}
