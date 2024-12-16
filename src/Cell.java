import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cell {

    private Circle circle = new Circle();
    private CodeColors codeColors;

    /**
     *
     * @param radius holds the radius of the circle for displaying on screen
     * @param isClickable parameter used to differentiate between a cell that needs to be interactive
     *                  ==> a cell can only be interactive if the user is currently working on that specific row
     *                  ==> a cell is not interactive when it's the secret code OR the result panel on the right as those are static
     * @param color the default color with which the circle is initiated
     * @param codeColors a reference to the CodeColors object to be able to look for next color, removing and adding colors
     */
    public Cell(double radius, boolean isClickable, Color color, CodeColors codeColors){
        this.circle.setFill(color);
        this.circle.setRadius(radius);
        this.circle.setStroke(Color.LIGHTBLUE); // Border color
        this.circle.setStrokeWidth(1); // Border width (in pixels)
        if(isClickable){
            addClickListener();
        }
        this.codeColors = codeColors;
    }

    /**
     * @return the current Color of the circle object. Returned as a JavaFX Color object.
     */
    public Color getColor(){
        return (Color) getCircle().getFill();
    }

    /**
     * @return the Circle object from the JavaFX library which is used for the visual aspect
     */
    public Circle getCircle(){
        return this.circle;
    }

    /**
     * Adds or removes the event listener on the Circle object. Only user input cells (when using the current
     * guessing row) are interactive. If the Circle is part of the secret code, a finalized row, a future row
     * or the result fields, the Circle is NOT interactive
     * @param allowClick passed in the constructor at first to indicate if the cicle is interactive or not
     */
    public void setClickable(boolean allowClick){
        if(allowClick){
            addClickListener();
        }else{
            removeClickListener();
        }
    }

    /**
     * Sets the Color of the circle object
     * @param color color to apply to the Circle
     */
    public void setColor(Color color){
        getCircle().setFill(color);
    }

    /**
     * Adds an event listener to the Circle object and the corresponding logic
     */
    public void addClickListener(){
        getCircle().setOnMouseClicked(mouseEvent -> {
            Color oldColor = getColor();
            Color newColor = codeColors.getNextColor(getColor());
            setColor(newColor);
            codeColors.removeColor(newColor);
            codeColors.addColor(oldColor);
        });
    }

    /**
     * removes the event listener of the Cell/Circle object turning it into an static Circle/Cell
     */
    public void removeClickListener(){
        getCircle().setOnMouseClicked(null);
    }

}
