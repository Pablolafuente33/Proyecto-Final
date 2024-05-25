package EstructurasDeDatos;

import individuo.Individuo;
import recurso.Recurso;

public class VerticeIndividuoRecurso {
    private Individuo individuo;
    private Recurso recurso;

    public VerticeIndividuoRecurso(Individuo individuo) {
        this.individuo = individuo;
        this.recurso = null;
    }

    public VerticeIndividuoRecurso(Recurso recurso) {
        this.recurso = recurso;
        this.individuo = null;
    }

    public Individuo getIndividuo() {
        return individuo;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
        this.recurso = null;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
        this.individuo = null;
    }
}
