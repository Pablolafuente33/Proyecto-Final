package EstructurasDeDatos;

public class ListaSimple {
    private NodoLS[] elemento;
    private int max = 100;
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
    public void add (Object object){
        int i = 0;
        if (getNumeroElementos() == max){
            max += 50;
        }
        while (i < max && elemento[i] != null){
            i ++;
        }
        elemento[i] = new NodoLS(object);
    }
    public int getNumeroElementos(){
        int i = 0;
        while (i < max && elemento[i] != null){
            i ++;
        }
        return i ;
    }

}
