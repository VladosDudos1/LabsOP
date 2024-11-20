import java.awt.*;
import java.util.Random;

public class Line extends Figure {
    private int length, rotation;
    protected Line(int horizontalPosition, int verticalPosition) {
        super(horizontalPosition, verticalPosition);
        this.length = this.getRandInt(50, 600);
        this.yDelta = verticalPosition + this.getRandInt(20, 750);
        this.xDelta = horizontalPosition + this.getRandInt(10+length/2, 1290-length/2);
    }

    public Line(int horizontalPosition, int verticalPosition, int length) {
        this(horizontalPosition, verticalPosition);
        this.length = length;
    }

    public Line(int horizontalPosition, int verticalPosition, int length, int rotation) {
        this(horizontalPosition, verticalPosition, length);
        this.rotation = rotation;
    }
    @Override
    public void show(Graphics g, int x, int y) {
        g.drawLine(xDelta-length/2, yDelta, xDelta+length/2, yDelta);
    }

    @Override
    public void moveTo(int x, int y) {
        this.xDelta = x + (xDelta - horizontalPosition);
        this.yDelta = y + (yDelta - verticalPosition);
        this.horizontalPosition = x;
        this.verticalPosition = y;
    }

    public void changeRotation(int angle) {
        rotation = angle;
    }
    public void changeLength(int lengthDelta) {
        this.length += lengthDelta;
    }
    public int getLength(){
        return length;
    }
    public int getRotation(){
        return rotation;
    }
}
