import javax.swing.JFrame;

public class Drawer {

    public static void main(String[] args) {
        
        JFrame f = new JFrame("Memory");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // carico il canvas
        Canvas memory = new Canvas();
        f.getContentPane().add(memory);
        
        f.setSize(600, 630);
        f.setVisible(true);
        f.setLocationRelativeTo(null); 
        
    }
    
}
