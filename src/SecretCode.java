import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class SecretCode {

    private Code secretCode = new Code(false);

    public  SecretCode(){
        ArrayList<Color> colors = createSecretCode();
        for(int i = 0; i <= 3; i++){
            this.secretCode.setColorAtIndex(colors.get(i), i);
        }
        displaySecretCode(false);
        addToCss();
    }

    public HBox getSecretCodeVisual(){
        return secretCode.getVisualRowRepresentation();
    }

    public static ArrayList<Color> createSecretCode(){
        Random random = new Random();
       // boolean foundFour = false;
        int counter = 0;
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        int randomInt;
        // Generate a random integer between 0 and 5 (inclusive)
        while(counter <= 3){
            randomInt = random.nextInt(6);
            if(!listOfIntegers.contains(randomInt)){
                counter++;
                listOfIntegers.add(randomInt);
            }
        }
        CodeColors colors = new CodeColors();
        ArrayList<Color> outputColors = new ArrayList<>();
        for(Integer item: listOfIntegers){
            Color color = colors.getColors().get(item);
            outputColors.add(color);
        }
        return outputColors;
    }

    public Code getSecretCode(){
        return this.secretCode;
    }

    public void displaySecretCode(boolean displayCode){
        if(displayCode){
            this.secretCode.getVisualRowRepresentation().getChildren().forEach(child -> child.setVisible(true));
        }else{
            this.secretCode.getVisualRowRepresentation().getChildren().forEach(child -> child.setVisible(false));
        }
    }

    public void addToCss(){
        secretCode.getVisualRowRepresentation().getStyleClass().add("secret-code");
    }


}
