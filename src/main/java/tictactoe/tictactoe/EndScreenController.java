package tictactoe.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EndScreenController {
    @FXML
    Label winnerLabel;

    /**
     * Show the winner of the game when the game has ended.
     *
     * @param winnerText the text to display based on the game's winner
     */
    protected void displayWinner(String winnerText) {
        winnerLabel.setText(winnerText);
    }
}
