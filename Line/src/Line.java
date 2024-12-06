import java.awt.*;
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
        int minBarrierX;
        int minBarrierY;
        int maxBarrierX;
        int maxBarrierY;
        if (Math.min(this.startPoint.getHorizontalPosition(), this.endPoint.getHorizontalPosition()) >= 50){
            minBarrierX = this.startPoint.getHorizontalPosition()-50;
        }
        else minBarrierX = 1;
        if (Math.max(this.startPoint.getHorizontalPosition(), this.endPoint.getHorizontalPosition()) <= 1250){
            maxBarrierX = this.startPoint.getHorizontalPosition()+50;
        }
        else maxBarrierX = 1700;
        if (Math.min(this.startPoint.getVerticalPosition(), this.endPoint.getVerticalPosition()) >= 50){
            minBarrierY = this.startPoint.getVerticalPosition()-50;
        }
        else minBarrierY = 1;
        if (Math.max(this.startPoint.getVerticalPosition(), this.endPoint.getVerticalPosition()) <= 750){
            maxBarrierY = this.startPoint.getVerticalPosition()+50;
        }
        else maxBarrierY = 800;
        this.startPoint.setHorizontalPosition(getRandInt(minBarrierX, maxBarrierX));
        this.startPoint.setVerticalPosition(getRandInt(minBarrierY, maxBarrierY));
        this.endPoint.setVerticalPosition((int) (this.startPoint.getVerticalPosition() + (int) (getLength() / 2) * Math.sin(Math.toRadians(getRotation()))));
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
