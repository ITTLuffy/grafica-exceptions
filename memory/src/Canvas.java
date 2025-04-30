import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JPanel;

public class Canvas extends JPanel { // estende il JPanel
    private Color[] colorPool;
    private Color backColor;


    // lista di tessere 
    private Tessera[] tabellone;

    private Random r;

    // TODO controlli di gioco

    public Canvas() {
        setLayout(new GridLayout(4,4));
        r = new Random();
        tabellone = new Tessera[16];
        colorPool = new Color[8];

        setBackground(Color.black);

        colorPool[0] = Color.yellow;
        colorPool[1] = Color.red;
        colorPool[2] = Color.green;
        colorPool[3] = Color.blue;
        colorPool[4] = Color.cyan;
        colorPool[5] = Color.magenta;
        colorPool[6] = Color.darkGray;
        colorPool[7] = Color.pink;

        // inizializzo il tabellone
        for (int i = 0; i < tabellone.length; i++) {
            Tessera t = new Tessera(colorPool[i/2], Color.gray, i);

            tabellone[i] = t;
            this.add(t);

        }


    }


}