import javax.swing.JFrame;

public class Drawer {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(518, 563);

        Canvas c = new Canvas();

        frame.getContentPane().add(c);

        frame.setVisible(true);
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);

    }

}
