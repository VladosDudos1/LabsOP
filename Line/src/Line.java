import java.awt.*;

public class Line extends Figure {
    private int length, rotation;
    private int verticalBarrier = 750;
    private int horizontalBarrier = 1290;
    private int maxLength;

    protected Line() {
        super();
        maxLength = (int) (Math.pow(Math.sqrt(verticalBarrier) + Math.sqrt(horizontalBarrier), 2));
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
    public void moveTo(int x, int y) {
        this.startPoint.setVerticalPosition(y);
        this.endPoint.setVerticalPosition((int) (this.startPoint.getVerticalPosition() + (int) (getLength() / 2) * Math.sin(Math.toRadians(getRotation()))));
        this.startPoint.setHorizontalPosition(x);
        this.endPoint.setHorizontalPosition((int) (this.startPoint.getHorizontalPosition() + (int) (getLength() / 2) * Math.cos(Math.toRadians(getRotation()))));
    }
    public int getLength() {
        return length;
    }

    public void changeRotation(int rotation) {
        this.rotation = rotation;
        this.endPoint.setVerticalPosition((int) (this.startPoint.getVerticalPosition() + (int) (getLength() / 2) * Math.sin(Math.toRadians(getRotation()))));
        this.endPoint.setHorizontalPosition((int) (this.startPoint.getHorizontalPosition() + (int) (getLength() / 2) * Math.cos(Math.toRadians(getRotation()))));
    }

    public int getRotation() {
        return rotation;
    }
}
