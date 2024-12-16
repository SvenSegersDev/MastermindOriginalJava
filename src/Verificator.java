import javafx.scene.paint.Color;

public class Verificator {

   public static boolean isCodeComplete(Code userCode){
        for(int i = 0; i <= 3; i++){
            Color color = userCode.castNodeToColor(userCode.getVisualRowRepresentation().getChildren().get(i));
            if(!userCode.getCodeColors().getDefaultColors().contains(color)){
                return false;
            }
        }
        return true;
    }

    public static int getCorrectColorsInCorrectSpot(Code userCode, SecretCode secretCode){
        int output = 0;
        for(int i = 0; i <= 3; i++){
            if(userCode.getUserCode().get(i) == secretCode.getSecretCode().getColorAtIndex(i)){
                output++;
            }
        }
        return output;
    }

    public static int getCorrectColorsInWrongSpot(Code userCode, SecretCode secretCode){
        int output = 0;
        int fullyCorrectColors = getCorrectColorsInCorrectSpot(userCode, secretCode);
        int correctColors = 0;

        for(int i = 0; i <= 3; i++){
            Color color = secretCode.getSecretCode().getColorAtIndex(i);
            if(userCode.getUserCode().contains(color)){
                correctColors = correctColors + 1;
            }
        }

        output = correctColors - fullyCorrectColors;

        return output;
    }

    public static boolean isCodeCorrect(Code userCode, SecretCode secretCode){
        for(int i = 0; i <= 3; i++){
            if(userCode.getUserCode().get(i) != secretCode.getSecretCode().getUserCode().get(i)){
                return false;
            }
        }
        return true;
    }

}
