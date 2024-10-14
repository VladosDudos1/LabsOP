import java.awt.*;

public class Line extends Figure {
    private int length, rotation;
    protected Line(int horizontalPosition, int verticalPosition, Canvas canvas) {
        super(horizontalPosition, verticalPosition, canvas);
    }

    public Line(int horizontalPosition, int verticalPosition, Canvas canvas, int length) {
        this(horizontalPosition, verticalPosition, canvas);
        this.length = length;
    }
    public Line(int horizontalPosition, int verticalPosition, Canvas canvas, int length, int rotation) {
        this(horizontalPosition, verticalPosition, canvas, length);
        this.rotation = rotation;
    }
    @Override
    public void show(int x, int y) {

    }

    @Override
    void moveTo(int x, int y) {

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
