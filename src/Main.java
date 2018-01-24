import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class Main extends Application {

    private Check checkers;
    private Group game;
    private Othello othello;
    int appHeight;
    int appWidth;
    Button button;
    Button button2;
    @Override
    public void start(Stage primaryStage) throws Exception {
        checkers = new Check(this);
        othello = new Othello(this);
        appWidth = 800;
        appHeight = 800;
        Text welcome = new Text(400, 150, "WELCOME\n\n Pick a game");
        welcome.setFill(Color.WHITE);
        button = new Button("Checkers");
        button2 = new Button("Othello");
        game = new Group();
        button.relocate(100,200);
        button2.relocate(300,200);
        game.getChildren().add(welcome);
        game.getChildren().add(button);
        game.getChildren().add(button2);
        button.setOnAction(this::game);
        button2.setOnAction(this::game);
        Scene scene = new Scene(game, appWidth, appHeight, Color.BLACK);

        primaryStage.setTitle("Board Games");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void game(ActionEvent event) {
        game.getChildren().clear();
        if (event.getSource() == button) {
        game.getChildren().add(checkers);
        } else if (event.getSource() == button2) {
            game.getChildren().add(othello);
        }
    }
    
    
    private void replayC(ActionEvent event) {
        checkers.reset();
        game.getChildren().clear();
        game.getChildren().add(checkers);
    }
    
    public void getWinner() {
        if (checkers.winner().equals("white")) {
            game.getChildren().clear();
            Text winner = new Text(400, 150, "White is winner");
            winner.setFill(Color.WHITE);
            game.getChildren().add(winner);
            Button replay = new Button("Replay");
            replay.relocate(100,200);
            game.getChildren().add(replay);
            replay.setOnAction(this::replayC);
        } else if (checkers.winner().equals("black")) {
            game.getChildren().clear();
            Text winner = new Text(400, 150, "Black is winner");
            winner.setFill(Color.WHITE);
            game.getChildren().add(winner);
            Button replay = new Button("Replay");
            replay.relocate(100,200);
            game.getChildren().add(replay);
            replay.setOnAction(this::replayC);
        }
        
    }
    

    public static void main(String[] args) {
        launch(args);

    }

}
