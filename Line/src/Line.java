import java.awt.*;
import java.awt.Point;

public class Line extends Figure {
    private int length, rotation;
    private int verticalBarrier = 750;
    private int horizontalBarrier = 1290;

    protected Line() {
        super();
    }

    public Line(int length, int rotation) {
        this();
        this.length = length;
        this.rotation = rotation;
        this.startPoint.setVerticalPosition(this.getRandInt(20, verticalBarrier - getLength() / 2));
        this.endPoint.setVerticalPosition((int) (this.startPoint.getVerticalPosition() + (int) (getLength() / 2) * Math.sin(Math.toRadians(getRotation()))));
        this.startPoint.setHorizontalPosition(this.getRandInt(10, horizontalBarrier - getLength() / 2));
        this.endPoint.setHorizontalPosition((int) (this.startPoint.getHorizontalPosition() + (int) (getLength() / 2) * Math.cos(Math.toRadians(getRotation()))));
    }

    @Override
    public void show(Graphics g) {
        g.setColor(getColor());
        g.drawLine(this.startPoint.getHorizontalPosition(), this.startPoint.getVerticalPosition(),
                this.endPoint.getHorizontalPosition(),
                this.endPoint.getVerticalPosition());
    }

    @Override
    public void moveTo() {
        var deltaX = endPoint.getHorizontalPosition() - startPoint.getHorizontalPosition();
        var deltaY = endPoint.getVerticalPosition() - startPoint.getVerticalPosition();
        var newX = getRandInt(Math.max(50, startPoint.getHorizontalPosition()-100), Math.min(1250, startPoint.getHorizontalPosition()+100));
        if (1250 - (newX+deltaX) <= 0) newX = Math.abs(1250 - (newX+deltaX));
        var newY = getRandInt(Math.max(50, startPoint.getVerticalPosition()-100), Math.min(650, startPoint.getVerticalPosition()+100));
        if (650 - (newY+deltaY) <= 0) newY = Math.abs(650 - (newY+deltaY));

        startPoint.setHorizontalPosition(newX);
        startPoint.setVerticalPosition(newY);
        endPoint.setHorizontalPosition(newX+deltaX);
        endPoint.setVerticalPosition(newY+deltaY);
    }

    public int getLength() {
        return length;
    }

    public void changeRotation(int rotation) {
        this.rotation = rotation;
        var newY = (int) (this.startPoint.getVerticalPosition() + (int) (getLength() / 2) * Math.sin(Math.toRadians(getRotation())));
        var newX = (int) (this.startPoint.getHorizontalPosition() + (int) (getLength() / 2) * Math.cos(Math.toRadians(getRotation())));
        if (newX < 10) {
            startPoint.setHorizontalPosition(startPoint.getHorizontalPosition() + Math.abs(newX) + 10);
            newX = 10;
        } else if (newX > 1250) {
            startPoint.setHorizontalPosition(startPoint.getHorizontalPosition() - (newX - 1250));
            newX = 1250;
        }
        if (newY < 10) {
            startPoint.setVerticalPosition(startPoint.getVerticalPosition() + Math.abs(newY) + 10);
            newY = 10;
        } else if (newY > 600) {
            startPoint.setVerticalPosition(startPoint.getVerticalPosition() - (newY - 600));
            newY = 600;
        }
        this.endPoint.setVerticalPosition(newY);
        this.endPoint.setHorizontalPosition(newX);

        var semipoint = startPoint;
        if (endPoint.getHorizontalPosition() < startPoint.getHorizontalPosition()) {
            startPoint = endPoint;
            endPoint = semipoint;
        }
    }

    public int getRotation() {
        return rotation;
    }
}
