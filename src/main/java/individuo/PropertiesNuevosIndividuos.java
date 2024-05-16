package individuo;

public class PropertiesNuevosIndividuos {
    private double probabilidadMejora;
    private int turnosVida;
    private double probabilidadReproduccion;
    private double probabilidadClonacion;
    private double probabilidadMuerte;

    public PropertiesNuevosIndividuos(double probabilidadMejora, int turnosVida, double probabilidadReproduccion,
                                      double probabilidadClonacion) {
        this.probabilidadMejora = probabilidadMejora;
        this.turnosVida = turnosVida;
        this.probabilidadReproduccion = probabilidadReproduccion;
        this.probabilidadClonacion = probabilidadClonacion;
        this.probabilidadMejora = probabilidadMejora;

    }

    public double getprobabilidadMejora() {
        return probabilidadMejora;
    }
    public void setprobabilidadMejora(double probabilidadMejora) {
        this.probabilidadMejora = probabilidadMejora;
    }

    public int getTurnosVida() {
        return turnosVida;
    }
    public void setTurnosVida(int turnosVida) {
        this.turnosVida = turnosVida;
    }

    public double getProbabilidadReproduccion() {
        return probabilidadReproduccion;
    }
    public void setProbabilidadReproduccion(double probabilidadReproduccion) {
        this.probabilidadReproduccion = probabilidadReproduccion;
    }

    public double getProbabilidadMuerte(){
        return probabilidadMuerte;
    }
    public void setProbabilidadMuerte(double probabilidadReproduccion){
        this.probabilidadMuerte = probabilidadReproduccion;
    }

    public double getProbabilidadClonacion(){
        return probabilidadClonacion;
    }
    public void setProbabilidadClonacion(double probabilidadClonacion) {
        this.probabilidadClonacion = probabilidadClonacion;
    }
}
