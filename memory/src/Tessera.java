import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tessera extends JButton {

    // private Color front, back;
    private Image front, back;
    private boolean coperta;

    // mi serve per riconoscere quale tessera ho girato
    private int index;

    public Tessera(Image front, Image back, int index) {

        this.front = front;
        this.back = back;
        this.index = index;
        this.coperta = true;
    }

    public Image getFront() {
        return front;
    }

    public void setFront(Image front) {
        this.front = front;
    }

    public boolean isCoperta() {
        return coperta;
    }

    public int getIndex() {
        return index;
    }

    public void mostra() {
        coperta = false;
        setBorderPainted(false);
        repaint();
    }

    public void nascondi() {
        coperta = true;
        setBorderPainted(true);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // se la tessera è coperta, disegno il colore di "dorso"
        if (coperta) {
            // scalo l'immagine per la dimensione del pulsante
            Image iconaBack = back.getScaledInstance(
                    getSize().width,
                    getSize().height,
                    Image.SCALE_SMOOTH);

            // disegno l'icona del pulsante
            setIcon(new ImageIcon(iconaBack));

            // setBackground(back);
        } else {
            Image iconaFront = front.getScaledInstance(
                    getSize().width,
                    getSize().height,
                    Image.SCALE_SMOOTH);

            setIcon(new ImageIcon(iconaFront));
            // setBackground(front);
        }
    }

}
