import java.awt.*;

public class Rectangle extends FourAngle {

    private int width, height;

    public Rectangle(int width, int height) {
        this();
        this.width = width;
        this.height = height;
        this.startPoint.setVerticalPosition(getRandInt(10, 711-height));
        this.startPoint.setHorizontalPosition(getRandInt(10, 1211-width));
    }

    protected Rectangle() {
        super();
    }
    @Override
    public void show(Graphics g) {
        g.setColor(getColor());
        g.fillRect(startPoint.getHorizontalPosition(), startPoint.getVerticalPosition(), width, height);
    }

    public void changeLinearSize(int width, int height) {
        var maxWidth = 1290  - startPoint.getHorizontalPosition();
        var maxHeight = 750 - startPoint.getVerticalPosition();

        this.width = Math.min(width, maxWidth);
        this.height = Math.min(height, maxHeight);
    }

    @Override
    protected boolean canMove(int dx, int dy) {
        var maxX = Math.min((1290 - width), startPoint.getHorizontalPosition()+100);
        var maxY = Math.min((1290 - height), startPoint.getVerticalPosition()+100);
        return !(dx > maxX || dy > maxY || dx < 100 || dy < 100);
    }

    @Override
    protected void additionalMoveSetup(int dx, int dy) {
        var maxX = Math.min((1290 - width), startPoint.getHorizontalPosition()+100);
        var maxY = Math.min((1290 - height), startPoint.getVerticalPosition()+100);
        this.startPoint.setHorizontalPosition(getRandInt(maxX));
        this.startPoint.setVerticalPosition(getRandInt(maxY));}

    @Override
    public void moveToBasePos() {
        this.startPoint.setHorizontalPosition(20);
        this.startPoint.setVerticalPosition(20);
    }
}
