import java.awt.*;

public class Circle extends Figure {

    private int radius;

    protected Circle(Point point, int radius) {
        this();
        this.radius = radius;
        this.startPoint.setHorizontalPosition(point.getHorizontalPosition());
        this.startPoint.setVerticalPosition(point.getVerticalPosition());
    }

    public Circle(int radius) {
        this();
        this.radius = radius;
        this.startPoint.setHorizontalPosition(getRandInt(160, 1200 - (radius * 2) - 5));
        this.startPoint.setVerticalPosition(getRandInt(100, 681-radius*2));
    }

    protected Circle() {
        super();
    }

    @Override
    public void show(Graphics g) {
        g.setColor(getColor());
        g.drawOval(this.startPoint.getHorizontalPosition(), this.startPoint.getVerticalPosition(), getRadius()*2, getRadius()*2);
    }

    public void setRadius(int radius) {
        int maxRadius = Math.min((int)((1000- startPoint.getHorizontalPosition())/2), (int)((600 - startPoint.getVerticalPosition())/2));
        maxRadius = Math.min(300, maxRadius);
        if (radius < 1) {
            this.radius = 1;
        }
        else if (radius > maxRadius) {
            this.radius = maxRadius-10;
        }
        else this.radius = radius;
    }
    protected void setHardRadius(double radius){
        this.radius = (int)radius;
    }
    public int getRadius() {
        return radius;
    }


    @Override
    protected boolean canMove(int dx, int dy) {
        int newX = startPoint.getHorizontalPosition() + dx;
        int newY = startPoint.getVerticalPosition() + dy;
        return newX > 50 && newY > 50 && !(newX > 1100 - this.getRadius() * 1.5) && !(newY > 600 - this.getRadius() * 1.5);
    }

    @Override
    protected void additionalMoveSetup(int dx, int dy) {
        int newX = startPoint.getHorizontalPosition() + dx;
        int newY = startPoint.getVerticalPosition() + dy;
        this.startPoint.setHorizontalPosition(newX);
        this.startPoint.setVerticalPosition(newY);
    }
}
