import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CellCodeResult {

    private Circle circle;

    public CellCodeResult(double radius, Color defaultColor){
        this.circle = new Circle(radius);
        this.circle.setFill(defaultColor);
        this.circle.setStroke(Color.LIGHTBLUE); // Border color
        circle.setStrokeWidth(1); // Border width (in pixels)
    }

    public Circle getCircle(    ){
        return this.circle;
    }
}
