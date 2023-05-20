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

        System.out.println(this.getLocation());
        System.out.println(this.getX() + " " + this.getY());
        this.c = c;

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(c);
        //g.drawRect(this.getX(), getY(), this.getWidth(), this.getHeight());
        //g.fillRect(0, this.getHeight()/2, this.getWidth(), 0);
       
        g.fillRect(this.getWidth()/3, this.getHeight()/2, this.getWidth()/3, this.getHeight()/2);

        //g.fillRect(0, 0, 10, 10);    
        //g.fillRect(0, 0, 10, 10); 

        g.fillOval(0, 0, this.getWidth(), (this.getHeight()/3)*2);
        
    }
}
