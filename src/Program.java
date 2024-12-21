import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    private static final int BUTTON_WIDTH = 300;
    private static final int BUTTON_HEIGHT = 45;
    static JFrame frame = new JFrame("4218 Chiypesh Lab");
    static JButton buttonChooseFigure = ButtonFabric.createButton("Создать фигуру");
    static JButton buttonLine = ButtonFabric.createButton("Создать линию");
    static JButton buttonRectangle = ButtonFabric.createButton("Создать прямоугольник");
    static JButton buttonCircle = ButtonFabric.createButton("Создать круг");
    static JButton buttonRing = ButtonFabric.createButton("Создать кольцо");
    static JButton buttonEllipse = ButtonFabric.createButton("Создать эллипс");
    static JButton buttonTrapezoid = ButtonFabric.createButton("Создать трапецию");
    static JButton buttonRhombus = ButtonFabric.createButton("Создать ромб");
    static JButton buttonLineFunc = ButtonFabric.createButton("Изменить линию");
    static JButton buttonRectFunc = ButtonFabric.createButton("Изменить прямоугольник");
    static JButton buttonCircleFunc = ButtonFabric.createButton("Изменить круг");
    static JButton buttonRingFunc = ButtonFabric.createButton("Изменить кольцо");
    static JButton buttonEllipseFunc = ButtonFabric.createButton("Изменить эллипс");
    static JButton buttonTrapezoidFunc = ButtonFabric.createButton("Изменить трапецию");
    static JButton buttonRhombusFunc = ButtonFabric.createButton("Изменить ромб");
    static JButton buttonRandFig = ButtonFabric.createButton("Случайная фигура");
    static JButton buttonMoveUltimate = ButtonFabric.createButton("Переместить все фигуры");
    static JButton buttonMove = ButtonFabric.createButton("Переместить фигуру");
    static JButton buttonDelete = ButtonFabric.createButton("Удалить фигуру");
    static JButton buttonClear = ButtonFabric.createButton("Очистить список");
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
        buttonLineFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 50, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonRectFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 100, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonCircleFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 150, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonRingFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 200, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonEllipseFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 250, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonTrapezoidFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 300, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonRhombusFunc.setBounds(frame.getWidth() - BUTTON_WIDTH, 350, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonRandFig.setBounds(frame.getWidth() - BUTTON_WIDTH, 400, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonMoveUltimate.setBounds(frame.getWidth() - BUTTON_WIDTH, 550, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonMove.setBounds(frame.getWidth() - BUTTON_WIDTH, 600, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonDelete.setBounds(frame.getWidth() - BUTTON_WIDTH, 650, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonClear.setBounds(frame.getWidth() - BUTTON_WIDTH, 700, BUTTON_WIDTH, BUTTON_HEIGHT);

        frame.add(buttonLineFunc);
        frame.add(buttonRectFunc);
        frame.add(buttonCircleFunc);
        frame.add(buttonRingFunc);
        frame.add(buttonEllipseFunc);
        frame.add(buttonChooseFigure);
        frame.add(buttonTrapezoidFunc);
        frame.add(buttonRhombusFunc);
        frame.add(buttonMove);
        frame.add(buttonDelete);
        frame.add(buttonClear);
        frame.add(buttonRandFig);
        frame.add(buttonMoveUltimate);
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
            Line line = (Line) FigureFabric.createFigure(FigureType.LINE, resultMap);
            addFigure(line);
        });
        buttonLineFunc.addActionListener(al -> {
            for (Figure figure : figures.reversed()) {
                if (figure instanceof Line) {
                    ((Line) figure).changeRotation(Figure.getRandInt(360));
                    drawingPanel.repaint();
                    return;
                }
            }
        });
        buttonRectangle.addActionListener(al -> {
            var resultMap = FabricDialog.getInfoFromRectangleDialog(frame, "Настройка прямоугольника");
            Rectangle rectangle = (Rectangle) FigureFabric.createFigure(FigureType.RECTANGLE, resultMap);
            addFigure(rectangle);
        });
        buttonRectFunc.addActionListener(al -> {
            for (Figure f : figures.reversed()) {
                if (f instanceof Rectangle) {
                    ((Rectangle) f).changeLinearSize(Figure.getRandInt(1300), Figure.getRandInt(700));
                    drawingPanel.repaint();
                    return;
                }
            }
        });
        buttonCircle.addActionListener(al -> {
            var resultMap = FabricDialog.getInfoFromCircleDialog(frame, "Настройка круга");
            Circle circle = (Circle) FigureFabric.createFigure(FigureType.CIRCLE, resultMap);
            addFigure(circle);
        });
        buttonCircleFunc.addActionListener(al -> {
            for (Figure figure : figures.reversed()) {
                if (figure instanceof Circle && !(figure instanceof Ring) && !(figure instanceof Ellipse)) {
                    ((Circle) figure).setRadius(Figure.getRandInt(300));
                    drawingPanel.repaint();
                    return;
                }
            }
        });
        buttonRing.addActionListener(al -> {
            var resultMap = FabricDialog.getInfoFromCircleDialog(frame, "Настройка кольца");
            Ring ring = (Ring) FigureFabric.createFigure(FigureType.RING, resultMap);
            addFigure(ring);
        });
        buttonRingFunc.addActionListener(al -> {
            for (Figure figure : figures.reversed()) {
                if (figure instanceof Ring) {
                    ((Ring) figure).setRadius(Figure.getRandInt(300));
                    drawingPanel.repaint();
                    return;
                }
            }
        });
        buttonTrapezoid.addActionListener(al -> {
            Trapezoid trapezoid = (Trapezoid) FigureFabric.createFigure(FigureType.TRAPEZOID, null);
            addFigure(trapezoid);
        });
        buttonTrapezoidFunc.addActionListener(al ->{
            for (Figure figure : figures.reversed()) {
                if (figure instanceof Trapezoid) {
                    ((Trapezoid) figure).changeHeight();
                    drawingPanel.repaint();
                    return;
                }
            }
        });
        buttonRhombus.addActionListener(al -> {
            Rhombus rhombus = (Rhombus) FigureFabric.createFigure(FigureType.RHOMBUS, null);
            addFigure(rhombus);
        });
        buttonRhombusFunc.addActionListener(al ->{
            for (Figure figure : figures.reversed()) {
                if (figure instanceof Rhombus) {
                    ((Rhombus) figure).changeDiagonals();
                    drawingPanel.repaint();
                    return;
                }
            }
        });
        buttonEllipse.addActionListener(al -> {
            var resultMap = FabricDialog.getInfoFromEllipseDialog(frame, "Настройка эллипса");
            Ellipse ellipse = (Ellipse) FigureFabric.createFigure(FigureType.ELLIPSE, resultMap);
            addFigure(ellipse);
        });
        buttonEllipseFunc.addActionListener(al -> {
            for (Figure figure : figures.reversed()) {
                if (figure instanceof Ellipse) {
                    ((Ellipse) figure).changeOrientation();
                    drawingPanel.repaint();
                    return;
                }
            }
        });

        buttonMove.addActionListener(al -> {
            figures.getLast().moveTo();
            drawingPanel.repaint();
        });
        buttonChooseFigure.addActionListener(al -> {
            dialog.setVisible(true);
        });
        buttonDelete.addActionListener(al -> {
            figures.removeLast();
            drawingPanel.repaint();
        });
        buttonClear.addActionListener(al -> {
            figures.clear();
            drawingPanel.repaint();
        });
        buttonRandFig.addActionListener(al -> {
            addFigure(FigureFabric.randomFigure(frame));
        });
        buttonMoveUltimate.addActionListener(al -> {
            for (Figure figure : figures.reversed()) {
                figure.moveToBasePos();
                drawingPanel.repaint();
            }
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
        dialog = FabricDialog.createListFigureDialog(frame, "Выберите фигуру", Arrays.asList(buttonLine, buttonRectangle, buttonCircle, buttonRing, buttonEllipse, buttonTrapezoid, buttonRhombus));
        dialog.setSize(BUTTON_WIDTH + 120, BUTTON_HEIGHT + 120);
    }

    private static void addFigure(Figure figure) {
        figures.add(figure);
        drawingPanel.repaint();
        dialog.dispose();
    }
}