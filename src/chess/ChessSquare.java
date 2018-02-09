package chess;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public class ChessSquare extends Pane {

    private ChessPiece piece;
    private Rectangle rect;
    private Point2D cord;
    
    public ChessSquare(Color color, ChessPiece piece, ChessBoard board, Point2D cord) {
        rect = new Rectangle(100, 100, color);
        setPrefSize(100,100);
        getChildren().add(rect);
        addPiece(piece);
        this.cord = cord;
    }

    public ChessSquare(Color color, ChessBoard board, Point2D cord) {
        rect = new Rectangle(100, 100, color);
        setPrefSize(100,100);
        getChildren().add(rect);
        piece = null;
        this.cord = cord;
    }
    
    
    public void addPiece(ChessPiece piece) {
        this.piece = piece;
        getChildren().add(this.piece);
        piece.layoutXProperty().bind(widthProperty().subtract(piece.fitWidthProperty()).divide(2));
        piece.layoutYProperty().bind(heightProperty().subtract(piece.fitHeightProperty()).divide(2));
        centerPiece();
    }
    
    public ChessPiece getPiece() {
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
    
    public void centerPiece() {
        piece.setX(rect.getX());
        piece.setY(rect.getY());
    }
    
    public Point2D getCords() {
        return cord;
    }
    
}
