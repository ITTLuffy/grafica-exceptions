import javax.swing.JFrame;

public class Drawer {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(670, 790);

        // canvas
        Canvas c = new Canvas();
        frame.add(c);

        frame.setVisible(true);
        
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);

    }

}
