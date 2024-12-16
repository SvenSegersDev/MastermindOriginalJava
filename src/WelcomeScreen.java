import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WelcomeScreen {

    private VBox welcomeScreen = new VBox();
    private HBox horizontalButtonContainer = new HBox();
    private ScreenController controller;
    private Button newGameButton = new Button("PLAY");;
    private Button quitGameButton = new Button("QUIT");;
    private Label welcomeText = new Label("Welcome\n    to\nMastermind");;



    public WelcomeScreen(ScreenController controller){
        this.controller = controller;
        addListeners();

        welcomeScreen.getChildren().add(0, welcomeText);
        horizontalButtonContainer.getChildren().add(0,newGameButton);
        horizontalButtonContainer.getChildren().add(1, quitGameButton);
    welcomeScreen.getChildren().add(1,horizontalButtonContainer);
        addToCss();
    }

    public VBox getWelcomeScreenVisual(){
        return welcomeScreen;
    }



    public void showHideWelcomeScreen(boolean show){
        if(show) {
            welcomeScreen.setVisible(true);
        }else{
            welcomeScreen.setVisible(false);
        }

    }

    public void addToCss(){
        welcomeScreen.getStyleClass().add("ws-vbox-container");
        horizontalButtonContainer.getStyleClass().add("ws-hbox-button-container");
        welcomeText.getStyleClass().add("ws-welcome-text");
        newGameButton.getStyleClass().add("ws-new-game-button");
        quitGameButton.getStyleClass().add("ws-quit-game-button");
    }

    public void addListeners(){
        newGameButton.setOnMouseClicked(mouseEvent -> {
            controller.getUserGrid().resetGrid();
            controller.hideWelcomeScreen();
            controller.showUserGrid();
        });

        quitGameButton.setOnMouseClicked(mouseEvent -> {
            Platform.exit();
        });
    }

}
