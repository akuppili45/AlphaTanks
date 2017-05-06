package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by akupp_000 on 5/3/2017.
 */
public class PlayerTank extends Tank
{
    int velX = 0;
//    int velY = 0;
    public PlayerTank(int x, int y){
        super(x,y);
    }
    @Override
    public void update() {
        setX(getX() + velX);
    }

    @Override
    public void draw(Graphics2D g2D){
        /*Rectangle rect = new Rectangle(getX(),getY(),30,30);
        g2D.setColor(Color.BLACK);
        g2D.fill(rect);
        g2D.draw(rect);
        Rectangle rect2 = new Rectangle(24,243,63,22);
        g2D.setColor(Color.BLUE);
        g2D.fill(rect2);
        g2D.draw(rect2);*/
        g2D.setColor(Color.BLACK);
        g2D.fillRect(getX(),getY(),30,30);

    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT)
            velX = -5;
        else if (key == KeyEvent.VK_RIGHT)
            velX = 5;

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT)
            velX = 0;
        else if (key == KeyEvent.VK_RIGHT)
            velX = 0;
    }
    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public int getHealth() {
        return 0;
    }


}
