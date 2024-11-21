import java.awt.*;
import java.util.Random;

public class Line extends Figure {
    private int length, rotation;
    protected Line(int horizontalPosition, int verticalPosition) {
        super(horizontalPosition, verticalPosition);
        this.length = this.getRandInt(50, 600);
        this.endPoint.setVerticalPosition(verticalPosition + this.getRandInt(20, 750));
        this.endPoint.setHorizontalPosition(horizontalPosition + this.getRandInt(10+length/2, 1290-length/2));
        System.out.println("Создалась линия");
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
        g.setColor(getColor());
        g.drawLine(this.endPoint.getHorizontalPosition()-length/2, this.endPoint.getVerticalPosition(), this.endPoint.getHorizontalPosition()+length/2, this.endPoint.getVerticalPosition());
    }

    @Override
    public void moveTo(int x, int y) {
        this.endPoint.setHorizontalPosition(x + (this.endPoint.getHorizontalPosition() - this.startPoint.getHorizontalPosition()));
        this.endPoint.setVerticalPosition(y + (this.endPoint.getHorizontalPosition() - this.startPoint.getHorizontalPosition()));
        this.startPoint.setHorizontalPosition(x);
        this.startPoint.setVerticalPosition(y);
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
