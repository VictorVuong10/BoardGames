package chess;

import javafx.scene.image.Image;

public class Pawn extends ChessPiece{

    
    
    public Pawn(Team team, ChessBoard board) {
        firstMove = true;
        type = PieceType.PAWN;
        this.team = team;
        this.board = board;
        
        if (this.team == Team.DARK) {
            setImage(new Image("pawnDark.png"));
        } else {
            setImage(new Image("pawnlight.png"));
        }
        
    }

    @Override
    public boolean calcMove(ChessSquare dest) {
        //implement another way?? check to see if x subtracted is what is = 2 then what y subtracted is switch?
        //also make it depend it on team which ya forgot...
        
        int rowMove = (int) (dest.getCords().getY() - square.getCords().getY());
        int colMove = Math.abs((int) (dest.getCords().getX() - square.getCords().getX()));
            switch (rowMove) {
                case 1:
                    if (team == Team.LIGHT) {
                        break;
                    }
                    if (colMove == 0 && !dest.hasPiece()) {
                            return true;
                    } else if (board.isenPassant() && colMove == 1 && board.enPassantSquare().getCords().getX() == dest.getCords().getX()) {
                            capture(board.enPassantSquare());
                            return true;
                    }else if(colMove == 1 && dest.hasPiece()) {
                            return canCapture();
                    } else {
                        break;
                    }
                case 2:
                    if (team == Team.LIGHT) {
                        break;
                    }
                    if (firstMove) {
                        if (colMove != 0) {
                            break;
                        } else {
                            if (!dest.hasPiece() && !board.getGridSquare((int) dest.getCords().getX(), (int) (dest.getCords().getY() - 1)).hasPiece()) {
                                justEnPassant = board.setEnPassant(team, dest);
                                board.isenPassant();
                                return true;
                            }
                        }
                    } else {
                        break;
                    }
                case -1:
                    if (team == Team.DARK) {
                        break;
                    }
                    if (colMove == 0 && !dest.hasPiece()) {
                            return true;
                    } else if (board.isenPassant() && colMove == 1 && board.enPassantSquare().getCords().getX() == dest.getCords().getX()) {
                            capture(board.enPassantSquare());
                        return true;
                    } else if (colMove == 1 && dest.hasPiece()) {
                        return canCapture();
                    } else {
                        break;
                    }
                case -2:
                    if (team == Team.DARK) {
                        break;
                    }
                    if (firstMove) {
                        if (colMove != 0) {
                            break;
                        } else {
                            if (!dest.hasPiece() && !board.getGridSquare((int) dest.getCords().getX(), (int) (dest.getCords().getY() + 1)).hasPiece()) {
                                justEnPassant = board.setEnPassant(team, dest);
                                return true;
                            }
                        }
                    } else {
                        break;
                    }    
               default:
                   break;
            }
        return false;
        
        
        
        
        
        
//        if (team == Team.DARK && firstMove && ((dest.getCords().getY() - 2) == square.getCords().getY()
//                || (dest.getCords().getY() - 1) == square.getCords().getY())
//                && (dest.getCords().getX()) == square.getCords().getX()) {
//            firstMove = false;
//            return true;
//        } else if((dest.getCords().getY() - 1) == square.getCords().getY() 
//                && (dest.getCords().getX()) == square.getCords().getX()) {
//            return true;
//        }
//        return false;
    }
    
    
//    @Override
//    public void Move(MouseEvent e) {
//        dest = board.getGridSquare((int) (Math.floor(e.getSceneX() / 100)),
//                (int)  (Math.floor(e.getSceneY() / 100)));
//      if(calcMove(dest)) {
//          square.removePiece();
//          square = dest;
//          square.addPiece(this);
//          if(canCapture()) {
//              capture();
//          }
//          
//      } else {
//          square.centerPiece();
//      }
//    }
}
