package practice3.part1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class MatchScore extends JFrame {
    private int milanScore;
    private int madridScore;
    private final JLabel result = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
    private final JLabel lastScorer = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
    private final JLabel winner = new JLabel("Winner: DRAW", SwingConstants.CENTER);

    public MatchScore() {
        super("Match results");
        JButton milan = new JButton("AC Milan");
        JButton madrid = new JButton("Real Madrid");
        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(milan);
        buttons.add(madrid);
        JPanel information = new JPanel();
        information.setLayout(new BoxLayout(information, BoxLayout.Y_AXIS));
        information.add(result);
        information.add(lastScorer);
        information.add(winner);
        milan.addActionListener(e -> { milanScore++; updateScore("AC Milan"); });
        madrid.addActionListener(e -> { madridScore++; updateScore("Real Madrid"); });
        add(buttons, BorderLayout.NORTH);
        add(information, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(340, 180);
        setLocationRelativeTo(null);
    }

    private void updateScore(String team) {
        result.setText("Result: " + milanScore + " X " + madridScore);
        lastScorer.setText("Last Scorer: " + team);
        String winningTeam = milanScore == madridScore ? "DRAW" :
                (milanScore > madridScore ? "AC Milan" : "Real Madrid");
        winner.setText("Winner: " + winningTeam);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MatchScore().setVisible(true));
    }
}
