import java.awt.*;

public class Rhombus extends FourAngle {

    private Point[] vertices = new Point[4];

    public Rhombus() {
        super();
        int centerX = getRandInt(100, 1150);
        int centerY = getRandInt(100, 550);
        int halfDiagonal1 = getRandInt(50, 150);
        int halfDiagonal2 = getRandInt(50, 150);

        vertices[0] = new Point(centerY - halfDiagonal1, centerX);
        vertices[1] = new Point(centerY, centerX + halfDiagonal2);
        vertices[2] = new Point(centerY + halfDiagonal1, centerX);
        vertices[3] = new Point(centerY, centerX - halfDiagonal2);
    }

    @Override
    public void show(Graphics g) {
        int[] arrX = new int[4];
        int[] arrY = new int[4];
        for (int i = 0; i < 4; i++) {
            arrX[i] = vertices[i].getHorizontalPosition();
            arrY[i] = vertices[i].getVerticalPosition();
        }
        g.setColor(getColor());
        g.fillPolygon(arrX, arrY, 4);
    }

    @Override
    public void moveTo() {
        int dx = getRandInt(-100, 100);
        int dy = getRandInt(-100, 100);

        for (Point vertex : vertices) {
            int newX = vertex.getHorizontalPosition() + dx;
            int newY = vertex.getVerticalPosition() + dy;

            if (newX < 0) dx = Math.max(dx, -vertex.getHorizontalPosition());
            if (newX > 1250) dx = Math.min(dx, 1250 - vertex.getHorizontalPosition());
            if (newY < 0) dy = Math.max(dy, -vertex.getVerticalPosition());
            if (newY > 650) dy = Math.min(dy, 650 - vertex.getVerticalPosition());
        }
        for (Point vertex : vertices) {
            vertex.setHorizontalPosition(vertex.getHorizontalPosition() + dx);
            vertex.setVerticalPosition(vertex.getVerticalPosition() + dy);
        }
    }

    public void changeDiagonals() {
        int d1Change = getRandInt(-100, 100);
        int d2Change = getRandInt(-100, 100);

        int centerX = (vertices[0].getHorizontalPosition() + vertices[2].getHorizontalPosition()) / 2;
        int centerY = (vertices[0].getVerticalPosition() + vertices[2].getVerticalPosition()) / 2;

        int newHalfDiagonal1 = Math.max(50, Math.min(150, (vertices[2].getVerticalPosition() - vertices[0].getVerticalPosition()) / 2 + d1Change / 2));
        int newHalfDiagonal2 = Math.max(50, Math.min(150, (vertices[1].getHorizontalPosition() - vertices[3].getHorizontalPosition()) / 2 + d2Change / 2));

        vertices[0].setVerticalPosition(centerY - newHalfDiagonal1);
        vertices[0].setHorizontalPosition(centerX);

        vertices[1].setVerticalPosition(centerY);
        vertices[1].setHorizontalPosition(centerX + newHalfDiagonal2);

        vertices[2].setVerticalPosition(centerY + newHalfDiagonal1);
        vertices[2].setHorizontalPosition(centerX);

        vertices[3].setVerticalPosition(centerY);
        vertices[3].setHorizontalPosition(centerX - newHalfDiagonal2);
    }
}