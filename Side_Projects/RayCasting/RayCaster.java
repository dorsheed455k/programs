import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyListener;

public class RayCaster implements Runnable, KeyListener  {

    private final int HEIGHT = 545, WIDTH = 1000;
    private float px, py, pdx, pdy, pa;
    int x, y;
    private final double PI = Math.PI, PI2 = Math.PI/2, PI3 = 3*Math.PI/2;
    private Thread thread;
    private MouseInput mouse;
    private boolean running = false;
    private final double DR = 0.0174533;
    private final String title = "Ray Caster";
    private int mapX = 8, mapY = 8, mapS = 64;
    private Canvas canvas;
    private JFrame frame;
     int[] map =
            {
                    1, 1, 1, 1, 1, 1, 1, 1,
                    1, 0, 0, 0, 0, 0, 0, 1,
                    1, 0, 0, 0, 0, 0, 0, 1,
                    1, 0, 0, 0, 0, 0, 0, 1,
                    1, 0, 0, 0, 0, 0, 0, 1,
                    1, 0, 0, 0, 0, 0, 0, 1,
                    1, 0, 0, 0, 0, 0, 0, 1,
                    1, 1, 1, 1, 1, 1, 1, 1
            };

    public RayCaster()
    {

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas = new Canvas();
        mouse = new MouseInput();
        canvas.addMouseListener(mouse);
        canvas.addMouseMotionListener(mouse);
        frame.getContentPane().add(canvas);
        frame.addKeyListener(this);
        frame.setSize(WIDTH,HEIGHT+50);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.start();
    }

    public void init() {
        // Setting player position
        px = 300; py = 400;
        x = 0; y = 0;
        pdx = (int) Math.cos(pa)*5;
        pdy= (int) Math.sin(pa)*5;
        mouse.getMap(map);
        mouse.getX(x);
        mouse.getX(y);
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
        g.setColor(Color.BLACK);
        g.fillRect(0,0,canvas.getWidth(), canvas.getHeight());

        Color cl = new Color(0x114FB7);
        g.setColor(cl);
        g.fillRect(0,0, WIDTH,HEIGHT);
        Graphics2D g2 = (Graphics2D) g;


        drawMap2D(g2);
        drawGrid(g2);
        drawPlayer(g2);

        GradientPaint gr = new GradientPaint(512,0,Color.BLUE, 512, 75, Color.CYAN);
        g2.setPaint(gr);
        g.fillRect(512,0,512,150);

        drawRays3d(g2);

        g.dispose();
        bs.show();
    }

    private void update() {
        //TODO
        map = mouse.setMap();
        x = mouse.setmX();
        y = mouse.setmY();
    }

    void drawMap2D(Graphics2D g2)
    {
        int x, y, xo, yo;
        for (y = 0; y < mapY; y++) {
            for (x = 0; x < mapX; x++) {
                if(map[y*mapX+x] == 1) {
                    g2.setColor(Color.white);
                } else {
                    g2.setColor(Color.black);
                }
                xo = x*mapS; yo = y*mapS;
                g2.fillRect(xo,yo, 64,64);
            }
        }
    }

    void drawGrid(Graphics2D g2) {
        g2.setColor(Color.GRAY);
        for (int i = 0; i < 8; i++) {
            g2.drawLine(64*i,0,64*i,512);
        }

        for (int i = 0; i < 8; i++) {
            g2.drawLine(0,64*i,512,64*i);
        }
    }

    void drawPlayer(Graphics2D g2)
    {
        g2.setColor(Color.yellow);
        g2.fill(new Ellipse2D.Float(px,py, 10,10));
    }

    public float dist(float ax, float ay, float bx, float by)
    {
        return (float) Math.sqrt((bx-ax)*(bx-ax) + (by-ay)*(by-ay));
    }

