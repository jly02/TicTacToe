package tictactoe.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * The GameController class handles all actions done by the user to the game screen.
 */
public class GameController {
    /**
     * Handles a click of any button in the game screen.
     *
     * @param e action used to find what button was clicked
     */
    @FXML
    protected void handleClick(ActionEvent e) {
        String s = ((Button) e.getSource()).getId();
    }
}
