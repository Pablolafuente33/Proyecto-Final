package Controllers;

import com.example.demo.IndividuoModelProperties;
import com.example.demo.RecursosModelProperties;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import  java.net.URL;
import java.util.ResourceBundle;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.tab;

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
    protected Slider tesosroVidaSlider;
    @FXML
    protected Slider tesosroReproduccionSlider;
    @FXML
    protected Slider tesoroMuerteSlider;
    @FXML
    protected Slider tesoroClonacionSlider;

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


    private Stage stage;
    private IndividuoModelProperties individuoModel;
    private RecursosModelProperties aguaModel;
    private RecursosModelProperties bibliotecaModel;
    private RecursosModelProperties comidaModel;
    private RecursosModelProperties montañaModel;
    private RecursosModelProperties pozoModel;
    private RecursosModelProperties tesoroModel;

    /** Medidas **/
    //Individuo
    protected IntegerProperty medidaIndividuoVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaIndividuoReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaIndividuoMuerte = new SimpleIntegerProperty(100);
    protected IntegerProperty medidaIndividuoClonacion = new SimpleIntegerProperty();
    //Recursos
    protected IntegerProperty medidaAguaVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaAguaReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaAguaMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaAguaClonacion = new SimpleIntegerProperty();

    protected IntegerProperty medidaBibliotecaVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaBibliotecaReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaBibliotecaMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaBibliotecaClonacion = new SimpleIntegerProperty();

    protected IntegerProperty medidaComidaVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaComidaReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaComidaMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaComidaClonacion = new SimpleIntegerProperty();

    protected IntegerProperty medidaMontañaVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaMontañaReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaMontañaMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaMontañaClonacion = new SimpleIntegerProperty();

    protected IntegerProperty medidaPozoVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPozoReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPozoMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPozoClonacion = new SimpleIntegerProperty();

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
        /**Recursos:**/
        //**Agua**//
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
        //**Biblioteca**//
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
        //**Comida**//
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
        //**Montaña**//
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
        //**Pozo**//
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
        //**Tesoro**//
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
        aguaReproduccionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoReproduccionProperty());
        aguaMuerteSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoMuerteProperty());
        aguaClonacionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoClonacionProperty());
        //**Biblioteca**//
        bibliotecaVidaSlider.valueProperty().bindBidirectional(aguaModel.vidaRecursoProperty());
        bibliotecaReproduccionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoReproduccionProperty());
        aguaMuerteSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoMuerteProperty());
        bibliotecaClonacionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoClonacionProperty());
        //**Comida**//
        comidaVidaSlider.valueProperty().bindBidirectional(aguaModel.vidaRecursoProperty());
        comidaReproduccionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoReproduccionProperty());
        comidaMuerteSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoMuerteProperty());
        comidaClonacionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoClonacionProperty());
        //**Montaña**//
        montañaVidaSlider.valueProperty().bindBidirectional(aguaModel.vidaRecursoProperty());
        montañaReproduccionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoReproduccionProperty());
        montañaMuerteSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoMuerteProperty());
        montañaClonacionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoClonacionProperty());
        //**Pozo**//
        recursoVidaSlider.valueProperty().bindBidirectional(aguaModel.vidaRecursoProperty());
        recursoReproduccionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoReproduccionProperty());
        recursoMuerteSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoMuerteProperty());
        recursoClonacionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoClonacionProperty());
        //**Tesoro**//
        tesoroVidaSlider.valueProperty().bindBidirectional(aguaModel.vidaRecursoProperty());
        tesoroReproduccionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoReproduccionProperty());
        recursoMuerteSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoMuerteProperty());
        recursoClonacionSlider.valueProperty().bindBidirectional(aguaModel.probabilidadRecursoClonacionProperty());
    }
    public void loadUserData(IndividuoModelProperties individuoModel, RecursosModelProperties recursosModel){
        this.individuoModel = individuoModel;
        this.aguaModel = recursosModel;
        this.updateGUIWithModel();
    }
}
