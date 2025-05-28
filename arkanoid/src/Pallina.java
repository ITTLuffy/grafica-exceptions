
import java.awt.Rectangle;



public class Pallina {
    // definizione sprite
    private int x, y;
    private int diametro; // diametro della pallina

    // fisica della pallina
    private int speed;
    private int currentSpeed;
    private int xVel, yVel; // x --> -1 = sinistra 0 = ferma 1 = destra
                            // y --> -1 = su 0 = ferma 1 = giù  

    public Pallina() {
        speed = 10;
        diametro = 20;

        inizializza();
    }

    private void inizializza() {
        // settare pos iniziale
        x = Canvas.WIDTH / 2 - diametro / 2; 
        y = Canvas.Y_START - diametro; // sopra la navetta

        // settare velocita inizale
        currentSpeed = 0;

        // direzione iniziale
        xVel = 1; // verso destra
        yVel = -1; // verso l'alto

    }

    public void muovi() {

        // aggiorno la posizione della pallina
        x += xVel * currentSpeed;
        y += yVel * currentSpeed;

    }

    public void checkRimbalzi() {
        // se tocco il muro orrizontale
        if (y + yVel * currentSpeed < 0) {
            rimbalzoVert();
        }

        // se tocco il muro verticale
        if ((x + xVel * currentSpeed) < 0 || x + xVel*currentSpeed > Canvas.WIDTH - diametro) {
            rimbalzoHor();
        }

    }

    public void spostaX(int vel) {
        x += vel;
    }

    public void rimbalzoVert() {
        yVel *= -1;
    }

    public void rimbalzoHor() {
        xVel *= -1;
    }

    public void stop() {
        currentSpeed = 0;
    }

    public void lancia() {
        currentSpeed = speed; // inizializzo current speed
    }

    public Rectangle getHitBox() {
        return new Rectangle(x, y, diametro, diametro);
    }

    public Rectangle getNextHitBox() {
        return new Rectangle(x + xVel * currentSpeed, y + yVel * currentSpeed, diametro, diametro);
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

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getxVel() {
        return xVel;
    }

    public void setxVel(int xVel) {
        this.xVel = xVel;
    }

    public int getyVel() {
        return yVel;
    }

    public void setyVel(int yVel) {
        this.yVel = yVel;
    }

    
}

