import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
public class sound {



    public void sound(String file, int time_ms) {
        sleep sleep = new sleep();
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(file));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
            // If you want to stop the sound, then use clip.stop();
            sleep.sleep(time_ms);

            //clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sound_loop(String file) {
        sleep sleep = new sleep();
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(file));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
            // If you want to stop the sound, then use clip.stop();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            //clip.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}