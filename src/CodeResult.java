import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class CodeResult {

    private GridPane resultGrid = new GridPane();
    private ArrayList<CellCodeResult> resultCellsList = new ArrayList<>();

    public CodeResult(){
       for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                CellCodeResult resultCell = new CellCodeResult(7.5, Color.BROWN);
                resultGrid.add(resultCell.getCircle(), col, row);
                resultCellsList.add(resultCell);
            }
        }
        addToCss();
    }

   public GridPane getResultGrid(){
        return this.resultGrid;
    }

    public void updateColors(int correctColorsCorrectSpot, int correctColorsWrongSpot){
        int start = 0;
        for(int i = 0; i <= correctColorsCorrectSpot -1 ; i++){
            setColorAtPosition(i, Color.BLACK);
            start = start + 1;
        }
        int stop = start + correctColorsWrongSpot - 1;
        for(int x = start; x <= stop; x++){
            setColorAtPosition(x, Color.WHITE);
        }
    }

    public void setColorAtPosition(int index, Color color){
        Circle circle = NodeCast.castNodeToCircle(getResultGrid().getChildren().get(index));
        circle.setFill(color);
    }

    public void resetResult(){
        for(int i = 0 ; i <= 3; i++){
            setColorAtPosition(i, Color.BROWN);
        }
    }

    public void addToCss(){
        resultGrid.getStyleClass().add("result-grid");
    }


}
