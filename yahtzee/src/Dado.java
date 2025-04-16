import java.util.Random;

public class Dado {

    // logica dado
    private Random r;
    private int faccia;

    private boolean bloccato;

    public Dado() {
        r = new Random();
        lancia();
        bloccato = false;
    }

    public void lancia() {
        if (!bloccato) {
            faccia = r.nextInt(1, 7);
        }
    }
    
    public void blocca() {
        bloccato = true;
    }
    
    public void sblocca() {
        bloccato = false;
    }

    public void invertiStato() {
        bloccato = !bloccato;
    }

    public boolean isBloccato() {
        return bloccato;
    }
    
    public int getFaccia() {
        return faccia;
    }

}
