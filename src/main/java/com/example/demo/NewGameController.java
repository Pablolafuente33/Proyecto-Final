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

public class NewGameController implements Initializable {
    @FXML
    protected Slider miSlider;
    @FXML
    protected Label sliderValue;
    protected StringProperty texto = new SimpleStringProperty("No Hay Nada");
    protected IntegerProperty medida = new SimpleIntegerProperty(0);
    @Override
    public void initialize(URL url, ResourceBoundle resourceBoundle){
        miSlider.valueProperty().bindBidirectional(medida);
        sliderValue.textProperty().bind(medida.asString);
    }
}
