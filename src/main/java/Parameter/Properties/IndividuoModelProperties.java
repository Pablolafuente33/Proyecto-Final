package Parameter.Properties;

import individuo.Individuo;
import javafx.beans.property.*;

public class IndividuoModelProperties {
    protected Individuo individuoOriginal;

    protected IntegerProperty vida = new SimpleIntegerProperty();
    protected DoubleProperty probabilidadReproduccion = new SimpleDoubleProperty();
    protected DoubleProperty probabilidadMuerte = new SimpleDoubleProperty();
    protected DoubleProperty probabilidadClonacion = new SimpleDoubleProperty();


    public IndividuoModelProperties(Individuo individuoOriginal){
        setIndividuoOriginal(individuoOriginal);
    }
    public void setIndividuoOriginal(Individuo IndividuoOriginal) {
        this.individuoOriginal = individuoOriginal;
    }

    public void commit(){
        individuoOriginal.setTurnosVida(vida.get());
        individuoOriginal.setProbabilidadClonacion(probabilidadClonacion.get());
        individuoOriginal.setProbabilidadReproduccion(probabilidadReproduccion.get());
        individuoOriginal.setProbabilidadMuerte(probabilidadReproduccion.get());
    }
    public void rollback (){
        vida.set(individuoOriginal.getTurnosVida());
        probabilidadReproduccion.set(individuoOriginal.getProbabilidadReproduccion());
        probabilidadClonacion.set(individuoOriginal.getProbabilidadClonacion());
        probabilidadMuerte.set(individuoOriginal.getProbabilidadMuerte());
    }

    public void setVida(int vida) {
        this.vida.set(vida);
    }
    public void setProbabilidadReproduccion(int probabilidadReproduccion) {
        this.probabilidadReproduccion.set(probabilidadReproduccion);
    }
    public void setProbabilidadMuerte(int probabilidadReproduccion){
        this.probabilidadMuerte.set(probabilidadReproduccion);
    }
    public void setProbabilidadClonacion(int probabilidadClonacion) {
        this.probabilidadClonacion.set(probabilidadClonacion);
    }

    public Property<Number> vidaIndividuoProperty(){return vida ;}
    public Property<Number> probabilidadIndividuoReproduccionProperty(){return probabilidadReproduccion;}
    public Property<Number> probabilidadIndividuoMuerteProperty(){return probabilidadMuerte;}
    public Property<Number> probabilidadIndividuoClonacionProperty(){return probabilidadClonacion;}

}
