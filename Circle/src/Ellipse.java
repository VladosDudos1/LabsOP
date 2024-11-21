import java.awt.*;

public class Ellipse extends Circle {

    private Orientation orientation;
    private double diff;

    public Ellipse() {
        this(0, 0);
    }

    public Ellipse(int x, int y) {
        super(x, y);
        this.diff = (double) (getRandInt(80, 160) - 1) /100;
        this.orientation = Orientation.VERTICAL;
        if (getRandInt(2) % 2 == 0) changeOrientation();
    }

    public void show(Graphics g, int x, int y) {
        g.setColor(getColor());
        if (orientation == Orientation.HORIZONTAL) {
            g.drawOval(this.endPoint.getHorizontalPosition(), this.endPoint.getVerticalPosition(), getRadius() * 2, (int) (getRadius() * diff));
        } else {
            g.drawOval(this.endPoint.getHorizontalPosition(), this.endPoint.getVerticalPosition(), (int) (getRadius() * diff), getRadius() * 2);
        }
    }

    protected void changeOrientation() {
        if (this.orientation == Orientation.HORIZONTAL) {
            this.orientation = Orientation.VERTICAL;
        }
        else this.orientation = Orientation.HORIZONTAL;
    }

    public void moveTo(int x, int y) {
        this.endPoint.setHorizontalPosition(x + (this.endPoint.getHorizontalPosition() - this.startPoint.getHorizontalPosition()));
        this.endPoint.setVerticalPosition(y + (this.endPoint.getVerticalPosition() - this.startPoint.getVerticalPosition()));
        this.startPoint.setHorizontalPosition(x);
        this.startPoint.setVerticalPosition(y);
    }
}
