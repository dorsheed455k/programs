package ProjectileGame.KeyInput;


import java.awt.event.*;

public class KeyHandler implements KeyListener {

    private int dir;

    public KeyType getKey() {

        if(dir == 1) return KeyType.LeftArrow;
        if(dir == 2) return KeyType.RightArrow;
        if(dir == 3) return KeyType.TopArrow;

        return KeyType.Unknown;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //TODO
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT) dir = 1;
        if(key == KeyEvent.VK_RIGHT) dir = 2;
        if(key == KeyEvent.VK_UP) dir = 3;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        dir = 0;
    }
}
