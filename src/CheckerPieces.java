import javafx.scene.shape.StrokeType;
import javafx.scene.paint.Color;

public class CheckerPieces extends Pieces {

    
    private String team;
    
    private String state;
    
    public CheckerPieces(Color color) {

        if(color == Color.BLACK) {
            team = "black";
        } else {
            team = "white";
        }
        
        setRadius(50);
        setFill(color);
        state = "man";
        
    }
    
    public String getTeam() {
        return team;
        
    }
    
    
    public void kinged() {
        state = "king";
        setStrokeType(StrokeType.INSIDE);
        setStroke(Color.RED);
        setStrokeWidth(5);
    }
    
    public boolean isKing() {
        if (state.equals("king")) {
            return true;
        }
        
        return false;
    }
    
}
