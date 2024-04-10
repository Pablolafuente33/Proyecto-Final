public class Individuo {
    private int id;
    private int generacion;
    private int turnosVida;
    private int probabilidadReproduccion;
    private int probabilidadClonacion;
    private int probabilidadMuerte;
    private String tipo;
    public Individuo(int id, int generacion, int turnosVida, int probabilidadReproduccion, int probabilidadClonacion, String tipo){
        this.id = id;
        this.generacion = generacion;
        this.turnosVida = turnosVida;
        this.probabilidadReproduccion = probabilidadReproduccion;
        this.probabilidadMuerte = 100 - probabilidadReproduccion;
    }
    public String Moverse(){
        String tipoMovimiento = null;
        return tipoMovimiento;

    }
    public Individuo reproducirse(Individuo individuo){
        return nuevoIndividuo;
    }

}
