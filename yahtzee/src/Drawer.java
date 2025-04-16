import java.awt.BorderLayout;
import java.awt.Button;
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
        
        // rendiamo visibile
        f.setVisible(true);
        
        // centriamo
        f.setLocationRelativeTo(null);
        
        

    }
    
}
