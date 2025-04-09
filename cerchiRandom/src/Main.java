import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        JFrame f = new JFrame("Cerchi randomizzati");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int w = 600;
        int h = 400;
        f.setSize(w, h);

        Canvas c = new Canvas(w, h);
        f.add(c);

        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

}
