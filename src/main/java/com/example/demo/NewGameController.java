package com.example.demo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

public  class NewGameController implements Initializable{
    @FXML
    protected Slider vidaSlider;
    @FXML
    protected Slider reproduccionSlider;
    @FXML
    protected Slider clonacionSlider;
    @FXML
    protected Label sliderValue;
    @FXML
    protected Label sliderVidaValue;
    @FXML
    protected Label sliderreproduccionValue;
    @FXML
    protected Label sliderClonacionValue;
    private Stage stage;
    private ParameterDataModelProperties model;

    protected StringProperty texto = new SimpleStringProperty("No Hay Nada");
    protected IntegerProperty medida = new SimpleIntegerProperty(0);
    @Override
    public void initialize(URL url, Individuo individuo){
        vidaSlider.valueProperty().bindBidirectional(medida);
        sliderValue.textProperty().bind(medida.asString);
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void updateGUIWithModel(){
        vidaSlider.valueProperty().bindBidirectional(model.vidaProperty());
        reproduccionSlider.valueProperty().bindBidirectional(model.probabilidadReproduccionProperty());
        clonacionSlider.valueProperty().bindBidirectional(model.probabilidadClonacionProperty());

    }
    public void loadUserData(ParameterDataModelProperties parameterDataModel){
        this.model = parameterDataModel;
        this.updateGUIWithModel();
    }

}
