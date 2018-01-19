import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;

public class Squares extends GridPane {

    private Pieces piece;
    private Rectangle rect;
    
    
    public Squares(Color color, Pieces piece) {
        rect = new Rectangle(100, 100, color);
        add(rect,0,0);
        rect.setStrokeType(StrokeType.INSIDE);
        addPiece(piece);
    }

    public Squares(Color color) {
        rect = new Rectangle(100, 100, color);
        rect.setStrokeType(StrokeType.INSIDE);
        add(rect,0,0);
        piece = null;
    }
    
    
    public void addPiece(Pieces piece) {
        this.piece = piece;
        add(this.piece, 0, 0);
    }
    
    public Pieces getPiece() {
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
