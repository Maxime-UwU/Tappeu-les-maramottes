package me.les3disciple;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

/**
 * Permet de jouer un son
 */
public class AudioClip {
    private Clip clip;

    /**
     * @param soundName Le nom du fichier sonore à jouer.
     *  Doit être placer dans le dossier resources/sounds et être au format .wav
     */
    public AudioClip(String soundName) {
        try {
            clip = AudioSystem.getClip();

            URL file = getClass().getClassLoader().getResource("sounds/" + soundName + ".wav");
            if (file == null) {
                System.out.println("Fichier audio non trouver " + soundName + ".wav");
                return;
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Jouer le son un fois
     */
    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }

    /**
     * Jouer le son en boucle
     */
    public void playIndefinitely(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        play();
    }

    /**
     * Stopper le son
     */
    public void stop(){
        clip.stop();
    }
}
