package chess;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Knight extends ChessPiece{

    
    public Knight(Team team, ChessBoard board) {
        type = PieceType.KNIGHT;
        this.team = team;
        this.board = board;
        
        if (this.team == Team.DARK) {
            setImage(new Image("KnightDark.png"));
        } else {
            setImage(new Image("Knightlight.png"));
        }
    }
    
    @Override
    public boolean calcMove(ChessSquare dest) {
        
        Point2D newCords = dest.getCords().subtract(square.getCords());
        
        if (Math.abs(newCords.getX()) + Math.abs(newCords.getY()) == 3 
                && newCords.getX() != 0 && newCords.getY() != 0) {
            if(dest.hasPiece()) {
                if(dest.getPiece().getTeam() != team) {
                    return canCapture();
                }
                    
            } else {
                return true;
            }
        }
        return false;
    }

}
