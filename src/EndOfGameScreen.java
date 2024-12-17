import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class EndOfGameScreen {

private Label winLossLabel = new Label("DEFAULT");
private Label newGameLabel = new Label("Start again...or whatever");
private Button newGameButton = new Button("Play again");
private Button quitToMainMenuButton = new Button("Quit");
private GridPane endOfGameScreen = new GridPane();
private ScreenController controller;

public EndOfGameScreen(ScreenController controller){
    this.controller = controller;
    this.endOfGameScreen.add(winLossLabel,0,0);
    this.endOfGameScreen.add(newGameLabel, 0,1);
    this.endOfGameScreen.add(newGameButton, 1,1);
    this.endOfGameScreen.add(quitToMainMenuButton, 1,2);
    addClickListeners();
}

public void addClickListeners(){
    newGameButton.setOnMouseClicked(mouseEvent -> {
        // resets the grid and starts over
        controller.getUserGrid().resetGrid();
        controller.hideEndOfGameScreen();
    });
    quitToMainMenuButton.setOnMouseClicked(mouseEvent -> {
        // brings the user back to the welcome screen

        controller.hideAllChildren();
        controller.showWelcomeScreen();


    });
}

    public GridPane getEndOfGameScreen() {
        return endOfGameScreen;
    }

    public void setEndOfGameScreenVisible(boolean setVisibility){
        if(setVisibility){
            getEndOfGameScreen().setVisible(true);
        }else{
            getEndOfGameScreen().setVisible(false);
        }
    }
}

