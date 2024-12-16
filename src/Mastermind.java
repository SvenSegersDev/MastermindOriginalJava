import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Mastermind extends Application {

private int enabledRow;

    @Override
    public void start(Stage primaryStage) {
        //enabledRow = 0;




        Button verifyRowButton = new Button("Verify row");
        GridPane grid = new GridPane();

        ScreenController controller = new ScreenController(grid);
       //grid.add(userGrid.getVerticalGrid(), 0, 0);
      // grid.add(verifyRowButton, 0,1);
        //WelcomeScreen welcomeScreen = new WelcomeScreen();

        controller.hideUserGrid();
        Scene scene = new Scene(grid, 300, 550);

        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        grid.add(controller.getWelcomeScreenVisual(),0,0);
        grid.add(controller.getUserGridVisual(),0,0);
        grid.add(controller.getEndOfGameScreen(),0,0);
        controller.hideEndOfGameScreen();
        //scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        grid.getStyleClass().add("main-container");
        primaryStage.setTitle("Mastermind Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        /*
        System.out.println("1 --- " + getClass().getResource("/fonts/Winter Minie.ttf"));
        System.out.println("2 --- " + getClass().getResource("fonts/Winter Minie.ttf"));
        System.out.println("3 --- " + getClass().getResource("resources/fonts/Winter Minie.ttf"));
        System.out.println("4 --- " + getClass().getResource("/resources//fonts/Winter Minie.ttf"));

        if (font != null) {
            System.out.println("Font loaded successfully!");
        } else {
            System.out.println("Failed to load font.");
        }*/
        //Font font = Font.loadFont(getClass().getResourceAsStream("/fonts/Winter Minie.ttf"), 18);

        /*verifyRowButton.setOnMouseClicked(mouseEvent -> {
                if(!Verificator.isCodeComplete(userGrid.getUserRowList().get(enabledRow).getUserCode())){
                    System.out.println("The code is not complete yet...");
                }
                else{
                    int fullyCorrectColors = Verificator.getCorrectColorsInCorrectSpot(userGrid.getUserRowList().get(enabledRow).getUserCode(), userGrid.getSecretCode());
                    int correctColors = Verificator.getCorrectColorsInWrongSpot(userGrid.getUserRowList().get(enabledRow).getUserCode(), userGrid.getSecretCode())  ;
                    userGrid.getUserRowList().get(enabledRow).getCodeResult().updateColors(fullyCorrectColors, correctColors);
                    userGrid.getUserRowList().get(enabledRow).getUserCode().setRowModifiable(false);
                    enabledRow++;

                    userGrid.getUserRowList().get(enabledRow).getUserCode().setRowModifiable(true);

                }
        });*/

    }

    public static void main(String[] args) {
        launch(args);


    }

}
