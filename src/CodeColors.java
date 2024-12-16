import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class CodeColors {

    private ArrayList<Color> codeColors;
    private ArrayList<Color> defaultColors;

    public CodeColors(){
        resetColors();
    }

    public ArrayList<Color> getColors(){
        return this.codeColors;
    }

    public ArrayList<Color> getDefaultColors() {
        return defaultColors;
    }

    /**
     * Takes the previous color the user selected as a parameter to determine what the next color to disploy is
     * @param currentColor the color that was selected in a Circle before changing color
     * @return returns the color that is next in line based on the user input
     */
    public Color getNextColor(Color currentColor){
        if(!getColors().contains(currentColor)){
            return getColors().get(0);
        }
       int positionOfCurrentColor = getColors().indexOf(currentColor);
       int lastIndex = getColors().size() - 1;
       if(positionOfCurrentColor == lastIndex){
           return getColors().get(0);
       }
       return getColors().get(positionOfCurrentColor + 1);
    }

    public void resetColors(){
        this.codeColors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.PURPLE, Color.YELLOW));
        this.defaultColors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.PURPLE, Color.YELLOW));
    }

    public void removeColor(Color color){
        getColors().remove(color);
    }

    /**
     * Tries to add a color to the list. This can only be a valid color from the default list.
     * Will throw an exception if the Color is already present ==> if a color is set to a cell, it will be removed from this
     * list as we don't allow duplicate colors in a single row.
     * @param color
     */
    public void addColor(Color color){
        if(getColors().contains(color)){
            throw new IllegalArgumentException("The color you are trying to add already exists. This should not happen.");
        }else if(getDefaultColors().contains(color)) {
            getColors().add(color);
        }
    }


}
