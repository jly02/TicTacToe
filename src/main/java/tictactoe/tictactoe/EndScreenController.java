package tictactoe.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EndScreenController {
    @FXML
    Label winnerLabel;

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
}
