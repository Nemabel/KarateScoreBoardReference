import java.awt.*;

public class Competitor {
    final String name;
    int points;
    int admonitions;
    CustomFont customFont;
    Color color;
    Boolean left;
    Boolean senshu;

    CompetitorPointLabel competitorPointLabel;
    CompetitorPanel competitorPanel;

    public Competitor(String _name, Color _color, Boolean _left, CustomFont _customFont) {
        name = _name;
        color = _color;
        left = _left;
        customFont = _customFont;
        points = 0;
        admonitions = 0;
        senshu = false;

        competitorPointLabel = new CompetitorPointLabel(this);
        competitorPanel = new CompetitorPanel(this);
    }

    public void addPoints(int score) {
        if ((points + score) >= 0){
            points += score;
        }
    }

    public void addSenshu() {
        senshu = true;
    }

    public void removeSenshu() {
        senshu = false;
    }

    public void addAdmonition(int score) {
        if ((admonitions + score) >= 0 && (admonitions + score) <= 5){
            admonitions += score;
        }
    }

    public Font getcNameFont() {
        return customFont.getcNameFont();
    }

    public Font getcPointFont() {
        return customFont.getcPointFont();
    }

    public Font getdNameFont() {
        return customFont.getdNameFont();
    }

    public Font getdPointFont() {
        return customFont.getdPointFont();
    }

    public void reset() {
        points = 0;
        admonitions = 0;
        senshu = false;
        competitorPointLabel.refreshPoints();
    }
}
