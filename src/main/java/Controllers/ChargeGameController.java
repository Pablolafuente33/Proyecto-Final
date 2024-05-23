package Controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChargeGameController {
    @FXML
    protected VBox partidas;
    private Stage stage;

    public VBox getPartidas() {
        return partidas;
    }

    public Stage getStage() {
        return stage;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
