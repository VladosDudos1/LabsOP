import java.awt.*;

public class Line extends Figure {
    private int length, rotation;
    private int verticalBarrier = 750;
    private int horizontalBarrier = 1290;
    int deltaX;
    int deltaY;
    private Point endPoint = new Point(0, 0);

    protected Line() {
        super();
    }

    public Line(int length, int rotation) {
        this();
        this.length = length;
        this.rotation = rotation;
        this.startPoint.setVerticalPosition(getRandInt(20, verticalBarrier - getLength() / 2));
        this.endPoint.setVerticalPosition((int) (this.startPoint.getVerticalPosition() + (int) (getLength() / 2) * Math.sin(Math.toRadians(getRotation()))));
        this.startPoint.setHorizontalPosition(getRandInt(10, horizontalBarrier - getLength() / 2));
        this.endPoint.setHorizontalPosition((int) (this.startPoint.getHorizontalPosition() + (int) (getLength() / 2) * Math.cos(Math.toRadians(getRotation()))));
    }

    @Override
    public void show(Graphics g) {
        g.setColor(getColor());
        g.drawLine(this.startPoint.getHorizontalPosition(), this.startPoint.getVerticalPosition(),
                this.endPoint.getHorizontalPosition(),
                this.endPoint.getVerticalPosition());
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

    @Override
    protected boolean canMove(int dx, int dy) {
        deltaX = endPoint.getHorizontalPosition() - startPoint.getHorizontalPosition();
        deltaY = endPoint.getVerticalPosition() - startPoint.getVerticalPosition();
        var newX = dx + startPoint.getHorizontalPosition();
        var newY = dy + startPoint.getVerticalPosition();
        return 1250 - (newX + deltaX) > 0 && 650 - (newY + deltaY) > 0 && newX > 0 && newY > 0;
    }

    @Override
    protected void additionalMoveSetup(int dx, int dy) {
        var newX = dx + startPoint.getHorizontalPosition();
        var newY = dy + startPoint.getVerticalPosition();
        startPoint.setHorizontalPosition(newX);
        startPoint.setVerticalPosition(newY);
        endPoint.setHorizontalPosition(newX+deltaX);
        endPoint.setVerticalPosition(newY+deltaY);
    }
}
