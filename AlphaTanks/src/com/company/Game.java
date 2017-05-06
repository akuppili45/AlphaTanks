package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by akupp_000 on 5/5/2017.
 */
public class Game extends JPanel implements ActionListener
{
    private static final long serializedVersionUID = 1L;
    Timer gameLoopTimer;
    PlayerTank playerTank;
    public Game(){
        setFocusable(true);
        gameLoopTimer = new Timer(10,this);
        gameLoopTimer.start();
        playerTank = new PlayerTank(300,700);
        addKeyListener(new KeyInput(playerTank));

    }
    public void paint(Graphics g){
        super.paint(g);
        playerTank.draw((Graphics2D) g);

}

    @Override
    public void actionPerformed(ActionEvent e) {
        playerTank.update();
        repaint();
    }
}
