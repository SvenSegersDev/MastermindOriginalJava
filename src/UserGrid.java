import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class UserGrid {

    private VBox verticalGrid = new VBox();
    private ArrayList<UserRow> userRowList = new ArrayList<>();
    private SecretCode secretCode;
    private HBox secretOverLay = new HBox();
    private ScreenController controller;
    private HBox buttonsBox = new HBox();
    private Button verifyRow = new Button("CHECK");
    private Button quitToWelcomeScreen= new Button("QUIT");
    private int enabledRow = 0;
    private HBox infoContainer = new HBox();
    private InfoToUser informationLabel = new InfoToUser();

    public UserGrid(ScreenController controller){
         this.controller = controller;

         verifyRow.setOnMouseClicked(mouseEvent -> {
            handleClickOnVerifyButton();
        });
        quitToWelcomeScreen.setOnMouseClicked(mouseEvent -> {
            handleClickOnQuitButton();
        });

        initializeGrid();
        addToCss();
    }

    public void initializeGrid(){
        infoContainer.getChildren().add(informationLabel.getOutputLabel());
        verticalGrid.getChildren().add(infoContainer);
        informationLabel.setLabelText("Let's start guessing !");
        UserRow userRow = new UserRow(true);
        verticalGrid.getChildren().add(userRow.getUserRowHBox());
        userRowList.add(userRow);
        for(int i = 0; i <= 8; i++){
            userRow = new UserRow(false);
            verticalGrid.getChildren().add(userRow.getUserRowHBox());
            userRowList.add(userRow);
        }
        this.secretCode = new SecretCode();
        verticalGrid.getChildren().add(secretCode.getSecretCodeVisual());
        secretCode.displaySecretCode(true);
        buttonsBox.getChildren().add(verifyRow);
        buttonsBox.getChildren().add(quitToWelcomeScreen);
        verticalGrid.getChildren().add(buttonsBox);
    }

    public void handleClickOnQuitButton(){
        controller.hideUserGrid();
        controller.getUserGrid().resetGrid();
        controller.showWelcomeScreen();
    }

    public void handleClickOnVerifyButton() {
        Code userCode = getUserRowList().get(enabledRow).getUserCode();

        //todo ==> not sure but here we need to check the current row inputted by the user
        if (!Verificator.isCodeComplete(getUserRowList().get(enabledRow).getUserCode())) {
            informationLabel.setLabelText("Complete the row before clicking the check button...");
        } else {
            int correctColors = Verificator.getCorrectColorsInCorrectSpot(userCode, secretCode);
            int otherCorrect = Verificator.getCorrectColorsInWrongSpot(userCode, secretCode);
            userRowList.get(enabledRow).getCodeResult().updateColors(correctColors, otherCorrect);
            userRowList.get(enabledRow).getUserCode().setRowModifiable(false);
            if (Verificator.isCodeCorrect(userCode, secretCode)) {
                //todo --> implement handling when the game is WON
                // display the end of game screen
                //controller.showEndOfGameScreen(true);
                informationLabel.setLabelText("You have cracked the code !");
                secretCode.displaySecretCode(true);
                // todo ==> this includes a reset of the grid AND of the secret code
                System.out.println("The game is over...");
            } else {
                if (getEnabledRow() == 9) {
                    //todo END OF GAME - YOU LOST
                    //controller.showEndOfGameScreen(false);
                    informationLabel.setLabelText("Too bad. You did not crack the code.");
                    secretCode.displaySecretCode(true);
                } else {
                    informationLabel.setLabelText("You have " + correctColors + " colors in the right spot and " + otherCorrect + " correct colors in the wrong spot");
                    increaseEnabledRow();
                    getUserRowList().get(enabledRow).getUserCode().setRowModifiable(true);
                }
            }
        }
    }

    public int getEnabledRow(){
        return enabledRow;
    }

    public void increaseEnabledRow(){
        if(enabledRow <= 8) {
            enabledRow = enabledRow + 1;
        }
    }

    public VBox getVerticalGrid(){
        return  this.verticalGrid;
    }

    public ArrayList<UserRow> getUserRowList() {
        return userRowList;
    }

    public void showHideUserGrid(boolean show){
        if(show){
            verticalGrid.setVisible(true);
        }else{
            verticalGrid.setVisible(false);
        }
    }

    public void resetGrid(){
        this.enabledRow = 0;
        for(int i = 0; i <= 9; i++){
            userRowList.get(i).resetUserRow();

        }
        userRowList.get(0).getUserCode().setRowModifiable(true);
        secretCode.displaySecretCode(false);
        informationLabel.setLabelText("Let's start guessing !");
    }

    public void addToCss(){
        buttonsBox.getStyleClass().add("grid-buttons-box");
        verticalGrid.getStyleClass().add("ug-main-container-vbox");
        verifyRow.getStyleClass().add("verify-row-button");
        quitToWelcomeScreen.getStyleClass().add("quit-to-main-menu-button");
        secretOverLay.getStyleClass().add("secret-overlay");
        infoContainer.getStyleClass().add("info-container");
    }
}
