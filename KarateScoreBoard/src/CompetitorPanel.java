import javax.swing.*;
import java.awt.*;

public class CompetitorPanel {
    Competitor competitor;
    CompetitorPointLabel competitorPointLabel;

    JPanel controlPanel;
    JPanel displayPanel;

    CompetitorPanel(Competitor _competitor) {
        competitor = _competitor;
        competitorPointLabel = competitor.competitorPointLabel;
        PointControlPanel pointControlPanel = new PointControlPanel(competitor);
        AdmonitionPanel admonitionPanel = competitor.admonitionPanel;

        ///Control Panel setup
        controlPanel = new JPanel();
        controlPanelSetup(pointControlPanel, admonitionPanel);

        ///Display Panel setup
        displayPanel = new JPanel();
        displayPanelSetup(admonitionPanel);

    }

    private void displayPanelSetup(AdmonitionPanel admonitionPanel) {
        displayPanel.setLayout(new GridLayout(2, 1));
        displayPanel.setBackground(Color.BLACK);
        displayPanel.setVisible(true);

        displayPanel.add(competitorPointLabel.displayPanel);
        displayPanel.add(admonitionPanel.displayPanel);
    }

    private void controlPanelSetup(PointControlPanel pointControlPanel, AdmonitionPanel admonitionPanel) {
        controlPanel.setLayout(new GridLayout(3, 1));
        controlPanel.setBackground(competitor.color);
        controlPanel.setVisible(true);

        controlPanel.add(competitorPointLabel.controlPanel);
        controlPanel.add(pointControlPanel.panel);
        controlPanel.add(admonitionPanel.controlPanel);
    }
}
