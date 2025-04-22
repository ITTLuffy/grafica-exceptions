import java.awt.*;
import javax.swing.*;

public class Canvas extends JPanel {

    private Dado[] dadi; // dado
    private Color coloreDado, colorePunti;

    private final int dimDado = 115;
    private final int dimPunto = 25;
    private final int rAngolo = 20;

    public Canvas() {
        dadi = new Dado[5];
        for (int i = 0; i < dadi.length; i++) {
            dadi[i] = new Dado();
        }

        setBackground(new Color(0, 150, 0));
        coloreDado = Color.white;
        colorePunti = Color.black;
    }

    public void init() {
        for (Dado dado : dadi) {
            dado.lancia();
        }
    }

    public void bloccaDado(int pos) {
        dadi[pos].invertiStato();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(coloreDado);
        // punti x, y, width, height, smussaturaX, smussaturaY

        for (int i = 0; i < dadi.length; i++) {
            g.fillRoundRect(15 + 130*i, 35, dimDado, dimDado, rAngolo, rAngolo);
        }
        
        g.setColor(colorePunti);

        for (int i = 0; i < dadi.length; i++) {
            Dado dado = dadi[i];
            switch (dado.getFaccia()) {
                case 1:
                    g.fillOval(60 + 130 * i, 80, dimPunto, dimPunto);
                    break;
                case 2:
                    g.fillOval(20 + 130 * i, 40, dimPunto, dimPunto);
                    g.fillOval(100 + 130 * i, 120, dimPunto, dimPunto);
                    break;

                case 3:
                    g.fillOval(60 + 130 * i, 80, dimPunto, dimPunto);   // 1
                    g.fillOval(20 + 130 * i, 40, dimPunto, dimPunto);   // 2
                    g.fillOval(100 + 130 * i, 120, dimPunto, dimPunto); // 2
                    break;

                case 4:
                    g.fillOval(20 + 130 * i, 40, dimPunto, dimPunto);   // 2
                    g.fillOval(100 + 130 * i, 120, dimPunto, dimPunto); // 2
                    g.fillOval(20 + 130 * i, 120, dimPunto, dimPunto);
                    g.fillOval(100 + 130 * i, 40, dimPunto, dimPunto);
                    break;

                case 5:
                    g.fillOval(60 + 130 * i, 80, dimPunto, dimPunto);   // 1
                    g.fillOval(20 + 130 * i, 40, dimPunto, dimPunto);   // 4
                    g.fillOval(100 + 130 * i, 120, dimPunto, dimPunto); // 4
                    g.fillOval(20 + 130 * i, 120, dimPunto, dimPunto);  // 4
                    g.fillOval(100 + 130 * i, 40, dimPunto, dimPunto);  // 4
                    break;

                case 6:
                    g.fillOval(20 + 130 * i, 40, dimPunto, dimPunto);   // 4
                    g.fillOval(100 + 130 * i, 120, dimPunto, dimPunto); // 4
                    g.fillOval(20 + 130 * i, 120, dimPunto, dimPunto);  // 4
                    g.fillOval(100 + 130 * i, 40, dimPunto, dimPunto);  // 4
                    g.fillOval(60 + 130 * i, 40, dimPunto, dimPunto);
                    g.fillOval(60 + 130 * i, 120, dimPunto, dimPunto);
                    break;
            }
        }
    }
}
