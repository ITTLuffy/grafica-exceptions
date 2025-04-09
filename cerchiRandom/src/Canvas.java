import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    private Random r = new Random();
    private ArrayList<Cerchio> cerchi;

    public Canvas() {
        cerchi = new ArrayList<>();
        setBackground(Color.white);
        init();
    }

    private void init() {
        cerchi.clear();

        for (int i = 0; i < 10; i++) {
            // nuovo cerchio
            cerchi.add(new Cerchio(getWidth(), getHeight()));

        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        // background diventa bianco
        super.paintComponent(g);

        for (Cerchio c : cerchi) {

        }

        g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), 128));

        // Random r = new Random();
        // System.out.println("Numero di cerchi che verranno stampati");

        // int nCerchi = r.nextInt(3, 10);
        // System.out.println(nCerchi);

        // RISOLUZIONE 600, 400

        // for (int i = 0; i < nCerchi; i++) {
        // // genero prima le dimensioni
        // int w = r.nextInt(50, 200); // larghezza
        // int h = r.nextInt(50, 200); // altezza

        // // prendo l'altezza e la larghezza reale, dato che la
        // // risoluzione comprende bordi e tutto il resto
        // int panelW = getWidth(); // larghezza pannello
        // int panelH = getHeight(); // altezza pannello

        // // coordinate che rendono l'ovale giusto
        // int minX = w / 2; // bordo sinistro
        // int maxX = panelW - w / 2; // bordo destro
        // int minY = h / 2; // bordo superiore
        // int maxY = panelH - h / 2; // bordo inferiore

        // int x = r.nextInt(minX, maxX); // coordinate x
        // int y = r.nextInt(minY, maxY); // coordinate y

        // // variabili finali
        // int finX = x - w / 2;
        // int finY = y - h / 2;

        // // colore che cambia
        // // Trasparenza fissa a 100
        // Color c = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255),
        // 100);

        // // cambio colore
        // g.setColor(c);
        // // genero l'ovale
        // g.fillOval(finX, finY, w, h);

    }
}
