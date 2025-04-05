import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        
        // finestra
        JFrame f = new JFrame("Window");
        
        // chiusura finestra
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        // pannello
        Canvas tela = new Canvas();
        f.add(tela);
        
        // risoluzione 
        f.setSize(600, 400); 
        
        // finestra diventa visibile
        f.setVisible(true); 
        
        // centro
        f.setLocationRelativeTo(null); 

    }

}
