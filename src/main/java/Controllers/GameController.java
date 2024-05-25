package Controllers;

import EstructurasDeDatos.ListaSimple;
import com.example.demo.Partida;
import individuo.Individuo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Tablero.*;

import java.io.IOException;

public class GameController {
    @FXML
    private GridPane tablero;
    private Tablero tableroModel;
    public Tablero getTableroModel(){
        return tableroModel;
    }
    @FXML
    private VBox tableroContainer;
    @FXML
    public void setTablero(GridPane tablero) {
        this.tablero = tablero;
        mostrarTablero();
    }
    private void mostrarTablero(){
        tableroContainer.getChildren().clear();
        tableroContainer.getChildren().add(tablero);}

    private Partida modeloPartida;

    public void setModeloPartida(Partida modeloPartida) {
        this.modeloPartida = modeloPartida;
        tableroParametrizable();
    }

    @FXML
    private Stage  stage;
    @FXML
    private Button comenzar;
    @FXML
    private Button reanudar;

    @FXML
    private Button pausar;
    public void setStage(Stage stage){
        this.stage = stage;
    }
    @FXML
    public void pausarButton(){

    }
    @FXML
    public void comenzarButton(){
        inicializarTablero();
    }
    private void insertarElementos(GridPane tablero) {

    }
    private void tableroParametrizable(){
        tablero.getChildren().clear();
        tablero.getRowConstraints().clear();
        tablero.getColumnConstraints().clear();

        double totalHeight = 425.0;
        double totalWidth = 425.0;
        tablero.setPrefHeight(totalHeight);
        tablero.setPrefWidth(totalWidth);
        tablero.setMaxHeight(totalHeight);
        tablero.setMaxWidth(totalWidth);
        tablero.setMinHeight(totalHeight);
        tablero.setMinWidth(totalWidth);

        int filas = modeloPartida.getMedidaFilas();
        int columnas = modeloPartida.getMedidaColumnas();

        for (int i = 0; i< filas; i ++) {
            RowConstraints fila = new RowConstraints();
            fila.setPrefHeight(totalHeight / filas);
            tablero.getRowConstraints().add(fila);
        }
        for(int j = 0; j < columnas; j ++){
            ColumnConstraints columna = new ColumnConstraints();
            columna.setPrefWidth(totalWidth / columnas);
            tablero.getColumnConstraints().add(columna);
        }
        for (int i = 0; i < filas;i ++ ){
            for (int j = 0;j < columnas; j++){
                Label label = new Label();
                label.setStyle("-fx-border-color: black; -fx-alignment: center");
                label.setPrefSize(totalWidth/columnas, totalHeight/filas);
                label.setId(i+"_"+j);
                tablero.add(label, j, i);
            }
        }
        setTablero(tablero);
    }
    private void inicializarTablero(){
        tableroModel = new Tablero(modeloPartida.getMedidaFilas(), modeloPartida.getMedidaColumnas());
        ListaSimple<Individuo> listaIndividuosIniciales =  tableroModel.getListaVivosIndividuos();
        AleatoriedadController aleatory = new AleatoriedadController();
        for (int i = 0; i < listaIndividuosIniciales.getNumeroElementos(); i ++){
            int fila = aleatory.generarRndInt(0, modeloPartida.getMedidaFilas());
            int columna = aleatory.generarRndInt(0, modeloPartida.getMedidaColumnas());
            Individuo individuo = listaIndividuosIniciales.get(i);
            Node node = tablero.lookup(fila+"_"+columna);
            if(node instanceof Label){
                Label label = (Label) node;
                label.setText("I");
            }
        }
    }
}
