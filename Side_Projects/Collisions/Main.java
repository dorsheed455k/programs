public class Main {
 
    public Main() {
        JFrame frame  = new JFrame("Collisions");
        frame.pack();
        frame.add(new GraphicsDemo(frame));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
  
}
