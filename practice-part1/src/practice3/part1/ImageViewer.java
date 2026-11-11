package practice3.part1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageViewer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Укажите путь к изображению в аргументах запуска.");
            return;
        }
        try {
            BufferedImage image = ImageIO.read(new File(args[0]));
            if (image == null) {
                System.out.println("Неподдерживаемый формат изображения.");
                return;
            }
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Изображение");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(new JLabel(new ImageIcon(image))));
                frame.setSize(700, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
        } catch (IOException e) {
            System.out.println("Не удалось открыть изображение: " + e.getMessage());
        }
    }
}
