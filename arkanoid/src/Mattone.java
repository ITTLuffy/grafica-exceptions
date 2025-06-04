import java.awt.Rectangle;

public class Mattone {
    
    private int x, y;
    public static final int width = 39;
    public static final int height = 20;
    
    private boolean distrutto = false;
    private int colpiRimasti;
    
    public Mattone(int x, int y, int punti) {
        
        this.x = x;
        this.y = y;
        this.colpiRimasti = punti;
    }
    
    public boolean aggiornaPunti() {
        
        colpiRimasti--;
        
        if (colpiRimasti == 0) {
            distrutto = true;
        }
        
        return distrutto;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDistrutto() {
        return distrutto;
    }

    public int getColpiRimasti() {
        return colpiRimasti;
    }

    public Rectangle getHitBox() {
        if (!distrutto) {
            return new Rectangle(x, y, width, height);
        } else 
            return null;
    }
    
    
}
