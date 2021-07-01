import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class MouseInput implements MouseListener, MouseMotionListener {
    private int x, y;
    private int mx, my;
    private int WIDTH;
    private int[] map;
    private int mapSqrt = 8;

    public MouseInput() {
        this.WIDTH = WIDTH;
        x = 0;
        y = 0;
    }

    public void getMap(int[] arr) {
        this.map = arr;
    }

    public void getX(int x) {
        this.mx = x;
    }

    public void getY(int y) {
        this.my = y;
    }

    public int[] setMap() {
        return map;
    }

    public int setmX() {
       return mx;
    }

    public int setmY() {
        return my;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        for (int i = 0; i < 8; i++) {
            if (x >= i * 64 && x < (i * 64) + 64) {
                for (int j = 0; j < 8; j++) {
                    if (y >= j * 64 && y < (j * 64) + 64) {
                        System.out.println((i+1) + ", " + (j+1));
                        System.out.println(i*mapSqrt+j);
                       if (map[j*mapSqrt+i] == 0) map[j*mapSqrt+i] = 1;
                       else map[j*mapSqrt+i] = 0;
                    }
                }
            }
            //  System.out.println(e.getX() + " " + e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
      //  System.out.println(x + " " + y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
    }
}
