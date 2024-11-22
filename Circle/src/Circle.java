import java.awt.*;

public class Circle extends Figure {

    private int radius;

    public Circle(int radius) {
        this();
        this.radius = radius;
        this.startPoint.setHorizontalPosition(this.getRandInt(0, 1300 - (radius * 2) - 5));
        this.startPoint.setVerticalPosition(this.getRandInt(0, 750-radius*2));
    }

    protected Circle() {
        super();
    }

    @Override
    public void show(Graphics g) {
        g.setColor(getColor());
        g.drawOval(this.startPoint.getHorizontalPosition(), this.startPoint.getVerticalPosition(), getRadius()*2, getRadius()*2);
    }

    @Override
    public void moveTo(int x, int y) {
        this.startPoint.setHorizontalPosition(x);
        this.startPoint.setVerticalPosition(y);
    }

    public void setRadius(int radius) {
        if (radius < 1) {
            this.radius = 1;
        }
        else if (radius > 300) {
            this.radius = 300;
        }
        else this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
