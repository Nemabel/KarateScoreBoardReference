import javax.swing.*;
import java.awt.*;

public class CompetitorPointLabel {
    private final Competitor competitor;
    JPanel controlPanel;
    JLabel controlPointsLabel;

    JPanel displayPanel;
    JLabel displayPointsLabel;

    CompetitorPointLabel(Competitor _competitor){

        competitor = _competitor;

        ///Control Panel setup
        controlPanel = new JPanel();
        controlPanelSetup(competitor.getcNameFont());

        ///Display Panel setup
        displayPanel = new JPanel();
        displayPanelSetup(competitor.getdNameFont());

        refreshPoints();

    }

    private void displayPanelSetup(Font nameFont) {
        displayPanel.setLayout(new GridLayout(1,1));
        displayPanel.setBackground(Color.BLACK);
        displayPanel.setVisible(true);

        displayPointsLabel = new JLabel();
        displayPointsLabel.setFont(nameFont);
        displayPointsLabel.setOpaque(true);
        displayPointsLabel.setBackground(Color.BLACK);
        displayPointsLabel.setForeground(competitor.color);
        displayPointsLabel.setVerticalAlignment(SwingConstants.CENTER);
        displayPointsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        displayPanel.add(displayPointsLabel);
    }

    private void controlPanelSetup(Font nameFont) {
        controlPanel.setLayout(new GridLayout(1,1));
        controlPanel.setBackground(competitor.color);
        controlPanel.setVisible(true);

        controlPointsLabel = new JLabel();
        controlPointsLabel.setFont(nameFont);
        controlPointsLabel.setBackground(competitor.color);
        controlPointsLabel.setVerticalAlignment(SwingConstants.CENTER);
        controlPointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        controlPanel.add(controlPointsLabel);
    }

    void refreshPoints(){
        if (Boolean.TRUE.equals(competitor.left)) {
            if(Boolean.TRUE.equals(competitor.senshu)){
                controlPointsLabel.setText("* " + competitor.name + ": " + competitor.points);
                displayPointsLabel.setText("* " + competitor.name + ": " + competitor.points);
            }
            else{
                controlPointsLabel.setText(competitor.name + ": " + competitor.points);
                displayPointsLabel.setText(competitor.name + ": " + competitor.points);
            }
        }
        else{
            if(Boolean.TRUE.equals(competitor.senshu)){
                controlPointsLabel.setText(competitor.points + ": " + competitor.name + " *");
                displayPointsLabel.setText(competitor.points + ": " + competitor.name + " *");
            }
            else{
                controlPointsLabel.setText(competitor.points + ": " + competitor.name);
                displayPointsLabel.setText(competitor.points + ": " + competitor.name);
            }
        }

    }
}
