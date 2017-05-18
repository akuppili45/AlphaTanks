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
    private float angle;
    private Tank tankID;
    int x;
    public Gun(float x, float y, ObjectId id, float gunAngle, Tank tank) {
        super(x, y, id);
        this.bullets = new Stack<Bullet>();
        angle = gunAngle;
        this.tankID = tank;
    }

    @Override
    public String toString() {
        return "Gun";
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
       x += velX;
    }
    @Override
    public void render(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(10));
        g2D.drawLine((int)x, (int)y,(int)((x) + getRadius() * Math.cos(Math.toRadians(angle))),
                (int)(y- getRadius()*Math.sin(Math.toRadians(angle))));

    }
    public float getRadius(){
        float dx = (int)(x+5) - x;
        float dy = (int)(y-20) - y;
        return (float)Math.sqrt(dx*dx + dy*dy);
    }
    public float getAngle(){
        return angle;

    }
    public void setAngle(float angle) {
        this.angle = angle;
    }
    public boolean isPlayerTank(){
        return tankID.isPlayer();
    }
    public String getTankGunString(){
        return "Tank1";
    }
}
