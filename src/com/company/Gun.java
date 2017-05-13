package com.company;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Gun extends GameObject
{
    Stack<Bullet> bullets;
    public static final float GUN_WIDTH = 20;
    public static final float GUN_HEIGHT = 70;
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
        //y+= velY;
        //setAngle(angle);
        //y += velY;

    }
    @Override
    public void render(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(20));
        g2D.drawLine((int)x, (int)y, (int)(x + 5), (int)y-20);
    }

    public void setAngle(float angle) {
        this.angle = angle;
        //System.out.println("new speed: " + speed);

    }

    public float getAngle(){
        return angle;

    }
    public void rotateGun(Gun gun){

    }

 /*
    @Override
    public void render(Graphics g) {
        //speed' and y' should be on the center, use rotate and translate formula to derive an equation to get these points.
        //Just use a line???

        Graphics2D g2D = (Graphics2D) g;
        AffineTransform at = new AffineTransform();
        at.rotate(Math.toRadians(45));
        //g2D.setTransform(at);
        g2D.fillRect((int) speed,(int)y,(int)GUN_WIDTH,(int)GUN_HEIGHT);
        g2D.drawOval(380,180,100,100);
       // g2D.rotate(Math.toRadians(angle));

        //speed and y need to change in here. don't call tick??
        //g2D.setColor(Color.WHITE);
        //g2D.drawOval((int) speed,(int)y,50,60);
        //g2D.fillRect((int) speed,(int)y,20,70);

    }*/


}
