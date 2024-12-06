import java.awt.*;

public class Ellipse extends Circle {

    private Orientation orientation;
    private double diff;

    public Ellipse(int diff, int radius) {
        this(radius);
        this.setRadius(getRandInt(50, 250));
        this.diff = ((double) diff)/100;
    }

    public Ellipse(int radius) {
        super(radius);
        this.orientation = Orientation.VERTICAL;
    }

    public void show(Graphics g) {
        g.setColor(getColor());
        if (orientation == Orientation.HORIZONTAL) {
            g.drawOval(this.startPoint.getHorizontalPosition()-(getRadius()/2), this.startPoint.getVerticalPosition()-(getRadius()/2), getRadius() * 2, (int) (getRadius() * diff));
        } else {
            g.drawOval(this.startPoint.getHorizontalPosition() - (getRadius()/2), this.startPoint.getVerticalPosition() - (getRadius()/2), (int) (getRadius() * diff), getRadius() * 2);
        }
    }

    @Override
    public void moveTo() {
        var newX = getRandInt(startPoint.getHorizontalPosition()-100, startPoint.getHorizontalPosition()+100);
        var newY = getRandInt(startPoint.getVerticalPosition()-100, startPoint.getVerticalPosition()+100);
        if (newX <= 100) newX = 100;
        if (newY <= 100) newY = 100;
        if (newX > 1200-this.getRadius()*1.2) newX = 1200-this.getRadius();
        if (newY > 600-this.getRadius()*1.2) newY = 600-this.getRadius();
        this.startPoint.setHorizontalPosition(newX);
        this.startPoint.setVerticalPosition(newY);
    }

    protected void changeOrientation() {
        if (this.orientation == Orientation.HORIZONTAL) {
            this.orientation = Orientation.VERTICAL;
        }
        else this.orientation = Orientation.HORIZONTAL;
    }
}
