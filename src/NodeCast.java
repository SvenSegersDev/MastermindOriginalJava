import javafx.scene.shape.Circle;
import javafx.scene.Node;
import javafx.scene.paint.Color;

public class NodeCast {

    public static Circle castNodeToCircle(Node node){
        return (Circle)node;
    }

    public static Color castNodeToColor(Node node){
        Circle circle = castNodeToCircle(node);
        return (Color)circle.getFill();
    }

}
