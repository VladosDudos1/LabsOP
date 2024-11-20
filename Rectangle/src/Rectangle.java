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
        this.yDelta = verticalPosition + this.getRandInt(10, 750-height);
        this.xDelta = horizontalPosition + this.getRandInt(10, 1290-width);
    }
    @Override
    public void show(Graphics g, int x, int y) {
        g.drawRect(xDelta, yDelta, width, height);
    }

    @Override
    public void moveTo(int x, int y) {
        this.xDelta = x + (xDelta - horizontalPosition);
        this.yDelta = y + (yDelta - verticalPosition);
        this.horizontalPosition = x;
        this.verticalPosition = y;
    }

    public void changeLinearSize(int weightDelta, int heightDelta) {
        this.width += weightDelta;
        this.height += heightDelta;
    }
    public void changeLinearSize(int sizeDelta, boolean isItHeight){
        if(isItHeight) this.height += sizeDelta; else this.width += sizeDelta;
    }
}
