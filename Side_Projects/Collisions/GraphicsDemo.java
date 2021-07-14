import javax.swing.*;
import java.awt.*;

import java.awt.geom.Line2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class GraphicsDemo extends JPanel implements Runnable {

    public ArrayList<Particle> particles = new ArrayList<>();
    private Image spaceImage;
    private Collisions coll;
    private Thread thread;
    private KeyHandler key;
    private JFrame frame;
    private int HEIGHT, WIDTH;
    private boolean running = false;
    private boolean added = false;
    double deltaTime = 0;

    public GraphicsDemo(JFrame frame) {
        super();
        setFocusable(true);
        this.HEIGHT = 500;
        this.WIDTH = 735;
        this.frame = frame;
        frame.setSize(WIDTH, HEIGHT);
        this.start();
    }

    public void init() {
        coll = new Collisions();
        key = new KeyHandler();
        addParticle();
        this.addKeyListener(key);
        spaceImage = new ImageIcon("C:\\Users\\admin\\Downloads\\space.jpg").getImage();

    }

    public void addParticle() {
        for (int i = 0; i < 2; i++) {
            int x = (int) ((Math.random() * 550) + 1);
            int y = (int) ((Math.random() * 400) + 1);
            int radius = (int) ((Math.random() * 50) + 10);
            Color cl = randomColor(radius);
            if (i != 0) {
                for (int j = 0; j < particles.size(); j++) {
                    if (coll.getDistance(x, y,
                            particles.get(j).getCx(),
                            particles.get(j).getCy())
                            - radius * 2 < 0) {
                        x = (int) ((Math.random() * 550) + 1);
                        y = (int) ((Math.random() * 400) + 1);
                        j = -1;
                    }
                }
            }
            particles.add(new Particle(25, x, y, cl));
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / amountOfTicks;
        int frames = 0;
        init();
        while (running) {
            long now = System.nanoTime();
            deltaTime += (now - lastTime) / ns;
            lastTime = now;
            while (deltaTime >= 1) {
              //  System.out.println(deltaTime);
                update();
                tick(deltaTime);
                deltaTime--;
                render();
                frames++;
            }

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                this.frame.setTitle("Collisions | " + frames + " FPS");
                System.out.println(frames + " FPS");
                frames = 0;
            }
        }
        stop();
    }

    public void render() {
        BufferStrategy bs = frame.getBufferStrategy();
        if(bs == null) {
            frame.createBufferStrategy(3);
            return;
        }

        // Drawing Backdrop
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(spaceImage, 0,0, 735, 500, null);
        GradientPaint paint = new GradientPaint(0,0,Color.RED, 420,0,Color.BLUE);
        // g2D.setPaint(paint);

      //  if (added) {
            for (Particle p : particles) {
                p.render(g2);
            }
       // }
        drawLine(g2);

        g.dispose();
        bs.show();
    }

    void tick(double dt) {
       // if (added) {
            for (Particle particle : particles) {
                particle.tick(dt);
            }
       // }
    }

    void start() {
        running = true;
        try {
            this.thread = new Thread(this, "Run");
            this.thread.start();
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
    }

    void stop() {
        running = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

    public void update() {
        if (key.getKey() == KeyType.A) {
            int x = (int) ((Math.random() * 550) + 1);
            int y = (int) ((Math.random() * 400) + 1);
            int radius = (int) ((Math.random() * 50) + 10);
            Color cl = randomColor(radius);
            particles.add(new Particle(radius, x, y, cl));
        }
      //  if (added) {
            for (Particle p : particles) {
                p.move();
            }
            coll.collide(particles);
     //   }
    }


    public void drawLine(Graphics2D g2D) {
        int i = 0;
        for (Particle b1 : particles) {
            int j = 0;
            for (Particle b2 : particles) {
                if (j == i) continue;
                Line2D line2D = new Line2D.Double();
                line2D.setLine(b1.getCx()+b1.getRadius(), b1.getCy()+b1.getRadius(),
                        b2.getCx()+b2.getRadius(), b2.getCy()+b2.getRadius());
                g2D.draw(line2D);
                int mX = (int) ((b1.getCx() + b2.getCx()) / 2);
                int mY = (int) ((b1.getCy() + b2.getCy()) / 2);
                int dist = (int) coll.getDistance(b1.getCx(), b1.getCy(), b2.getCx(), b2.getCy());
                g2D.setColor(Color.RED);
                g2D.drawString(String.valueOf(dist), mX, mY);
                j++;
            }
            i++;
        }
    }


    public Color randomColor(int radius) {
        int r = (int) (Math.floor(Math.random()*3)*127);
        int g = (int) (Math.floor(Math.random()*3)*127);
        int b = (int) (Math.floor(Math.random()*3)*127);

        if (radius < 25) {
            r *= 0.65;
            g *= 0.65;
            b *= 0.65;
        }
        return new Color(r, g, b);
    }
}
