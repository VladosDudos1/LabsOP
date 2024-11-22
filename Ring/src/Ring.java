import java.awt.*;
import java.util.Map;

public class Ring extends Circle {
    private Point additionalStartPoint;
    private int additionalRadius;

    public Ring(int radius) {
        super(radius);
        additionalRadius = (int)(radius*0.9);
        additionalStartPoint = new Point(this.startPoint.getVerticalPosition() + this.getRadius()-additionalRadius,
                this.startPoint.getHorizontalPosition() + this.getRadius()-additionalRadius);
    }

    @Override
    public void moveTo(int x, int y) {
        super.moveTo(x, y);
        additionalStartPoint = new Point(this.startPoint.getVerticalPosition() + this.getRadius()-additionalRadius,
                this.startPoint.getHorizontalPosition() + this.getRadius()-additionalRadius);
    }

    @Override
    public void setRadius(int radius) {
        super.setRadius(radius);
        additionalRadius = (int)(radius*0.9);
        additionalStartPoint = new Point(this.startPoint.getVerticalPosition() + this.getRadius()-additionalRadius,
                this.startPoint.getHorizontalPosition() + this.getRadius()-additionalRadius);
    }

    @Override
    public void show(Graphics g) {
        super.show(g);
        g.drawOval(this.additionalStartPoint.getHorizontalPosition(),
                this.additionalStartPoint.getVerticalPosition(),
                (additionalRadius * 2), (additionalRadius * 2));

    }
}
