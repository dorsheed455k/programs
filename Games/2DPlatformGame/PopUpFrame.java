package ProjectileGame;

import javax.swing.*;

public class PopUpFrame extends JFrame {
    private Terrain terrain;
    private Player player;

    public PopUpFrame(Terrain terrain, Player player) {
        this.setLocationRelativeTo(null);
        this.player = player;
        this.terrain = terrain;
    }

    public void initClosingDialog() {
        if(player.getX() >= player.maxDistX && (!player.isFalling() || !player.isJumping())) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
           int response =  JOptionPane.showConfirmDialog(null, "You have completed this level with " + terrain.getCoins() + " coins!\nPlay Again?");
           if(response == JOptionPane.YES_OPTION) {
               player.x = terrain.px;
               player.y = terrain.py;
           } else {
               System.exit(0);
           }
        }
    }
}
