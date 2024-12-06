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
        this.startPoint.setHorizontalPosition(this.getRandInt(0, 1300 - (radius * 2) - 5));
        this.startPoint.setVerticalPosition(this.getRandInt(0, 750-radius*2));
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
        int minBarrierX;
        int minBarrierY;
        int maxBarrierX;
        int maxBarrierY;
        if (this.startPoint.getHorizontalPosition() > 100){
            minBarrierX = this.startPoint.getHorizontalPosition()-100;
        }
        else minBarrierX = 1;
        if (this.startPoint.getHorizontalPosition() < 1200-(getRadius()*2)){
            maxBarrierX = this.startPoint.getHorizontalPosition()+100;
        }
        else maxBarrierX = 1200-(getRadius()*2);
        if (this.startPoint.getVerticalPosition() > 100){
            minBarrierY = this.startPoint.getVerticalPosition()-100;
        }
        else minBarrierY = 1;
        if (this.startPoint.getVerticalPosition() < 650-(getRadius()*2)){
            maxBarrierY = this.startPoint.getVerticalPosition()+100;
        }
        else maxBarrierY = 700-(getRadius()*2);
        this.startPoint.setHorizontalPosition(getRandInt(minBarrierX, maxBarrierX));
        this.startPoint.setVerticalPosition(getRandInt(minBarrierY, maxBarrierY));
    }

    public void setRadius(int radius) {
        if (radius < 1) {
            this.radius = 1;
        }
        else if (radius > 300) {
            this.radius = 300;
        }
        else this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
