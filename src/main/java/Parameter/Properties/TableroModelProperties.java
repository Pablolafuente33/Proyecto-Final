package Parameter.Properties;
import Tablero.Tablero;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;

public class TableroModelProperties {
    protected Tablero tableroOriginal;
    protected IntegerProperty columnas = new SimpleIntegerProperty();
    protected IntegerProperty filas = new SimpleIntegerProperty();
    public TableroModelProperties(Tablero tableroOriginal){
        setTableroOriginal(tableroOriginal);
    }

    public void setTableroOriginal(Tablero tableroOriginal) {
        this.tableroOriginal = tableroOriginal;
    }
    public Tablero getTableroOriginal(){
        return tableroOriginal;
    }

    public void setX(int x) {
        this.columnas.set(x);
    }

    public void setY(int y) {
        this.filas.set(y);
    }

    public void commit(){
        tableroOriginal.setColumnas(columnas.get());
        tableroOriginal.setFilas(columnas.get());
    }
    public void rollback(){
        columnas.set(tableroOriginal.getColumnas());
        filas.set(tableroOriginal.getFilas());
    }
    public Property<Number> columnasProperty(){return columnas;}
    public Property<Number> filasProperty(){return filas;}
}
