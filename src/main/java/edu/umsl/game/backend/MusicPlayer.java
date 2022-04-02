package edu.umsl.game.backend;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {
    AudioInputStream audio;
    Clip clip;

    public void playMusic(String fileName, boolean loop){

        try{
            audio = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(fileName));
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            if (loop){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
