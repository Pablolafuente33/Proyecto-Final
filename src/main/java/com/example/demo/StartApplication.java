package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage1) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500,500);
        stage1.setTitle("El Juego De La Vida");
        stage1.setScene(scene);
        stage1.show();
    }
    public static void main (String [] args){
        launch();
    }
}
