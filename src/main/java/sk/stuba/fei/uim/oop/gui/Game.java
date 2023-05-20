package sk.stuba.fei.uim.oop.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sk.stuba.fei.uim.oop.controls.GameLogic;

public class Game {
    
    public Game() {

        JFrame f = new JFrame("Skicar lite");
        f.setSize(800, 700);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setFocusable(true);

        f.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new GridLayout(2, 2));

        JButton move = new JButton("move");
        JButton color = new JButton("next color");
        JButton tree = new JButton("tree");

        GameLogic logic = new GameLogic();
        
        menu.add(move);
        menu.add(color);
        menu.add(tree);
        menu.add(logic.getLabel());
        
        
        f.add(menu, BorderLayout.PAGE_START);
        
        move.addActionListener(logic);
        color.addActionListener(logic);
        tree.addActionListener(logic);

        f.add(logic.getRender(),BorderLayout.CENTER);



        f.setVisible(true);

    }

}
