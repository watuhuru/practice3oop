package practice3.part3;

import java.awt.*;
import javax.swing.*;

public class ButtonCalculator extends JFrame {
    private final JTextField display = new JTextField("0");
    private double firstValue;
    private String operator;
    private boolean newNumber = true;

    public ButtonCalculator() {
        super("Калькулятор");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(display.getFont().deriveFont(22f));
        add(display, BorderLayout.NORTH);
        JPanel keys = new JPanel(new GridLayout(4, 4, 5, 5));
        for (String key : new String[]{"7", "8", "9", "/", "4", "5", "6", "*",
                "1", "2", "3", "-", "0", ".", "=", "+"}) {
            JButton button = new JButton(key);
            button.addActionListener(e -> press(key));
            keys.add(button);
        }
        add(keys, BorderLayout.CENTER);
        JButton clear = new JButton("C");
        clear.addActionListener(e -> reset());
        add(clear, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(340, 280);
        setLocationRelativeTo(null);
    }

    private void press(String key) {
        if (key.matches("[0-9]") || key.equals(".")) {
            if (newNumber) {
                display.setText(key.equals(".") ? "0." : key);
                newNumber = false;
            } else if (!key.equals(".") || !display.getText().contains(".")) {
                display.setText(display.getText() + key);
            }
            return;
        }
        double value = Double.parseDouble(display.getText());
        if (key.equals("=")) {
            if (operator != null && !newNumber) {
                Double answer = apply(firstValue, value, operator);
                if (answer == null) return;
                display.setText(Double.toString(answer));
                operator = null;
                newNumber = true;
            }
        } else {
            if (operator != null && !newNumber) {
                Double answer = apply(firstValue, value, operator);
                if (answer == null) return;
                display.setText(Double.toString(answer));
                firstValue = answer;
            } else if (operator == null) {
                firstValue = value;
            }
            operator = key;
            newNumber = true;
        }
    }

    private Double apply(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) {
                    JOptionPane.showMessageDialog(this, "На ноль делить нельзя.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    reset();
                    return null;
                }
                return a / b;
            default: throw new IllegalStateException("Неизвестная операция");
        }
    }

    private void reset() {
        firstValue = 0;
        operator = null;
        newNumber = true;
        display.setText("0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ButtonCalculator().setVisible(true));
    }
}
