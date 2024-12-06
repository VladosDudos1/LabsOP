import java.awt.*;

public class Rectangle extends Figure {

    private int width, height;

    public Rectangle(int width, int height) {
        this();
        this.width = width;
        this.height = height;
        this.startPoint.setVerticalPosition(this.getRandInt(10, 750-height));
        this.startPoint.setHorizontalPosition(this.getRandInt(10, 1290-width));
    }

    protected Rectangle() {
        super();
    }
    @Override
    public void show(Graphics g) {
        g.setColor(getColor());
        g.fillRect(startPoint.getHorizontalPosition(), startPoint.getVerticalPosition(), width, height);
    }

    @Override
    public void moveTo() {
        int minBarrierX;
        int minBarrierY;
        int maxBarrierX;
        int maxBarrierY;
        if (this.startPoint.getHorizontalPosition() >= 50){
            minBarrierX = this.startPoint.getHorizontalPosition()-50;
        }
        else minBarrierX = 1;
        if (this.startPoint.getHorizontalPosition() <= 1250){
            maxBarrierX = this.startPoint.getHorizontalPosition()+50;
        }
        else maxBarrierX = 1700;
        if (this.startPoint.getVerticalPosition() >= 50){
            minBarrierY = this.startPoint.getVerticalPosition()-50;
        }
        else minBarrierY = 1;
        if (this.startPoint.getVerticalPosition() <= 750){
            maxBarrierY = this.startPoint.getVerticalPosition()+50;
        }
        else maxBarrierY = 800;
        this.startPoint.setHorizontalPosition(getRandInt(minBarrierX, maxBarrierX));
        this.startPoint.setVerticalPosition(getRandInt(minBarrierY, maxBarrierY));
    }

    public void changeLinearSize(int weight, int height) {
        this.width = weight;
        this.height = height;
    }
}
