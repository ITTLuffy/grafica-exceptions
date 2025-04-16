import java.util.Random;

public class Dado {
    
    // logica dado
    private Random r;
    private int faccia;
    
    public Dado() {
        r = new Random();
        lancia();
    }
    
    public void lancia() {
        faccia = r.nextInt(1, 7);
    }
    
    public int getFaccia() {
        return faccia;
    }
    
}
