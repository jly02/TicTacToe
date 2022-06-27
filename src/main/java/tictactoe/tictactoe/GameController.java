package tictactoe.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The GameController class handles all actions done by the user to the game screen.
 */
public class GameController {
    @FXML
    private Label nextTurnLabel;
    @FXML
    private Circle topLeftCircle;
    @FXML
    private Circle topMiddleCircle;
    @FXML
    private Circle topRightCircle;
    @FXML
    private Circle middleLeftCircle;
    @FXML
    private Circle middleCircle;
    @FXML
    private Circle middleRightCircle;
    @FXML
    private Circle bottomLeftCircle;
    @FXML
    private Circle bottomMiddleCircle;
    @FXML
    private Circle bottomRightCircle;
    @FXML
    private Text topLeftX;
    @FXML
    private Text topMiddleX;
    @FXML
    private Text topRightX;
    @FXML
    private Text middleLeftX;
    @FXML
    private Text middleX;
    @FXML
    private Text middleRightX;
    @FXML
    private Text bottomLeftX;
    @FXML
    private Text bottomMiddleX;
    @FXML
    private Text bottomRightX;


    /**
     * Handles a click of any button in the game screen.
     *
     * @param e action used to find what button was clicked
     */
    @FXML
    protected void handleClick(ActionEvent e) throws IOException {
        String space = ((Button) e.getSource()).getId();
        ((Button) e.getSource()).setVisible(false);
        TicTacToeGame game = TicTacToeGame.getGameObject(); // this could break, lol
        boolean nextTurnO = nextTurnLabel.getText().equals("It is O's turn to play."); // figure out which turn it is
        TicTacToeGame.State gameState = updateBoard(space, nextTurnO, game);

        // Handles the event that the game has ended
        gameEnd(e, gameState);

        if (nextTurnO) {
            nextTurnLabel.setText("It is X's turn to play.");
        } else {
            nextTurnLabel.setText("It is O's turn to play.");
        }
    }

    // Updates the visible board state.
    // Returns whether the board is full or not.
    private TicTacToeGame.State updateBoard(String space, boolean nextTurnO, TicTacToeGame game) {
        TicTacToeGame.State state = TicTacToeGame.State.BLANK;
        switch (space) {
            case "topLeft":
                state = game.takeTurn(0, 0);
                if(nextTurnO) {
                    topLeftCircle.setVisible(true);
                } else {
                    topLeftX.setVisible(true);
                }

                break;
            case "topMiddle":
                state = game.takeTurn(0, 1);
                if(nextTurnO) {
                    topMiddleCircle.setVisible(true);
                } else {
                    topMiddleX.setVisible(true);
                }

                break;
            case "topRight":
                state = game.takeTurn(0, 2);
                if(nextTurnO) {
                    topRightCircle.setVisible(true);
                } else {
                    topRightX.setVisible(true);
                }

                break;
            case "middleLeft":
                state = game.takeTurn(1, 0);
                if(nextTurnO) {
                    middleLeftCircle.setVisible(true);
                } else {
                    middleLeftX.setVisible(true);
                }

                break;
            case "middle":
                state = game.takeTurn(1, 1);
                if(nextTurnO) {
                    middleCircle.setVisible(true);
                } else {
                    middleX.setVisible(true);
                }

                break;
            case "middleRight":
                state = game.takeTurn(1, 2);
                if(nextTurnO) {
                    middleRightCircle.setVisible(true);
                } else {
                    middleRightX.setVisible(true);
                }

                break;
            case "bottomLeft":
                state = game.takeTurn(2, 0);
                if(nextTurnO) {
                    bottomLeftCircle.setVisible(true);
                } else {
                    bottomLeftX.setVisible(true);
                }

                break;
            case "bottomMiddle":
                state = game.takeTurn(2, 1);
                if(nextTurnO) {
                    bottomMiddleCircle.setVisible(true);
                } else {
                    bottomMiddleX.setVisible(true);
                }

                break;
            case "bottomRight":
                state = game.takeTurn(2, 2);
                if(nextTurnO) {
                    bottomRightCircle.setVisible(true);
                } else {
                    bottomRightX.setVisible(true);
                }

                break;
        }

        return state;
    }

    /**
     * Handles the event of the game ending.
     *
     * @param state the final state of the game
     */
    protected void gameEnd(ActionEvent e, TicTacToeGame.State state) throws IOException {
        if(state != null) {
            String winnerText = null;

            switch(state) {
                case BLANK:
                    winnerText = "It was a tie!";
                    break;
                case O:
                    winnerText = "Player O has won!";
                    break;
                case X:
                    winnerText = "Player X has won!";
                    break;
            }

            EndScreenController endScreen = new EndScreenController();
            endScreen.switchToEndScreen(e, winnerText);
        }
    }
}
