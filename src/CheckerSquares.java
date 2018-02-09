import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.paint.Color;

public class CheckerSquares extends Squares {

    private CheckerPieces piece;
    private Rectangle rect;
    
    //make this a pane then add it to the groups remove from pane on press then get the square on clicked and put it back in if its a valid move i need to add a constructor to add square to pieces.
    
    public CheckerSquares(Color color, CheckerPieces piece) {
        rect = new Rectangle(100, 100, color);
        add(rect,0,0);
        rect.setStrokeType(StrokeType.INSIDE);
        addPiece(piece);
    }

    public CheckerSquares(Color color) {
        rect = new Rectangle(100, 100, color);
        rect.setStrokeType(StrokeType.INSIDE);
        add(rect,0,0);
        piece = null;
    }
    
    
    public void addPiece(CheckerPieces piece) {
        this.piece = piece;
        add(this.piece, 0, 0);
    }
    
    public CheckerPieces getPiece() {
        return piece;
    }
    
    public void removePiece() {
        getChildren().remove(this.piece);
        piece = null;
    }
    
    public boolean hasPiece() {
        if (piece == null) {
            return false;
        }
        
        return true;
    }
    
    public void select() {
        rect.setStroke(Color.GREEN);
        rect.setStrokeWidth(5);
    }
    
    public void posMove() {
        rect.setStroke(Color.HOTPINK);
        rect.setStrokeWidth(5);
    }
    
    public void deselect() {
        rect.setStrokeWidth(0);
    }
    
    public Rectangle getRect() {
        return rect;
    }
}
