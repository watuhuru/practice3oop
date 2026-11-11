package practice3.part3;

import java.awt.*;
import javax.swing.*;

public class CountrySelector extends JFrame {
    private final JComboBox<String> countries =
            new JComboBox<>(new String[]{"Australia", "China", "England", "Russia"});
    private final JTextArea information = new JTextArea(5, 28);

    public CountrySelector() {
        super("Выбор страны");
        setLayout(new BorderLayout(8, 8));
        information.setEditable(false);
        information.setLineWrap(true);
        information.setWrapStyleWord(true);
        countries.addActionListener(e -> showCountry());
        add(countries, BorderLayout.NORTH);
        add(new JScrollPane(information), BorderLayout.CENTER);
        showCountry();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void showCountry() {
        switch (countries.getSelectedIndex()) {
            case 0: information.setText("Австралия. Столица: Канберра. Расположена в Австралии и Океании."); break;
            case 1: information.setText("Китай. Столица: Пекин. Расположен в Восточной Азии."); break;
            case 2: information.setText("Англия. Главный город: Лондон. Часть Соединённого Королевства."); break;
            default: information.setText("Россия. Столица: Москва. Расположена в Европе и Азии.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CountrySelector().setVisible(true));
    }
}
