import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel {

    // insieme di colori che userò nel gioco
    // private Color[] colorPool;
    // private Color backColor;
    private Image[] imagePool;
    private Image backImage;

    // lista di tessere che compongono il gioco
    private Tessera[] tabellone;

    private Random r;

    // TODO controlli di gioco

    private int contaClick = 0;
    private int primaTessera = -1;
    private int secondaTessera = -1;
    private int tesseraCorrente = -1;

    public Canvas() {

        // imposto un layout per la disposizione delle tessere
        setLayout(new GridLayout(4, 4));

        // creazione delle istanze
        r = new Random();
        tabellone = new Tessera[16];
        imagePool = new Image[8];
        // colorPool = new Color[8];

        /*
         * colorPool[0] = Color.yellow;
         * colorPool[1] = Color.red;
         * colorPool[2] = Color.cyan;
         * colorPool[3] = Color.green;
         * colorPool[4] = Color.blue;
         * colorPool[5] = Color.magenta;
         * colorPool[6] = Color.orange;
         * colorPool[7] = Color.pink;
         */

        BufferedImage frontTiles = null;

        try {
            backImage = ImageIO.read(new File("memory/images/back.png"));
            frontTiles = ImageIO.read(new File("memory/images/tiles.jpg"));

            int w = frontTiles.getWidth() / 4;
            int h = frontTiles.getHeight() / 4;

            imagePool[0] = frontTiles.getSubimage(0, 0, w, h);
            imagePool[1] = frontTiles.getSubimage(w, 0, w, h);
            imagePool[2] = frontTiles.getSubimage(2 * w, 0, w, h);
            imagePool[3] = frontTiles.getSubimage(3 * w, 0, w, h);
            imagePool[4] = frontTiles.getSubimage(0, h, w, h);
            imagePool[5] = frontTiles.getSubimage(w, h, w, h);
            imagePool[6] = frontTiles.getSubimage(2 * w, h, w, h);
            imagePool[7] = frontTiles.getSubimage(3 * w, h, w, h);

        } catch (IOException ioe) {
            System.out.println("Errore di caricamento immagini");
        } catch (Exception e) {
            System.out.println("Errore generico");
        }
        setBackground(Color.black);

        // associo un colore ad ogni tessera
        for (int i = 0; i < tabellone.length; i++) {
            Tessera t = new Tessera(imagePool[i / 2], backImage, i);

            // aggiungo la tessera al tabellone e al JPanel
            tabellone[i] = t;
            this.add(t);

            t.addActionListener(
                    (e) -> {
                        if (t.isCoperta()) {
                            t.mostra();
                            tesseraCorrente = t.getIndex();

                            contaClick++;
                            checkCoppia();
                        }
                    });
        }

        // e li mescolo
        mescolaTessere();
    }

    // mescolo usando un algoritmo di shuffle
    private void mescolaTessere() {

        for (int i = 0; i < tabellone.length; i++) {

            int random = r.nextInt(tabellone.length);

            // inverto le tessere
            Image temp = tabellone[i].getFront();
            tabellone[i].setFront(tabellone[random].getFront());
            tabellone[random].setFront(temp);
        }
    }

    private void checkCoppia() {
        if (contaClick % 2 == 1) {
            if (contaClick > 1 && tabellone[primaTessera].getFront() != tabellone[secondaTessera].getFront()) {
                tabellone[primaTessera].nascondi();
                tabellone[secondaTessera].nascondi();

            }
            primaTessera = tesseraCorrente;

        } else {
            secondaTessera = tesseraCorrente;
        }

    }

}
