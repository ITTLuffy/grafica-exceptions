public class Navetta {
    
    // attributi sprite
    private int x,y;
    private int width, height;
    
    private int speed;          // quanti pixel ogni frame
    private int currentSpeed;   // a quanto si sta muovendo
    
    private Pallina pallina;
    private boolean startPallina;
    
    public Navetta(Pallina p) {
        
        startPallina = true;    // ho il possesso della pallina
        speed = 10;
        
        this.pallina = p;
        inizializza();  
    }
    
    public void inizializza() {
        
        width = 70;
        height = 20;
        
        x = Canvas.WIDTH/2 - width/2;   // posizione centrale dello schermo
        y = Canvas.Y_START;
    }

    public void muovi() {
        
        // aggiorno la posizione orizzontale della navetta
        x += currentSpeed;
        
        // controllo di rimanere dentro i bordi, altrimenti annullo lo spostamento
        if (x < 0 || x > Canvas.WIDTH - width) {
            x -= currentSpeed;
            return;
        }
        
        // TODO
    }
    
    public void stop() {
        currentSpeed = 0;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(boolean versoDx) {
        
        if (versoDx)
            currentSpeed = +speed;
        else
            currentSpeed = -speed;
        
        //currentSpeed = versoDx ? +speed : -speed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
}
