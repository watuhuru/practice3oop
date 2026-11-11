package practice3.part3;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import javax.swing.*;

public class TextEditor extends JFrame {
    private final JTextArea text = new JTextArea(10, 40);

    public TextEditor() {
        super("Текстовый редактор");
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("Файл");
        JMenu edit = new JMenu("Правка");
        JMenu help = new JMenu("Справка");
        JMenuItem save = new JMenuItem("Сохранить");
        JMenuItem exit = new JMenuItem("Выйти");
        JMenuItem copy = new JMenuItem("Копировать");
        JMenuItem cut = new JMenuItem("Вырезать");
        JMenuItem paste = new JMenuItem("Вставить");
        JMenuItem about = new JMenuItem("О программе");
        save.addActionListener(e -> saveText());
        exit.addActionListener(e -> dispose());
        copy.addActionListener(e -> text.copy());
        cut.addActionListener(e -> text.cut());
        paste.addActionListener(e -> text.paste());
        about.addActionListener(e -> JOptionPane.showMessageDialog(this, "Простой текстовый редактор"));
        file.add(save); file.add(exit);
        edit.add(copy); edit.add(cut); edit.add(paste);
        help.add(about);
        menuBar.add(file); menuBar.add(edit); menuBar.add(help);
        setJMenuBar(menuBar);

        JButton clear = new JButton("Очистить");
        JButton select = new JButton("Выделить всё");
        clear.addActionListener(e -> text.setText(""));
        select.addActionListener(e -> { text.requestFocusInWindow(); text.selectAll(); });
        JPanel buttons = new JPanel();
        buttons.add(clear); buttons.add(select);
        add(buttons, BorderLayout.NORTH);
        add(new JScrollPane(text), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void saveText() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                Files.write(chooser.getSelectedFile().toPath(), text.getText().getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Не удалось сохранить файл: " + e.getMessage(),
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextEditor().setVisible(true));
    }
}
