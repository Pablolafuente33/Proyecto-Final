package com.example.demo;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;
import  java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class NewGameController implements Initializable{
    //Sliders:
    @FXML
    protected Slider vidaSlider;
    @FXML
    protected Slider reproduccionSlider;
    @FXML
    protected Slider muerteSlider;
    @FXML
    protected Slider clonacionSlider;

    //Labels de los Sliders:
    @FXML
    protected Label sliderVidaValue;
    @FXML
    protected Label sliderReproduccionValue;
    @FXML
    protected Label sliderMuerteValue;
    @FXML
    protected Label sliderClonacionValue;

    private Stage stage;
    private ParameterDataModelProperties model;

    protected StringProperty texto = new SimpleStringProperty("No Hay Nada");
    protected IntegerProperty medidaVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaMuerte = new SimpleIntegerProperty(100);
    protected IntegerProperty medidaClonacion = new SimpleIntegerProperty();

    @Override
    public void initialize(URL url, ResourceBundle resources){
        vidaSlider.valueProperty().bindBidirectional(medidaVida);
        sliderVidaValue.textProperty().bind(medidaVida.asString());

        reproduccionSlider.valueProperty().bindBidirectional(medidaReproduccion);
        sliderReproduccionValue.textProperty().bind(medidaReproduccion.asString());

        muerteSlider.valueProperty().bindBidirectional((Property<Number>) medidaMuerte);
        sliderMuerteValue.textProperty().bind(medidaMuerte.asString());
        medidaReproduccion.addListener((obs, oldValue, newValue) -> {
            // Actualizar medidaMuerte cuando medidaReproduccion cambia
            medidaMuerte.set(100 - newValue.intValue());
        });

        clonacionSlider.valueProperty().bindBidirectional(medidaClonacion);
        sliderClonacionValue.textProperty().bind(medidaClonacion.asString());
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void updateGUIWithModel(){
        vidaSlider.valueProperty().bindBidirectional(model.vidaProperty());
        reproduccionSlider.valueProperty().bindBidirectional(model.probabilidadReproduccionProperty());
    }
    public void loadUserData(ParameterDataModelProperties parameterDataModel){
        this.model = parameterDataModel;
        this.updateGUIWithModel();
    }

}
