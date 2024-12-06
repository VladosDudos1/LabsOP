import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class FabricDialog {
    public static JDialog createListFigureDialog(JFrame frame, String title, List<JButton> buttons) {
        JDialog dialog = new JDialog(frame, title, true);
        dialog.setLayout(new FlowLayout());
        dialog.setLocationRelativeTo(frame);

        buttons.forEach(dialog::add);
        JButton closeButton = new JButton("Закрыть");
        dialog.add(closeButton);
        closeButton.addActionListener(event -> dialog.dispose());
        return dialog;
    }

    public static Map<String, Integer> getInfoFromLineDialog(JFrame frame, String title) {
        JDialog dialog = new JDialog(frame, title, true);
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel rotationLabel = new JLabel("    Угол наклона:");
        JTextField rotationField = new JTextField("0");
        JLabel lengthLabel = new JLabel("    Длина:");
        JTextField lengthField = new JTextField("1");

        JLabel errorLabel = new JLabel();

        JButton closeButton = new JButton("OK");
        closeButton.setBackground(new Color(50, 168, 80));

        Map<String, Integer> result = new HashMap<>();

        closeButton.addActionListener(event -> {
            String rotationText = rotationField.getText();
            String lengthText = lengthField.getText();
            try {
                int rotation = Integer.parseInt(rotationText);
                int length = Integer.parseInt(lengthText);
                if (length > 1250 || length < 1) {
                    errorLabel.setText("1 <= Длина <= 1250!");
                } else {
                    result.put("length", length);
                    result.put("rotation", rotation);
                    dialog.dispose();
                }
            } catch (NumberFormatException e) {
                errorLabel.setText("Введите числовые значения для угла и длины!");
            }
        });
        dialog.add(rotationLabel);
        dialog.add(rotationField);
        dialog.add(lengthLabel);
        dialog.add(lengthField);
        dialog.add(errorLabel);
        dialog.add(new JLabel());
        dialog.add(closeButton);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
        return result;
    }

    public static Map<String, Integer> getInfoFromCircleDialog(JFrame frame, String title) {
        JDialog dialog = new JDialog(frame, title, true);
        dialog.setSize(400, 150);
        dialog.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel radiusLabel = new JLabel("    Радиус:");
        JTextField radiusField = new JTextField("21");

        JLabel errorLabel = new JLabel();
        JButton closeButton = new JButton("OK");
        closeButton.setBackground(new Color(50, 168, 80));

        Map<String, Integer> result = new HashMap<>();

        closeButton.addActionListener(event -> {
            String radiusText = radiusField.getText();
            try {
                double radius = Double.parseDouble(radiusText);
                if (radius > 300 || radius < 21) {
                    errorLabel.setText("21 <= Радиус <= 300!");
                }
                else {
                    result.put("radius", (int) radius);
                    dialog.dispose();
                }
            } catch (NumberFormatException e) {
                errorLabel.setText("Введите числовые значения для радиуса!");
            }
        });
        dialog.add(radiusLabel);
        dialog.add(radiusField);
        dialog.add(errorLabel);
        dialog.add(new JLabel());
        dialog.add(closeButton);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
        return result;
    }
    public static Map<String, Integer> getInfoFromRectangleDialog(JFrame frame, String title) {
        JDialog dialog = new JDialog(frame, title, true);
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel widthLabel = new JLabel("    Ширина:");
        JTextField widthField = new JTextField("1");
        JLabel heightLabel = new JLabel("    Высота:");
        JTextField heightField = new JTextField("1");

        JLabel errorLabel = new JLabel();

        JButton closeButton = new JButton("OK");
        closeButton.setBackground(new Color(50, 168, 80));

        Map<String, Integer> result = new HashMap<>();

        closeButton.addActionListener(event -> {
            String widthText = widthField.getText();
            String heightText = heightField.getText();
            try {
                int height = Integer.parseInt(heightText);
                int width = Integer.parseInt(widthText);
                if (height > 700 || height < 1) {
                    errorLabel.setText("1 <= Высота <= 700!");
                }
                else if (width > 1250 || width < 1){
                    errorLabel.setText("1 <= Ширина <= 1250!");
                }else {
                    result.put("height", height);
                    result.put("width", width);
                    dialog.dispose();
                }
            } catch (NumberFormatException e) {
                errorLabel.setText("Введите числовые значения для высоты и ширины!");
            }
        });
        dialog.add(widthLabel);
        dialog.add(widthField);
        dialog.add(heightLabel);
        dialog.add(heightField);
        dialog.add(errorLabel);
        dialog.add(new JLabel());
        dialog.add(closeButton);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
        return result;
    }
    public static Map<String, Integer> getInfoFromEllipseDialog(JFrame frame, String title) {
        JDialog dialog = new JDialog(frame, title, true);
        dialog.setSize(400, 150);
        dialog.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel diffLabel = new JLabel("    Разница осевой:");
        JTextField diffField = new JTextField("50");

        JLabel errorLabel = new JLabel();

        JButton closeButton = new JButton("OK");
        closeButton.setBackground(new Color(50, 168, 80));

        Map<String, Integer> result = new HashMap<>();

        closeButton.addActionListener(event -> {
            String diffText = diffField.getText();
            try {
                double diff = Double.parseDouble(diffText);
                if (diff > 200 || diff < 50) {
                    errorLabel.setText("50 <= Коэффицент <= 200!");
                }
                else {
                    result.put("diff", (int) diff);
                    dialog.dispose();
                }
            } catch (NumberFormatException e) {
                errorLabel.setText("Введите числовые значения для разницы!");
            }
        });
        dialog.add(diffLabel);
        dialog.add(diffField);
        dialog.add(errorLabel);
        dialog.add(new JLabel());
        dialog.add(closeButton);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
        return result;
    }
}
