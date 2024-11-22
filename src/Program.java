import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    private static final int BUTTON_WIDTH = 300;
    private static final int BUTTON_HEIGHT = 50;
    static JFrame frame = new JFrame("4218 Chiypesh Lab");
    static JButton buttonChooseFigure = new JButton("Создать фигуру");
    static JButton buttonLine = new JButton("Создать линию");
    static JButton buttonRectangle = ButtonFabric.createButton("Создать прямоугольник");
    static JButton buttonCircle = ButtonFabric.createButton("Создать круг");
    static JButton buttonRing = ButtonFabric.createButton("Создать кольцо");
    static JButton buttonEllipse = ButtonFabric.createButton("Создать эллипс");
    static JButton buttonPolygon = ButtonFabric.createButton("Создать многоугольник");
    static JButton buttonLineFunc = ButtonFabric.createButton("Изменить линию");
    static JButton buttonRectFunc = ButtonFabric.createButton("Изменить прямоугольник");
    static JButton buttonCircleFunc = ButtonFabric.createButton("Изменить круг");
    static JButton buttonRingFunc = ButtonFabric.createButton("Изменить кольцо");
    static JButton buttonEllipseFunc = ButtonFabric.createButton("Изменить эллипс");
    static JButton buttonPolygonFunc = ButtonFabric.createButton("Изменить четырёхугольник");
    static JButton buttonMove = ButtonFabric.createButton("Переместить фигуру");
    static DrawingPanel drawingPanel = new DrawingPanel();
    static ArrayList<Figure> figures = new ArrayList<>();
    static JDialog dialog;

    public static void main(String[] args) {
        setUpFrame(frame);
        setUpDialog(frame);
    }

    private static void setUpFrame(JFrame frame) {
        frame.setSize(1600, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        buttonChooseFigure.setBounds(frame.getWidth() - BUTTON_WIDTH, 0, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonLineFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 55, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonRectFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 110, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonCircleFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 165, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonRingFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 220, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonEllipseFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 275, BUTTON_WIDTH, BUTTON_HEIGHT);
//        buttonPolygonFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 330, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonMove.setBounds(frame.getWidth() - BUTTON_WIDTH, 400, BUTTON_WIDTH, BUTTON_HEIGHT);

        frame.add(buttonLineFunc);
        frame.add(buttonRectFunc);
        frame.add(buttonCircleFunc);
        frame.add(buttonRingFunc);
        frame.add(buttonEllipseFunc);
//        frame.add(buttonPolygonFunc);
        frame.add(buttonChooseFigure);
        frame.add(buttonMove);
        frame.setLayout(null);

        frame.add(drawingPanel);
        drawingPanel.setBounds(0, 0, frame.getWidth() - BUTTON_WIDTH, frame.getHeight());
        drawingPanel.setBackground(Color.WHITE);

        applyListeners();
    }

    private static void applyListeners() {
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        buttonLine.addActionListener(al -> {
            var resultMap = FabricDialog.getInfoFromLineDialog(frame, "Настройка линии");
            Line line = (Line)FigureFabric.createFigure(FigureType.LINE, resultMap);
            addFigure(line);
        });
        buttonLineFunc.addActionListener(al ->{
            figures.reversed().forEach(figure -> {
                if (figure instanceof Line) {
                    ((Line) figure).changeRotation(figure.getRandInt(360));
                    return;
                }
            });
            drawingPanel.repaint();
        });
        buttonRectangle.addActionListener(al -> {
            var resultMap = FabricDialog.getInfoFromRectangleDialog(frame, "Настройка прямоугольника");
            Rectangle rectangle = (Rectangle) FigureFabric.createFigure(FigureType.RECTANGLE, resultMap);
            addFigure(rectangle);
        });
        buttonRectFunc.addActionListener(al -> {
            figures.reversed().forEach(figure -> {
                if (figure instanceof Rectangle) {
                    ((Rectangle) figure).changeLinearSize(figure.getRandInt(1300), figure.getRandInt(700));
                    return;
                }
            });
            drawingPanel.repaint();
        });
        buttonCircle.addActionListener(al -> {
            var resultMap = FabricDialog.getInfoFromCircleDialog(frame, "Настройка круга");
            Circle circle = (Circle) FigureFabric.createFigure(FigureType.CIRCLE, resultMap);
            addFigure(circle);
        });
        buttonCircleFunc.addActionListener(al ->{
            figures.reversed().forEach(figure -> {
                if (figure instanceof Circle && !(figure instanceof Ring)&& !(figure instanceof Ellipse)) {
                    ((Circle) figure).setRadius(figure.getRandInt(360));
                    return;
                }
            });
            drawingPanel.repaint();
        });
        buttonRing.addActionListener(al -> {
            var resultMap = FabricDialog.getInfoFromCircleDialog(frame, "Настройка кольца");
            Ring ring = (Ring) FigureFabric.createFigure(FigureType.RING, resultMap);
            addFigure(ring);
        });
        buttonRingFunc.addActionListener(al ->{
            figures.reversed().forEach(figure -> {
                if (figure instanceof Ring) {
                    ((Ring) figure).setRadius(figure.getRandInt(360));
                    return;
                }
            });
            drawingPanel.repaint();
        });
        buttonEllipse.addActionListener(al -> {
            var resultMap = FabricDialog.getInfoFromEllipseDialog(frame, "Настройка эллипса");
            Ellipse ellipse = (Ellipse) FigureFabric.createFigure(FigureType.ELLIPSE, resultMap);
            addFigure(ellipse);
        });
        buttonEllipseFunc.addActionListener(al ->{
            figures.reversed().forEach(figure -> {
                if (figure instanceof Ellipse) {
                    ((Ellipse) figure).changeOrientation();
                    return;
                }
            });
            drawingPanel.repaint();
        });
//        buttonPolygon.addActionListener(al -> {
//            FourAngle fourAngle = FigureFabric.createFigure(FigureType.FOUR_ANGLE, );
//            addFigure(fourAngle);
//        });
        buttonMove.addActionListener(al ->{
            var resultMap = FabricDialog.changePointDialog(frame, "Новые координаты");
            figures.getLast().moveTo(resultMap.get("x"), resultMap.get("y"));
            drawingPanel.repaint();
        });
        buttonChooseFigure.addActionListener(al -> {
            dialog.setVisible(true);
        });
    }

    static class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Figure figure : figures) {
                figure.show(g);
            }
        }
    }

    static void setUpDialog(JFrame frame) {
        dialog = FabricDialog.createListFigureDialog(frame, "Выберите фигуру", Arrays.asList(buttonLine, buttonRectangle, buttonCircle, buttonRing, buttonEllipse, buttonPolygon));
        dialog.setSize(BUTTON_WIDTH + 120, BUTTON_HEIGHT + 100);
    }
    private static void addFigure(Figure figure) {
        figures.add(figure);
        drawingPanel.repaint();
        dialog.dispose();
    }
}