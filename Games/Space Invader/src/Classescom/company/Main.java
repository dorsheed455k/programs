package Classescom.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends Canvas implements KeyListener, ActionListener   {
    private final int WIDTH = 600, HEIGHT = 700;
    private SpriteCropper crop = new SpriteCropper();
    private int by, bx, laserWidth, laserHeight, points = 0;
    private final int[] yPosition = {-40, -40, -40}, xPosition = {100, 250, 500};
    private Timer t;
    private boolean readytoFire, fire = false, collide, explode = false;
    private boolean launch1 = false;
    private boolean launch2 = false;
    private boolean launch3 = false;
    private Image BACK = new ImageIcon("img/background-black.png").getImage();
    private BufferedImage YELLOW_Ship;
    private BufferedImage[] Enemy = {
            crop.trimImage(ImageIO.read(new File("img/pixel_ship_red_small.png"))),
            crop.trimImage(ImageIO.read(new File("img/pixel_ship_blue_small.png"))),
            crop.trimImage(ImageIO.read(new File("img/pixel_ship_green_small.png")))
            };
    private BufferedImage EXPLOSION, Player_LASER, Red_LASER, Blue_LASER, Green_LASER;
    private BufferedImage rightKey = ImageIO.read(new File("img/keyboard_key_right.png"));
    private BufferedImage leftKey = ImageIO.read(new File("img/keyboard_key_left.png"));
    private BufferedImage spaceBarKey = ImageIO.read(new File("img/spaceBar.png"));
    private int x;
    private int y;
    private int[] ey = new int[3];
    private int[] ex = new int[3];
    private int [] lsx = {20,10,20};
    private int healthWidth = 100;
    private int highScore = 0;
    private boolean displayTitle = true;


    Main() throws IOException
    {
        new Window(WIDTH, HEIGHT, "Space Invaders", this);
        YELLOW_Ship = crop.trimImage(ImageIO.read(new File("img/pixel_ship_yellow.png")));
        x = WIDTH / 2 - 50;
        y = HEIGHT - YELLOW_Ship.getHeight() - 100;
     }


    @Override
    public void actionPerformed(ActionEvent e)
    {

        EnemyShift();
        launch();
        shoot();

        try {
            setRed_LASERS();
            setBlue_LASER();
            setGreen_LASER();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        playerHit();

        try {
            lostDialog();
        } catch (IOException | InterruptedException e1) {
            e1.printStackTrace();
        }

        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(BACK, 0, 0, WIDTH, HEIGHT, this);

        // Drawing lasers
        drawLaser(g2);
        drawRedLaser(g2);
        drawBlueLaser(g2);
        drawGreenLaser(g2);

        // Drawing player ship
        g.drawImage(YELLOW_Ship, x, y, 100, 90, this);
        for (int i = 0; i < Enemy.length; i++) {
            g2.drawImage(Enemy[i], xPosition[i], yPosition[i], Enemy[i].getWidth(this), Enemy[i].getHeight(this), this);
        }

        // Drawing Explosion
        drawExplosion(g2);
        drawTitle(g2);
        removeTitle(g2);


    }

      void drawTitle(Graphics2D g2)
      {
        if(displayTitle) {
            g2.setColor(Color.white);
            g2.setFont(new Font("Eras Bold ITC", Font.ITALIC, 50));
            g2.drawString("SPACE INVADERS ", 70, 200);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g2.setFont(new Font("GB18030 Bitmap", Font.BOLD, 20));
            g2.drawString("Press 'P' to play ", 220, 250);
            g2.drawString("Press 'A' to pause ", 220, 270);
            g2.drawString(" Press ", 175, 320);
            g2.drawImage(rightKey, 240, 295, 30,30, this);
            g2.drawString(" key to move right ", 270, 320);
            g2.drawString(" Press ", 175, 355);
            g2.drawImage(leftKey, 240, 330, 30,30, this);
            g2.drawString(" key to move left ", 270, 355);
            g2.drawString(" Press ", 160, 385);
            g2.drawImage(spaceBarKey, 190, 305, 150,150, this);
            g2.drawString(" key to move left ", 300, 385);
        }

    }

     void removeTitle(Graphics g2)
     {
        if (!displayTitle) {
            g2.setColor(Color.red);
            g2.fillRect(x, y - 20, 100, 15);
            g2.setColor(Color.green);
            g2.fillRect(x, y - 20, healthWidth, 15);
            g2.drawImage(YELLOW_Ship, x, y, 100, 90, this);

            g2.setColor(Color.white);
            g2.setFont(new Font("GB18030 Bitmap", Font.BOLD, 30));
            g2.drawString("Points: ", 420, 40);
            g2.drawString(String.valueOf(points), 530, 40);
            g2.drawString("High score: ", 10, 40);
            g2.drawString(String.valueOf(highScore), 185, 40);
            if (!fire) {
                g2.setFont(new Font("GB18030 Bitmap", Font.BOLD, 20));
                g2.drawString("Charging... ", 450, 70);
            }
        }
    }

     void drawLaser(Graphics g2)
     {
        if(fire) {
            g2.drawImage(Player_LASER, bx, by, laserWidth, laserHeight, this);
        }
     }

     void drawRedLaser(Graphics g2)
     {
        if (Red_LASER != null) {
            if(launch1) {
                g2.drawImage(Red_LASER, ex[0], ey[0], Red_LASER.getWidth(), Red_LASER.getHeight(), this);
            }
        }
     }

     void drawBlueLaser(Graphics g2)
     {
        if (Blue_LASER != null) {
            if(launch2) {
                g2.drawImage(Blue_LASER, ex[1], ey[1], Blue_LASER.getWidth(), Blue_LASER.getHeight(), this);
            }
        }
     }

     void drawGreenLaser(Graphics g2)
     {
        if (Green_LASER != null) {
            if(launch3) {
                g2.drawImage(Green_LASER, ex[2], ey[2], Green_LASER.getWidth(), Green_LASER.getHeight(), this);
            }
        }
     }

     void drawExplosion(Graphics g2)
     {
        if (explode) {
            g2.drawImage(EXPLOSION, bx - 50, by - 20, 100, 87, this);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            collide = false;
            explode = false;
            bx = x;
            by = y;
            Player_LASER = null;
            EXPLOSION = null;
        }
     }

    public int playerWIDTH()
    {
        return WIDTH - YELLOW_Ship.getWidth(this);
    }

    public int yRandPosition()
    {
        return (int) (Math.random() * -100 + 1);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        int xSpeed = 20;
        switch (key) {
            case KeyEvent.VK_P:
                displayTitle = false;
                t = new Timer(100, this);
                t.start();
                break;
            case KeyEvent.VK_A:
                t.stop();
                break;
            case KeyEvent.VK_LEFT:
                x -= xSpeed;
                System.out.println("You clicked left.");
                break;
            case KeyEvent.VK_RIGHT:
                x += xSpeed;
                System.out.println("You clicked right.");
                break;
            case KeyEvent.VK_SPACE:
                if (Player_LASER == null) {
                    readytoFire = true;
                    try {
                        Player_LASER = crop.trimImage(ImageIO.read(new File("img/pixel_laser_yellow.png")));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    by = y;
                    bx = x + (YELLOW_Ship.getWidth()/2)+2;
                    laserWidth = Player_LASER.getWidth(this);
                    laserHeight = Player_LASER.getHeight(this);
                    fire = true;
                }
              }
              repaint();
        }

    @Override
    public void keyReleased(KeyEvent e)
    {
     int key = e.getKeyCode();
     switch (key) {
         case KeyEvent.VK_LEFT:
             x = x;
             break;
         case KeyEvent.VK_RIGHT:
             x = x;
             break;
         case KeyEvent.VK_SPACE:
             readytoFire = false;
             if (by <= -Player_LASER.getHeight()) {
                 Player_LASER = null;
                 fire = false;
                 readytoFire = true;
             }
         }
     }

    public void shoot()
    {
        if (fire) {
            by = by - 20;
            try {
                collision();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        // Not using this method
    }

    public void collision() throws IOException
    {
      for (int i = 0; i < xPosition.length; i++)
          if (bx >= xPosition[i] && bx <= xPosition[i] + Enemy[i].getWidth() && by <= yPosition[i] + Enemy[i].getHeight()) {
              readytoFire = false;
              if (EXPLOSION == null) {
                  points += 5;
                  collide = true;
                  EXPLOSION = crop.trimImage(ImageIO.read(new File("img/pixel_Explosion2.png")));
                  explode = true;
                  yPosition[i] = yRandPosition() - 100;
                  switch (xPosition[i]) {
                      case 100:
                          xPosition[i] = 250;
                          break;
                      case 250:
                          xPosition[i] = 500;
                          break;
                      case 500:
                          xPosition[i] = 100;
                          break;
                  }
                  Player_LASER = null;
                  fire = false;
                  readytoFire = true;
              }
          }
    }

     void setRed_LASERS() throws IOException
     {
      if (yPosition[0] >= (Math.random() * 400) + 1 && yPosition[0] <= 550) {
          boolean enemyFire1 = true;
          if (Red_LASER == null) {
              Red_LASER = crop.trimImage(ImageIO.read(new File("img/pixel_laser_red.png")));
              ey[0] = yPosition[0];
              ex[0] = xPosition[0] + lsx[0];
              launch1 = true;
          }

          if (ey[0] >= HEIGHT + 30) {
              enemyFire1 = false;
              Red_LASER = null;
          }
        }
     }


      void setBlue_LASER() throws IOException
      {
        if (yPosition[1] >= (Math.random() * 400) + 50 && yPosition[1] <= 550) {
            boolean enemyFire2 = true;
            if (Blue_LASER == null) {
                Blue_LASER = crop.trimImage(ImageIO.read(new File("img/pixel_laser_blue.png")));
                ey[1] = yPosition[1];
                ex[1] = xPosition[1] + lsx[1];
                launch2 = true;
            }
            if (ey[1] >= HEIGHT + 30) {
                enemyFire2 = false;
                Blue_LASER = null;
            }
        }
      }

     void setGreen_LASER() throws IOException
     {
      if (yPosition[2] >= (Math.random() * 400) + 50 && yPosition[2] <= 550) {
          boolean enemyFire3 = true;
          if (Green_LASER == null) {
              Green_LASER = crop.trimImage(ImageIO.read(new File("img/pixel_laser_green.png")));
              ey[2] = yPosition[2];
              ex[2] = xPosition[2] + lsx[2];
              launch3 = true;
            }
          if (ey[2]  >= HEIGHT + 30) {
              enemyFire3 = false;
                Green_LASER = null;
          }
        }
     }

     void playerHit()
     {
         if (Red_LASER != null && Blue_LASER != null && Green_LASER != null) {
             for (int i = 0; i < ey.length; i++) {
                 if (ey[i] + Red_LASER.getHeight() >= y && ex[i] >= x && ex[i] <= x + 80) {
                     ey[i] = yPosition[i];
                     ex[i] = xPosition[i] + lsx[i];
                     healthWidth -= 2;
                 }
                 if (yPosition[i] + Enemy[i].getHeight() >= y && xPosition[i] >= x && xPosition[i] <= x + YELLOW_Ship.getWidth()) {
                     yPosition[i] = yRandPosition() - 10;
                     switch(xPosition[i]) {
                         case 100:
                             xPosition[i] = 250;
                             break;
                         case 250:
                             xPosition[i] = 500;
                             break;
                         case 500:
                             xPosition[i] = 100;
                             break;
                     }
                     healthWidth -= 5;
                 }
             }
         }
     }


     void lostDialog() throws IOException, InterruptedException
     {
       if (healthWidth <= 0) {
        for (int i = 0; i < yPosition.length; i++) {
            by = y;
            bx = x;
            EXPLOSION = crop.trimImage(ImageIO.read(new File("img/pixel_Explosion2.png")));
            Thread.sleep(100);
            EXPLOSION = null;
            t.stop();
            int a = JOptionPane.showConfirmDialog(this, "You lost! The enemy has invaded!\n" +
                    "\t\t\t\tPlay Again?");
            if (a == JOptionPane.YES_OPTION) {
                if (highScore < points) {
                    highScore = points;
                }
                points = 0;
                healthWidth = 100;
                yPosition[i] = 40;
                x = WIDTH / 2 - 50;
                xPosition[0] = 100;
                xPosition[1] = 250;
                xPosition[2] = 500;
                t.start();
            } else if (a == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
          }
       }
     }

    void launch()
    {
        if (launch1) ey[0] = ey[0] + 20;
        if (launch2) ey[1] = ey[1] + 20;
        if (launch3) ey[2] = ey[2] + 20;

    }

     void EnemyShift()
    {
        int ySpeed = 3;
        for (int i = 0; i < yPosition.length; i++) {
            yPosition[i] = yPosition[i] + ySpeed;
            if (yPosition[i] >= HEIGHT) {
                yPosition[i] = yRandPosition();
                ySpeed++;
                if (xPosition[i] == 100) {
                    xPosition[i] = 250;
                } else if (xPosition[i] == 250) {
                    xPosition[i] = 500;
                } else if (xPosition[i] == 500) {
                    xPosition[i] = 100;
                }
                ySpeed = ySpeed + 5;
                healthWidth -= 5;
            }
        }
        if (x <= 5) {
            x = 5;
        } else if (x >= playerWIDTH() - 20) {
            x = playerWIDTH() - 20;
        }
    }
}
