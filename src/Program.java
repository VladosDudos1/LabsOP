import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Program {
    private static final int BUTTON_WIDTH = 300;
    private static final int BUTTON_HEIGHT = 50;
    static JFrame frame = new JFrame("4218 Chiypesh Lab");
    static JButton buttonLine = new JButton("Создать линию");
    static JButton buttonRectangle = new JButton("Создать прямоугольник");
    static JButton buttonCircle = new JButton("Создать круг");
    static DrawingPanel drawingPanel = new DrawingPanel();
    static ArrayList<Figure> figures = new ArrayList<>();

    public static void main(String[] args) {
        setUpFrame(frame);
    }

    private static void setUpFrame(JFrame frame) {
        frame.setSize(1600, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        buttonLine.setBounds(frame.getWidth()-BUTTON_WIDTH, 0, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonRectangle.setBounds(frame.getWidth()-BUTTON_WIDTH, 55, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonCircle.setBounds(frame.getWidth()-BUTTON_WIDTH, 110, BUTTON_WIDTH, BUTTON_HEIGHT);

        applyListeners();

        frame.setLayout(null);
        frame.add(buttonLine);
        frame.add(buttonRectangle);
        frame.add(buttonCircle);

        frame.add(drawingPanel);
        drawingPanel.setBounds(0, 0, frame.getWidth()-BUTTON_WIDTH, frame.getHeight());
        drawingPanel.setBackground(Color.WHITE);
    }

    private static void applyListeners() {
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        buttonLine.addActionListener(al -> {
            Line line = (Line) createFigure(FigureType.LINE);
            figures.add(line);
            drawingPanel.repaint();
        });
        buttonRectangle.addActionListener(al -> {
            Rectangle rectangle = (Rectangle) createFigure(FigureType.RECTANGLE);
            figures.add(rectangle);
            drawingPanel.repaint();
        });
        buttonCircle.addActionListener(al -> {
            Circle circle = (Circle) createFigure(FigureType.CIRCLE);
            figures.add(circle);
            drawingPanel.repaint();
        });
    }

    private static Figure createFigure(FigureType type) {
        return switch (type) {
            case CIRCLE -> new Circle(0, 0);
            case LINE -> new Line(0, 0);
            case RECTANGLE -> new Rectangle(0, 0);
        };
    }

    static class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Figure figure : figures) {
                figure.show(g, figure.getHorizontalPosition(), figure.getVerticalPosition());
            }
        }
    }
}