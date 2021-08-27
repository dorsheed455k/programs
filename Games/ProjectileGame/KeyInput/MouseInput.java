package ProjectileGame.KeyInput;

import ProjectileGame.GamePanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {
    private int WIDTH;

    public MouseInput(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //TODO
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        /*
         Rectangle playButton = new Rectangle(WIDTH/2-50, 150, 100, 50);
         Rectangle helpButton = new Rectangle(WIDTH/2-50, 250, 100, 50);
         Rectangle quitButton = new Rectangle(WIDTH/2-50, 350, 100, 50);
        * */
        if(mx >= WIDTH/2-50 && mx <= WIDTH/2+50)
        {
            if(my >= 100 && my <= 150) {
                // Pressed Play Button
                GamePanel.State = GamePanel.STATE.GAME;
            }
            if(my >= 300 && my <= 350)
            {
                System.exit(0);
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //TODO
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //TODO
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //TODO
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //TODO
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x + " " + y);
    }
}
