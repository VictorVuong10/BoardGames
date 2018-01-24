import javafx.scene.paint.Color;

public class OthelloPieces extends Pieces{

    private String team;
    
    public OthelloPieces(Color color) {

        if(color == Color.BLACK) {
            team = "black";
        } else {
            team = "white";
        }
        
        setRadius(46);
        setFill(color);
    }
    
    public void flip() {
        if (team.equals("black")) {
            setFill(Color.WHITE);
            team = "white";
        } else {
            setFill(Color.BLACK);
            team = "black";
        }
    }
}
