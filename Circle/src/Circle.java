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
        this.startPoint.setVerticalPosition(getRandInt(80, 650-radius*2));
    }

    protected Circle() {
        super();
    }

    @Override
    public void show(Graphics g) {
        g.setColor(getColor());
        g.drawOval(this.startPoint.getHorizontalPosition(), this.startPoint.getVerticalPosition(), getRadius()*2, getRadius()*2);
    }

    @Override
    public void moveTo() {
        var newX = getRandInt(startPoint.getHorizontalPosition()-100, startPoint.getHorizontalPosition()+100);
        var newY = getRandInt(startPoint.getVerticalPosition()-100, startPoint.getVerticalPosition()+100);
        if (newX <= 100) newX = 100;
        if (newY <= 100) newY = 100;
        if (newX > 1100-this.getRadius()*1.5) newX = 1100-(this.getRadius()*2);
        if (newY > 550-this.getRadius()*1.5) newY = 550-(this.getRadius()*2);
        this.startPoint.setHorizontalPosition(newX);
        this.startPoint.setVerticalPosition(newY);
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
}
