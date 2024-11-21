public class Point {
    private int verticalPosition;
    private int horizontalPosition;

    public Point(int verticalPosition, int horizontalPosition) {
        this.verticalPosition = verticalPosition;
        this.horizontalPosition = horizontalPosition;
    }
    public int getVerticalPosition() {
        return verticalPosition;
    }
    public int getHorizontalPosition() {
        return horizontalPosition;
    }
    public void setVerticalPosition(int verticalPosition) {
        this.verticalPosition = verticalPosition;
    }
    public void setHorizontalPosition(int horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }
}
