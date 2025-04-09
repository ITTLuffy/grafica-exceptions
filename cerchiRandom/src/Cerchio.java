
import java.awt.Color;
import java.util.Random;

public class Cerchio {
    private Random r;
    private int width, height; // dimensioni della finestra

    private int x, y;
    private int d;
    private Color c;

    public Cerchio(int width, int height) {
        r = new Random();
        this.width = width;
        this.height = height;

        Color c = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),128);
        int d = r.nextInt(25, 175); // dimensione minima
        int x = r.nextInt(width - d);
        int y = r.nextInt(height - d);

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }


    
}
