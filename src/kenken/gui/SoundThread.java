import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class SoundThread extends Thread {

    private final String resource;
    Thread t;
    Clip clip;
    
    /**
     * Plays the music.
     */
    public void play() {
        
        t.start();
    }
    
    /**
     * Stops the music.
     */
    public void stopMusic() {
        clip.stop();
    }

    /**
     * Sets a new SoundThread and also sets a deamon.
     * @param resource Sets a new resource to the thread.
     */
    public SoundThread(String resource) {
        this.resource = resource;
        t = new SoundThread(resource);
        t.setDaemon(true);
    }

    /**
     * Runs the SoundThread.
     */
    @Override
    public void run() {
        clip = null;
        try {
            InputStream in = SoundThread.class.getClassLoader().getResourceAsStream(resource);
            if(in != null) {
                AudioInputStream stream = AudioSystem.getAudioInputStream(in);
                AudioFormat format = stream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(stream);
                clip.loop(0);
                do  {
                    try {
                        Thread.sleep(100);
                    } catch(InterruptedException iex) {
                        // bad form on my part here. Should do somethinging
                    }
                } while(clip.isRunning());
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if(clip != null) {
                    clip.close();
                }
            } catch(Exception x) {
                x.printStackTrace(System.out);
            }
        }
    }
}