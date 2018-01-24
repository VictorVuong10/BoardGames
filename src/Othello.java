import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;

public class Othello extends GridPane {

    private Main main;
    
    public Othello(Main main) {
        
        this.main = main;
        
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                OthelloSquares square;
                if (col == 3 && row == 3 || col == 4 && row == 4) {
                    square = new OthelloSquares(new OthelloPieces(Color.BLACK));
                } else if (col == 3 && row == 4 || col == 4 && row == 3) {
                    square = new OthelloSquares(new OthelloPieces(Color.CHARTREUSE)); 
                } else {
                    square = new OthelloSquares();
                }
                        square.setOnMouseClicked(this::move);
                        add(square, col, row);
            }
        }
    }
    
        
    
    public void move(MouseEvent event) {
    
    }
    
}
