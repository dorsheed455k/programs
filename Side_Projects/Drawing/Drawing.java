import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Drawing implements Runnable, MouseMotionListener, MouseListener {

    private Thread thread;
    private int WIDTH = 735, HEIGHT = 600;
    private boolean running = false;
    private final String title = "Drawing";
    private Canvas canvas;
    private JFrame frame;
    private JPanel panel;
    private JButton button, color;
    private Color cl;
    private boolean cleared = false;
    private ArrayList<Circle> paint = new ArrayList<>();

    public Drawing()  {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel(new FlowLayout());
        button = new JButton("Clear");
        color = new JButton("Color");
        panel.add(button);
        panel.add(color);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button && paint.size() != 0) {
                    System.out.println("Pressed");
                    cleared = true;
                    paint.clear();
                }
            }
        });

        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == color) {
                    System.out.println("Yes");
                    Color initialcolor = Color.RED;
                    cl = JColorChooser.showDialog(panel,"Select a color", initialcolor);
                }
            }
        });

        frame.add(panel, BorderLayout.NORTH);
        canvas = new Canvas();
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
        frame.getContentPane().add(canvas);
        frame.setSize(WIDTH,HEIGHT+50);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.start();
    }


    public void init() {
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60;
        double delta = 0;
        int frames = 0;
        init();
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                this.frame.setTitle(title + " | " + frames + " fps");
                frames = 0;
            }
        }
        stop();
    }

    public synchronized void start() {
        running = true;
        this.thread = new Thread(this, "Display");
        this.thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }


    private void render() {
        BufferStrategy bs = canvas.getBufferStrategy();
        if(bs == null) {
            canvas.createBufferStrategy(2);
            return;
        }
        Graphics  g = bs.getDrawGraphics();
        Graphics2D  g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,WIDTH, HEIGHT);


        if (!cleared) {
            for (int i = 0; i < paint.size(); i++) {
                paint.get(i).render(g2);
            }
        }
        g.dispose();
        bs.show();
    }

    public Color randomColor() {
        int r = (int) (Math.floor(Math.random()*3)*127);
        int g = (int) (Math.floor(Math.random()*3)*127);
        int b = (int) (Math.floor(Math.random()*3)*127);

        if (r < 25) {
            r *= 0.65;
            g *= 0.65;
            b *= 0.65;
        }
        return new Color(r, g, b);
    }

    public void update() {
        //   System.out.println(paint.size());
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        //  System.out.println("Dragged");
        //  paint.add(new Circle(e.getX(), e.getY(), randomColor()));
        cleared = false;
        paint.add(new Circle(e.getX(), e.getY(),  cl));


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        new Drawing();
    }

}


