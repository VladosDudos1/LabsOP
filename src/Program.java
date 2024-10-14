import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Program {
    static Frame frame = new Frame("4218 Chiypesh Lab");
    static Canvas canvas = new Canvas();

    public static void main(String[] args) {
        setUpCanvas(canvas);
        setUpFrame(frame, canvas);
    }

    private static void setUpFrame(Frame frame, Canvas canvas) {
        frame.add(canvas);
        frame.setSize(canvas.getWidth(), canvas.getHeight());
        frame.setVisible(true);
        frame.setResizable(false);
        applyListeners();
    }

    private static void setUpCanvas(Canvas canvas) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        canvas.setSize((int) (screenSize.width * 0.7), (int) (screenSize.height * 0.7));
        canvas.setBackground(Color.WHITE);
    }

    private static void applyListeners() {
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private static Figure createFigure(FigureType type, Canvas canvas, int horizontalPosition, int verticalPosition) {
        switch (type) {
            case CIRCLE: {

            }
            case LINE: {

            }
            case RECTANGLE: {

            }
            default: {
                return null;
            }
        }
    }
}
