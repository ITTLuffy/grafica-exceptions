import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    Random r = new Random();
    private int width, height;
    private ArrayList<Cerchio> cerchi;

    public Canvas(int w, int h) {

        this.width = w;
        this.height = h;

        cerchi = new ArrayList<>();
        setBackground(Color.white);
        init();
    }

    public void init() {

        cerchi.clear();

        for (int i = 0; i < 10; i++) {

            // genero un nuovo cerchio passando la dimensione del pannello
            cerchi.add(new Cerchio(width, height));
        }
    }

    public void aggiungi() {
        cerchi.add(new Cerchio(width, height));
    }

    public void rimuovi() {
        int x = r.nextInt(0, cerchi.size());
        cerchi.remove(x);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Cerchio c : cerchi) {

            g.setColor(c.getC());
            g.fillOval(c.getX(), c.getY(), c.getD(), c.getD());
        }

    }

}
