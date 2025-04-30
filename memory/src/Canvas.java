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

        // inizializzo il tabellone
        for (int i = 0; i < tabellone.length; i++) {
            tabellone[i] = new 
        }
    }


}