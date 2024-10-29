import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Beeper {
    int beep15volume;
    int beepEndVolume;

    public Beeper(int _beep15volume, int _beepEndVolume){
        beep15volume = _beep15volume;
        beepEndVolume = _beepEndVolume;
    }

    void beep15sec(){
        try {
            URL url = this.getClass().getClassLoader().getResource("ping.wav");
            openUrl(url, beep15volume);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void beepEnd(){
        try {
            URL url = this.getClass().getClassLoader().getResource("airhorn.wav");
            openUrl(url, beepEndVolume);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openUrl(URL url, int beepEndVolume) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        assert url != null;
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(beepEndVolume);
        clip.start();
    }
}
