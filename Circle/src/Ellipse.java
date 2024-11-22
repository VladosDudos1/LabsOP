import java.awt.*;

public class Ellipse extends Circle {

    private Orientation orientation;
    private double diff;

    public Ellipse(int diff, int radius) {
        this(radius);
        this.setRadius(getRandInt(300));
        this.diff = ((double) diff)/100;
        if (getRandInt(2) % 2 == 0) changeOrientation();
    }

    public Ellipse(int radius) {
        super(radius);
        this.orientation = Orientation.VERTICAL;
    }

    public void show(Graphics g) {
        g.setColor(getColor());
        if (orientation == Orientation.HORIZONTAL) {
            g.drawOval(this.startPoint.getHorizontalPosition(), this.startPoint.getVerticalPosition(), getRadius() * 2, (int) (getRadius() * diff));
        } else {
            g.drawOval(this.startPoint.getHorizontalPosition(), this.startPoint.getVerticalPosition(), (int) (getRadius() * diff), getRadius() * 2);
        }
    }

    protected void changeOrientation() {
        if (this.orientation == Orientation.HORIZONTAL) {
            this.orientation = Orientation.VERTICAL;
        }
        else this.orientation = Orientation.HORIZONTAL;
    }
}
