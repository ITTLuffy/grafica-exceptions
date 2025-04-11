import java.awt.Color;
import java.util.Random;

public class Cerchio {

    private Random rand;
    private int width, height; // dimensioni della finestra

    private int x, y;
    private int d;
    private Color c;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getD() {
        return d;
    }

    public Color getC() {
        return c;
    }

    public Cerchio(int w, int h) {

        rand = new Random();
        width = w;
        height = h;

        // generazione casuale del colore
        c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), 128);

        // coordinate del cerchio
        d = rand.nextInt(25, 175); // dimensione minima
        x = rand.nextInt(width - d);
        y = rand.nextInt(height - d);
    }
}
