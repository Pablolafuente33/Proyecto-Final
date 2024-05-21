package Controllers;

import Parameter.Properties.IndividuoModelProperties;
import Parameter.Properties.RecursosModelProperties;
import Parameter.Properties.TableroModelProperties;
import Recursos_Juego.*;
import com.example.demo.*;
import Tablero.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Controller{
    private Stage stage = new Stage();

    /**
     * Propiedades "bindeadas" que permite interconectar elementos visuales.
     */
    private Individuo parametrosDataIndividuo = new Individuo(7,23,43,50,23,"Normal");
    private Agua parameterDataAgua = new Agua(7, 8, 9, 10);
    private Biblioteca parameterDataBiblioteca = new Biblioteca(7, 8, 9, 10);
    private Comida parameterDataComida = new Comida(7, 8, 9, 10);
    private Montaña parameterDataMontaña = new Montaña(7,8,9,0);
    private Pozo parameterDataPozo = new Pozo(7, 8, 9, 10);
    private Tesoro parameterDataTesoro = new Tesoro(7, 8, 9, 10);
    private Tablero parameterDataTablero = new Tablero(7,7);

    private IndividuoModelProperties modeloParaGUICompartidoIndividuo = new IndividuoModelProperties(parametrosDataIndividuo);
    private RecursosModelProperties modeloParaGUICompartidoAgua = new RecursosModelProperties(parameterDataAgua);
    private RecursosModelProperties modeloParaGUICompartidoBiblioteca = new RecursosModelProperties(parameterDataBiblioteca);
    private RecursosModelProperties modeloParaGUICompartidoComida = new RecursosModelProperties(parameterDataComida);
    private RecursosModelProperties modeloParaGUICompartidoMontaña = new RecursosModelProperties(parameterDataMontaña);
    private RecursosModelProperties modeloParaGUICompartidoPozo = new RecursosModelProperties(parameterDataPozo);
    private RecursosModelProperties modeloParaGUICompartidoTesoro = new RecursosModelProperties(parameterDataTesoro);

    private TableroModelProperties  modeloParaGUICompartidoTablero = new TableroModelProperties(parameterDataTablero);



    @FXML
    public void onNewGameButtonClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("newGame-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 600, 450);
            stage.setTitle("Configuración:");
            stage.setScene(scene);
            NewGameController c = fxmlLoader.getController();
            c.loadUserData(modeloParaGUICompartidoIndividuo, modeloParaGUICompartidoAgua, modeloParaGUICompartidoBiblioteca,modeloParaGUICompartidoComida, modeloParaGUICompartidoMontaña,
                    modeloParaGUICompartidoPozo, modeloParaGUICompartidoTesoro, modeloParaGUICompartidoTablero);
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
            c.loadUserData(modeloParaGUICompartidoIndividuo, modeloParaGUICompartidoAgua, modeloParaGUICompartidoBiblioteca,modeloParaGUICompartidoComida, modeloParaGUICompartidoMontaña,
                    modeloParaGUICompartidoPozo, modeloParaGUICompartidoTesoro, modeloParaGUICompartidoTablero);
            c.setStage(stage);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private double aleatoryValue(double min, double max){
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

}