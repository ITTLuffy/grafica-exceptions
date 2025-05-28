
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Canvas extends JPanel {

    public static final int Y_START = 500;
    public static final int HEIGHT = 561;
    public static final int WIDTH = 434;

    private Pallina pallina;
    private Navetta navetta;
    private Mattone[] mattoni;

    private Color[] coloriMattoni;

    private Timer timer;
    private final int frameTime = 30;

    private int vite;

    public Canvas() {

        pallina = new Pallina();
        navetta = new Navetta(pallina);
        mattoni = new Mattone[30];

        // palette di colori dei mattoni
        coloriMattoni = new Color[8];
        coloriMattoni[0] = Color.yellow;
        coloriMattoni[1] = Color.cyan;
        coloriMattoni[2] = Color.pink;
        coloriMattoni[3] = Color.magenta;
        coloriMattoni[4] = Color.orange;
        coloriMattoni[5] = Color.red;
        coloriMattoni[6] = Color.green;
        coloriMattoni[7] = Color.blue;

        vite = 3;

        setBackground(Color.black);

        // setup mattoni
        setupMattoni();

        // gestione input giocatore
        setupControlli();

        // gestione frame
        timer = new Timer(frameTime,
                (ActionEvent e) -> {

                    gestioneFrame();
                    repaint();
                });

        timer.start();
    }

    private void setupMattoni() {

        int w = Mattone.width;
        int h = Mattone.height;

        for (int i = 0; i < mattoni.length; i++) {

            int col = 10;
            int punti = mattoni.length / col - i / col;
            mattoni[i] = new Mattone(4 + (i % col) * (w + 4), 100 + (i / col) * (h + 4), punti);
        }
    }

    private void setupControlli() {

        InputMap im = getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        Action dxAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                navetta.setCurrentSpeed(true);
            }
        };

        Action sxAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                navetta.setCurrentSpeed(false);
            }
        };

        Action dxUpAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                navetta.stop();
            }
        };

        Action sxUpAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                navetta.stop();
            }
        };

        Action spaceAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // far partire la pallina
                navetta.sbloccaPallina();
                pallina.lancia();
            }
        };

        // specifico le azioni da rilevare da tastiera
        im.put(KeyStroke.getKeyStroke("pressed RIGHT"), "destra");
        im.put(KeyStroke.getKeyStroke("pressed LEFT"), "sinistra");
        im.put(KeyStroke.getKeyStroke("released RIGHT"), "destraUp");
        im.put(KeyStroke.getKeyStroke("released LEFT"), "sinistraUp");
        im.put(KeyStroke.getKeyStroke("SPACE"), "spazio");

        // key binding delle azioni
        am.put("destra", dxAction);
        am.put("sinistra", sxAction);
        am.put("destraUp", dxUpAction);
        am.put("sinistraUp", sxUpAction);
        am.put("spazio", spaceAction);
    }

    private void gestioneFrame() {

        // aggiorno la pallina
        pallina.muovi();
        pallina.checkRimbalzi();

        // aggiorno la navetta
        navetta.muovi();

        // aggiorno logica delle vite
        // aggiorno fisica dei mattoni
        // aggiorno collisioni
        if (navetta.navettaColpita() && !navetta.isPallinaFerma()) {
            pallina.rimbalzoVert();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // disegno la navetta
        g.setColor(Color.red);
        g.fillOval(navetta.getX(), navetta.getY(), navetta.getHeight(), navetta.getHeight());
        g.fillOval(navetta.getX() + navetta.getWidth() - navetta.getHeight(), navetta.getY(), navetta.getHeight(), navetta.getHeight());

        g.setColor(Color.lightGray);
        g.fillRect(navetta.getX() + navetta.getHeight() / 2, navetta.getY(),
                navetta.getWidth() - navetta.getHeight(), navetta.getHeight());

        // disegno la pallina
        g.setColor(Color.white);
        g.fillOval(pallina.getX(), pallina.getY(), pallina.getDiametro(), pallina.getDiametro());

        // disegno i mattoni
        for (Mattone m : mattoni) {

            if (m.isDistrutto()) {
                continue;
            }

            g.setColor(coloriMattoni[m.getColpiRimasti() - 1]);
            g.fillRect(m.getX(), m.getY(), Mattone.width, Mattone.height);
        }
    }

}
