import java.awt.Color;
import java.awt.Graphics;
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

    private Direzione d = Direzione.dx;
    private Direzione prec = Direzione.stop;

    // impostazioni grafiche
    private final int dimCorpo = 25;

    // variabili di gioco
    // gestione del frame
    private final int frameTime = 100; // ms

    private Timer t;

    private Random r;

    public Canvas() {
        r = new Random();
        campo = new int[20][20];

        setBackground(Color.green);
        setUpGioco();
    }

    private void setUpTimer() {

    }
    
    private void setUpGioco() {
        cTesta = campo.length / 2;
        rTesta = campo[0].length / 2;
        
        for (int i = 0; i < testa; i++) {
            campo[rTesta][cTesta-i] = testa - i;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < campo.length; row++) {
            for (int col = 0; col < campo[0].length; col++) {

                if ((row + col) % 2 == 0) {
                    g.setColor(new Color(108, 187, 60));
                } else {
                    g.setColor(new Color(92, 168, 42));
                }

                g.fillRect(col*25, row*25, 25, 25);
                if (campo[row][col] == 0) {
                    continue;
                }
                // disengo il serpente
                if (campo[row][col] > 0) {
                    g.setColor(Color.orange);
                    g.fillRect(col*dimCorpo + 1, row*dimCorpo + 1, dimCorpo-2, dimCorpo-2);
                }
                // disegno la frutta
                
                if (campo[row][col] == testa) {
                    g.setColor(Color.orange);
                } else {
                    g.setColor(Color.yellow);
                }
                            
                

            }

        }
    }

}
