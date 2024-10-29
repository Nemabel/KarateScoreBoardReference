import java.awt.*;

public class Program {
    static Color akacolor = new Color(255, 114, 118);
    static Color aocolor = new Color(173, 216, 230);
    static int timeLeft = 60;


    //Set the program parameters here
    static String font = "Arial";

    //Control frame sizes
    static int cNameSize = 50;
    static int cPointSize = 30;
    static int cTimerSize = 100;

    //Display frame sizes
    static int dNameSize = 200;
    static int dPointSize = 200;
    static int dTimerSize = 500;

    //Has to stay between -80 and 6
    static int beep15volume = 5;
    static int beepEndVolume = 5;

    static CustomFont customFont = new CustomFont(font, cNameSize, cPointSize, dNameSize, dPointSize);

    public static void main(String[] args) {

        Competitor ao = new Competitor("AO", aocolor, true, customFont);
        Competitor aka = new Competitor("AKA", akacolor, false, customFont);
        Beeper beeper = new Beeper(beep15volume, beepEndVolume);
        Clock clock = new Clock(beeper, timeLeft, font, cTimerSize, dTimerSize);

        ControlFrame controlFrame = new ControlFrame(ao, aka, clock);

        DisplayFrame displayFrame = new DisplayFrame(ao, aka, clock);

    }
}
