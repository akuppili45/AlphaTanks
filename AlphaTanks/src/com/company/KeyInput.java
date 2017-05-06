package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by akupp_000 on 5/5/2017.
 */
public class KeyInput extends KeyAdapter
{
    PlayerTank p;
    public KeyInput(PlayerTank p){
        this.p = p;
    }
    public void keyPressed(KeyEvent e){
        p.keyPressed(e);
    }
    public void keyReleased(KeyEvent e){
        p.keyReleased(e);
    }
}
