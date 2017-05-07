package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by akupp_000 on 5/3/2017.
 */
public class PlayerTank extends GameObject
{
    private float width = 32, height = 64;
    Handler handler;
    public PlayerTank(float x, float y, ObjectId id, Handler handler){
        super(x,y,id);
        this.handler = handler;
    }
    @Override
    public void tick(LinkedList<GameObject> object) {
        x+=velX;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int) x, (int) y, (int)width, (int)height);


    }





}
