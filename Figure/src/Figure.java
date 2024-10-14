import java.awt.*;
import java.util.Map;

public abstract class Figure {
    protected int horizontalPosition = 0;
    protected int verticalPosition = 0;
    protected Graphics2D paint;
    public abstract void show(int x, int y);
    abstract void moveTo(int x, int y);

    protected Figure(int horizontalPosition, int verticalPosition, Canvas canvas) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
    }
    public int getHorizontalPosition() {
        return horizontalPosition;
    }
    public int getVerticalPosition() {
        return verticalPosition;
    }

    public void show(){
        show(0, 0);
    }
}
