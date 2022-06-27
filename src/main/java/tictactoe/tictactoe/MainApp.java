package tictactoe.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.net.URL; //remove later

/**
 * MainApp initializes and launches the GUI.
 */
public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("game-view.fxml"));
        // If your compiler/IDE can't find the resource, use the commented out line instead.
        // FXMLLoader fxmlLoader = new FXMLLoader(new URL("file:///[filepath goes here...]/game-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("game-view.css")).toExternalForm());
        // As before, use the commented out line if the original does not work
        // scene.getStylesheets().add("file:///[filepath goes here...]/game-view.css");

        stage.setTitle("Tic-Tac-Toe");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}