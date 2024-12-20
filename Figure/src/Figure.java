import java.awt.*;
import java.util.Random;

public abstract class Figure {
    protected Point startPoint = new Point(0, 0);
    protected int[] color = new int[3];

    public abstract void show(Graphics g);

    public void moveTo() {
        int dx = getRandInt(-100, 100);
        int dy = getRandInt(-100, 100);

        while (!canMove(dx, dy)){
            dx = getRandInt(-100, 100);
            dy = getRandInt(-100, 100);
        }
        additionalMoveSetup(dx, dy);
    }

    protected Figure() {
        color[0] = getRandInt(0, 255);
        color[1] = getRandInt(0, 255);
        color[2] = getRandInt(0, 255);
    }

    protected static int getRandInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    protected static int getRandInt(int max) {
        return new Random().nextInt(max) + 1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + startPoint.getHorizontalPosition() + " " + startPoint.getVerticalPosition();
    }
    protected Color getColor(){
        return new Color(color[0], color[1], color[2], 172);
    }
    protected abstract boolean canMove(int dx, int dy);
    protected abstract void additionalMoveSetup(int dx, int dy);
}
