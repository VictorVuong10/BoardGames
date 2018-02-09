package chess;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;

public class ChessBoard extends GridPane {

    private ChessPiece selectedPiece;
    private Boolean enPassant;
    private ChessSquare enPassantSquare;
    private boolean darkSquare;
    
    public ChessBoard() {
        makeBoard();
        enPassant = false;
    }
    
//    public ChessSquare DestSquare(int x, int y) {
//        for (Node node : getChildren()) {
//            if (GridPane.getColumnIndex(node) == x && GridPane.getRowIndex(node) ==  y) {
//                destinationSquare = (ChessSquare) node;
//                return destinationSquare;
//            }
//        }
//        return null;
//       }
    
    public ChessSquare getGridSquare(int x, int y) {
        for (Node node : getChildren()) {
            if (GridPane.getColumnIndex(node) == x && GridPane.getRowIndex(node) ==  y) {
                return (ChessSquare) node;                
            }
        }
        return null;
       }
    
    public ChessSquare enPassantSquare() {
        return enPassantSquare;
    }
    
    public boolean isenPassant() {
        return enPassant;
    }
    
    public void removeEnPassant() {
        enPassantSquare = null;
        enPassant = false;
    }
    
    public boolean setEnPassant(Team team, ChessSquare destSquare) {
        int col = (int) destSquare.getCords().getX();
        int row = (int) destSquare.getCords().getY();
        ChessSquare leftSquare = null;
        ChessSquare rightSquare = null;
        
        if (col != 0) {
            leftSquare = getGridSquare(col - 1, row);
        }
        if (col != 7) {
            rightSquare = getGridSquare(col + 1, row);
        }
        
        if(leftSquare != null && rightSquare != null) {
            if(((leftSquare.hasPiece() && leftSquare.getPiece().getTeam() != team)) || ((rightSquare.hasPiece() && rightSquare.getPiece().getTeam() != team))) {
                enPassant = true;
                
        }
        } else if(leftSquare == null) {
            if((rightSquare.hasPiece() && rightSquare.getPiece().getTeam() != team)) {
                enPassant = true;
            }
            
        } else {
            if(leftSquare.hasPiece() && leftSquare.getPiece().getTeam() != team) {
                enPassant = true;
            }
        }
        
        if (enPassant) {
            if (team == Team.DARK) {
                enPassantSquare = (getGridSquare(col, row));
            } else {
                enPassantSquare = (getGridSquare(col, row));
            }
        }
        return enPassant;
    }
    
    public void selectPiece(ChessPiece piece) {
        selectedPiece = piece;
    }
    
    public ChessPiece currentPiece() {
        return selectedPiece;
    }
    
    public void deselectCurrentPiece() {
        selectedPiece = null;
    }
    
    public void makeBoard() {
        
        darkSquare = true;
        for (int row = 0; row < 8; row += 1) {
            darkSquare = !darkSquare;
            for (int col = 0; col < 8; col += 1) {
                Point2D cord = new Point2D(col, row);
                ChessSquare square;
                ChessPiece piece;
                
                if (row == 0 || row == 7) {
                    square = makeRow(cord);
                }else if (row == 1) {
                    if(!darkSquare) {
                        piece = new Pawn(Team.DARK, this);
                        square = new ChessSquare(Color.LAVENDERBLUSH, piece, this, cord);
                        darkSquare = !darkSquare;
                        piece.addSquare(square);
                    } else {
                        piece = new Pawn(Team.DARK, this);
                        square = new ChessSquare(Color.NAVY, piece, this, cord);
                        darkSquare = !darkSquare;
                        piece.addSquare(square);
                    }
                } else if (row == 6) {
                    if(!darkSquare) {
                        piece = new Pawn(Team.LIGHT, this);
                        square = new ChessSquare(Color.LAVENDERBLUSH, piece, this, cord);
                        darkSquare = !darkSquare;
                        piece.addSquare(square);
                    } else {
                        piece = new Pawn(Team.LIGHT, this);
                        square = new ChessSquare(Color.NAVY, piece, this, cord);
                        darkSquare = !darkSquare;
                        piece.addSquare(square);
                    }
                } else {
                    if(!darkSquare) {
                        square = new ChessSquare(Color.LAVENDERBLUSH, this, cord);
                        darkSquare = !darkSquare;
                    } else {
                        square = new ChessSquare(Color.NAVY, this, cord);
                        darkSquare = !darkSquare;
                    }
                }
                add(square, col, row);

            }
        }
    }
    
    public ChessSquare makeRow(Point2D cord) {
        
        ChessSquare square;
        ChessPiece piece;
        
        switch ((int) cord.getX()) {
             
            case 1:
            case 6:
                if(!darkSquare) {
                    if (cord.getY() == 0) {
                    piece = new Knight(Team.DARK, this);
                    } else {
                        piece = new Knight(Team.LIGHT, this);
                    }
                    square = new ChessSquare(Color.LAVENDERBLUSH, piece, this, cord);
                    darkSquare = !darkSquare;
                    piece.addSquare(square);
                } else {
                    if (cord.getY() == 0) {
                        piece = new Knight(Team.DARK, this);
                    } else {
                        piece = new Knight(Team.LIGHT, this);
                    }
                    square = new ChessSquare(Color.NAVY, piece, this, cord);
                    darkSquare = !darkSquare;
                    piece.addSquare(square);
                }
                break;
           default:
               if(!darkSquare) {
                   square = new ChessSquare(Color.LAVENDERBLUSH, this, cord);
                   darkSquare = !darkSquare;
               } else {
                   square = new ChessSquare(Color.NAVY, this, cord);
                   darkSquare = !darkSquare;
               }
         
        }
     return square;
    }

}
