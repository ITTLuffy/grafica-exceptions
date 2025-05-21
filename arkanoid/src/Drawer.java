
import javax.swing.JFrame;

public class Drawer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Arkanoid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Canvas c = new Canvas();
        frame.getContentPane().add(c);

        frame.setSize(450, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
