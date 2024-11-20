import java.awt.*;
import java.util.Map;
import java.util.Random;

public abstract class Figure {
    protected int horizontalPosition = 0;
    protected int verticalPosition = 0;
    protected int yDelta;
    protected int xDelta;

    public abstract void show(Graphics g, int x, int y);

    public abstract void moveTo(int x, int y);

    protected Figure(int horizontalPosition, int verticalPosition) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getVerticalPosition() {
        return verticalPosition;
    }

    public void show(Graphics g) {
        show(g, 0, 0);
    }
    protected int getRandInt(int min, int max) {
        return new Random().nextInt(max-min+1)+min;
    }
    protected int getRandInt(int max) {
        return new Random().nextInt(max)+1;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + this.horizontalPosition + "   " + this.verticalPosition;
    }
}
