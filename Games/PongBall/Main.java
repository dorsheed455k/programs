import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JComponent  implements ActionListener, MouseMotionListener {
    private  int BallX = -15;
    private  int BallY = 20;
    private  int BallXspeed = 10;
    private  int BallYspeed  = 12;
    private int paddleX;
    private int paddleY = 522;
    private int count = 0;
    private int highScore = 0;
    private int cloudX[][] = {{177, 150}, {290, 263}, {70,43}};
    private static JButton play = new  JButton("Play");
    private static JButton pause = new  JButton("Pause");

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Main game = new Main();
        game.setDefaultLookAndFeel();
        frame.setTitle("Pong ball game");
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        play.setBounds(0,0,90,40);
        pause.setBounds(90,0,90,40);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == play) {
                 Timer t = new Timer(100, game);
                 t.start();
                }
            }
        });
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == pause) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        frame.add(play);
        frame.add(pause);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.addMouseMotionListener(game);
    }

    public void setDefaultLookAndFeel() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {

        }
    }

        public Dimension getPreferredSize() {
            return new Dimension(800,680);
        }

         public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;

             GradientPaint gr = new GradientPaint(100,300,Color.cyan,100,50,Color.BLUE);
             g2.setPaint(gr);
             g2.fillRect(0,40,800,760);
             g2.fillRect(180,0,620,770);
             Color greyWhite = new Color(0xD3DBD7);
             Color grey = new Color(0xA6AEAA);

             // cloud 1
             g2.setColor(grey);
             g2.fillRect(cloudX[0][0],80,100,20);
             g2.fillRect(cloudX[0][1],100,150,30);
            // cloud 2
             g2.setColor(greyWhite);
             g2.fillRect(cloudX[1][0],250,100,20);
             g2.fillRect(cloudX[1][1],270,150,30);
             // cloud 3
             g2.setColor(Color.white);
             g2.fillRect(cloudX[2][0],320,100,20);
             g2.fillRect(cloudX[2][1],340,150,30);

            int[] grassRectX = {0,150,300,450,600,750};
            Image image1 = new ImageIcon("PIXEL-Grass2.JPG").getImage();
            for (int i = 0; i < grassRectX.length; i++) {
                g2.drawImage(image1, grassRectX[i], 550, 150, 160, this);
            }

            g2.setColor(new Color(0xFF5E28));
            Image image2 = new ImageIcon("Ball2.png").getImage();
            g.drawImage(image2,BallX,BallY,60,60, this);

            g2.setColor(new Color(0x0E0C20));
            g2.fillRect(paddleX, paddleY,100,20);

            g2.setColor(Color.white);
            g2.setFont(new Font("GB18030 Bitmap", Font.BOLD, 30));
            g2.drawString("Points: ", 630,40);
            g2.drawString(String.valueOf(count), 750,40);
            g2.drawString("High Score: ", 553,70);
            g2.drawString(String.valueOf(highScore), 750,70);


        }

       @Override
        public void actionPerformed(ActionEvent e) {
            BallX = BallX + BallXspeed;
            BallY = BallY + BallYspeed;


            if (BallX >= paddleX-5 && BallX <= paddleX + 100 && BallY >= paddleY - 36) {
                BallYspeed = -12;
                count++;
            }

            if (BallY >= 520) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                if(count > highScore) {
                    int temp = count;
                    highScore = count;
                    temp = highScore;
                }
                BallY = 0;
                BallX = 0;
                count = 0;
            }

            if (BallX >= 765) {
                BallXspeed = -10;
            }


            if (BallY <= -10) {
                BallYspeed = + 12;
            }
            if (BallX <= -15) {
                BallXspeed = + 10;
            }


            for (int i = 0; i < 2; i++) {
                cloudX[0][i] = cloudX[0][i] + 5;
                if (cloudX[0][1] >= 810 ) {
                    cloudX[0][1] = - 155;
                    cloudX[0][0] = - 128;
                }
            }
            for (int i = 0; i < 2; i++) {
                cloudX[1][i] = cloudX[1][i] + 7;
                if (cloudX[1][1] >= 810 ) {
                    cloudX[1][1] = - 155;
                    cloudX[1][0] = - 128;
                }
            }

            for (int i = 0; i < 2; i++) {
                cloudX[2][i] = cloudX[2][i] + 4;
                if (cloudX[2][1] >= 810 ) {
                    cloudX[2][1] = - 155;
                    cloudX[2][0] = - 128;
                }
            }

            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            paddleX = e.getX();
        }


        @Override
        public void mouseMoved(MouseEvent e) {
            paddleX = e.getX()-50;
            repaint();
        }
    }
