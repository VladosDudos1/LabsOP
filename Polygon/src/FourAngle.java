import java.awt.*;
import java.util.ArrayList;

public abstract class FourAngle extends Figure {

    private int[] horizontalPoints;
    private int[] verticalPoints;

    protected FourAngle(ArrayList<Integer> horizontalPoints, ArrayList<Integer> verticalPoints) {
        super();
        this.horizontalPoints = horizontalPoints.stream().mapToInt(i -> i).toArray();
        this.verticalPoints = verticalPoints.stream().mapToInt(i -> i).toArray();
        this.startPoint.setHorizontalPosition(this.horizontalPoints[0]);
        this.startPoint.setVerticalPosition(this.verticalPoints[0]);
    }
    protected FourAngle() {
        super();
    }
}
