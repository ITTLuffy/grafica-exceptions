import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {

        JFrame f = new JFrame("Cerchi randomizzati");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int w = 600;
        int h = 400;
        f.setSize(w, h);

        Canvas c = new Canvas(w, h);
        f.add(c);

        JButton add = new JButton("Add"); // aggiungi un bottone
        JButton refresh = new JButton("Refresh"); // creato pulsante
        JButton remove = new JButton("Remove"); // aggiungi un bottone

        JPanel pulsantiera = new JPanel(); // spazio dove mettere il pulsante

        // pulsante
        pulsantiera.add(add); // aggiugno allo spazio il pulsante
        pulsantiera.add(refresh); // aggiugno allo spazio il pulsante
        pulsantiera.add(remove); // aggiugno allo spazio il pulsante

        f.add(pulsantiera, BorderLayout.SOUTH); // aggiungo lo spazio al frame

        // listener x il click
        refresh.addActionListener(
                (e) -> {
                    // rigenera la lista
                    c.init();

                    // disegno
                    c.repaint();
                }

        );

        add.addActionListener(
                (e) -> {
                    // aggiungo
                    c.aggiungi();

                    // disegno
                    c.repaint();
                });

        remove.addActionListener(
                (e) -> {
                    // rimuovi
                    c.rimuovi();

                    // disegno
                    c.repaint();
                });

        f.setVisible(true);
        f.setLocationRelativeTo(null);

    }

}
