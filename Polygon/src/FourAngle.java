import java.awt.*;
import java.util.ArrayList;

public class FourAngle extends Figure {

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

    @Override
    public void show(Graphics g) {
        g.setColor(getColor());
        g.drawPolygon(horizontalPoints, verticalPoints, 4);
    }

    @Override
    public void moveTo() {
        int minBarrierX;
        int minBarrierY;
        int maxBarrierX;
        int maxBarrierY;
        if (this.startPoint.getHorizontalPosition() >= 50){
            minBarrierX = this.startPoint.getHorizontalPosition()-50;
        }
        else minBarrierX = 1;
        if (this.startPoint.getHorizontalPosition() <= 1650){
            maxBarrierX = this.startPoint.getHorizontalPosition()+50;
        }
        else maxBarrierX = 1700;
        if (this.startPoint.getVerticalPosition() >= 50){
            minBarrierY = this.startPoint.getHorizontalPosition()-50;
        }
        else minBarrierY = 1;
        if (this.startPoint.getHorizontalPosition() <= 750){
            maxBarrierY = this.startPoint.getVerticalPosition()+50;
        }
        else maxBarrierY = 800;
        this.startPoint.setHorizontalPosition(getRandInt(minBarrierX, maxBarrierX));
        this.startPoint.setVerticalPosition(getRandInt(minBarrierY, maxBarrierY));
    }

    protected void changePoint(int x, int y, int index){
        horizontalPoints[index] = x;
        verticalPoints[index] = y;
    }
}
