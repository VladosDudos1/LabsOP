import java.awt.*;
import java.util.Map;
import java.util.Random;

public abstract class Figure {
    protected Point startPoint;
    protected Point endPoint;
    protected int[] color = new int[3];

    public abstract void show(Graphics g, int x, int y);

    public abstract void moveTo(int x, int y);

    protected Figure(int horizontalPosition, int verticalPosition) {
        startPoint = new Point(horizontalPosition, verticalPosition);
        endPoint = startPoint;
        color[0] = getRandInt(0, 255);
        color[1] = getRandInt(0, 255);
        color[2] = getRandInt(0, 255);
    }

    public int getHorizontalPosition() {
        return startPoint.getHorizontalPosition();
    }

    public int getVerticalPosition() {
        return startPoint.getVerticalPosition();
    }

    public void show(Graphics g) {
        show(g, 0, 0);
    }

    protected int getRandInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    protected int getRandInt(int max) {
        return new Random().nextInt(max) + 1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + startPoint.getHorizontalPosition() + " " + startPoint.getVerticalPosition();
    }
    protected Color getColor(){
        return new Color(color[0], color[1], color[2], 172);
    }
}
