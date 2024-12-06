import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class FigureFabric {

    public static Figure createFigure(FigureType type, Map<String, Integer> map) {
        try {
            return switch (type){
                case CIRCLE -> createCircle(map.get("radius"));
                case LINE -> createLine(map.get("length"), map.get("rotation"));
                case RING -> createRing(map.get("radius"));
                case ELLIPSE -> createEllipse(map.get("diff"));
                case RECTANGLE -> createRectangle(map.get("width"), map.get("height"));
                case TRAPEZOID -> null;
                case RHOMBUS -> null;
                default -> null;
            };
        }
        catch (Exception e) {
            return null;
        }
    }

    private static Line createLine(int length, int rotation){
        System.out.println("Создалась линия");
        return new Line(length, rotation);
    }
    private static Circle createCircle(int radius){
        System.out.println("Создался круг");
        return new Circle(radius);
    }
    private static Rectangle createRectangle(int width, int height){
        System.out.println("Создался прямоугольник");
        return new Rectangle(width, height);
    }
    private static Ring createRing(double radius){
        System.out.println("Создалость кольцо");
        return new Ring((int)radius);
    }
    private static Ellipse createEllipse(int diff){
        System.out.println("Создался эллипс");
        return new Ellipse(diff, new Random().nextInt(1, 301));
    }
    private static FourAngle createPolygon(Map<String, Integer> listPoints){
        ArrayList<Integer> horizontalPoints = new ArrayList<>();
        ArrayList<Integer> verticalPoints = new ArrayList<>();
        System.out.print(listPoints);
        for (int i = 1; i <= 4; i++){
            horizontalPoints.add(listPoints.get("x"+i));
            verticalPoints.add(listPoints.get("y"+i));
        }
        System.out.println("Создался четырёхугольник");
        return new FourAngle(horizontalPoints, verticalPoints);
    }
}
