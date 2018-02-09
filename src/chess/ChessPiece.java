package chess;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
//import javafx.scene.Group;
//import javafx.scene.Node;

public abstract class ChessPiece extends ImageView {

    protected Team team;
    protected boolean selected;
    protected ChessSquare square;
    protected ChessBoard board;
    protected ChessSquare dest;
    protected boolean firstMove;
    protected PieceType type;
    protected boolean justEnPassant;
    
    public ChessPiece() {
        
        setOnMousePressed(this::Pressed);
        setOnMouseDragged(this::Dragged);
        setOnMouseReleased(this::Move);
        setFitHeight(90);
        setFitWidth(90);
        justEnPassant = false;
    }
    
    abstract public boolean calcMove(ChessSquare dest);
    
    final public void Pressed(MouseEvent e) {
        square.toFront();
        board.selectPiece(this);

    }
    
    final public void Dragged(MouseEvent e) {
        
        setX(e.getX() - 45);
        setY(e.getY() - 45);
        
        //add it tosquare, then remove from the square, add to group higher than a gridpane to make it dragable? or auto add to the group..??? so that it is dragable. so its in group and in square, but not in grid pane?// or not use gridpane at all
        //and use a group? wiht a 2d array????
    }
    
    final public void addSquare(ChessSquare square) {
        this.square = square;
    }
    
    final public ChessSquare getSquare() {
        return square;
    }
    
//    public void Move(MouseEvent e) {
////        if(calcMove) {
////            
////        }
//        board.setDestSquare((int) (Math.floor(e.getSceneX() / 100)), (int)  (Math.floor(e.getSceneY() / 100)) );
//        square.removePiece();
//        square = board.getDestSquare();
//        square.addPiece(this);
//
//        
//    }
    
     final public void Move(MouseEvent e) {
      dest = board.getGridSquare((int) (Math.floor(e.getSceneX() / 100)),
              (int)  (Math.floor(e.getSceneY() / 100)));
        if(calcMove(dest)) {
            square.removePiece();
            square = dest;
            square.addPiece(this);
            firstMove = false;
            if(justEnPassant) {
                justEnPassant = false;
            }else if (!justEnPassant && board.isenPassant()) {
                board.removeEnPassant();
            }
            
        } else {
            square.centerPiece();
        }
        
    }
    
    final public boolean canCapture() {
        ChessPiece eatable = dest.getPiece();
        
        if(eatable.getTeam() == team) {
            return false;
        }
        
        capture(dest);
        
        return true;
        
    }
    
    final public void capture(ChessSquare captureSquare) {
        captureSquare.removePiece();
        //add it to the side or something later.....
    }
    
    final public Team getTeam() {
        return team;
    }
 
    final public PieceType getType() {
        return type;
    }
    
}
