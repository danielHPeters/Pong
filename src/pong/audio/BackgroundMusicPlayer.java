/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.audio;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A musicplayer whic plays a list of wav files in the background
 *
 * @author d.peters
 */
public class BackgroundMusicPlayer {

    /**
     * Directory scanner
     */
    private final DirectoryScanner dirScan;

    /**
     * List of audio files to be played
     */
    private final List<AudioClip> clips;

    /**
     * Default constructor. Gets all wav files and loads them into the clips
     * list and shuffles the list.
     */
    public BackgroundMusicPlayer() {
        this.dirScan = new DirectoryScanner("src/wav");
        this.clips = dirScan.getDirContents();
        Collections.shuffle(clips);

    }

    /**
     * Plays all clips from the list
     */
    public void playAllClips() {

        URL url;
        Clip clip;
        AudioInputStream iStream;
        LineListener listener;

        for (int i = 0; i < clips.size(); i++) {

            try {

                listener = (LineEvent event) -> {
                    Type eventType = event.getType();
                    if (eventType == Type.STOP || eventType == Type.CLOSE) {
                    }
                };

                url = this.getClass().getClassLoader().getResource("wav/" + this.clips.get(i).getLocation());
                System.out.println(url.toString());
                clip = AudioSystem.getClip();
                iStream = AudioSystem.getAudioInputStream(url);

                clip.addLineListener(listener);
                clip.open(iStream);
                clip.start();

                while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {

                }

            } catch (LineUnavailableException ex) {

                System.out.println("Audios error.");

            } catch (UnsupportedAudioFileException ex) {

                System.out.println("Wrong audio type.");

            } catch (IOException ex) {

                System.out.println("File not found.");

            }

        }

    }
}
