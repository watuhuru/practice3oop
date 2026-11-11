package practice3.part3;

import java.awt.*;
import javax.swing.*;

public class TwoNumberCalculator extends JFrame {
    private final JTextField first = new JTextField(10);
    private final JTextField second = new JTextField(10);
    private final JLabel result = new JLabel("Результат: ");

    public TwoNumberCalculator() {
        super("Калькулятор двух чисел");
        setLayout(new FlowLayout());
        add(new JLabel("Первое число:"));
        add(first);
        add(new JLabel("Второе число:"));
        add(second);
        for (String op : new String[]{"+", "-", "*", "/"}) {
            JButton button = new JButton(op);
            button.addActionListener(e -> calculate(op));
            add(button);
        }
        add(result);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 190);
        setLocationRelativeTo(null);
    }

    private void calculate(String op) {
        try {
            double a = Double.parseDouble(first.getText().trim().replace(',', '.'));
            double b = Double.parseDouble(second.getText().trim().replace(',', '.'));
            if (!Double.isFinite(a) || !Double.isFinite(b))
                throw new NumberFormatException();
            if (op.equals("/") && b == 0) {
                JOptionPane.showMessageDialog(this, "На ноль делить нельзя.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double value;
            switch (op) {
                case "+": value = a + b; break;
                case "-": value = a - b; break;
                case "*": value = a * b; break;
                default: value = a / b;
            }
            result.setText("Результат: " + value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Введите два корректных числа.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TwoNumberCalculator().setVisible(true));
    }
}
