package com.company;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by akupp_000 on 5/5/2017.
 */
public class KeyInput extends KeyAdapter
{
    Handler handler;
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i<handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ObjectId.PlayerTank){ //Checks if the id is a player
                if(key == KeyEvent.VK_D)
                    tempObject.setVelX(5);
                if(key== KeyEvent.VK_A)
                    tempObject.setVelX(-5);

            }
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i<handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ObjectId.PlayerTank){
                if(key == KeyEvent.VK_D)
                    tempObject.setVelX(0);
                if(key== KeyEvent.VK_A)
                    tempObject.setVelX(0);
            }
        }
    }
}
