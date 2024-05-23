package Controllers;

import EstructurasDeDatos.*;
import Parameter.Properties.IndividuoModelProperties;
import Parameter.Properties.RecursosModelProperties;
import Parameter.Properties.TableroModelProperties;
import PartidasGuardadas.FileReaderPartidas;
import Recursos_Juego.*;
import com.example.demo.StartApplication;
import individuo.Individuo;
import Tablero.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;

import static constantes.Constantes.IND_BASICO;

public class Controller{
    private Stage stage = new Stage();

    /**
     * Propiedades "bindeadas" que permite interconectar elementos visuales.
     */
    private Individuo parametrosDataIndividuo = new Individuo("Pepe",23,43,50,23,IND_BASICO);
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
    private Label chargeError;
    @FXML
    public void onChargeGameButtonClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("chargeGame-view.fxml"));
        String filePath = "C:\\Users\\santi\\Documents\\ESTRUCTURADATOS\\Proyecto-Final\\src\\main\\java\\PartidasGuardadas\\PartidasGuardadas";
        File file = new File(filePath);
        if (file.length() == 0){
            chargeError.setText("No hay partidas guardadas. Por favor cree una nueve");
        }else {
            ListaSimple<HashMap<String, String>> listaPartidas = FileReaderPartidas.cargarParametro(filePath);
            try {
                //Primerio cargamos la escena para que los elementos se intrduzcan correctamente
                Scene scene = new Scene(fxmlLoader.load(), 600, 450);
                ChargeGameController c = fxmlLoader.getController();
                stage.setTitle("Cargar Partida");
                stage.setScene(scene);
                c.getPartidas().getChildren().clear();
                for (HashMap<String, String> parametros : listaPartidas){
                    String nombrePartida = parametros.get("Nombre Partida");
                    Button botonPartida = new Button(nombrePartida);
                    c.getPartidas().getChildren().add(botonPartida);
                }
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
