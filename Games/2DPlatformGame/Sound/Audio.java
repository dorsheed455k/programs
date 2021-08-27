package ProjectileGame.Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    private File music, jumping, fire, coin;
    private AudioInputStream effects;
    private Clip clipEffect;

    public Audio() {
        music = new File("C:\\Users\\Administrator.WIN-5GBSLTHUIQC\\RayCaster\\src\\ProjectileGame\\Sound\\8-bit-retro-game-level-music-207435-PREVIEW (online-audio-converter.com).wav");
        jumping = new File("C:\\Users\\Administrator.WIN-5GBSLTHUIQC\\RayCaster\\src\\ProjectileGame\\Sound\\jump_11.wav");
        fire = new File("C:\\Users\\Administrator.WIN-5GBSLTHUIQC\\RayCaster\\src\\ProjectileGame\\Sound\\FireIgnite.wav");
        coin = new File("C:\\Users\\Administrator.WIN-5GBSLTHUIQC\\RayCaster\\src\\ProjectileGame\\Sound\\classiccoin.wav");
    }

    public void playMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(music);
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(audioInputStream);
            try {
                Thread.sleep(1000);
                audioClip.start();
                audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void jumpSound() {
        try {
            effects = AudioSystem.getAudioInputStream(jumping);
            clipEffect = AudioSystem.getClip();
            clipEffect.open(effects);
            clipEffect.start();
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void burningSound() {
        try {
            effects = AudioSystem.getAudioInputStream(fire);
            clipEffect = AudioSystem.getClip();
            clipEffect.open(effects);
            clipEffect.start();
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void coinSound() {
        try {
            effects = AudioSystem.getAudioInputStream(coin);
            clipEffect = AudioSystem.getClip();
            clipEffect.open(effects);
            clipEffect.start();
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
