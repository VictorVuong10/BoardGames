import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class Othello extends GridPane {

    private Main main;
    private OthelloPieces[] flip = new OthelloPieces[8];
    private boolean up;
    private boolean leftup;
    private boolean rightup;
    private boolean left;
    private boolean right;
    private boolean down;
    private boolean leftdown;
    private boolean rightdown;
    private boolean alldown;
    private boolean allup;
    private boolean allleft;
    private boolean allright;
    
    public Othello(Main main) {
        
        this.main = main;
        
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                OthelloSquares square;
                if (col == 3 && row == 3 || col == 4 && row == 4) {
                    OthelloPieces b = new OthelloPieces(Color.INDIGO);
                    System.out.println(col);
                    square = new OthelloSquares(b);
                    
                } else if (col == 3 && row == 4 || col == 4 && row == 3) {
                    square = new OthelloSquares(new OthelloPieces(Color.HONEYDEW)); 
                } else {
                    square = new OthelloSquares();
                }       
                square.setOnMouseEntered(this::hoverOn);
                square.setOnMouseExited(this::hoverOff);
                square.setOnMouseClicked(this::place);
                add(square, col, row);
            }
        }
        
    }
    
    public void hoverOn(MouseEvent event) {
        OthelloSquares sq = (OthelloSquares) event.getSource();
        if(!sq.hasPiece()) {
            sq.over();
        }
    }
    
    public void hoverOff(MouseEvent event) {
        OthelloSquares sq = (OthelloSquares) event.getSource();
        sq.off();
    }
    
    public void place(MouseEvent event) {
        OthelloSquares sq = (OthelloSquares) event.getSource();
        if(!sq.hasPiece()) {
           int col = GridPane.getColumnIndex(sq);
           int row = GridPane.getRowIndex(sq);
           
           getAround(col, row);
           
        }
    }
    
    public void getCorner() {
        
    }
    
    public void getSide() {
        
    }
    
    public void getAround(int col, int row) {
        
//        if (row + 1 == 8) {
//            down = false;
//            leftdown = false;
//            rightdown = false;
//            alldown = false;
//        } else if (row - 1 == -1) {
//            up = false;
//            leftup = false;
//            rightup = false;
//            allup = false;
//        }
//        
//        if(col - 1 == -1) {
//            allside
//        }
        
    }
    
}
