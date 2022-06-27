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
    protected void switchToEndScreen(ActionEvent e, String winnerText) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("end-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("game-view.css").toExternalForm());
        stage.setTitle("Game over!");
        stage.setScene(scene);
        stage.show();
        winnerLabel.setText(winnerText);
    }
}