    void drawRays3d(Graphics2D g2)
    {
        int r, mx, my, mp, dof;
        float rx = 0, ry = 0, ra, xo = 0, yo = 0, distT = 0;
        ra = (float) (pa-DR*30);
        if(ra < 0) { ra += 2 * PI; }
        if(ra > 2*PI) {ra -= 2*PI;}

        for (r= 0; r < 60; r++)
        {
            // Horizontal Lines
            float distH = 1000000, hx = px, hy = py;
            dof = 0;
            float aTan = (float) (-1 / Math.tan(ra));
            if(ra > PI) { ry = (float) ((((int) py >> 6) << 6) -0.0001); rx = (py-ry)*aTan+px; yo = -64;xo = -yo*aTan;}
            if(ra < PI) { ry = (float) ((((int) py >> 6) << 6) + 64); rx = (py-ry)*aTan+px; yo = 64; xo = -yo*aTan;}
            if(ra == 0 || ra == PI) {rx = px; ry = py; dof = 8;}
            while (dof < 8)
            {
                mx = (int) (rx) >> 6; my = (int) (ry) >> 6; mp = my*mapX + mx;
                if(mp > 0 && mp < mapX*mapY && map[mp]>0) {hx = rx; hy = ry; distH = dist(px,py,hx,hy); dof = 8;}
                else  {rx += xo; ry += yo; dof += 1;}
            }

            // Vertical Lines
            float distV = 1000000, vx = px, vy = py;
            dof = 0;
            float nTan = (float) (-Math.tan(ra));
            if(ra > PI2 && ra < PI3) { rx = (float) ((((int) px >> 6) << 6) -0.0001); ry = (px-rx)*nTan+py; xo = -64; yo = -xo*nTan;}
            if(ra < PI2 || ra > PI3) { rx = (float) ((((int) px >> 6) << 6) + 64); ry = (px-rx)*nTan+py; xo = 64; yo = -xo*nTan;}
            if(ra == 0 || ra == PI) {rx = px; ry = py; dof = 8;}
            while (dof < 8)
            {
                mx = (int) (rx) >> 6; my = (int) (ry) >> 6; mp = my*mapX + mx;
                if(mp > 0 && mp < mapX*mapY && map[mp]>0) {vx = rx; vy = ry; distV = dist(px,py,vx,vy); dof = 8;}
                else  {rx += xo; ry += yo; dof += 1;}
            }
            if(distV < distH) {
                rx = vx;
                ry = vy;
                distT = distV;
                Color c1 = new Color(91, 208, 24);
                g2.setColor(c1);
            }
            if(distH < distV) {
                rx = hx;
                ry = hy;
                distT = distH;
                Color c2 = new Color(17, 139, 39);
                g2.setColor(c2);
            }
            g2.setStroke(new BasicStroke(1));
            g2.draw(new Line2D.Float(px+5,py+5,rx,ry));

            // Walls
            float ca = pa - ra;
            if(ca < 0) {ca += 2*PI;}
            if(ca >  2*PI) {ca -= 2*PI;}
            distT = (float) (distT *Math.cos(ca));
            float lineH = (mapS*320)/ distT;
            float lineO = 160 - lineH/2;
            if(lineH > 320) {
                lineH = 320;
            }
            g2.setStroke(new BasicStroke(8));
            g2.draw(new Line2D.Float(r*8+516, lineO, r*8+516,lineH+lineO));
            ra += DR; if(ra < 0) { ra += 2 * PI;} if(ra > 2*PI) {ra -= 2*PI;}
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT) {
            pa += 0.1; if(pa > 2*PI) { pa -= 2*PI; }
            pdx = (float) Math.cos(pa)*5;
            pdy= (float) Math.sin(pa)*5;
        }
        if(key == KeyEvent.VK_LEFT) {
            pa -= 0.1; if(pa < 0) { pa += 2* PI; }
            pdx =  (float) Math.cos(pa)*5;
            pdy= (float) Math.sin(pa)*5;
        }
        if(key == KeyEvent.VK_UP) { px += pdx; py += pdy; }
        if(key == KeyEvent.VK_DOWN) { px -= pdx; py -= pdy; }

        canvas.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new RayCaster();
    }

}
