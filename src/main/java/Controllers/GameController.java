package Controllers;

import EstructurasDeDatos.ListaSimple;
import com.example.demo.Partida;
import comun.Posicion;
import constantes.Constantes;
import individuo.Individuo;
import individuo.PropertiesNuevosIndividuos;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Tablero.*;
import recurso.Recurso;

public class GameController {
    private double probAparicionNuevoRecurso = 0.25;
    private int turno;
    protected IntegerProperty medidaTurno = new SimpleIntegerProperty(0);
    @FXML
    protected Label turnoValue;
    private int maximoTurnos = 200;
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
        ListaSimple<Individuo> listaIndividuosIniciales =  modeloPartida.getListaIndividuos();
        AleatoriedadController aleatory = new AleatoriedadController();
        for (int i = 0; i < listaIndividuosIniciales.getNumeroElementos(); i ++){
            int fila = aleatory.generarRndInt(0, modeloPartida.getMedidaFilas());
            int columna = aleatory.generarRndInt(0, modeloPartida.getMedidaColumnas());
            Individuo individuo = listaIndividuosIniciales.get(i);
            Node node = tablero.lookup("#"+fila+"_"+columna);
            if(node instanceof Label){
                Label label = (Label) node;
                label.setText("I");
            }
        }
    }
    private void Bucle(){
        tableroModel.setListaVivosIndividuos(modeloPartida.getListaIndividuos());
        PropertiesNuevosIndividuos propestiesNuevosIndividuos = new PropertiesNuevosIndividuos(
                0.5, modeloPartida.getMedidaIndividuoVida(), modeloPartida.getMedidaIndividuoReproduccion(), modeloPartida.getMedidaIndividuoClonacion());

        while (tableroModel.getListaVivosIndividuos().getNumeroElementos() > 1 && turno < maximoTurnos) {
            ++turno;
            medidaTurno.setValue(turno);
            turnoValue.textProperty().bind(medidaTurno.asString());
            System.out.println("Comienza el turno: " + turno);

            // Actualización de turnos de vida de los individuos y recursos
            System.out.println(" ---> Actualización de turnos de vida");
            for (int i = 0; i < tableroModel.getFilas(); ++i) {
                for (int j = 0; j < tableroModel.getColumnas(); ++j) {
                    Casilla cas = tableroModel.getCasillaFilaColumna(i, j);
                    VidaController.actualizarTurnosVidaIndividuos(tableroModel, cas, turno);
                    VidaController.actualizarTurnosVidaRecursos(tableroModel, cas);
                }
            }

            // Movimiento de los individuos
            System.out.println(" ---> Movimiento");
            if (tableroModel.getListaVivosIndividuos() != null && !tableroModel.getListaVivosIndividuos().isVacia()) {
                for (int i = 0; i < tableroModel.getListaVivosIndividuos().getNumeroElementos(); ++i) {
                    // Fijamos la posición en el individuo
                    Individuo individuo = tableroModel.getListaVivosIndividuos().get(i);
                    Casilla casillaInd = BusquedaController.buscarIndividuo(tableroModel, individuo);
                    Posicion posicionAnterior = individuo.getPosicion();  // Guardar la posición anterior
                    individuo.setPosicion(casillaInd.getPosicion());
                    // Se fijan los recursos en el caso de que procedan
                    if ((individuo.getTipo().equals(Constantes.IND_NORMAL) || individuo.getTipo().equals(Constantes.IND_AVANZADO))
                            && individuo.getFijadoRecursoPosicion() == null) {
                        // Se fija el recurso al cual se va mover el usuario normal o avanzado.
                        RecursoController.fijarRecursoIndividuo(tableroModel, individuo);
                    }
                    // El usuario realiza la acción de movimiento
                    MovimientoController.accionMovimiento(tableroModel, individuo);
                    actualizarUIIndividuo(individuo, posicionAnterior);  // Actualiza la interfaz gráfica después del movimiento
                }
            }

            // Interacción de los recursos con los individuos
            System.out.println(" ---> Interacción recursos -- individuos");
            for (int i = 0; i < tableroModel.getFilas(); ++i) {
                for (int j = 0; j < tableroModel.getColumnas(); ++j) {
                    Casilla cas = tableroModel.getCasillaFilaColumna(i, j);
                    if (!cas.getListaIndividuos().isVacia() && !cas.getListaRecursos().isVacia()) {
                        VidaController.iteraccionIndividuoRecurso(tableroModel, cas, turno);
                    }
                }
            }

            // Reproducción y clonación
            System.out.println(" ---> Reproducción y clonación");
            for (int i = 0; i < tableroModel.getFilas(); ++i) {
                for (int j = 0; j < tableroModel.getColumnas(); ++j) {
                    Casilla cas = tableroModel.getCasillaFilaColumna(i, j);
                    ListaSimple<Individuo> nuevosIndividuos = new ListaSimple<>();

                    if (!cas.getListaIndividuos().isVacia() && cas.getListaIndividuos().getNumeroElementos() > 2) {
                        // Comprobamos qué individuos son los que se van a reproducir
                        ListaSimple<Individuo> indReproductores = new ListaSimple<>();
                        for (int k = 0; k < cas.getListaIndividuos().getNumeroElementos(); ++k) {
                            Individuo ind = cas.getListaIndividuos().get(k);
                            if (AleatoriedadController.sortearAccion(ind.getProbabilidadReproduccion())) {
                                // El individuo actual es reproductor
                                indReproductores.add(ind);
                            }
                        }
                        // Comprobamos que los individuos que se pueden reproducir sean al menos 2
                        if (indReproductores.getNumeroElementos() >= 2) {
                            // Si los 3 individuos de la casilla se pueden reproducir, se sacrifica al 3º individuo
                            if (indReproductores.getNumeroElementos() == 3) {
                                VidaController.muerteIndividuo(tableroModel, cas, indReproductores.get(2), turno);
                            }
                            // Se reproducen los dos individuos
                            Individuo nacidoInd = VidaController.reproduccionIndividuos(tableroModel, cas.getListaIndividuos().get(0),
                                    cas.getListaIndividuos().get(1), propestiesNuevosIndividuos, turno);
                            nuevosIndividuos.add(nacidoInd);
                        } else {
                            // No se reproduce ningún individuo en la casilla actual, luego todos mueren
                            ListaSimple<Individuo> indSacrificados = new ListaSimple<>();
                            indSacrificados.addAll(cas.getListaIndividuos());
                            for (int k = 0; k < indSacrificados.getNumeroElementos(); ++k) {
                                Individuo indSacr = indSacrificados.get(k);
                                VidaController.muerteIndividuo(tableroModel, cas, indSacr, turno);
                            }
                        }
                    }

                    // Se comprueba si algún individuo se clona a sí mismo
                    for (int k = 0; k < cas.getListaIndividuos().getNumeroElementos(); ++k) {
                        Individuo individuo = cas.getListaIndividuos().get(k);
                        Individuo clonadoInd = VidaController.clonacionIndividuos(tableroModel, individuo, turno);
                        if (clonadoInd != null) {
                            nuevosIndividuos.add(clonadoInd);
                        }
                    }

                    // Nacen los individuos clonados y nacidos por reproducción
                    for (int k = 0; k < nuevosIndividuos.getNumeroElementos(); ++k) {
                        Individuo nInd = nuevosIndividuos.get(k);
                        VidaController.nacimientoIndividuo(tableroModel, nInd);
                    }

                    // Se limpian hasta dejar sólo los tres individuos más jóvenes
                    if (cas.getListaIndividuos().getNumeroElementos() > 3) {
                        VidaController.limpiarViejosIndividuos(tableroModel, cas, turno);
                    }

                    // Se comprueba si en la casilla actual debe aparecer un recurso más
                    if (cas.getListaRecursos().getNumeroElementos() < 3 &&
                            AleatoriedadController.sortearAccion(probAparicionNuevoRecurso)) {
                        // Debe aparecer un nuevo recurso en esta casilla
                        Recurso nuevoRecurso = RecursoController.sortearNuevoRecurso(tableroModel.getListaRecursosUnicos());
                        VidaController.nacimientoRecurso(tableroModel, nuevoRecurso);
                    }
                }
            }
        }
    }
    private void actualizarUIIndividuo(Individuo individuo, Posicion posicionAnterior) {
        // Limpiar la antigua posición del individuo
        if (posicionAnterior != null) {
            Node nodeAnterior = tablero.lookup("#" + posicionAnterior.getX() + "_" + posicionAnterior.getY());
            if (nodeAnterior instanceof Label) {
                Label label = (Label) nodeAnterior;
                label.setText("");
            }
        }

        // Poner la 'I' en la nueva posición del individuo
        Posicion nuevaPosicion = individuo.getPosicion();
        Node nodeNueva = tablero.lookup("#" + nuevaPosicion.getX() + "_" + nuevaPosicion.getY());
        if (nodeNueva instanceof Label) {
            Label label = (Label) nodeNueva;
            label.setText("I");
        }
    }
}
