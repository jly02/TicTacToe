package tictactoe.tictactoe;

/**
 * The TicTacToeGame class is the model that forms the basis for a game
 * of 3x3 tic-tac-toe.
 */
public class TicTacToeGame {
    private static TicTacToeGame gameObject;
    private final State[][] gameModel;
    private State nextToPlay; // false means the O player is next, true means the X player is next
    private int numMoves;

    private TicTacToeGame() {
        nextToPlay = State.O;
        numMoves = 0;
        gameModel = new State[3][3];

        for(State[] states : gameModel) {
            for(int i = 0; i < 3; i++) {
                states[i] = State.BLANK;
            }
        }
    }

    /**
     * Returns the TicTacToeGame object.
     *
     * @return the singleton instance of a TicTacToeGame object
     */
    protected static TicTacToeGame getGameObject() {
        // If not yet accessed, initialize the gameObject.
        if(gameObject == null) {
            gameObject = new TicTacToeGame();
        }

        return gameObject;
    }

    /**
     * Takes a single turn for a certain user.
     *
     * @param row the row of the space
     * @param col the column of the space
     * @return if any player won, if there was a draw, or neither
     */
    protected State takeTurn(int row, int col) {
        if(nextToPlay == State.O) {
            gameModel[row][col] = State.O;
        } else {
            gameModel[row][col] = State.X;
        }

        numMoves++;
        nextToPlay = (nextToPlay == State.O) ? State.X : State.O; // Update next player's turn

        return gameEnd();
    }

    /**
     * Returns which player has won the game, or BLANK if neither have won yet.
     *
     * @return which player has won the game, or BLANK if neither have won yet
     */
    public State gameEnd() {
        // Check if there are any wins in the rows.
        for(int row = 0; row < 3; row++) {
            if(gameModel[row][0] == gameModel[row][1] && gameModel[row][1] == gameModel[row][2]) {
                if(gameModel[row][0] != State.BLANK) {
                    return gameModel[row][0]; // return who won if all in the row are equal
                }
            }
        }

        // Check if there are any wins in the columns.
        for(int col = 0; col < 3; col++) {
            if(gameModel[0][col] == gameModel[1][col] && gameModel[1][col] == gameModel[2][col]) {
                if(gameModel[0][col] != State.BLANK) {
                    return gameModel[0][col]; // return who won if all in the column are equal
                }
            }
        }

        // Check first diagonal
        if(gameModel[0][0] == gameModel[1][1] && gameModel[1][1] == gameModel[2][2] && gameModel[0][0] != State.BLANK) {
            return gameModel[0][0];
        }

        // Check the anti-diagonal
        if(gameModel[0][2] == gameModel[1][1] && gameModel[1][1] == gameModel[2][0] && gameModel[0][2] != State.BLANK) {
            return gameModel[0][2];
        }

        // Check if there is a tie
        if(numMoves == 9) {
            return State.BLANK;
        }

        return null;
    }

    public enum State {
        BLANK, X, O
    }
}
