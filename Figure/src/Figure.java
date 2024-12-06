import java.awt.*;
import java.util.Map;
import java.util.Random;

public abstract class Figure {
    protected Point startPoint = new Point(0, 0);
    protected Point endPoint = new Point(0, 0);
    protected int[] color = new int[3];

    public abstract void show(Graphics g);

    public abstract void moveTo();

    protected Figure() {
        color[0] = getRandInt(0, 255);
        color[1] = getRandInt(0, 255);
        color[2] = getRandInt(0, 255);
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
