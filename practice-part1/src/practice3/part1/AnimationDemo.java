package practice3.part1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AnimationDemo extends JPanel {
    private final List<BufferedImage> frames;
    private int currentFrame;

    private AnimationDemo(List<BufferedImage> frames) {
        this.frames = frames;
        setPreferredSize(new Dimension(500, 300));
        new Timer(100, e -> {
            currentFrame = (currentFrame + 1) % frames.size();
            repaint();
        }).start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(frames.get(currentFrame), 0, 0, getWidth(), getHeight(), this);
    }

    private static List<BufferedImage> sampleFrames() {
        List<BufferedImage> frames = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            BufferedImage frame = new BufferedImage(500, 300, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = frame.createGraphics();
            g.setColor(Color.WHITE); g.fillRect(0, 0, 500, 300);
            g.setColor(new Color(65, 120, 200)); g.fillOval(20 + i * 18, 100, 60, 60);
            g.dispose();
            frames.add(frame);
        }
        return frames;
    }

    public static void main(String[] args) {
        List<BufferedImage> frames = new ArrayList<>();
        try {
            if (args.length == 0) frames = sampleFrames();
            else for (String path : args) {
                BufferedImage frame = ImageIO.read(new File(path));
                if (frame == null) throw new IOException("Неподдерживаемое изображение: " + path);
                frames.add(frame);
            }
        } catch (IOException e) {
            System.out.println("Не удалось открыть кадр: " + e.getMessage());
            return;
        }
        final List<BufferedImage> readyFrames = frames;
        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame("Покадровая анимация");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.add(new AnimationDemo(readyFrames));
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        });
    }
}
