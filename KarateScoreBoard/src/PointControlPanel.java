import javax.swing.*;
import java.awt.*;

public class PointControlPanel {
    Competitor competitor;
    CompetitorPointLabel competitorPointLabel;
    JPanel panel;


    PointControlPanel(Competitor _competitor){
        competitor = _competitor;
        competitorPointLabel = competitor.competitorPointLabel;

        Font pointFont = competitor.getcPointFont();
        Color color = competitor.color;

        panel = new JPanel();
        panel.setLayout(new GridLayout(1,4));
        panel.setBackground(competitor.color);
        panel.setVisible(true);

        JButton minusPoint = new JButton("-1"); ///To undo any points mistakenly given
        minusPoint.addActionListener(e -> {competitor.addPoints(-1); refreshPoints();});
        minusPoint.setBackground(color);
        minusPoint.setFont(pointFont);

        JButton yuko = new JButton("+1"); /// Yuko is 1 point in Karate
        yuko.addActionListener(e -> {competitor.addPoints(1); refreshPoints();});
        yuko.setBackground(color);
        yuko.setFont(pointFont);

        JButton wazari = new JButton("+2"); /// Wazari is 2 points in Karate
        wazari.addActionListener(e -> {competitor.addPoints(2); refreshPoints();});
        wazari.setBackground(color);
        wazari.setFont(pointFont);

        JButton ippon = new JButton("+3"); /// Ippon is 3 points in Karate
        ippon.addActionListener(e -> {competitor.addPoints(3); refreshPoints();});
        ippon.setBackground(color);
        ippon.setFont(pointFont);

        panel.add(yuko);
        panel.add(wazari);
        panel.add(ippon);
        panel.add(minusPoint);
    }

    void refreshPoints(){
        competitorPointLabel.refreshPoints();
    }
}
