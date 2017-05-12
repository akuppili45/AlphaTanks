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
    public static final float GUN_WIDTH = 15;
    public static final float GUN_HEIGHT = 60;
    private float angle;
    int stuff;
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
        y+=velY;
        //setAngle(angle);
        //y += velY;

    }

    @Override
    public void render(Graphics g) {
        AffineTransform at = AffineTransform.getTranslateInstance(0,0);
        at.rotate(Math.toRadians(45));
        Graphics2D g2D = (Graphics2D) g;
       // g2D.setTransform(at);
        g2D.transform(at);
        g2D.fillRect((int) x,(int)y,20,70);
       // g2D.rotate(Math.toRadians(angle));

        //x and y need to change in here. don't call tick??
        //g2D.setColor(Color.WHITE);
        //g2D.drawOval((int) x,(int)y,50,60);
        //g2D.fillRect((int) x,(int)y,20,70);

    }

    public void setAngle(float angle) {
        this.angle = angle;
        //System.out.println("new x: " + x);

    }

    public float getAngle(){
        return angle;

    }
    public void rotateGun(Gun gun){

    }


}
