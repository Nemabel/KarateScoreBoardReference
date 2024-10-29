import javax.swing.*;
import java.awt.*;

public class DisplayFrame {
    Competitor competitor1;
    Competitor competitor2;
    Clock clock;
    JFrame displayFrame;

    DisplayFrame(Competitor _competitor1, Competitor _competitor2, Clock _clock) {

        competitor1 = _competitor1;
        competitor2 = _competitor2;
        clock = _clock;

        ///Display
        displayFrame = new JFrame("Karate - Display Frame");
        displayFrame.setLayout(new GridLayout(2, 1));
        displayFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        displayFrame.setSize(800, 400);
        displayFrame.setBackground(Color.BLACK);

        ///Time Display
        displayFrame.add(clock.timeLabel);

        ///Competitor Panels
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1, 2));
        scorePanel.add(competitor1.competitorPanel.displayPanel);
        scorePanel.add(competitor2.competitorPanel.displayPanel);

        displayFrame.add(scorePanel);

        displayFrame.setVisible(true);
    }

}
