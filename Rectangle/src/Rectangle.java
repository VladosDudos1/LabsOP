import java.awt.*;

public class Rectangle extends Figure {

    private int weight, height;

    public Rectangle(int horizontalPosition, int verticalPosition, int weight, int height, Canvas canvas) {
        this(horizontalPosition, verticalPosition, canvas);
        this.weight = weight;
        this.height = height;
    }

    protected Rectangle(int horizontalPosition, int verticalPosition, Canvas canvas) {
        super(horizontalPosition, verticalPosition, canvas);
    }
    @Override
    public void show(int x, int y) {

    }

    @Override
    void moveTo(int x, int y) {

    }

    public void changeLinearSize(int weightDelta, int heightDelta) {
        this.weight += weightDelta;
        this.height += heightDelta;
    }
    public void changeLinearSize(int sizeDelta, boolean isItHeight){
        if(isItHeight) this.height += sizeDelta; else this.weight += sizeDelta;
    }
}
