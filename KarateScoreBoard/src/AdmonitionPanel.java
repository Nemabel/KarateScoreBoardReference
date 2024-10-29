import javax.swing.*;
import java.awt.*;

public class AdmonitionPanel {
    Competitor competitor;
    CompetitorPointLabel competitorDisplay;

    JPanel controlPanel;
    JButton controlAdmonitionButton;

    JPanel displayPanel;
    JLabel displayAdmonitionLabel;

    AdmonitionPanel(Competitor _competitor){

        competitor = _competitor;
        competitorDisplay = competitor.competitorPointLabel;
        Color color = competitor.color;

        ///Control Panel setup
        controlPanel = new JPanel();
        controlPanelSetup(color, competitor.getcPointFont());

        ///Display Panel setup
        displayPanel = new JPanel();
        displayPanelSetup(competitor.getdPointFont());

        refreshAdmonitions();
        refreshPoints();
    }

    private void displayPanelSetup(Font pointFont) {
        displayPanel.setLayout(new GridLayout(1,1));
        displayPanel.setBackground(Color.BLACK);
        displayPanel.setVisible(true);

        displayAdmonitionLabel = new JLabel();
        displayAdmonitionLabel.setFont(competitor.getcNameFont());
        displayAdmonitionLabel.setOpaque(true);
        displayAdmonitionLabel.setBackground(Color.BLACK);
        displayAdmonitionLabel.setForeground(Color.RED);
        displayAdmonitionLabel.setVerticalAlignment(SwingConstants.CENTER);
        displayAdmonitionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        displayAdmonitionLabel.setFont(pointFont);

        displayPanel.add(displayAdmonitionLabel);
    }

    private void controlPanelSetup(Color color, Font pointFont) {
        controlPanel.setLayout(new GridLayout(1,4));
        controlPanel.setBackground(color);
        controlPanel.setVisible(true);

        controlAdmonitionButton = new JButton(); ///Display the amount of admonitions the competitor has
        controlAdmonitionButton.addActionListener(e -> {competitor.addAdmonition(1); refreshAdmonitions();});
        controlAdmonitionButton.setBackground(color);
        controlAdmonitionButton.setFont(pointFont);

        JButton removeAdmonition = new JButton("-C"); ///To undo any admonitions mistakenly given
        removeAdmonition.addActionListener(e -> {competitor.addAdmonition(-1); refreshAdmonitions();});
        removeAdmonition.setBackground(color);
        removeAdmonition.setFont(pointFont);

        JButton addSenshu = new JButton("S"); ///Adds Senshu
        addSenshu.addActionListener(e -> {competitor.addSenshu(); refreshPoints();});
        addSenshu.setBackground(color);
        addSenshu.setFont(pointFont);

        JButton removeSenshu = new JButton("-S"); ///Removes Senshu
        removeSenshu.addActionListener(e -> {competitor.removeSenshu(); refreshPoints();});
        removeSenshu.setBackground(color);
        removeSenshu.setFont(pointFont);

        controlPanel.add(controlAdmonitionButton);
        controlPanel.add(removeAdmonition);
        controlPanel.add(addSenshu);
        controlPanel.add(removeSenshu);
    }

    void refreshAdmonitions(){
        controlAdmonitionButton.setText("C: " + competitor.admonitions);
        displayAdmonitionLabel.setText("× ".repeat(Math.max(0, competitor.admonitions)));
    }

    void refreshPoints(){
        competitorDisplay.refreshPoints();
    }
}
