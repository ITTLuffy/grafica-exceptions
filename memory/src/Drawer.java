
import javax.swing.JFrame;

public class Drawer {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Memory Game");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // canvas

        Canvas gioco = new Canvas();
        frame.getContentPane().add(gioco);
        frame.setSize(600, 630);
        frame.setVisible(true);

        frame.setLocationRelativeTo(null);
    }
}
