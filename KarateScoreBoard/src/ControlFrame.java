import javax.swing.*;
import java.awt.*;


public class ControlFrame {

    Competitor competitor1;
    Competitor competitor2;
    Clock clock;
    JFrame controlFrame;

    ControlFrame(Competitor _competitor1, Competitor _competitor2, Clock _clock) {
        competitor1 = _competitor1;
        competitor2 = _competitor2;
        clock = _clock;

        ///Timer Panel
        TimerControlPanel timerControlPanel = new TimerControlPanel(competitor1, competitor2, clock);

        ///Competitor Panels
        JPanel competitorPanel = new JPanel();
        competitorPanel.setLayout(new GridLayout(1, 2));
        CompetitorPanel AKA = competitor1.competitorPanel;
        CompetitorPanel AO = competitor2.competitorPanel;
        competitorPanel.add(AKA.controlPanel);
        competitorPanel.add(AO.controlPanel);
        competitorPanel.setVisible(true);

        ///Display
        controlFrame = new JFrame("Karate - Control Frame");
        controlFrame.setLayout(new GridLayout(2, 1));
        controlFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        controlFrame.setSize(800, 400);


        controlFrame.getContentPane().add(timerControlPanel.panel);
        controlFrame.getContentPane().add(competitorPanel);

        controlFrame.setVisible(true);
    }
}
