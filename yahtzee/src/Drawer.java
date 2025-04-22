import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawer {

    public static void main(String[] args) {
        // finestra
        JFrame f = new JFrame("Yahtzee");

        // chiude la finestra e ferma l'esecuzione
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // risoluzione
        f.setSize(680, 350);

        Canvas c = new Canvas();

        f.add(c);

        // sarebbe meglio così |
        // f.getContentPane().add(c);
        JButton lancia = new JButton("Rilancia");
        lancia.addActionListener(
                (e) -> {
                    c.init();
                    c.repaint();
                });

        JPanel pulsantiera = new JPanel();
        pulsantiera.add(lancia);
        f.getContentPane().add(pulsantiera, BorderLayout.SOUTH);

        // pulstanti per bloccare i dadi
        JButton blocca1 = new JButton("Blocca 1");
        blocca1.addActionListener(
                (e) -> {
                    c.bloccaDado(0);
                    c.repaint();
                });
        JButton blocca2 = new JButton("Blocca 2");
        blocca2.addActionListener(
                (e) -> {
                    c.bloccaDado(1);
                    c.repaint();
                });
        JButton blocca3 = new JButton("Blocca 3");
        blocca3.addActionListener(
                (e) -> {
                    c.bloccaDado(2);
                    c.repaint();
                });
        JButton blocca4 = new JButton("Blocca 4");
        blocca4.addActionListener(
                (e) -> {
                    c.bloccaDado(3);
                    c.repaint();
                });
        JButton blocca5 = new JButton("Blocca 5");
        blocca5.addActionListener(
                (e) -> {
                    c.bloccaDado(4);
                    c.repaint();

                });

        // pulsantiera che contiene i "blocchi dei singoli dadi"
        JPanel blocchi = new JPanel(new GridLayout(1, 5, 10, 0)); // sistemo i bottoni rispetto ai dadi

        // aggiungo i bottoni alla pulsantiera blocchi
        blocchi.add(blocca1);
        blocchi.add(blocca2);
        blocchi.add(blocca3);
        blocchi.add(blocca4);
        blocchi.add(blocca5);

        // aggiungo la pulsantiera blocchi alla finestra
        f.getContentPane().add(blocchi, BorderLayout.NORTH);


        // rendiamo visibile
        f.setVisible(true);

        // centriamo
        f.setLocationRelativeTo(null);

    }

}
