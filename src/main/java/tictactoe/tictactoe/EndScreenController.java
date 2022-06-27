package tictactoe.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

public class EndScreenController {
    @FXML
    private Label winnerLabel;
    @FXML
    private AnchorPane scenePane;

    /**
     * Switches to the end screen.
     *
     * @param winnerText the text to be displayed
     * @param stage the window that is being changed
     * @param scene the scene to be switched to
     */
    protected void switchToEndScreen(String winnerText, Stage stage, Scene scene) {
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("game-view.css")).toExternalForm());
        stage.setTitle("Game over!");
        stage.setScene(scene);
        stage.show();
        winnerLabel.setText(winnerText);
    }

    // Exits the window.
    @FXML
    private void exitGame() {
        Stage stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
}
