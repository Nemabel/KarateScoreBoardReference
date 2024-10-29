import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Clock {
    JButton timeButton;
    JLabel timeLabel;
    JComboBox<String> timeSelector;
    Timer timer;
    int timeLeft;
    boolean isTimerRunning = false;
    Beeper beeper;

    Clock(Beeper _beeper, int _timeLeft, String _Font, int _cTimerSize, int _dTimerSize) {
        beeper = _beeper;
        timeLeft = _timeLeft;
        Font controlFont = new Font(_Font, Font.BOLD, _cTimerSize);
        Font displayFont = new Font(_Font, Font.BOLD, _dTimerSize);

        //Control
        timeButton = new JButton(formatTime(timeLeft));
        timeButton.setFont(controlFont);

        //Display
        timeLabel = new JLabel(formatTime(timeLeft), SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(displayFont);
        timeLabel.setOpaque(true);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.WHITE);

        //Time Selector
        String[] times = {"1", "1.5", "2", "2.5", "3"}; //in minutes
        timeSelector = new JComboBox<>(times);
        timeSelector.setFont(new Font(_Font, Font.PLAIN, 30));
        timeSelector.addActionListener(e -> {
            timeLeft = (int) (Float.parseFloat((String) Objects.requireNonNull(timeSelector.getSelectedItem())) * 60);
            refreshTime();
        });

        timeButton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setMinimumSize(new Dimension(200, 150));
            dialog.setModal(true);
            dialog.setLayout(new GridLayout(1,1));
            dialog.add(timeSelector);
            dialog.pack();

            timeSelector.addActionListener(event -> {
                timeLeft = (int) (Float.parseFloat((String) Objects.requireNonNull(timeSelector.getSelectedItem())) * 60);
                refreshTime();
                dialog.dispose();
            });

            dialog.setLocationRelativeTo(timeButton);
            dialog.setVisible(true);
        });
    }

    public void startTimer() {
        timer = new Timer(1000, e -> {
            timeLeft--;
            refreshTime();
            if (timeLeft == 15){
                beeper.beep15sec();
            }
            if (timeLeft <= 0) {
                ((Timer) e.getSource()).stop();
                isTimerRunning = false;
                beeper.beepEnd();
                //calculateWinner();
            }
        });
        timer.start();
        isTimerRunning = true;
    }

    public void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
        isTimerRunning = false;
    }

    public void resetTimer(JComboBox<String> timeSelector) {
        stopTimer();
        timeLeft = (int) (Float.parseFloat((String) Objects.requireNonNull(timeSelector.getSelectedItem())) * 60); // Reset to selected time
        refreshTime();
    }

    private String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public void plusSec(){
        timeLeft++;
        refreshTime();
    }

    public void minusSec(){
        if (timeLeft > 0) {
            timeLeft--;
            refreshTime();
        }
    }

    public void refreshTime(){
        timeLabel.setText(formatTime(timeLeft));
        timeButton.setText(formatTime(timeLeft));
    }
}
