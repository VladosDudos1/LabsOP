import java.awt.*;

public class FourAngle extends Figure {

    private int[] horizontalPoints;
    private int[] verticalPoints;

    protected FourAngle(int[] horizontalPoints, int[] verticalPoints) {
        super();
        this.horizontalPoints = horizontalPoints;
        this.verticalPoints = verticalPoints;
    }

    @Override
    public void show(Graphics g) {
        g.setColor(getColor());
        g.drawPolygon(horizontalPoints, verticalPoints, horizontalPoints.length);
    }

    @Override
    public void moveTo(int x, int y) {
        this.endPoint.setHorizontalPosition(x + (this.endPoint.getHorizontalPosition() - this.startPoint.getHorizontalPosition()));
        this.endPoint.setVerticalPosition(y + (this.endPoint.getVerticalPosition() - this.startPoint.getVerticalPosition()));
        this.startPoint.setHorizontalPosition(x);
        this.startPoint.setVerticalPosition(y);
    }
}
