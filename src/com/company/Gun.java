package com.company;

import java.awt.*;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Gun extends GameObject
{
    Stack<Bullet> bullets;
    public static final float GUN_WIDTH = 15;
    public static final float GUN_HEIGHT = 60;
    private float angle;
    public Gun(float x, float y, ObjectId id, float gunAngle) {
        super(x, y, id);
        this.bullets = new Stack<Bullet>();
        angle = gunAngle;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        x += velX;
        //y += velY;
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.rotate(Math.toRadians(angle));
        g2D.fillRect((int) x,(int)y,20,70);
        //System.out.println(x + "and"+y);
    }

    public void setAngle(float angle) {
        this.angle = angle;
        System.out.println(angle);
    }

    public float getAngle(){
        return angle;

    }


}
