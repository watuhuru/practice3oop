package practice3.part1;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class RandomShapes extends JPanel {
    private abstract static class Shape {
        final int x, y, size;
        final Color color;
        Shape(int x, int y, int size, Color color) {
            this.x = x; this.y = y; this.size = size; this.color = color;
        }
        abstract void draw(Graphics2D graphics);
    }

    private static class Circle extends Shape {
        Circle(int x, int y, int size, Color color) { super(x, y, size, color); }
        void draw(Graphics2D g) { g.setColor(color); g.fillOval(x, y, size, size); }
    }

    private static class RectangleShape extends Shape {
        RectangleShape(int x, int y, int size, Color color) { super(x, y, size, color); }
        void draw(Graphics2D g) { g.setColor(color); g.fillRect(x, y, size, size * 2 / 3); }
    }

    private static class Triangle extends Shape {
        Triangle(int x, int y, int size, Color color) { super(x, y, size, color); }
        void draw(Graphics2D g) {
            g.setColor(color);
            g.fillPolygon(new int[]{x, x + size / 2, x + size},
                    new int[]{y + size, y, y + size}, 3);
        }
    }

    private final Shape[] shapes = new Shape[20];

    public RandomShapes() {
        setPreferredSize(new Dimension(700, 500));
        setBackground(Color.WHITE);
        Random random = new Random();
        for (int i = 0; i < shapes.length; i++) {
            int x = random.nextInt(610), y = random.nextInt(410), size = 30 + random.nextInt(60);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            switch (random.nextInt(3)) {
                case 0: shapes[i] = new Circle(x, y, size, color); break;
                case 1: shapes[i] = new RectangleShape(x, y, size, color); break;
                default: shapes[i] = new Triangle(x, y, size, color);
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g.create();
        for (Shape shape : shapes) shape.draw(graphics);
        graphics.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("20 случайных фигур");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new RandomShapes());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
