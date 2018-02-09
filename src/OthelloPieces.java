import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class OthelloPieces extends Circle{

    private String team;
    
    public OthelloPieces(Color color) {

        if(color == Color.INDIGO) {
            team = "black";
        } else {
            team = "white";
        }
        
        setRadius(46);
        setFill(color);
        
        setOnMousePressed(this::Pressed);
        setOnMouseDragged(this::Dragged);
        setOnMouseReleased(this::Move);
        
    }
    
    public void flip() {
        if (team.equals("black")) {
            setFill(Color.HONEYDEW);
            team = "white";
        } else {
            setFill(Color.INDIGO);
            team = "black";
        }
    }
    
    public void Pressed(MouseEvent e) {
        //outline the piece
    }
    
    public void Dragged(MouseEvent e) {
        setCenterX(e.getX());
        setCenterY(e.getY());
    }
    
    public void Move(MouseEvent e) {
//        if(calcMove) {
//            
//        }
    }
    
    
}
