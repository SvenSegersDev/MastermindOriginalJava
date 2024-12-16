import javafx.scene.layout.HBox;

public class UserRow {

    private HBox userRowHBox = new HBox();
    private Code userCode;
    private CodeResult codeResult = new CodeResult();

    /**
     * This is the combination of a Code and a Result item in 1 horizontal box
     */
    public UserRow(boolean isModifiable){
        this.userCode = new Code( isModifiable);
        userRowHBox.getChildren().add(userCode.getVisualRowRepresentation());
        userRowHBox.getChildren().add(codeResult.getResultGrid());
        addToCss();
    }

    public Code getUserCode(){
        return this.userCode;
    }

    public CodeResult getCodeResult(){
        return this.codeResult;
    }

    public HBox getUserRowHBox(){
        return this.userRowHBox;
    }

    public void resetUserRow(){
        this.userCode.resetCode();
        this.codeResult.resetResult();
    }

    public void addToCss(){
        userRowHBox.getStyleClass().add("userrow-hbox");
    }

}
