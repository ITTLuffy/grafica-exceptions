import javax.swing.JFrame;

public class Drawer {

    public static void main(String[] args) {
        
        JFrame f = new JFrame("Breakout");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Canvas breakout = new Canvas();
        f.getContentPane().add(breakout);
        
        f.setSize(450, 600);
        f.setResizable(false);
        f.setVisible(true);
        f.setLocationRelativeTo(null); 
    }
    
}
