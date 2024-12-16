import javafx.scene.text.Text;

public class InfoToUser {

    private Text outputLabel = new Text("");

    public InfoToUser(){
        addToCss();
        outputLabel.setWrappingWidth(250.0);
        outputLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
    }

    public Text getOutputLabel(){
        return  this.outputLabel;
    }

    public void setLabelText(String txt){
        outputLabel.setText(txt);
    }

    public void addToCss(){
        outputLabel.getStyleClass().add("info-label");
    }

}
