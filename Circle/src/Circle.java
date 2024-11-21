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
        this.endPoint.setHorizontalPosition(horizontalPosition + this.getRandInt(0, 1300 - (radius * 2) - 5));
        this.endPoint.setVerticalPosition(verticalPosition + this.getRandInt(0, 750-radius*2));
        System.out.println("Создалась окружность");
    }

    @Override
    public void show(Graphics g, int x, int y) {
        g.setColor(getColor());
        g.drawOval(this.endPoint.getHorizontalPosition(), this.endPoint.getVerticalPosition(), getRadius() * 2, getRadius() * 2);
    }

    @Override
    public void moveTo(int x, int y) {
        this.endPoint.setHorizontalPosition(x + (this.endPoint.getHorizontalPosition() - this.startPoint.getHorizontalPosition()));
        this.endPoint.setVerticalPosition(y + (this.endPoint.getVerticalPosition() - this.startPoint.getVerticalPosition()));
        this.startPoint.setHorizontalPosition(x);
        this.startPoint.setVerticalPosition(y);
    }

    public void setRadius(int radiusDelta) {
        this.radius += radiusDelta;
    }

    public int getRadius() {
        return radius;
    }
}
