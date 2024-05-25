package Parameter.Properties;

import com.example.demo.Partida;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
public class PartidaModelProperties {
     private final IntegerProperty medidaColumnas = new SimpleIntegerProperty();
     private final IntegerProperty medidaFilas = new SimpleIntegerProperty();

     private final IntegerProperty medidaAguaVida = new SimpleIntegerProperty();
     private final DoubleProperty medidaAguaClonacion = new SimpleDoubleProperty();
     private final DoubleProperty medidaAguaReproduccion = new SimpleDoubleProperty();
     private final DoubleProperty medidaAguaMuerte = new SimpleDoubleProperty();

     private final IntegerProperty medidaBibliotecaVida = new SimpleIntegerProperty();
     private final DoubleProperty medidaBibliotecaClonacion = new SimpleDoubleProperty();
     private final DoubleProperty medidaBibliotecaReproduccion = new SimpleDoubleProperty();
     private final DoubleProperty medidaBibliotecaMuerte = new SimpleDoubleProperty();

     private final IntegerProperty medidaComidaVida = new SimpleIntegerProperty();
     private final DoubleProperty medidaComidaClonacion = new SimpleDoubleProperty();
     private final DoubleProperty medidaComidaReproduccion = new SimpleDoubleProperty();
     private final DoubleProperty medidaComidaMuerte = new SimpleDoubleProperty();

     private final IntegerProperty medidaMontañaVida = new SimpleIntegerProperty();
     private final DoubleProperty medidaMontañaClonacion = new SimpleDoubleProperty();
     private final DoubleProperty medidaMontañaReproduccion = new SimpleDoubleProperty();
     private final DoubleProperty medidaMontañaMuerte = new SimpleDoubleProperty();

     private final IntegerProperty medidaPozoVida = new SimpleIntegerProperty();
     private final DoubleProperty medidaPozoClonacion = new SimpleDoubleProperty();
     private final DoubleProperty medidaPozoReproduccion = new SimpleDoubleProperty();
     private final DoubleProperty medidaPozoMuerte = new SimpleDoubleProperty();

     private final IntegerProperty medidaTesoroVida = new SimpleIntegerProperty();
     private final DoubleProperty medidaTesoroClonacion = new SimpleDoubleProperty();
     private final DoubleProperty medidaTesoroReproduccion = new SimpleDoubleProperty();
     private final DoubleProperty medidaTesoroMuerte = new SimpleDoubleProperty();

     private final IntegerProperty medidaIndividuoVida = new SimpleIntegerProperty();
     private final DoubleProperty medidaIndividuoClonacion = new SimpleDoubleProperty();
     private final DoubleProperty medidaIndividuoReproduccion = new SimpleDoubleProperty();
     private final DoubleProperty medidaIndividuoMuerte = new SimpleDoubleProperty();

     public PartidaModelProperties(Partida partida) {
         this.medidaColumnas.set(partida.getMedidaColumnas());
         this.medidaFilas.set(partida.getMedidaFilas());
         this.medidaAguaVida.set(partida.getMedidaAguaVida());
         this.medidaAguaClonacion.set(partida.getMedidaAguaClonacion());
         this.medidaAguaReproduccion.set(partida.getMedidaAguaReproduccion());
         this.medidaAguaMuerte.set(partida.getMedidaAguaMuerte());
         this.medidaBibliotecaVida.set(partida.getMedidaBibliotecaVida());
         this.medidaBibliotecaClonacion.set(partida.getMedidaBibliotecaClonacion());
         this.medidaBibliotecaReproduccion.set(partida.getMedidaBibliotecaReproduccion());
         this.medidaBibliotecaMuerte.set(partida.getMedidaBibliotecaMuerte());
         this.medidaComidaVida.set(partida.getMedidaComidaVida());
         this.medidaComidaClonacion.set(partida.getMedidaComidaClonacion());
         this.medidaComidaReproduccion.set(partida.getMedidaComidaReproduccion());
         this.medidaComidaMuerte.set(partida.getMedidaComidaMuerte());
         this.medidaMontañaVida.set(partida.getMedidaMontañaVida());
         this.medidaMontañaClonacion.set(partida.getMedidaMontañaClonacion());
         this.medidaMontañaReproduccion.set(partida.getMedidaMontañaReproduccion());
         this.medidaMontañaMuerte.set(partida.getMedidaMontañaMuerte());
         this.medidaPozoVida.set(partida.getMedidaPozoVida());
         this.medidaPozoClonacion.set(partida.getMedidaPozoClonacion());
         this.medidaPozoReproduccion.set(partida.getMedidaPozoReproduccion());
         this.medidaPozoMuerte.set(partida.getMedidaPozoMuerte());
         this.medidaTesoroVida.set(partida.getMedidaTesoroVida());
         this.medidaTesoroClonacion.set(partida.getMedidaTesoroClonacion());
         this.medidaTesoroReproduccion.set(partida.getMedidaTesoroReproduccion());
         this.medidaTesoroMuerte.set(partida.getMedidaTesoroMuerte());
         this.medidaIndividuoVida.set(partida.getMedidaIndividuoVida());
         this.medidaIndividuoClonacion.set(partida.getMedidaIndividuoClonacion());
         this.medidaIndividuoReproduccion.set(partida.getMedidaIndividuoReproduccion());
         this.medidaIndividuoMuerte.set(partida.getMedidaIndividuoMuerte());
        }
        public int getMedidaColumnas() {
            return medidaColumnas.get();
        }

        public IntegerProperty medidaColumnasProperty() {
            return medidaColumnas;
        }

        public int getMedidaFilas() {
            return medidaFilas.get();
        }

        public IntegerProperty medidaFilasProperty() {
            return medidaFilas;
        }

        public int getMedidaAguaVida() {
            return medidaAguaVida.get();
        }

        public IntegerProperty medidaAguaVidaProperty() {
            return medidaAguaVida;
        }

        public double getMedidaAguaClonacion() {
            return medidaAguaClonacion.get();
        }

        public DoubleProperty medidaAguaClonacionProperty() {
            return medidaAguaClonacion;
        }

        public double getMedidaAguaReproduccion() {
            return medidaAguaReproduccion.get();
        }

        public DoubleProperty medidaAguaReproduccionProperty() {
            return medidaAguaReproduccion;
        }

        public double getMedidaAguaMuerte() {
            return medidaAguaMuerte.get();
        }

        public DoubleProperty medidaAguaMuerteProperty() {
            return medidaAguaMuerte;
        }

        public int getMedidaBibliotecaVida() {
            return medidaBibliotecaVida.get();
        }

        public IntegerProperty medidaBibliotecaVidaProperty() {
            return medidaBibliotecaVida;
        }
        public double getMedidaBibliotecaClonacion() {
         return medidaBibliotecaClonacion.get();
     }
        public DoubleProperty medidaBibliotecaClonacionProperty() {
            return medidaBibliotecaClonacion;
        }
}
