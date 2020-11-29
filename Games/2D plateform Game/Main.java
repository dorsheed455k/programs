import javax.swing.*;
import java.awt.*;

public class Main extends Canvas {

    public Main() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        String title = "2D Game";
        frame.setTitle(title);
        frame.setResizable(false);
        frame.setContentPane(new GamePanel(title, frame));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
