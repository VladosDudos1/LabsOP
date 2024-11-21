import java.awt.*;

public class Rectangle extends Figure {

    private int width, height;

    public Rectangle(int horizontalPosition, int verticalPosition, int width, int height) {
        this(horizontalPosition, verticalPosition);
        this.width = width;
        this.height = height;
    }

    protected Rectangle(int horizontalPosition, int verticalPosition) {
        super(horizontalPosition, verticalPosition);
        this.width = this.getRandInt(20, 500);
        this.height = this.getRandInt(20, 500);
        this.endPoint.setVerticalPosition(verticalPosition + this.getRandInt(10, 750-height));
        this.endPoint.setHorizontalPosition(horizontalPosition + this.getRandInt(10, 1290-width));
        System.out.println("Создался прямоугольник");
    }
    @Override
    public void show(Graphics g, int x, int y) {
        g.setColor(getColor());
        g.fillRect(endPoint.getHorizontalPosition(), endPoint.getVerticalPosition(), width, height);
    }

    @Override
    public void moveTo(int x, int y) {
        this.endPoint.setHorizontalPosition(x + (this.endPoint.getHorizontalPosition() - this.startPoint.getHorizontalPosition()));
        this.endPoint.setVerticalPosition(y + (this.endPoint.getVerticalPosition() - this.startPoint.getVerticalPosition()));
        this.startPoint.setHorizontalPosition(x);
        this.startPoint.setVerticalPosition(y);
    }

    public void changeLinearSize(int weightDelta, int heightDelta) {
        this.width += weightDelta;
        this.height += heightDelta;
    }
    public void changeLinearSize(int sizeDelta, boolean isItHeight){
        if(isItHeight) this.height += sizeDelta; else this.width += sizeDelta;
    }
}
