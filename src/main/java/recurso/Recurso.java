package recurso;

public class Recurso  {

    private String nombre;
    private int turnosVida;
    private double probAparicion;
    // Los siguientes datos indicarán como interactúe el recurso con el individuo
    private int turnosVidaInd;
    private double probReproduccionInd;
    private double probMuerteInd;
    private double probClonacionInd;

    public Recurso(String nombre, int turnosVida, double probAparicion, int turnosVidaInd, double probReproduccionInd,
                   double probMuerteInd, double probClonacionInd){
        this.nombre = nombre;
        this.turnosVida = turnosVida;
        this.probAparicion = probAparicion;
        // Datos interactivos con los individuos
        this.turnosVidaInd = turnosVidaInd;
        this.probReproduccionInd = probReproduccionInd;
        this.probMuerteInd  = probMuerteInd;
        this.probClonacionInd = probClonacionInd;
    }

    public int getTurnosVida() {
        return turnosVida;
    }
    public void setTurnosVida(int turnosVidaInd) {
        this.turnosVida = turnosVidaInd;
    }

    public double getProbAparicion() {
        return probAparicion;
    }
    public void setProbAparicion(double probAparicion) {
        this.probAparicion = probAparicion;
    }

    public int getTurnosVidaInd() {
        return turnosVidaInd;
    }
    public void setTurnosVidaInd(int turnosVidaInd) {
        this.turnosVidaInd = turnosVidaInd;
    }

    public double getProbReproduccionInd() {
        return probReproduccionInd;
    }
    public void setProbReproduccionInd(double probReproduccionInd) {
        this.probReproduccionInd = probReproduccionInd;
    }

    public double getProbMuerteInd() {
        return probMuerteInd;
    }
    public void setProbMuerteInd(double probMuerteInd) {
        this.probMuerteInd = probMuerteInd;
    }

    public double getProbClonacionInd() {
        return probClonacionInd;
    }
    public void setProbClonacionInd(double probClonacionInd) {
        this.probClonacionInd = probClonacionInd;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
