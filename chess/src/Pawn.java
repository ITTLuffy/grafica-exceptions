import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pawn {

    // attributi
    private Color colore;
    private boolean eaten;
    // cella con coordinate x e y
    private int x;
    private int y;
    // immagine
    private BufferedImage immagine;

    // costruttore
    public Pawn(Color colore, int x, int y) {
        this.colore = colore;
        this.x = x;
        this.y = y;
        // immagine
        if (colore == Color.BLACK) {
            try {
                immagine = ImageIO.read(getClass().getResourceAsStream("/chess/Chess_pdt45.svg.png"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {

            try {
                immagine = ImageIO.read(getClass().getResourceAsStream("/chess/Chess_plt45.svg.png"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    public Color getColore() {
        return colore;
    }

    public void setColore(Color colore) {
        this.colore = colore;
    }

    public boolean isEaten() {
        return eaten;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
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

}
