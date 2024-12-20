import java.awt.*;
import java.util.Map;

public class Ring extends Circle {
    private Circle innerCircle;

    public Ring(int radius) {
        super(radius);
        innerCircle = new Circle(new Point(this.startPoint.getVerticalPosition() + this.getRadius() - (int)(this.getRadius()*0.9),
                this.startPoint.getHorizontalPosition() + this.getRadius() - (int)(this.getRadius()*0.9)), (int) (radius * 0.9));
    }

    @Override
    public void setRadius(int radius) {
        super.setRadius(radius);
        innerCircle.setHardRadius(this.getRadius()*0.9);
        innerCircle.startPoint = new Point(this.startPoint.getVerticalPosition() + this.getRadius() - innerCircle.getRadius(),
                this.startPoint.getHorizontalPosition() + this.getRadius() - innerCircle.getRadius());
    }

    @Override
    public void show(Graphics g) {
        super.show(g);
        g.drawOval(innerCircle.startPoint.getHorizontalPosition(),
                innerCircle.startPoint.getVerticalPosition(),
                (innerCircle.getRadius() * 2), (innerCircle.getRadius() * 2));

    }

    @Override
    protected void additionalMoveSetup(int dx, int dy) {
        super.additionalMoveSetup(dx, dy);
        innerCircle.startPoint = new Point(this.startPoint.getVerticalPosition() + this.getRadius() - innerCircle.getRadius(),
                this.startPoint.getHorizontalPosition() + this.getRadius() - innerCircle.getRadius());
    }
}
