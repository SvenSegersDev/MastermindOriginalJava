import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Code {

    private HBox row = new HBox();
    private CodeColors codeColors = new CodeColors();
    private ArrayList<Cell> cellsInRow = new ArrayList<>();

    public Code(boolean isModifiable){
        for(int i = 1; i <= 4; i++){
            Cell cell = new Cell(15.0, isModifiable, Color.GRAY, codeColors);
            this.row.getChildren().add(cell.getCircle());
            this.cellsInRow.add(cell);
        }
        addToCss();
    }

    public HBox getVisualRowRepresentation(){
        return this.row;
    }

    public ArrayList<Cell> getCells(){
        return this.cellsInRow;
    }

    public CodeColors getCodeColors(){
        return this.codeColors;
    }

    public ArrayList<Color> getUserCode(){
        ArrayList<Color> listOfUserColors = new ArrayList<>();
        for(int i = 0; i <= 3; i++){
            Color color = castNodeToColor(getVisualRowRepresentation().getChildren().get(i));
            listOfUserColors.add(color);
        }
        return listOfUserColors;
    }

    public Color castNodeToColor(Node node){
        Circle circle = (Circle) node;
        return (Color) circle.getFill();
    }

    public void setColorAtIndex(Color color, int index){
        Circle circle = (Circle) getVisualRowRepresentation().getChildren().get(index);
        circle.setFill(color);
    }

    public Color getColorAtIndex(int index){
        Circle circle = (Circle) getVisualRowRepresentation().getChildren().get(index);
        return (Color) circle.getFill();
    }

    public void setRowModifiable(boolean setInteractive){
        if(setInteractive){
            for(Cell cell: getCells()){
                cell.setClickable(true);
            }
        }
        else{
            for(Cell cell: getCells()){
                cell.setClickable(false);
            }
        }
    }

    public void resetCode(){
        for(int i = 0; i <= 3; i++){
            getCells().get(i).setColor(Color.GRAY);
            getCells().get(i).setClickable(false);
        }
        codeColors.resetColors();
    }

    public void addToCss(){
        row.getStyleClass().add("row-user-code");
        for(Cell cell: cellsInRow){
            cell.getCircle().getStyleClass().add("user-code-cell");
        }
    }

}
