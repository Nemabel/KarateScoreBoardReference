import javax.swing.*;
import java.awt.*;

public class TimerControlPanel {
    Competitor competitor1;
    Competitor competitor2;
    JPanel panel;
    Clock clock;

    TimerControlPanel(Competitor _competitor1, Competitor _competitor2, Clock _clock) {
        competitor1 = _competitor1;
        competitor2 = _competitor2;
        clock = _clock;

        Font pointFont = competitor1.getcPointFont();

        panel = new JPanel(new GridLayout(3, 1));
        panel.setBackground(Color.WHITE);
        panel.setVisible(true);

        JButton timeButton = clock.timeButton;
        panel.add(timeButton);

        // Start/stop/resume
        JButton startStopButton = new JButton("Start");
        startStopButton.setFont(pointFont);
        startStopButton.addActionListener(e -> {
            if (!clock.isTimerRunning) {
                clock.startTimer();
                startStopButton.setText("Stop");
            } else {
                clock.stopTimer();
                startStopButton.setText("Resume");
            }
        });
        panel.add(startStopButton);


        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setVisible(true);

        // Minus sec
        JButton minusButton = new JButton("-1 sec");
        minusButton.addActionListener(e -> clock.minusSec());
        minusButton.setFont(pointFont);
        buttonPanel.add(minusButton);

        // Plus sec
        JButton plusButton = new JButton("+1 sec");
        plusButton.addActionListener(e -> clock.plusSec());
        plusButton.setFont(pointFont);
        buttonPanel.add(plusButton);

        // Reset
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {clock.resetTimer(clock.timeSelector); startStopButton.setText("Start"); competitor1.reset(); competitor2.reset();});
        resetButton.setFont(pointFont);
        buttonPanel.add(resetButton);

        JButton beepButton = new JButton("Beep");
        beepButton.setFont(pointFont);
        beepButton.addActionListener(e -> clock.beeper.beepEnd());
        buttonPanel.add(beepButton);

        panel.add(buttonPanel);
    }
}
