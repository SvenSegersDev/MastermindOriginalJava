import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Mastermind extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button verifyRowButton = new Button("Verify row");
        GridPane grid = new GridPane();

        ScreenController controller = new ScreenController(grid);

        controller.hideUserGrid();
        Scene scene = new Scene(grid, 300, 550);

        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        grid.add(controller.getWelcomeScreenVisual(),0,0);
        grid.add(controller.getUserGridVisual(),0,0);
        grid.add(controller.getEndOfGameScreen(),0,0);
        controller.hideEndOfGameScreen();
        grid.getStyleClass().add("main-container");
        primaryStage.setTitle("Mastermind Game");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
