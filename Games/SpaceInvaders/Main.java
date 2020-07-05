import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Window extends Canvas {
    private static final long serialVersionUID = -240840600533728354L;

    public Window(int WIDTH, int HEIGHT, String title,  Main main) {
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle(title);
        this.setDefaultLookAndFeel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.addKeyListener(main);
        setFocusTraversalKeysEnabled(true);
        frame.add(main);
        frame.setVisible(true);
    }

    public void setDefaultLookAndFeel() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {

        }
    }
    public static void main(String[] args) throws IOException {
        new Main();
    }

}
