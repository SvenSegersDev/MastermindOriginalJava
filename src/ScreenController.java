import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ScreenController {

    private WelcomeScreen welcomeScreen;
    private UserGrid userGrid;
    private EndOfGameScreen endOfGameScreen;
    private GridPane mainGrid;

    public ScreenController(GridPane mainGrid){
        this.mainGrid = mainGrid;
        this.welcomeScreen = new WelcomeScreen(this);
        this.userGrid = new UserGrid(this);
        this.endOfGameScreen = new EndOfGameScreen(this);
    }

    public UserGrid getUserGrid() {
        return userGrid;
    }

    public VBox getWelcomeScreenVisual(){
        return welcomeScreen.getWelcomeScreenVisual();
    }

    public VBox getUserGridVisual(){
        return userGrid.getVerticalGrid();
    }

    public GridPane getEndOfGameScreen(){
        return endOfGameScreen.getEndOfGameScreen();
    }

    public void hideWelcomeScreen(){
        welcomeScreen.showHideWelcomeScreen(false);
    }

    public void showWelcomeScreen(){
        welcomeScreen.showHideWelcomeScreen(true);
    }

    public void hideUserGrid(){
        userGrid.showHideUserGrid(false);
    }

    public void showUserGrid(){

        userGrid.showHideUserGrid(true);
    }

    public void hideEndOfGameScreen(){
        endOfGameScreen.setEndOfGameScreenVisible(false);
    }

    public void hideAllChildren(){
        mainGrid.getChildren().forEach(node -> node.setVisible(false));
    }


}
