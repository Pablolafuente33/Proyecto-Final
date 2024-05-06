package Controllers;

import Recursos_Juego.Recurso;
import com.example.demo.*;
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
    private Recurso parameterDataRecursos = new Recurso(7, 8, 9, 10) {
        @Override
        public void setVida(int vida) {
            this.vidaPropertie = vida;
        }
        @Override
        public int getVida() {
            return 0;
        }
        @Override
        public int getClonacion() {
            return 0;
        }
        @Override
        public void setClonacion(int clonacion) {
            this.clonacionPropertie = clonacion;
        }
        @Override
        public int getReproduccion() {
            return 0;
        }
        @Override
        public void setReproduccion(int reproduccion) {
            this.reproduccionPropertie = reproduccion;
        }
        @Override
        public int getMuerte() {
            return 0;
        }
        @Override
        public void setMuerte(int muerte) {
            this.muertePropertie = muerte;
        }
    };
    private IndividuoModelProperties modeloParaGUICompartidoIndividuo = new IndividuoModelProperties(parametrosDataIndividuo);
    private RecursosModelProperties modeloParaGUICompartidoRecursos = new RecursosModelProperties(parameterDataRecursos);


    @FXML
    public void onNewGameButtonClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("newGame-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 600, 450);
            stage.setTitle("Configuración:");
            stage.setScene(scene);
            NewGameController c = fxmlLoader.getController();
            c.loadUserData(modeloParaGUICompartidoIndividuo, modeloParaGUICompartidoRecursos);
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
            c.loadUserData(modeloParaGUICompartidoIndividuo, modeloParaGUICompartidoRecursos);
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
