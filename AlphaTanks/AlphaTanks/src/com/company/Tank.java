package com.company;

import java.awt.*;

/**
 * Created by akupp_000 on 5/5/2017.
 */
public abstract class Tank
{
    private int x;
    private int y;
    public Tank(int x, int y){
        this.x = x;
        this.y = y;
    }
    public abstract void update();
    public abstract void draw(Graphics2D g2D);
    public abstract Image getImage();
    public abstract int getHealth();
    public int getX(){
        return x;}
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}
