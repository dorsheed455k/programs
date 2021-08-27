package ProjectileGame;

import ProjectileGame.KeyInput.KeyHandler;
import ProjectileGame.KeyInput.MouseInput;
import ProjectileGame.Sound.Audio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{
    private int WIDTH = 550, HEIGHT = 550;
    private Thread thread;
    private boolean running = false;
    private JFrame frame;
    private  MouseInput mouse;
    private String TITLE;
    private KeyHandler key;
    private Terrain terrain;
    private Camera cam;
    private Player p;
    private PopUpFrame pop;
    private Audio audio;
    private Font pixelPlus;
    private Menu menu;

    public static enum STATE {
       MENU,
       GAME
    }

    public static STATE State = STATE.MENU;

    public GamePanel(JFrame frame) {
        super();
        retriveFont();
        setFocusable(true);
        requestFocus();
        TITLE = "2D Platform Game";
        this.frame = frame;
        this.frame.setSize(WIDTH, HEIGHT);
        this.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                tick();
                delta--;
                render();
                frames++;
            }

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                this.frame.setTitle(TITLE + " | " + frames + " FPS");
                System.out.println(frames + " FPS");
                frames = 0;
            }
        }
        stop();
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

     void init() throws IOException {
        this.addKeyListener(key = new KeyHandler());
        this.addMouseListener(mouse = new MouseInput(WIDTH));
        terrain = new Terrain(WIDTH, HEIGHT);
        terrain.readMap2D("C:\\Users\\Administrator.WIN-5GBSLTHUIQC\\RayCaster\\src\\ProjectileGame\\Maps\\map1.txt");
        terrain.init();
        p = new Player(terrain.getPx(), terrain.getPy(), terrain);
        pop = new  PopUpFrame(terrain, p);
        cam = new Camera((float) p.getX(), (float)p.getY(), WIDTH);
        menu = new Menu(WIDTH, HEIGHT, pixelPlus);
        audio = new Audio();
        audio.playMusic();
    }

    void retriveFont() {
        try {
            pixelPlus = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Administrator.WIN-5GBSLTHUIQC\\RayCaster\\src\\ProjectileGame\\Fonts\\04B_30__.TTF")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Administrator.WIN-5GBSLTHUIQC\\RayCaster\\src\\ProjectileGame\\Fonts\\04B_30__.TTF")));
        } catch (IOException | FontFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    void update() {
        if(State == STATE.GAME) {
            p.move(terrain.tiles, terrain.lava, key, audio);
            pop.initClosingDialog();
        }
    }

    private void tick() {
        if(State == STATE.GAME) {
            p.tick();
            cam.tick(p, terrain);
            terrain.tick();
        }
    }

     void render()  {
         // Setting up BufferStrategy
         BufferStrategy bs = frame.getBufferStrategy();
         if (bs == null) {
            frame.createBufferStrategy(3);
            return;
         }

         // Drawing Backdrop
         Graphics g = bs.getDrawGraphics();
         Graphics2D g2 = (Graphics2D) g;
         g2.setColor(Color.BLACK);
         g2.fillRect(0, 0,  WIDTH, HEIGHT);

         if(State == STATE.GAME) {
           // Drawing Stuff
           g2.translate(cam.getX(), cam.getY());
           g2.setColor(Color.CYAN);
           g2.fillRect(-5, (int) -cam.getY(), (int) (terrain.maxX - cam.getX()), (int) (terrain.maxY + cam.getY()));
           p.render(g);
           terrain.render(g2, p, audio);
           g2.translate(-cam.getX(), -cam.getY());

           // Drawing Points
           g.setColor(Color.BLACK);
           g.setFont(pixelPlus);
           g.drawString("Coins: ", 20, 70);
           g.drawString(String.valueOf(terrain.getCoins()), 150, 70);
         } else {
           menu.render(g2);
         }
         // Disposing of graphics
         g.dispose();
         bs.show();

    }
}
