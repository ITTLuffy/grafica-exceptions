public class Mattone {
    
    private int x, y;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 20;


    private boolean distrutto = false;
    private int colpiRimasti;

    public Mattone(int x, int y, int colpiRimasti) {
        this.x = x;
        this.y = y;
        this.colpiRimasti = colpiRimasti;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean aggiornaPunti() {
        colpiRimasti--;
        if (colpiRimasti == 0) {
            distrutto = true;
        }
        return distrutto;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isDistrutto() {
        return distrutto;
    }

    public void setDistrutto(boolean distrutto) {
        this.distrutto = distrutto;
    }

    public int getColpiRimasti() {
        return colpiRimasti;
    }

    public void setColpiRimasti(int colpiRimasti) {
        this.colpiRimasti = colpiRimasti;
    }

    
}
