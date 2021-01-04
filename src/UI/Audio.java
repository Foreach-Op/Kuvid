package UI;

import javax.sound.sampled.*;
import java.io.File;

public class Audio {

    private Clip clip;

    public Audio(String file, boolean isLooping) {
        try {
            File audioPath = new File("./assets/Audio/" + file + ".wav");

            if (audioPath.exists()) {
                AudioInputStream audio = AudioSystem.getAudioInputStream(audioPath);
                clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();

                if(isLooping){
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            } else {
                System.err.println("Invalid file path");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
