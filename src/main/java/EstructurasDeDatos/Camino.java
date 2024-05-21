package EstructurasDeDatos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Camino <T> {
    ListaSimple<Vertice<T>> camino;
    double coste;

    public Camino(ListaSimple<Vertice<T>> camino, double coste) {
        this.camino = camino;
        this.coste = coste;
    }

    public void setCamino(ListaSimple<Vertice<T>> camino) {
        this.camino = camino;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public ListaSimple<Vertice<T>> getCamino() {
        return this.camino;
    }

    public double getCoste() {
        return this.coste;
    }

    public String toString() {
        StringBuffer salida = new StringBuffer();
        String var1 = String.valueOf(this.getCamino().getFirst().getObject());
        String var2 = String.valueOf(this.getCamino().getLast().getObject());
        salida.append("======= Volcado del camino desde [" + var1 + "] hasta [" + var2 + "]: ======\n");
        salida.append("Referencias a los vértices: " + String.valueOf(this.getCamino()) + "\n");
        salida.append("Lista de datos en vértices: [");
        Iterator var3 = this.getCamino().iterator();

        while (var3.hasNext()) {
            Vertice<T> vertexx = (Vertice) var3.next();
            salida.append(vertexx.data);
        }

        salida.append("] - Coste: " + this.getCoste() + "\n");
        return salida.toString();
    }

}