package 2DPlatformGame;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    public Window() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        String title = "2D Platform Game";
        frame.setTitle(title);
        frame.setResizable(true);
        frame.setContentPane(new ProjectileGame.GamePanel(frame));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}
