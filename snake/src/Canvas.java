
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
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

    private Direzione dir = Direzione.stop;
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
        score = 0;

        // Carico il record da file
        try {
            File f = new File("record.txt");
            if (!f.exists()) {
                f.createNewFile();
                record = 0; // Se il file non esiste, inizializzo il record a 0
            } else {
                FileReader fr = new FileReader(f);
                Scanner in = new Scanner(fr);

                if (in.hasNextInt()) {
                    record = in.nextInt(); // Leggo il record dal file
                    System.out.println("Punteggio caricato: " + record);
                } else {
                    record = 0; // Se il file è vuoto o non valido, inizializzo a 0
                    System.out.println("File vuoto o non valido, record impostato a 0");
                }

                in.close();
                fr.close();
            }
        } catch (IOException e1) {
            System.out.println("Errore di accesso al file: " + e1.getMessage());
            record = 0; // In caso di errore, inizializzo il record a 0
        } catch (Exception e2) {
            System.out.println("Errore generico: " + e2.getMessage());
            record = 0; // In caso di errore generico, inizializzo il record a 0
        }

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
                    if (morto) {
                        t.stop();
                        if (score > record) {
                            try {
                                FileWriter fw = new FileWriter("record.txt");
                                fw.write(String.valueOf(score));
                                System.out.println("Punteggio salvato");
                                fw.flush();
                                fw.close();
                            } catch (Exception ex) {
                                System.out.println("Errore generico");
                            }
                        }

                        JOptionPane.showMessageDialog(this, "Hai perso! Il tuo punteggio è: " + score,
                                "Game Over", JOptionPane.ERROR_MESSAGE);
                    } else {
                        repaint();
                    }
                });

        t.start();

    }

    private void gestioneFrame() {
        if (dir == Direzione.stop) {
            return;
        }

        for (int row = 0; row < campo.length; row++) {
            for (int col = 0; col < campo[0].length; col++) {
                if (campo[row][col] > 0) {
                    campo[row][col]--;
                }

            }

        }

        switch (dir) {
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
            return;
        }

        // se il serpente tocca se stesso
        if (campo[rTesta][cTesta] > 0) {
            morto = true;
            return;
        } else if (campo[rTesta][cTesta] == 0) {
            campo[rTesta][cTesta] = testa;
        } else {
            // se il serpente mangia il cibo
            testa++;
            campo[rTesta][cTesta] = testa;
            score++;

            // se il serpente mangia il cibo
            setUpCibo();
        }

    }

    private void setUpControlli() {
        InputMap im = getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        // setup del key biding
        Action dxAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dir != Direzione.sx && prec != Direzione.sx) {
                    prec = Direzione.stop;
                    dir = Direzione.dx;
                }
            }
        };

        Action sxAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dir != Direzione.dx && prec != Direzione.dx) {
                    prec = Direzione.stop;
                    dir = Direzione.sx;
                }
            }
        };

        Action suAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dir != Direzione.su && prec != Direzione.su) {
                    prec = Direzione.stop;
                    dir = Direzione.su;
                }
            }
        };

        Action giuAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dir != Direzione.su && prec != Direzione.su) {
                    prec = Direzione.stop;
                    dir = Direzione.giu;
                }
            }
        };

        Action pausaAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dir == Direzione.stop) {
                    dir = prec;
                    prec = Direzione.stop;
                } else {
                    prec = dir;
                    dir = Direzione.stop;
                }
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

        // stringa punteggio
        g.setColor(Color.black);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        g.drawString("Score: " + score, 10, 25);
        g.drawString("Record: " + record, 10, 50);

        if (dir == Direzione.stop) {
            g.setColor(new Color(128, 128, 128, 100));
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setFont(new Font("Comics Sans MS", Font.BOLD, 48));
            g.setColor(Color.black);
            g.drawString("PAUSA", 183, 263);
            g.setColor(Color.magenta);
            g.drawString("PAUSA", 180, 260);

        }

    }

}
