package chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    ChessBoard board;
    Scene scene;
    public void start(Stage primaryStage) throws Exception {
        
        board = new ChessBoard();
        
        scene = new Scene(board, 800, 800);
        
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }

}
