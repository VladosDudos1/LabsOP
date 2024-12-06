import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Trapezoid extends FourAngle {
    private int[] arrX = {0, 0, 0, 0};
    private int[] arrY = {0, 0, 0, 0};

    public Trapezoid(int pointXLeftUp, int pointYUp, int pointXRightUp, int pointXLeftDown, int pointXRightDown, int pointYDown) {
        super();
        if (pointXLeftUp < 100)
            pointXLeftUp = 100;

        if (pointXRightUp <= pointXLeftUp)
            pointXRightUp = pointXLeftUp + 100;

        if (pointXLeftDown > pointXLeftUp)
            pointXLeftDown = pointXLeftUp - 100;

        if (pointXRightDown <= pointXRightUp)
            pointXRightDown = pointXRightUp + 100;

        if (pointYDown <= pointYUp)
            pointYDown = pointYUp + 100;

        this.arrX[0] = startPoint.getHorizontalPosition();
        this.arrX[1] = pointXRightUp;
        this.arrX[2] = pointXRightDown;
        this.arrX[3] = pointXLeftDown;
        this.arrY[0] = startPoint.getVerticalPosition();
        this.arrY[1] = startPoint.getVerticalPosition();
        this.arrY[2] = pointYDown;
        this.arrY[3] = pointYDown;
    }

    public Trapezoid() {
        super();
        this.arrX[0] = getRandInt(200, 1000);
        this.arrX[1] = getRandInt(this.arrX[0] + 50, this.arrX[0] + 250);
        this.arrX[2] = getRandInt(this.arrX[1], this.arrX[1] + 150);
        this.arrX[3] = getRandInt(this.arrX[0] - 150, this.arrX[0]);
        this.arrY[0] = getRandInt(20, 600);
        this.arrY[1] = this.arrY[0];
        this.arrY[2] = getRandInt(this.arrY[0] + 50, this.arrY[0] + 150);
        this.arrY[3] = this.arrY[2];
    }

    public void moveTo() {
        int dx = getRandInt(-100, 100);
        int dy = getRandInt(-100, 100);

        while (!canMove(dx, dy)) {
            dx = getRandInt(-100, 100);
            dy = getRandInt(-100, 100);
        }
        for (int i = 0; i < 4; i++) {
            arrX[i] += dx;
            arrY[i] += dy;
        }
    }
    private boolean canMove(int dx, int dy) {
        for (int i = 0; i < 4; i++) {
            int newX = arrX[i] + dx;
            int newY = arrY[i] + dy;

            if (newX < 0 || newX > 1250 || newY < 0 || newY > 700) {
                return false;
            }
        }
        return true;
    }

    public void changeHeight() {
        int currentHeightDifference = Math.abs(arrY[2] - arrY[0]);
        int heightChange = getRandInt(-150, 150);

        int newHeightDifference = currentHeightDifference + heightChange;

        if (newHeightDifference < 20) newHeightDifference = 20;
        if (newHeightDifference > 650) newHeightDifference = 650;

        int heightDifferenceDelta = newHeightDifference - currentHeightDifference;
        int shiftY = heightDifferenceDelta / 2;

        arrY[2] += shiftY;
        arrY[3] += shiftY;
        arrY[0] -= shiftY;
        arrY[1] -= shiftY;

        if (arrY[0] < 0) arrY[0] = 0;
        if (arrY[1] < 0) arrY[1] = 0;
        if (arrY[2] > 650) arrY[2] = 650;
        if (arrY[3] > 650) arrY[3] = 650;
    }

    @Override
    public void show(Graphics paint) {
        paint.setColor(getColor());
        paint.fillPolygon(getArrX(), getArrY(), 4);
    }

    public int[] getArrX() {
        return arrX;
    }

    public int[] getArrY() {
        return arrY;
    }
}