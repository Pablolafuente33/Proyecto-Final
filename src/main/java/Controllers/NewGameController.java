package Controllers;

import Parameter.Properties.IndividuoModelProperties;
import Parameter.Properties.RecursosModelProperties;
import Parameter.Properties.TableroModelProperties;
import com.example.demo.StartApplication;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class NewGameController implements Initializable{
    @FXML
    private TabPane recursos;
    /**Sliders:**/
    //individuo
    @FXML
    protected Slider vidaIndividuoSlider;
    @FXML
    protected Slider reproduccionIndividuoSlider;
    @FXML
    protected Slider muerteIndividuoSlider;
    @FXML
    protected Slider clonacionIndividuoSlider;
    //Recursos:
    @FXML
    protected Slider aguaVidaSlider;
    @FXML
    protected Slider aguaReproduccionSlider;
    @FXML
    protected Slider aguaMuerteSlider;
    @FXML
    protected Slider aguaClonacionSlider;

    @FXML
    protected Slider bibliotecaVidaSlider;
    @FXML
    protected Slider bibliotecaReproduccionSlider;
    @FXML
    protected Slider bibliotecaMuerteSlider;
    @FXML
    protected Slider bibliotecaClonacionSlider;

    @FXML
    protected Slider comidaVidaSlider;
    @FXML
    protected Slider comidaReproduccionSlider;
    @FXML
    protected Slider comidaMuerteSlider;
    @FXML
    protected Slider comidaClonacionSlider;

    @FXML
    protected Slider montañaVidaSlider;
    @FXML
    protected Slider montañaReproduccionSlider;
    @FXML
    protected Slider montañaMuerteSlider;
    @FXML
    protected Slider montañaClonacionSlider;

    @FXML
    protected Slider pozoVidaSlider;
    @FXML
    protected Slider pozoReproduccionSlider;
    @FXML
    protected Slider pozoMuerteSlider;
    @FXML
    protected Slider pozoClonacionSlider;

    @FXML
    protected Slider tesoroVidaSlider;
    @FXML
    protected Slider tesoroReproduccionSlider;
    @FXML
    protected Slider tesoroMuerteSlider;
    @FXML
    protected Slider tesoroClonacionSlider;
    //Tablero
    @FXML
    protected Slider columnasSlider;
    @FXML
    protected Slider filasSlider;

    /**Labels de los Sliders**/
    //Individuos
    @FXML
    protected Label individuoVidaValue;
    @FXML
    protected Label individuoReproduccionValue;
    @FXML
    protected Label individuoMuerteValue;
    @FXML
    protected Label individuoClonacionValue;
    //Recursos
    @FXML
    protected Label aguaVidaValue;
    @FXML
    protected Label aguaReproduccionValue;
    @FXML
    protected Label aguaMuerteValue;
    @FXML
    protected Label aguaClonacionValue;

    @FXML
    protected Label bibliotecaVidaValue;
    @FXML
    protected Label bibliotecaReproduccionValue;
    @FXML
    protected Label bibliotecaMuerteValue;
    @FXML
    protected Label bibliotecaClonacionValue;

    @FXML
    protected Label comidaVidaValue;
    @FXML
    protected Label comidaReproduccionValue;
    @FXML
    protected Label comidaMuerteValue;
    @FXML
    protected Label comidaClonacionValue;

    @FXML
    protected Label montañaVidaValue;
    @FXML
    protected Label montañaReproduccionValue;
    @FXML
    protected Label montañaMuerteValue;
    @FXML
    protected Label montañaClonacionValue;

    @FXML
    protected Label pozoVidaValue;
    @FXML
    protected Label pozoReproduccionValue;
    @FXML
    protected Label pozoMuerteValue;
    @FXML
    protected Label pozoClonacionValue;

    @FXML
    protected Label tesoroVidaValue;
    @FXML
    protected Label tesoroReproduccionValue;
    @FXML
    protected Label tesoroMuerteValue;
    @FXML
    protected Label tesoroClonacionValue;

    @FXML
    protected Label nameError;
    @FXML
    protected TextField nombrePartida;

    /**Tablero**/
    @FXML
    protected GridPane tablero;

    /**Models**/
    private Stage stage;
    private IndividuoModelProperties individuoModel;
    private RecursosModelProperties aguaModel;
    private RecursosModelProperties bibliotecaModel;
    private RecursosModelProperties comidaModel;
    private RecursosModelProperties montañaModel;
    private RecursosModelProperties pozoModel;
    private RecursosModelProperties tesoroModel;
    private TableroModelProperties tableroModel;

    /** Medidas **/
    //Individuo
    protected IntegerProperty medidaIndividuoVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaIndividuoReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaIndividuoMuerte = new SimpleIntegerProperty(100);
    protected IntegerProperty medidaIndividuoClonacion = new SimpleIntegerProperty(0);
    //Recursos
    protected IntegerProperty medidaAguaVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaAguaReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaAguaMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaAguaClonacion = new SimpleIntegerProperty(0);

    protected IntegerProperty medidaBibliotecaVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaBibliotecaReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaBibliotecaMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaBibliotecaClonacion = new SimpleIntegerProperty(0);

    protected IntegerProperty medidaComidaVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaComidaReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaComidaMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaComidaClonacion = new SimpleIntegerProperty(0);

    protected IntegerProperty medidaMontañaVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaMontañaReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaMontañaMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaMontañaClonacion = new SimpleIntegerProperty(0);

    protected IntegerProperty medidaPozoVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPozoReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPozoMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPozoClonacion = new SimpleIntegerProperty();

    protected IntegerProperty medidaTesoroVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaTesoroReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaTesoroMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaTesoroClonacion = new SimpleIntegerProperty(0);

    //Tablero
    protected IntegerProperty medidaFilas = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaColumnas = new SimpleIntegerProperty(0);


    @Override
    public void initialize(URL url, ResourceBundle resources){
        //Individuo:
        vidaIndividuoSlider.valueProperty().bindBidirectional(medidaIndividuoVida);
        individuoVidaValue.textProperty().bind(medidaIndividuoVida.asString());

        reproduccionIndividuoSlider.valueProperty().bindBidirectional((Property<Number>) medidaIndividuoReproduccion);
        individuoReproduccionValue.textProperty().bind(medidaIndividuoReproduccion.asString());
        medidaIndividuoMuerte.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaIndividuoReproduccion.set(100 - newValue.intValue());
        });

        muerteIndividuoSlider.valueProperty().bindBidirectional((Property<Number>) medidaIndividuoMuerte);
        individuoMuerteValue.textProperty().bind(medidaIndividuoMuerte.asString());
        medidaIndividuoReproduccion.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaIndividuoMuerte.set(100 - newValue.intValue());
        });

        clonacionIndividuoSlider.valueProperty().bindBidirectional(medidaIndividuoClonacion);
        individuoClonacionValue.textProperty().bind(medidaIndividuoClonacion.asString());

        //**Agua**//
        aguaVidaSlider.valueProperty().bindBidirectional(medidaAguaVida);
        aguaVidaValue.textProperty().bind(medidaAguaVida.asString());

        aguaReproduccionSlider.valueProperty().bindBidirectional( medidaAguaReproduccion);
        aguaReproduccionValue.textProperty().bind(medidaAguaReproduccion.asString());
        medidaAguaMuerte.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaAguaReproduccion.set( 0 - newValue.intValue());
        });

        aguaMuerteSlider.valueProperty().bindBidirectional( medidaAguaMuerte);
        aguaMuerteValue.textProperty().bind(medidaAguaMuerte.asString());
        medidaAguaReproduccion.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaAguaMuerte.set( 0 - newValue.intValue());
        });

        aguaClonacionSlider.valueProperty().bindBidirectional(medidaAguaClonacion);
        aguaClonacionValue.textProperty().bind(medidaAguaClonacion.asString());

        //**Biblioteca**//
        bibliotecaVidaSlider.valueProperty().bindBidirectional(medidaBibliotecaVida);
        bibliotecaVidaValue.textProperty().bind(medidaBibliotecaVida.asString());

        bibliotecaReproduccionSlider.valueProperty().bindBidirectional( medidaBibliotecaReproduccion);
        bibliotecaReproduccionValue.textProperty().bind(medidaBibliotecaReproduccion.asString());
        medidaBibliotecaMuerte.addListener((obs, oldValue, newValue) -> {
            medidaBibliotecaReproduccion.set( 0 - newValue.intValue());
        });

        bibliotecaMuerteSlider.valueProperty().bindBidirectional( medidaBibliotecaMuerte);
        bibliotecaMuerteValue.textProperty().bind(medidaBibliotecaMuerte.asString());
        medidaBibliotecaReproduccion.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaBibliotecaMuerte.set( 0 - newValue.intValue());
        });

        bibliotecaClonacionSlider.valueProperty().bindBidirectional(medidaBibliotecaClonacion);
        bibliotecaClonacionValue.textProperty().bind(medidaBibliotecaClonacion.asString());

        //**Comida**//
        comidaVidaSlider.valueProperty().bindBidirectional(medidaComidaVida);
        comidaVidaValue.textProperty().bind(medidaComidaVida.asString());

        comidaReproduccionSlider.valueProperty().bindBidirectional( medidaComidaReproduccion);
        comidaReproduccionValue.textProperty().bind(medidaComidaReproduccion.asString());
        medidaComidaMuerte.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaComidaReproduccion.set( 0 - newValue.intValue());
        });

        comidaMuerteSlider.valueProperty().bindBidirectional( medidaComidaMuerte);
        comidaMuerteValue.textProperty().bind(medidaComidaMuerte.asString());
        medidaComidaReproduccion.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaComidaMuerte.set( 0 - newValue.intValue());
        });

        comidaClonacionSlider.valueProperty().bindBidirectional(medidaComidaClonacion);
        comidaClonacionValue.textProperty().bind(medidaComidaClonacion.asString());

        //**Montaña**//
        montañaVidaSlider.valueProperty().bindBidirectional(medidaMontañaVida);
        montañaVidaValue.textProperty().bind(medidaMontañaVida.asString());

        montañaReproduccionSlider.valueProperty().bindBidirectional( medidaMontañaReproduccion);
        montañaReproduccionValue.textProperty().bind(medidaMontañaReproduccion.asString());
        medidaMontañaMuerte.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaMontañaReproduccion.set( 0 - newValue.intValue());
        });

        montañaMuerteSlider.valueProperty().bindBidirectional( medidaMontañaMuerte);
        montañaMuerteValue.textProperty().bind(medidaMontañaMuerte.asString());
        medidaMontañaReproduccion.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaMontañaMuerte.set( 0 - newValue.intValue());
        });

        montañaClonacionSlider.valueProperty().bindBidirectional(medidaMontañaClonacion);
        montañaClonacionValue.textProperty().bind(medidaMontañaClonacion.asString());

        //**Pozo**//
        pozoVidaSlider.valueProperty().bindBidirectional(medidaPozoVida);
        pozoVidaValue.textProperty().bind(medidaPozoVida.asString());

        pozoReproduccionSlider.valueProperty().bindBidirectional( medidaPozoReproduccion);
        pozoReproduccionValue.textProperty().bind(medidaPozoReproduccion.asString());
        medidaPozoMuerte.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaPozoReproduccion.set( 0 - newValue.intValue());
        });

        pozoMuerteSlider.valueProperty().bindBidirectional( medidaPozoMuerte);
        pozoMuerteValue.textProperty().bind(medidaPozoMuerte.asString());
        medidaPozoReproduccion.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaPozoMuerte.set( 0 - newValue.intValue());
        });

        pozoClonacionSlider.valueProperty().bindBidirectional(medidaPozoClonacion);
        pozoClonacionValue.textProperty().bind(medidaPozoClonacion.asString());

        //**Tesoro**//
        tesoroVidaSlider.valueProperty().bindBidirectional(medidaTesoroVida);
        tesoroVidaValue.textProperty().bind(medidaTesoroVida.asString());

        tesoroReproduccionSlider.valueProperty().bindBidirectional( medidaTesoroReproduccion);
        tesoroReproduccionValue.textProperty().bind(medidaTesoroReproduccion.asString());
        medidaTesoroMuerte.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaTesoroReproduccion.set( 0 - newValue.intValue());
        });

        tesoroMuerteSlider.valueProperty().bindBidirectional( medidaTesoroMuerte);
        tesoroMuerteValue.textProperty().bind(medidaTesoroMuerte.asString());
        medidaTesoroReproduccion.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaTesoroMuerte.set( 0 - newValue.intValue());
        });

        tesoroClonacionSlider.valueProperty().bindBidirectional(medidaTesoroClonacion);
        tesoroClonacionValue.textProperty().bind(medidaTesoroClonacion.asString());
        //Tablero
        filasSlider.valueProperty().bindBidirectional(medidaFilas);
        medidaFilas.addListener((obs, oldValue, newValue) -> tableroParametrizable());

        columnasSlider.valueProperty().bindBidirectional(medidaColumnas);
        medidaColumnas.addListener((obs, oldValue, newValue) -> tableroParametrizable());
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void updateGUIWithModel(){
        /**Individuo:**/
        vidaIndividuoSlider.valueProperty().bindBidirectional(individuoModel.vidaIndividuoProperty());
        reproduccionIndividuoSlider.valueProperty().bindBidirectional(individuoModel.probabilidadIndividuoReproduccionProperty());
        muerteIndividuoSlider.valueProperty().bindBidirectional(individuoModel.probabilidadIndividuoMuerteProperty());
        clonacionIndividuoSlider.valueProperty().bindBidirectional(individuoModel.probabilidadIndividuoClonacionProperty());
        /**Recursos:**/
        //**Agua**//
        aguaVidaSlider.valueProperty().bindBidirectional(aguaModel.vidaRecursoProperty());
        aguaReproduccionSlider.valueProperty().bindBidirectional(aguaModel.reproduccionRecursoProperty());
        aguaMuerteSlider.valueProperty().bindBidirectional(aguaModel.muerteRecursoProperty());
        aguaClonacionSlider.valueProperty().bindBidirectional(aguaModel.clonacionRecursoProperty());
        //**Biblioteca**//
        bibliotecaVidaSlider.valueProperty().bindBidirectional(bibliotecaModel.vidaRecursoProperty());
        bibliotecaReproduccionSlider.valueProperty().bindBidirectional(bibliotecaModel.reproduccionRecursoProperty());
        aguaMuerteSlider.valueProperty().bindBidirectional(bibliotecaModel.muerteRecursoProperty());
        bibliotecaClonacionSlider.valueProperty().bindBidirectional(bibliotecaModel.clonacionRecursoProperty());
        //**Comida**//
        comidaVidaSlider.valueProperty().bindBidirectional(comidaModel.vidaRecursoProperty());
        comidaReproduccionSlider.valueProperty().bindBidirectional(comidaModel.reproduccionRecursoProperty());
        comidaMuerteSlider.valueProperty().bindBidirectional(comidaModel.muerteRecursoProperty());
        comidaClonacionSlider.valueProperty().bindBidirectional(comidaModel.clonacionRecursoProperty());
        //**Montaña**//
        montañaVidaSlider.valueProperty().bindBidirectional(montañaModel.vidaRecursoProperty());
        montañaReproduccionSlider.valueProperty().bindBidirectional(montañaModel.reproduccionRecursoProperty());
        montañaMuerteSlider.valueProperty().bindBidirectional(montañaModel.muerteRecursoProperty());
        montañaClonacionSlider.valueProperty().bindBidirectional(montañaModel.clonacionRecursoProperty());
        //**Pozo**//
        pozoVidaSlider.valueProperty().bindBidirectional(pozoModel.vidaRecursoProperty());
        pozoReproduccionSlider.valueProperty().bindBidirectional(pozoModel.reproduccionRecursoProperty());
        pozoMuerteSlider.valueProperty().bindBidirectional(pozoModel.muerteRecursoProperty());
        pozoClonacionSlider.valueProperty().bindBidirectional(pozoModel.clonacionRecursoProperty());
        //**Tesoro**//
        tesoroVidaSlider.valueProperty().bindBidirectional(tesoroModel.vidaRecursoProperty());
        tesoroReproduccionSlider.valueProperty().bindBidirectional(tesoroModel.reproduccionRecursoProperty());
        tesoroMuerteSlider.valueProperty().bindBidirectional(tesoroModel.muerteRecursoProperty());
        tesoroClonacionSlider.valueProperty().bindBidirectional(tesoroModel.clonacionRecursoProperty());
        /**Tablero**/
        filasSlider.valueProperty().bindBidirectional(tableroModel.filasProperty());
        columnasSlider.valueProperty().bindBidirectional(tableroModel.columnasProperty());
    }
    public void loadUserData(IndividuoModelProperties individuoModel, RecursosModelProperties aguaModel, RecursosModelProperties bibliotecaModel,RecursosModelProperties comidaModel,
                             RecursosModelProperties montañaModel, RecursosModelProperties pozoModel, RecursosModelProperties tesoroModel, TableroModelProperties tableroModel){
        this.individuoModel = individuoModel;
        this.aguaModel =aguaModel;
        this.bibliotecaModel = bibliotecaModel;
        this.comidaModel = comidaModel;
        this.montañaModel = montañaModel;
        this.pozoModel = pozoModel;
        this.tesoroModel = tesoroModel;
        this.tableroModel = tableroModel;

        this.updateGUIWithModel();
    }
    private void tableroParametrizable(){
        tablero.getChildren().clear();
        tablero.getRowConstraints().clear();
        tablero.getColumnConstraints().clear();

        double totalHeight = 250;
        double totalWidth = 310;
        tablero.setPrefHeight(totalHeight);
        tablero.setPrefWidth(totalWidth);
        tablero.setMaxHeight(totalHeight);
        tablero.setMaxWidth(totalWidth);
        tablero.setMinHeight(totalHeight);
        tablero.setMinWidth(totalWidth);

        int filas = medidaFilas.get();
        int columnas = medidaColumnas.get();

        for (int i = 0; i< filas; i ++) {
            RowConstraints fila = new RowConstraints();
            fila.setMinHeight(totalHeight / filas);
            fila.setPrefHeight(totalHeight / filas);
            fila.setMaxHeight(totalHeight / filas);
            tablero.getRowConstraints().add(fila);
        }
        for(int j = 0; j < medidaColumnas.get(); j ++){
            ColumnConstraints columna = new ColumnConstraints();
            columna.setMinWidth(totalWidth / columnas);
            columna.setPrefWidth(totalWidth / columnas);
            columna.setMaxWidth(totalWidth / columnas);
            tablero.getColumnConstraints().add(columna);
        }
        for (int i = 0; i < filas;i ++ ){
            for (int j = 0;j < columnas; j++){
                Label label = new Label();
                label.setStyle("-fx-border-color: black; -fx-alignment: center");
                label.setMinHeight(totalHeight / filas);
                label.setPrefHeight(totalHeight / filas);
                label.setMaxHeight(totalHeight / filas);
                label.setMinWidth(totalWidth / columnas);
                label.setPrefWidth(totalWidth / columnas);
                label.setMaxWidth(totalWidth / columnas);
                tablero.add(label, j, i);
            }
        }
    }
    @FXML
    public void guardarButton(){
        String nombre = nombrePartida.getText();
        if (nombre == null || nombre.isEmpty()){
            nameError.setText("Introduzca un nombre a su partida");
        }else {
            File file = new File("C:\\Users\\santi\\Documents\\ESTRUCTURADATOS\\Proyecto-Final\\src\\main\\java\\PartidasGuardadas\\PartidasGuardadas");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write("Nombre Partida="+nombre+" , "+"Columnas="+medidaColumnas.get()+" , "+"Filas="+medidaFilas.get()+","+
                        "AguaVida="+medidaAguaVida.get()+" , "+"AguaClonacion="+medidaAguaClonacion.get()+" , "+"AguaReproduccion=" + medidaAguaReproduccion.get()+" , "+"AguaMuerte="+medidaAguaMuerte.get()+" , "+
                        "BibliotecaVida="+medidaBibliotecaVida.get()+" , "+"BibliotecaClonacion="+medidaBibliotecaClonacion.get()+" , "+"BibliotecaReproduccion=" + medidaBibliotecaReproduccion.get()+" , "+"BibliotecaMuerte="+medidaBibliotecaMuerte.get()+" , "+
                        "ComidaVida="+medidaComidaVida.get()+" , "+"ComidaClonacion="+medidaComidaClonacion.get()+" , "+"ComidaReproduccion=" + medidaComidaReproduccion.get()+" , "+"ComidaMuerte="+medidaComidaMuerte.get()+" , "+
                        "MontañaVida="+medidaMontañaVida.get()+" , "+"MontañaClonacion="+medidaMontañaClonacion.get()+" , "+"MontañaReproduccion=" + medidaMontañaReproduccion.get()+" , "+"MontañaMuerte="+medidaMontañaMuerte.get()+" , "+
                        "TesoroVida="+medidaTesoroVida.get()+" , "+"TesoroClonacion="+medidaTesoroClonacion.get()+" , "+"TesoroReproduccion=" + medidaTesoroReproduccion.get()+" , "+"TesoroMuerte="+medidaTesoroMuerte.get()+" , "+
                        "PozoVida="+medidaPozoVida.get()+" , "+"PozoClonacion="+medidaPozoClonacion.get()+" , "+"PozoReproduccion=" + medidaPozoReproduccion.get()+" , "+"PozoMuerte="+medidaPozoMuerte.get()+" , "+
                        "IndividuoVida="+medidaIndividuoVida.get()+" , "+"IndividuoClonacion="+medidaIndividuoClonacion.get()+" , "+"IndividuoReproduccion=" + medidaIndividuoReproduccion.get()+" , "+"IndividuoMuerte="+medidaIndividuoMuerte.get());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            abrirJuego();
        }
    }
    private void abrirJuego(){
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("game-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 700, 700);
            stage.setTitle("El juego de la vida");
            stage.setScene(scene);
            GameController gameController = fxmlLoader.getController();
            gameController.setStage(stage);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
