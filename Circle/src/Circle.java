import java.awt.*;

public class Circle extends Figure{

    private int radius;

    public Circle(int horizontalPosition, int verticalPosition, int radius, Canvas canvas) {
        this(horizontalPosition, verticalPosition, canvas);
        this.radius = radius;
    }

    protected Circle(int horizontalPosition, int verticalPosition, Canvas canvas) {
        super(horizontalPosition, verticalPosition, canvas);
    }
    @Override
    public void show(int x, int y) {

    }

    @Override
    void moveTo(int x, int y) {

    }

    public void setRadius(int radiusDelta) {
        this.radius += radiusDelta;
    }
    public int getRadius() {
        return radius;
    }
}
