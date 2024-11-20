import java.awt.*;

public class Circle extends Figure {

    private int radius;

    public Circle(int horizontalPosition, int verticalPosition, int radius) {
        this(horizontalPosition, verticalPosition);
        this.radius = radius;
    }

    protected Circle(int horizontalPosition, int verticalPosition) {
        super(horizontalPosition, verticalPosition);
        this.radius = getRandInt(5, 299);
        this.xDelta = horizontalPosition + this.getRandInt(0, 1300 - (radius * 2) - 5);
        this.yDelta = verticalPosition + this.getRandInt(0, 750-radius*2);
    }

    @Override
    public void show(Graphics g, int x, int y) {
        g.drawOval(xDelta, yDelta, radius * 2, radius * 2);
        if (radius > 250) {
            System.out.println(radius);
            System.out.println(yDelta);
        }
    }

    @Override
    public void moveTo(int x, int y) {

    }

    public void setRadius(int radiusDelta) {
        this.radius += radiusDelta;
    }

    public int getRadius() {
        return radius;
    }
}
