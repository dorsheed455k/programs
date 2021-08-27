package ProjectileGame;

public class Camera {

    private float cx, cy;
    private int WIDTH;
    public Camera(float cx, float cy, int WIDTH) {
        this.cx = cx;
        this.cy = cy;
        this.WIDTH = WIDTH;
    }

    public float getX() {
        return cx;
    }

    public float getY() {
        return cy;
    }

    public void tick(Player p, Terrain terrain) {
        cx = (float) -p.getX() + (float) WIDTH/2;
        cy = (float) -p.getY() + (float) terrain.maxY/2;

         if(cx >= 5) cx = 5;
         if(cy <= 0) cy = 0;
         if(cx <= -(p.maxDistX - 495)) cx = -(p.maxDistX - 495);

       //  System.out.println("cx: " + cx + " cy: " + cy);
    }
}
