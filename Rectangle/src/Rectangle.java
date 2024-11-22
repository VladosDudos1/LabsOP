import java.awt.*;

public class Rectangle extends Figure {

    private int width, height;

    public Rectangle(int width, int height) {
        this();
        this.width = width;
        this.height = height;
        this.startPoint.setVerticalPosition(this.getRandInt(10, 750-height));
        this.startPoint.setHorizontalPosition(this.getRandInt(10, 1290-width));
    }

    protected Rectangle() {
        super();
    }
    @Override
    public void show(Graphics g) {
        g.setColor(getColor());
        g.fillRect(startPoint.getHorizontalPosition(), startPoint.getVerticalPosition(), width, height);
    }

    @Override
    public void moveTo(int x, int y) {
        this.startPoint.setHorizontalPosition(x);
        this.startPoint.setVerticalPosition(y);
    }

    public void changeLinearSize(int weight, int height) {
        this.width = weight;
        this.height = height;
    }
}
