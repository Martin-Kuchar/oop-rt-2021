package sk.stuba.fei.uim.oop.gui;

import java.awt.Color;
import javax.swing.JPanel;

import sk.stuba.fei.uim.oop.tree.Tree;

public class Render extends JPanel{

    public Render() {
        super();
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusable(true);
        
        this.setLayout(null);
    }

    public void addTree(Tree t) {
        this.add(t);
    }

}
