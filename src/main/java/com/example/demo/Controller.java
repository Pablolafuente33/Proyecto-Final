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
public class Controller implements Initializable{
    private Stage stage = new Stage();

    /**
     * Propiedades "bindeadas" que permite interconectar elementos visuales.
     */
    private Individuo parametrosData = new Individuo(7,23,43,50,23,"Normal");
    private ParameterDataModelProperties modeloParaGUICompartido = new ParameterDataModelProperties(parametrosData);


    @FXML
    public void onNewGameButtonClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("newGame-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 600, 450);
            stage.setTitle("Configuración");
            stage.setScene(scene);
            NewGameController c = new NewGameController();
            c.loadUserData(this.modeloParaGUICompartido);
            c.setStage(stage);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void onChargeGameButtonClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("chargeGame-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 600, 450);
            stage.setTitle("Cargar Partida");
            stage.setScene(scene);
            NewGameController c = fxmlLoader.getController();
            c.loadUserData(this.modeloParaGUICompartido);
            c.setStage(stage);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        vidaSlider.valueProperty().bindBidirectional(medida);
        sliderValue.textProperty().bind(medida.asString);
    }
    private double aleatoryValue(double min, double max){
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

}
