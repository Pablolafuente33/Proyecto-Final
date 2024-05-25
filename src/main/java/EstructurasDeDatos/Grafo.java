package EstructurasDeDatos;

import recurso.Recurso;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Grafo <T> {
    ListaSimple<Vertice<T>> vertices = new ListaSimple<>();
    ListaSimple<Arco<T>> arcos = new ListaSimple<>();

    public Grafo(ListaSimple<Vertice<T>> vertices, ListaSimple<Arco<T>> arcos) {
        this.vertices = vertices;
        this.arcos = arcos;
    }

    public Grafo() {
    }

    public ListaSimple<Vertice<T>> getVertices() {
        return vertices;
    }

    public void setVertices(ListaSimple<Vertice<T>> vertices) {
        this.vertices = vertices;
    }

    public ListaSimple<Arco<T>> getArcos() {
        return arcos;
    }

    public void setArcos(ListaSimple<Arco<T>> arcos) {
        this.arcos = arcos;
    }

    public void addVertex(Vertice<T> vertice) {
        this.vertices.add(vertice);
    }

    public void removeVertex(Vertice<T> vertice) {
        this.vertices.remove(vertice);
    }

    public void addEdge(Arco<T> arco) {
        this.arcos.add(arco);
        arco.origen.addOutEdge(arco);
        arco.destino.addInEdge(arco);
    }

    public void removeEdge(Arco<T> arco) {
        this.arcos.remove(arco);
    }

    public Map<Vertice<T>, Camino<T>> dijkstra(Vertice<T> origen) {
        Map<Vertice<T>, Double> distancias = new java.util.HashMap();
        Cola<Vertice<T>> colaPendientes = new Cola();
        Map<Vertice<T>, Vertice<T>> verticesAnteriores = new java.util.HashMap();
        this.dijkstra_init(origen, distancias, colaPendientes, verticesAnteriores);
        this.dijkstra_calcula(distancias, colaPendientes, verticesAnteriores);
        return this.dijkstra_procesaResultados(distancias, verticesAnteriores);
    }

    protected void dijkstra_init(Vertice<T> origen, Map<Vertice<T>, Double> distancias, Cola<Vertice<T>> colaPendientes, Map<Vertice<T>, Vertice<T>> verticesAnteriores) {
        Iterator var5 = this.vertices.iterator();

        while(var5.hasNext()) {
            Vertice<T> vertice = (Vertice)var5.next();
            distancias.put(vertice, Double.MAX_VALUE);
        }

        distancias.put(origen, 0.0);
        colaPendientes.insertar(origen);
    }

    protected void dijkstra_calcula(Map<Vertice<T>, Double> distancias, Cola<Vertice<T>> colaPendientes, Map<Vertice<T>, Vertice<T>> verticesAnteriores) {
        label19:
        while(true) {
            if (!colaPendientes.isVacia()) {
                Vertice<T> current = (Vertice)colaPendientes.extraer();
                Iterator var5 = current.arcosSalida.iterator();

                while(true) {
                    if (!var5.hasNext()) {
                        continue label19;
                    }

                    Arco<T> arco = (Arco)var5.next();
                    Vertice<T> neighbor = arco.destino;
                    double newDistance = (Double)distancias.get(current) + arco.coste;
                    if (newDistance < (Double)distancias.get(neighbor)) {
                        distancias.put(neighbor, newDistance);
                        verticesAnteriores.put(neighbor, current);
                        colaPendientes.insertar(neighbor);
                    }
                }
            }

            return;
        }
    }

    protected Map<Vertice<T>, Camino<T>> dijkstra_procesaResultados(Map<Vertice<T>, Double> distancias, Map<Vertice<T>, Vertice<T>> verticesAnteriores) {
        Map<Vertice<T>, Camino<T>> caminos = new HashMap();
        Iterator var4 = verticesAnteriores.keySet().iterator();

        while(var4.hasNext()) {
            Vertice<T> verticeDestino = (Vertice)var4.next();
            ListaSimple<Vertice<T>> caminoCalculado = new ListaSimple<>();

            for(Vertice<T> v = verticeDestino; v != null; v = (Vertice)verticesAnteriores.get(v)) {
                caminoCalculado.add(v);
            }

            ListaSimple<Vertice<T>> caminoRevertido = caminoCalculado.reverse();
            caminos.put(verticeDestino, new Camino(caminoRevertido, (Double)distancias.get(verticeDestino)));
        }

        return caminos;
    }
}
