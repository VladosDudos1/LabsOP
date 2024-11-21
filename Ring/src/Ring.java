import java.awt.*;

public class Ring extends Circle {
    private Point additionalEndPoint;
    private int additionalRadius;

    protected Ring(int horizontalPosition, int verticalPosition) {
        super(horizontalPosition, verticalPosition);
        this.additionalRadius = (int)(this.getRadius()*0.9);
        additionalEndPoint = new Point(this.endPoint.getVerticalPosition() + this.getRadius()-this.getAdditionalRadius(),
                this.endPoint.getHorizontalPosition() + this.getRadius()-this.getAdditionalRadius());
        System.out.println("Создалось кольцо");
    }

    public Ring() {
        this(0, 0);
    }

    @Override
    public void moveTo(int x, int y){
        super.moveTo(x, y);
        additionalEndPoint = new Point(this.endPoint.getVerticalPosition() +
                this.getRadius()-this.getAdditionalRadius(),
                this.endPoint.getHorizontalPosition() +
                        this.getRadius()-this.getAdditionalRadius());
    }

    @Override
    public void show(Graphics g, int x, int y) {
        super.show(g, x, y);
        g.drawOval(this.additionalEndPoint.getHorizontalPosition(), this.additionalEndPoint.getVerticalPosition(), additionalRadius * 2, additionalRadius * 2);
    }

    public int getAdditionalRadius() {
        return additionalRadius;
    }
}
