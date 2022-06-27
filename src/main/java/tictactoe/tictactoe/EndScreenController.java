package tictactoe.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EndScreenController {
    @FXML
    Label winnerLabel;

    /**
     * Switches the screen to the end screen after the game has ended.
     *
     * @param e the event source of the action
     * @param winnerText the text to be displayed
     * @throws IOException if an error occurs when loading the FXML loader
     */
    protected void switchToEndScreen(String winnerText, FXMLLoader fxmlLoader, Stage stage, Scene scene) throws IOException {
        scene.getStylesheets().add(getClass().getResource("game-view.css").toExternalForm());
        stage.setTitle("Game over!");
        stage.setScene(scene);
        stage.show();
        winnerLabel.setText(winnerText);
    }
}
