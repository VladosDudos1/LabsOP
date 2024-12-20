import java.awt.*;

public class Ellipse extends Circle {

    private Orientation orientation;
    private double diff;

    public Ellipse(int diff, int radius) {
        this(radius);
        this.setRadius(getRandInt(80, 250));
        this.diff = ((double) diff)/100;
    }

    public Ellipse(int radius) {
        super(radius);
        this.orientation = Orientation.VERTICAL;
    }

    public void show(Graphics g) {
        g.setColor(getColor());
        if (orientation == Orientation.HORIZONTAL) {
            g.drawOval(this.startPoint.getHorizontalPosition()-(getRadius()/2), this.startPoint.getVerticalPosition()-(int)(getRadius()/1.5), getRadius() * 2, (int) (getRadius() * diff));
        } else {
            g.drawOval(this.startPoint.getHorizontalPosition() - (getRadius()/2), this.startPoint.getVerticalPosition() - (int)(getRadius()/1.5), (int) (getRadius() * diff), getRadius() * 2);
        }
    }

    protected void changeOrientation() {
        if (this.orientation == Orientation.HORIZONTAL) {
            this.orientation = Orientation.VERTICAL;
        }
        else this.orientation = Orientation.HORIZONTAL;
    }

    @Override
    protected boolean canMove(int dx, int dy) {
        int newX = startPoint.getHorizontalPosition() + dx;
        int newY = startPoint.getVerticalPosition() + dy;
        return newX > 100 && newY > 100 && !(newX > 1100 - this.getRadius() * 1.2) && !(newY > 550 - this.getRadius() * 1.2);
    }
}
