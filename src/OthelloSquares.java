import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.geometry.HPos;
import javafx.geometry.Pos;

public class OthelloSquares extends Squares {

    private OthelloPieces piece;
    private Rectangle rect;
    
    
    public OthelloSquares(OthelloPieces piece) {
        rect = new Rectangle(100, 100, Color.MINTCREAM);
        add(rect,0,0);
        rect.setStrokeType(StrokeType.INSIDE);
        rect.setStroke(Color.NAVY);
        rect.setStrokeWidth(1);
        GridPane.setHalignment(piece, HPos.CENTER);
        addPiece(piece);
    }

    public OthelloSquares() {
        rect = new Rectangle(100, 100, Color.MINTCREAM);
        add(rect,0,0);
        rect.setStrokeType(StrokeType.INSIDE);
        rect.setStroke(Color.NAVY);
        rect.setStrokeWidth(1);
        piece = null;
    }
    
    
    public void addPiece(OthelloPieces piece) {
        this.piece = piece;
        add(this.piece, 0, 0);
    }
    
    public OthelloPieces getPiece() {
        return piece;
    }
    
    public boolean hasPiece() {
        if (piece == null) {
            return false;
        }
        
        return true;
    }
}
