
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;

public class Canvas extends JPanel {

    private enum Direzione {
        stop, sx, dx, su, giu
    };

    // matrice x la visualizzazione del gioco
    // 0: spazio libero
    // +: serpente
    // -: cibo
    private int[][] campo;

    // elementi del serpente
    private int rTesta, cTesta;
    private int testa = 3;
    private final int CIBO = -1;

    private Direzione d = Direzione.dx;
    private Direzione prec = Direzione.stop;

    // impostazioni grafiche
    private final int dimCorpo = 25;

    // variabili di gioco
    // gestione del frame
    private final int frameTime = 100; // ms

    private Timer t;

    private Random r;

    private boolean morto = false;

    private int score, record;

    public Canvas() {
        r = new Random();
        campo = new int[20][20];

        setBackground(new Color(0, 128, 0));
        setUpTimer();
        setUpGioco();
        setUpCibo();
        setUpControlli();
    }

    private void setUpTimer() {
        t = new Timer(frameTime,
                (e) -> {
                    // logica frame
                    gestioneFrame();

                    // logica morte
                    repaint();
                });

        t.start();

    }

    private void gestioneFrame() {
        if (d == Direzione.stop) {
            return;
        }

        for (int row = 0; row < campo.length; row++) {
            for (int col = 0; col < campo[0].length; col++) {
                if (campo[row][col] > 0) {
                    campo[row][col]--;
                }

            }

        }

        switch (d) {
            case dx:
                cTesta++;
                break;
            case sx:
                cTesta--;
                break;
            case su:
                rTesta--;
                break;
            case giu:
                rTesta++;
                break;
        }

        // se il serpente esce dal campo
        if (cTesta < 0 || cTesta >= campo[0].length || rTesta < 0 || rTesta >= campo.length) {

            morto = true;
        }

        // se il serpente tocca se stesso
        if (campo[rTesta][cTesta] > 0) {
            morto = true;
        } else if (campo[rTesta][cTesta] == 0) {
            campo[rTesta][cTesta] = testa;
        } else {
            // se il serpente mangia il cibo
            mangiaFrutto();
        }

    }

    private void setUpControlli() {
        InputMap im = getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        // setup del key biding
        Action dxAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (d != Direzione.sx && prec != Direzione.sx) {
                    prec = Direzione.stop;
                    d = Direzione.dx;
                }
            }
        };

        Action sxAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (d != Direzione.dx && prec != Direzione.dx) {
                    prec = Direzione.stop;
                    d = Direzione.sx;
                }
            }
        };

        Action suAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (d != Direzione.su && prec != Direzione.su) {
                    prec = Direzione.stop;
                    d = Direzione.su;
                }
            }
        };

        Action giuAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (d != Direzione.su && prec != Direzione.su) {
                    prec = Direzione.stop;
                    d = Direzione.giu;
                }
            }
        };

        Action pausaAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        // associo i tasti
        im.put(KeyStroke.getKeyStroke("pressed RIGHT"), "destra");
        im.put(KeyStroke.getKeyStroke("pressed LEFT"), "sinistra");
        im.put(KeyStroke.getKeyStroke("pressed UP"), "su");
        im.put(KeyStroke.getKeyStroke("pressed DOWN"), "giu");
        im.put(KeyStroke.getKeyStroke("pressed SPACE"), "pausa");

        // asccociamo le azioni
        am.put("destra", dxAction);
        am.put("sinistra", sxAction);
        am.put("su", suAction);
        am.put("giu", giuAction);
        am.put("pausa", pausaAction);
    }

    private void setUpGioco() {
        cTesta = campo.length / 2;
        rTesta = campo[0].length / 2;

        for (int i = 0; i < testa; i++) {
            campo[rTesta][cTesta - i] = testa - i;
        }
    }

    private void setUpCibo() {
        int rFood, cFood;

        do {
            rFood = r.nextInt(campo.length);
            cFood = r.nextInt(campo[0].length);
        } while (campo[rFood][cFood] > 0);

        campo[rFood][cFood] = CIBO;

    }

    private void mangiaFrutto() {
        if (campo[rTesta][cTesta] == CIBO) {
            campo[rTesta][cTesta] = 0; // mangia il cibo
            // il serpente si allunga
            for (int row = 0; row < campo.length; row++) {
                for (int col = 0; col < campo[0].length; col++) {
                    if (campo[row][col] > 0) {
                        campo[row][col]++; // Incrementa ogni parte del serpente
                    }
                }
            }

            // incrementa la testa
            testa++;

            // genero un nuovo cibo
            setUpCibo();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < campo.length; row++) {
            for (int col = 0; col < campo[0].length; col++) {

                // if ((row + col) % 2 == 0) {
                // g.setColor(new Color(108, 187, 60));
                // } else {
                // g.setColor(new Color(92, 168, 42));
                // }
                // g.fillRect(col*25, row*25, 25, 25);
                // if (campo[row][col] == 0) {
                // continue;
                // }
                // disengo il serpente
                if (campo[row][col] > 0) {
                    if (campo[row][col] == testa) {
                        g.setColor(Color.orange);
                    } else {
                        g.setColor(Color.yellow); // Corpo del serpente
                    }
                    g.fillRect(col * dimCorpo + 1, row * dimCorpo + 1, dimCorpo - 2, dimCorpo - 2);
                } else if (campo[row][col] == CIBO) {
                    // disegno il cibo
                    g.setColor(Color.red);
                    g.fillOval(col * dimCorpo + 1, row * dimCorpo + 1, dimCorpo - 2, dimCorpo - 2);
                }
            }

        }
    }

}
