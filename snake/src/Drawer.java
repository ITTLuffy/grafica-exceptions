
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Drawer {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar barra = new JMenuBar();
        JMenuItem restart = new JMenuItem("Nuova Partita");
        JMenu about = new JMenu("?");
        JMenuItem info = new JMenuItem("Snake by Marconi 2025");
        JMenuItem exit = new JMenuItem("Esci");

        barra.add(restart);
        about.add(info);
        barra.add(about);
        barra.add(exit);

        frame.getContentPane().add(barra, BorderLayout.NORTH);

        restart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // recuperiamo il contenitore del JFrame e rimuovere un Canvas
                if ((frame.getContentPane().getComponents().length) > 1) {
                    frame.getContentPane().remove(1);
                }
                Canvas gioco = new Canvas();
                frame.getContentPane().add(gioco);

                frame.revalidate();
                frame.repaint();
            }
        });

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("Esci");
                System.exit(0);
            }
        });

        frame.setSize(518, 563);

        frame.setVisible(true);
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);

    }

}
