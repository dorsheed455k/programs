import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends JFrame {

    private JPanel jPanel2;
    private JButton play = new JButton("Play");
    private JButton pause = new JButton("Pause");
    private JButton speedUp = new JButton("+");
    private JButton slowDown = new JButton("-");
    private JTextField tf = new JTextField("Distance");
    private JButton connectButton = new JButton("Connect");

    private JComboBox<String> portList = new JComboBox<>();
    static SerialPort chosenPort;

    private String line;

    public Main() {
        JFrame window = new JFrame();
        window.setTitle("Sensor Track");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(null);

        openingSerialPort();
        JPanel panel1 = new JPanel();
        jPanel2 = new Panel2();

      //  AccelerometerService accelerometerService= new AccelerometerService.create().get();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.add(play);
        panel1.add(pause);
        panel1.add(speedUp);
        panel1.add(slowDown);
        panel1.add(portList);
        panel1.add(connectButton);
        panel1.add(tf);
        panel1.setBounds(5, 0, 575, 45);

       connectingToPort();

        JLayeredPane lp = new JLayeredPane();
        lp.setBounds(10, 70, 540, 350);
        window.getContentPane().add(lp);
        lp.add(panel1);


        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        panel1.setBorder(blackline);


        window.add(panel1, BorderLayout.NORTH);
        window.add(jPanel2, BorderLayout.CENTER);
        window.setResizable(false);
        window.setSize(600, 400);
        window.setVisible(true);

    }

    public void connectingToPort() {
        connectButton.addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent arg0) {
                if(connectButton.getText().equals("Connect")) {
                    // attempt to connect to the serial port
                    chosenPort = SerialPort.getCommPort(portList.getSelectedItem().toString());
                    chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
                    if(chosenPort.openPort()) {
                        connectButton.setText("Disconnect");
                        portList.setEnabled(false);
                    }

                    // create a new thread that listens for incoming text and populates the graph
                    Thread thread = new Thread(){
                        @Override public void run() {
                            Scanner scanner = new Scanner(chosenPort.getInputStream());
                            while(scanner.hasNextLine()) {
                                try {
                                    line = scanner.nextLine();
                                    int number = Integer.parseInt(line);
                                    tf.setText(line);
                                } catch(Exception e) {}
                            }
                            scanner.close();
                        }
                    };
                    thread.start();
                } else {
                    // disconnect from the serial port
                    chosenPort.closePort();
                    portList.setEnabled(true);
                    connectButton.setText("Connect");
                }
            }
        });

      /*   AcceleromterServices service;

        try {
            service = AccelerometerService.create().get();
            System.out.println("Got accelerometer service.");
        } catch (Exception e) {
            // No accelerometer, using mouse events.
            System.out.println("No accelerometer service.");
        } */

    }

    public void openingSerialPort() {
        SerialPort[] portNames = SerialPort.getCommPorts();
        for (int i = 0; i < portNames.length; i++) {
            portList.addItem(portNames[i].getSystemPortName());
        }
    }

    class Panel2 extends JPanel implements ActionListener{
        private int xVel = 1;
        private int yVel = 1;

        private static int[] xPos = {230, 270, 340, 160};
        private static int[] yPos = {70, 70, 140, 140};
        private static final int TIMER_DELAY = 10;
        private ArrayList<Polygons> polygonsList = new ArrayList<>();
        Timer timer;

        Panel2() {
            play.addActionListener(this);
            pause.addActionListener(this);
            speedUp.addActionListener(this);
            slowDown.addActionListener(this);
            connectButton.addActionListener(this);

            polygonsList.add(new Polygons(new int[]{230, 270, 316, 184}, new int[]{70, 70, 116, 116}));
            polygonsList.add(new Polygons(new int[]{184, 316, 362, 138}, new int[]{116, 116, 162, 162}));
            polygonsList.add(new Polygons(new int[]{138, 362, 408, 92}, new int[]{162, 162, 208, 208}));
            polygonsList.add(new Polygons(new int[]{92, 408, 454, 46}, new int[]{208, 208, 254, 254}));
            polygonsList.add(new Polygons(new int[]{46, 454, 500,0}, new int[]{254, 254, 300, 300}));
            polygonsList.add(new Polygons(new int[]{0, 480, 550, -46}, new int[]{300, 300, 346, 346}));
            polygonsList.add(new Polygons(new int[]{-46, 526, 596, -92}, new int[]{346, 346, 392, 392}));


            this.setBounds(45, 50, 500, 300);
            this.setBackground(Color.GREEN);
            timer = new Timer(TIMER_DELAY, this);
            timer.start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);


            g2.setColor(Color.RED);
            g2.drawLine(230, 70, 0, 300);
            g2.drawLine(270, 70, 500, 300);


            for (Polygons polygon: polygonsList) {
                polygon.draw(g2);
            }

            GradientPaint cylu = new GradientPaint(0, 0, Color.BLUE, 0, 70, Color.CYAN);
            g2.setPaint(cylu);
            g2.fillRect(0,0,500, 70);

            GradientPaint yelge = new GradientPaint(0, 0, Color.YELLOW, 0, 40, Color.ORANGE);
            g2.setPaint(yelge);
            g2.fillOval(30, 10, 40, 40);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
          //  connectingToPort();
            for (Polygons polygon: polygonsList) {
                for (int i = 0; i < 4; i++) {
                    polygon.getYPoints()[i] += yVel;
                }
                polygon.getXPoints()[0] -= xVel;
                polygon.getXPoints()[3] -= xVel;
                polygon.getXPoints()[1] += xVel;
                polygon.getXPoints()[2] += xVel;

                if (polygon.getYPoints()[0]  >= 346 || polygon.getYPoints()[1]  >= 346) {
                    polygon.getYPoints()[0] = 24;
                    polygon.getYPoints()[1] = 24;
                    polygon.getYPoints()[2] = 70;
                    polygon.getYPoints()[3] = 70;

                    polygon.getXPoints()[0] = 276;
                    polygon.getXPoints()[1] = 224;
                    polygon.getXPoints()[2] = 270;
                    polygon.getXPoints()[3] = 230;
                }
            }
            speed(e);
            pausePanel(e);
            playPanel(e);

            System.out.println(line);

            repaint();
        }

        public void speed(ActionEvent e) {
            if (e.getSource() == speedUp) {
                xVel += 1;
                yVel += 1;
            }
            if (e.getSource() == slowDown) {
                xVel -= 1;
                yVel -=  1;
                if (xVel == -1) {
                    xVel = 0;
                    yVel = 0;
                }
            }

            if (line != null) {
                int distance = Integer.parseInt(line);
                if (distance >= 130) {
                    xVel = 0;
                    yVel = 0;
                } else if (distance >= 90) {
                    xVel = 2;
                    yVel = 2;
                } else if (distance >= 50) {
                    xVel = 4;
                    yVel = 4;
                } else if (distance >= 10) {
                    xVel = 6;
                    yVel = 6;
                } else {
                    xVel = 8;
                    yVel = 8;
                }
            }
        }

        public void pausePanel(ActionEvent e) {
            if (e.getSource() == pause) {
                timer.stop();
            }
        }

        public void playPanel(ActionEvent e) {
            if (e.getSource() == play) {
                timer = new Timer(10, this);
                timer.start();
            }
        }
    }

    public static void main(String[] args) {
       new Main();
    }
}
