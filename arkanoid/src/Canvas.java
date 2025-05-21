
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Canvas extends  JPanel{

    public static final int Y_START = 500;

    private Pallina pallina;
    private Navetta navetta;
    private Mattone[] mattoni;
    private Timer timer;

    private final int frameTime = 30;

    private int vite;

    private Color[] colori;

    public Canvas() {
        pallina = new Pallina();
        navetta = new Navetta();
        mattoni = new Mattone[30];

        vite = 3;

        colori = new Color[8];
        colori[0] = Color.yellow;
        colori[1] = Color.cyan;
        colori[2] = Color.pink;
        colori[3] = Color.magenta;
        colori[4] = Color.orange;
        colori[5] = Color.red;
        colori[6] = Color.green;
        colori[7] = Color.blue;


        setBackground(Color.black);

        // setup mattoni
        setUpMattoni();

        // input giocatore

        // gestione frame
    }

    private void setUpMattoni() {
        int w = Mattone.WIDTH;
        int h = Mattone.HEIGHT;
        int col = 10;

        for (int i = 0; i < mattoni.length; i++) {
            int punti = mattoni.length/col - i/col;
            mattoni[i] = new Mattone(4 + (i%col) * (w+4), 100 + (i/col) * (h+4), punti);
        }

        
    }

}
