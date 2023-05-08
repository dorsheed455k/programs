import com.fazecast.jSerialComm.SerialPort;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main extends ApplicationFrame {

    private JComboBox<String> portList = new JComboBox<>();
    static SerialPort chosenPort;
    private JButton connectButton = new JButton("Connect");
    private float temp1, temp2, temp3;
    private JButton t1 = new JButton("LM35 Sensor");
    private JButton t2 = new JButton("KY-028 Sensor");
    private JButton t3 = new JButton("DHT11 Sensor");


    private JPanel jpanel2;
    private String[] line;

    public Main() {
        super("Temperature Interface");

        JFrame window = new JFrame();
        window.setTitle("Temperature Interface");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(null);

        openingSerialPort();
        JPanel panel1 = new JPanel();
        jpanel2 = new Panel2();

        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.add(portList);
        panel1.add(connectButton);
        panel1.setBounds(5, 0, 700, 45);

        connectingToPort();

        JLayeredPane lp = new JLayeredPane();
        lp.setBounds(10, 70, 60, 350);
        window.getContentPane().add(lp);
        lp.add(panel1);

        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        panel1.setBorder(blackline);

        //t1.setPreferredSize(new Dimension(80, 40));
        t1.setBounds(550, 80, 120, 40);
        t2.setBounds(550, 130, 120, 40);
        t3.setBounds(550, 180, 120, 40);

        t1.setFont(new Font("Arial", Font.PLAIN, 8));
        t2.setFont(new Font("Arial", Font.PLAIN, 8));
        t3.setFont(new Font("Arial", Font.PLAIN, 8));

        window.add(panel1, BorderLayout.NORTH);
        window.add(jpanel2, BorderLayout.CENTER);

        window.add(t1, BorderLayout.EAST);
        window.add(t2, BorderLayout.EAST);
        window.add(t3, BorderLayout.EAST);

        window.setResizable(false);
        window.pack();
        window.setSize(700, 500);
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
                                    line = scanner.nextLine().split(" ");
                                    temp1 = Float.parseFloat(line[0]);
                                    temp2 = Float.parseFloat(line[1]);
                                    temp3 = Float.parseFloat(line[2]);
                                    System.out.println(temp1 + " " + temp2 + " " + temp3);
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

    }

    public float getTemp1() {
        return temp1;
    }
    public float getTemp2() {
        return temp2;
    }
    public float getTemp3() {
        return temp3;
    }


    public void openingSerialPort() {
        SerialPort[] portNames = SerialPort.getCommPorts();
        for (int i = 0; i < portNames.length; i++) {
            portList.addItem(portNames[i].getSystemPortName());
        }
    }

    class Panel2 extends JPanel implements ActionListener {
        Timer timer;
        private static final int TIMER_DELAY = 10;
        DefaultValueDataset dataset;
        float temp = 0;
        boolean th1 = false, th2 = false, th3 = false;


        private static JFreeChart createChart(ValueDataset valuedataset) {
            ThermometerPlot thermometerplot = new ThermometerPlot(valuedataset);
            JFreeChart jfreechart = new JFreeChart("Thermometer Demo 1", JFreeChart.DEFAULT_TITLE_FONT, thermometerplot, true);
            thermometerplot.setInsets(new RectangleInsets(5D, 5D, 5D, 5D));
            thermometerplot.setPadding(new RectangleInsets(10D, 10D, 10D, 10D));
            thermometerplot.setThermometerStroke(new BasicStroke(2.0F));
            thermometerplot.setThermometerPaint(Color.lightGray);
            thermometerplot.setUnits(2);
            thermometerplot.setGap(3);
            return jfreechart;
        }



        Panel2() {
            super(new BorderLayout());
            dataset = new DefaultValueDataset(temp);
            add(new ChartPanel(createChart(dataset)));


            t1.addActionListener(this);
            t2.addActionListener(this);
            t3.addActionListener(this);

            this.setBounds(45, 50, 500, 400);
            this.setBackground(Color.GRAY);
            timer = new Timer(TIMER_DELAY, this);
            timer.start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);


            int LMSensor = (int) getTemp1();
            int ThermSensor = (int) getTemp2();
            int DHTSensor = (int) getTemp3();
            System.out.println(LMSensor + " " + ThermSensor + " " + DHTSensor);


        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dataset.setValue(temp);

            if (e.getSource() == t1) {
                th1 = true;
                th2 = false;
                th3 = false;
            }

            if (e.getSource() == t2) {
                th2 = true;
                th1 = false;
                th3 = false;
            }

            if (e.getSource() == t3) {
                th3 = true;
                th1 = false;
                th2 = false;
            }

            //System.out.println(th1 + " " + th2 + " " + th3);
            if (th1) {
                temp = temp1;
                t1.setBackground(Color.RED);
                t2.setBackground(Color.lightGray);
                t3.setBackground(Color.lightGray);

                t1.setOpaque(true);
                t1.setBorderPainted(false);
            }


            if (th2) {
                temp = temp2;
                t2.setBackground(Color.RED);
                t1.setBackground(Color.lightGray);
                t3.setBackground(Color.lightGray);

                t2.setOpaque(true);
                t2.setBorderPainted(false);
            }

            if (th3) {
                temp = temp3;
                t3.setBackground(Color.RED);
                t1.setBackground(Color.lightGray);
                t2.setBackground(Color.lightGray);

                t3.setOpaque(true);
                t3.setBorderPainted(false);
            }

            repaint();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
