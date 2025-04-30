import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tessera extends JButton{
    private Color front, back;
    private boolean coperta;
    private int index; // x riconoscere le tessere

    public Tessera(Color front, Color back, int index) {
        this.front = front;
        this.back = back;
        this.index = index;
        coperta = false;
    }

    public Color getFront() {
        return front;
    }

    public void setFront(Color front) {
        this.front = front;
    }

    public Color getBack() {
        return back;
    }

    public void setBack(Color back) {
        this.back = back;
    }

    public boolean isCoperta() {
        return coperta;
    }

    public void setCoperta(boolean coperta) {
        this.coperta = coperta;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void mostra(){
        coperta = false;
        repaint();
    }

    public void nascondi(){
        coperta = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (coperta) {
        Image iconaBack = back.getScaledInstance(getSize().width, getSize().width, Image.SCALE_SMOOTH);
        //    setBackground(back);
        setIcon(new ImageIcon(iconaBack));
        } else {
        Image iconaFront = front.getScaledInstance(getSize().width, getSize().width, Image.SCALE_SMOOTH);
        // setBackground(front);
        setIcon(new ImageIcon(iconaFront));

        }
    }

}
