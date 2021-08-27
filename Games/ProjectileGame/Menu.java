package ProjectileGame;

import java.awt.*;
import java.io.File;

public class Menu {
    public Rectangle playButton;
    public Rectangle helpButton;
    public Rectangle quitButton;
    private int WIDTH, HEIGHT;
    public Font pixel;
    public Font pixelPlus;

    public Menu(int WIDTH, int HEIGHT, Font pixelPlus) {
        setFont();
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.pixelPlus = pixelPlus.deriveFont(35f);
        playButton = new Rectangle(this.WIDTH/2-50, 150, 100, 50);
        helpButton = new Rectangle(this.WIDTH/2-50, 250, 100, 50);
        quitButton = new Rectangle(this.WIDTH/2-50, 350, 100, 50);
    }

    public void setFont() {
        try {
            pixel = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Administrator.WIN-5GBSLTHUIQC" +
                    "\\RayCaster\\src\\ProjectileGame\\Fonts\\VCR_OSD_MONO_1.001.ttf")).deriveFont(30f);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics2D g) {
        g.setColor(Color.CYAN);
        g.fillRect(0,0, WIDTH, HEIGHT);

        g.setFont(pixelPlus);
        g.setColor(Color.WHITE);
        g.drawString("2D PLATFORM GAME", 15, 100);

        g.setFont(pixel);
        g.drawString("Play", playButton.x+15, playButton.y+35);
        g.draw(playButton);
        g.draw(helpButton);
        g.drawString("Help", helpButton.x+15, helpButton.y+35);
        g.draw(quitButton);
        g.drawString("Quit", quitButton.x+15, quitButton.y+35);
    }
}
