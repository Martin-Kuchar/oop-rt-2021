package sk.stuba.fei.uim.oop.tree;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Tree extends JPanel{
    
    @Setter
    private Color c;
    @Setter
    private int oldX;
    @Setter
    private int oldY;
    
    public Tree(Color c, int x, int y, int width, int height) {

        oldX = x;
        oldY = y;
        this.setLocation(x, y);
        this.setSize(width, height);
        this.c = c;

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(c);
        g.fillRect(this.getWidth()/3, this.getHeight()/2, this.getWidth()/3, this.getHeight()/2);
        g.fillOval(0, 0, this.getWidth(), (this.getHeight()/3)*2);
    }

    public boolean isInside(int x, int y) {
        if ((x > this.getWidth()/3 && x < (this.getWidth()/3)*2 && y > this.getHeight()/2) || (this.inInElipse(x, y))) {return true;}

        return false;
    }
    
    private boolean inInElipse(int x, int y) {

        double p = ((double)Math.pow((x - this.getWidth()/2), 2)
                    / (double)Math.pow(this.getWidth()/2, 2))
                   + ((double)Math.pow((y - this.getHeight()/3), 2)
                      / (double)Math.pow(this.getHeight()/3, 2));
        
        if (p <=1) {return true;}
        
        return false;
    }
}
