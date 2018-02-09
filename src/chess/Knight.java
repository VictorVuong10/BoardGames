package chess;

import javafx.scene.image.Image;

public class Knight extends ChessPiece{

    
    public Knight(Team team, ChessBoard board) {
        firstMove = true;
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
        //something like dest cords subtract orig cords then add the x and y and that equals three then other calcs;
        return false;
    }

}
