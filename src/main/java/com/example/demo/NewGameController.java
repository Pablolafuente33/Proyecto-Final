package com.example.demo;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import  java.net.URL;
import java.util.ResourceBundle;

public class NewGameController implements Initializable{
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
    protected Slider vidaRecursosSlider;
    @FXML
    protected Slider reproduccionRecursosSlider;
    @FXML
    protected Slider muerteRecursosSlider;
    @FXML
    protected Slider clonacionRecursosSlider;

    /**Labels de los Sliders:**/
    //Individuos
    @FXML
    protected Label sliderVidaValue;
    @FXML
    protected Label sliderReproduccionValue;
    @FXML
    protected Label sliderMuerteValue;
    @FXML
    protected Label sliderClonacionValue;
    //Recursos
    @FXML
    protected Label recursoVidaValue;
    @FXML
    protected Label recursoReproduccionValue;
    @FXML
    protected Label recursoMuerteValue;
    @FXML
    protected Label recursoClonacionValue;

    private Stage stage;
    private IndividuoModelProperties individuoModel;
    private RecursosModelProperties recursosModel;

    protected StringProperty texto = new SimpleStringProperty("No Hay Nada");
    protected IntegerProperty medidaIndividuoVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaIndividuoReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaIndividuoMuerte = new SimpleIntegerProperty(100);
    protected IntegerProperty medidaIndividuoClonacion = new SimpleIntegerProperty();

    protected IntegerProperty medidaRecursoVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaRecursoReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaRecursoMuerte = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaRecursoClonacion = new SimpleIntegerProperty();
    @Override
    public void initialize(URL url, ResourceBundle resources){
        //Individuo:
        vidaIndividuoSlider.valueProperty().bindBidirectional(medidaIndividuoVida);
        sliderVidaValue.textProperty().bind(medidaIndividuoVida.asString());

        reproduccionIndividuoSlider.valueProperty().bindBidirectional(medidaIndividuoReproduccion);
        sliderReproduccionValue.textProperty().bind(medidaIndividuoReproduccion.asString());

        muerteIndividuoSlider.valueProperty().bindBidirectional((Property<Number>) medidaIndividuoMuerte);
        sliderMuerteValue.textProperty().bind(medidaIndividuoMuerte.asString());
        medidaIndividuoReproduccion.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaIndividuoMuerte.set(100 - newValue.intValue());
        });

        clonacionIndividuoSlider.valueProperty().bindBidirectional(medidaIndividuoClonacion);
        sliderClonacionValue.textProperty().bind(medidaIndividuoClonacion.asString());
        /**Recursos:**/
        vidaRecursosSlider.valueProperty().bindBidirectional(medidaRecursoVida);
        recursoVidaValue.textProperty().bind(medidaRecursoVida.asString());

        reproduccionRecursosSlider.valueProperty().bindBidirectional(medidaRecursoReproduccion);
        recursoReproduccionValue.textProperty().bind(medidaRecursoReproduccion.asString());

        muerteRecursosSlider.valueProperty().bindBidirectional((Property<Number>) medidaRecursoMuerte);
        recursoMuerteValue.textProperty().bind(medidaRecursoMuerte.asString());
        medidaRecursoReproduccion.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaRecursoMuerte.set(-newValue.intValue());
        });

        clonacionRecursosSlider.valueProperty().bindBidirectional(medidaRecursoClonacion);
        recursoClonacionValue.textProperty().bind(medidaRecursoClonacion.asString());
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void updateGUIWithModel(){
        //Individuo:
        vidaIndividuoSlider.valueProperty().bindBidirectional(individuoModel.vidaIndividuoProperty());
        reproduccionIndividuoSlider.valueProperty().bindBidirectional(individuoModel.probabilidadIndividuoReproduccionProperty());
        muerteIndividuoSlider.valueProperty().bindBidirectional(individuoModel.probabilidadIndividuoMuerteProperty());
        clonacionIndividuoSlider.valueProperty().bindBidirectional(individuoModel.probabilidadIndividuoClonacionProperty());
        //Recursos:
        vidaRecursosSlider.valueProperty().bindBidirectional(recursosModel.vidaRecursoProperty());
        reproduccionRecursosSlider.valueProperty().bindBidirectional(recursosModel.probabilidadRecursoReproduccionProperty());
        muerteRecursosSlider.valueProperty().bindBidirectional(recursosModel.probabilidadRecursoMuerteProperty());
        clonacionRecursosSlider.valueProperty().bindBidirectional(recursosModel.probabilidadRecursoClonacionProperty());

    }
    public void loadUserData(IndividuoModelProperties individuoModel, RecursosModelProperties recursosModel){
        this.individuoModel = individuoModel;
        this.recursosModel = recursosModel;
        this.updateGUIWithModel();
    }

}
