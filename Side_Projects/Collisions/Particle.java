import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Particle {
    private Shape oval;
    private float radius, width;
    private float mass;
    float cx, cy;
    float velX, velY;
    float velocity;
    double dt = 0;
    long lastTime = System.currentTimeMillis();
    Color cl;

    Particle(int r, int x, int y, Color cl) {
        this.radius = r;
        this.cx = x;
        this.cy = y;
        width = radius*2;
        velX = (float) Math.floor(Math.random() * 10 - 4);
        velY = (float) Math.floor(Math.random() * 10 - 4);
        this.cl = cl;
        mass = (float) Math.pow(this.radius, 3);
    }

    public void tick(double val) {
        this.dt = val;
     //   this.dt *= 50;
    }

    void move() {
        cx += velX * dt;
        cy += velY * dt;
    }

    float area() {
        return (float) (Math.PI * radius * radius);
    }

    float circumference(){
        return (float) (2 * Math.PI * radius);
    }

    float angle() {
        return (float) Math.atan2(velX, velY);
    }

    float speed() {
        return (float) Math.sqrt(Math.pow(velX, 2) + Math.pow(velY, 2));
    }


    void changeSize(JSlider sl) {
        radius = sl.getValue();
    }

    void render(Graphics2D g) {
        g.setColor(cl);
        float[] fa = {10, 10, 10};
        BasicStroke bs = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10, fa, 10);
       // g.setStroke(bs);
     //   g.drawString(String.valueOf((int)cx + ", " + (int)cy), cx, cy);
        oval = new Ellipse2D.Double(cx, cy, width, width);
        g.fill(oval);
      //  g.fill(new Ellipse2D.Double(cx, cy, 5, 5));
    }

 //   public void setCx(double val) {cx = val;}
 //   public void setCy(double val) {cy = val;}
   // public void setColor(Color val) { cl = val; }
    public void setVelx(float val) { velX = val; }
    public void setVely(float val) { velY = val; }

    public float getCx(){  return cx;  }
    public float getWidth() { return width; };
    public float getCy(){  return cy;  }
    public float getVx(){  return velX; }
    public Shape getOval() { return oval; }
    public float getVy(){  return velY;}
    public float getRadius(){  return radius;  }
    public float getMass(){    return mass;    }

}
