package sk.stuba.fei.uim.oop.controls;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import lombok.Getter;
import sk.stuba.fei.uim.oop.gui.Render;
import sk.stuba.fei.uim.oop.tree.Tree;

public class GameLogic extends UniversalAdapter {

    @Getter
    private final Render render;

    @Getter
    private JLabel label;

    private boolean move;
    private Color c;

    private int newTreeX;
    private int newTreeY;

    private Tree newTree;


    public GameLogic() {
        this.render = new Render();
        render.addTree(new Tree(Color.red, 100, 100, 200, 100));
        render.addTree(new Tree(Color.blue, 0, 0, 100, 100));

        this.render.addMouseListener(this);
        this.render.addMouseMotionListener(this);
        
        render.revalidate();

        this.move = false;

        this.c = Color.blue;

        this.newTree = null;

        this.label = new JLabel("KRESLENIE");
        this.label.setForeground(c);

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if(move) {
            Component c = (Component)this.render.getComponentAt(e.getPoint());
            this.render.setComponentZOrder(c, 0);
            if (c instanceof Tree) {
    
                Tree t = ((Tree)c);
    
                int offX = t.getOldX() - e.getX();
                int offY = t.getOldY() - e.getY();
    
                System.out.println(offX);
    
                t.setLocation(t.getX() - offX, t.getY() - offY);
    
                t.setOldX(e.getX());
                t.setOldY(e.getY());
            }
        }

        else {
            if (this.newTree == null) {
                this.newTree = new Tree(this.c, this.newTreeX, this.newTreeY, this.newTreeX - e.getX(), this.newTreeY - e.getY());
                this.render.addTree(newTree);

            }
            else {
                int sizeX = e.getX() - this.newTreeX;
                int sizeY = e.getY() - this.newTreeY;

                if (sizeX < 0) {
                    this.newTree.setLocation(this.newTreeX + sizeX, this.newTree.getY());
                }
                if (sizeY < 0) {
                    this.newTree.setLocation(this.newTree.getX(), this.newTreeY + sizeY);
                }

                this.newTree.setSize(Math.abs(sizeX), Math.abs(sizeY));
            }
        }
        this.render.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(move){
            Component c = (Component)this.render.getComponentAt(e.getPoint());
            if (c instanceof Tree) {
                Tree t = ((Tree)c);

                t.setOldX(e.getX());
                t.setOldY(e.getY());
            }
        }

        else {
            newTreeX = e.getX();
            newTreeY = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.newTree = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("move")) {
            this.move = true;
            this.label.setText("MOVE");
            this.label.setForeground(Color.black);
        }
        else if (e.getActionCommand().equals("tree")) {
            this.move = false;
            this.label.setText("KRESLENIE");
            this.label.setForeground(c);
        }
        else if (e.getActionCommand().equals("next color")) {
            if (!move) {
                this.changeColor();
                this.label.setForeground(c);
            }
        }
        this.render.repaint();
    }
    
    private void changeColor() {
       if(this.c.equals(Color.blue)) {
            this.c = Color.red;
       }
       else if(this.c.equals(Color.red)) {
            this.c = Color.green;
       }
       else if(this.c.equals(Color.green)) {
            this.c = Color.blue;
       }
    }
}
