import javax.swing.JFrame;

public class Drawer {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Chess");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // canvas
        frame.setSize(600, 630);
        frame.setVisible(true);

        frame.setLocationRelativeTo(null);
    }
}
