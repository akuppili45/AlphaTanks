package com.company;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Gun extends GameObject
{
    private Stack<Bullet> bullets  = new Stack<>();
    private Stack<Bullet> enemyBullets = new Stack<>();
    private ArrayList<Bullet> enemyBullets1 = new ArrayList<>();
    private float angle;
    private Tank tankID;
    private Handler h;
    private int numBullets = 10;
    long timeLastFired = System.currentTimeMillis();



    public Gun(float x, float y, ObjectId id, float gunAngle, Tank tank, Handler handler) {
        super(x, y, id);
        angle = gunAngle;
        this.tankID = tank;
        h = handler;
        for(int i = 0; i < numBullets; i++){
            bullets.push(new Bullet(ObjectId.Bullet));
        }
        for(int i = 0; i < 50; i++){
            enemyBullets.push(new Bullet(ObjectId.Bullet));
        }
        for(int i = 0; i < 50; i++){
            enemyBullets1.add(new Bullet(ObjectId.Bullet));
        }
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
    public void fire(Handler h){
        long t = System.currentTimeMillis();
        if(bullets.size() != 0 && (t-timeLastFired) > 1000) {
            Bullet b = bullets.pop();
            b.setValues(((float) ((x) + getRadius() * Math.cos(Math.toRadians(getAngle())))), (float)
                    (y  - getRadius() * Math.sin(Math.toRadians(getAngle()))), ObjectId.Bullet, (float) (b.initialVelocity * Math.cos(Math.toRadians(getAngle()))), this, h);

            h.addObject(b);
            timeLastFired = t;

        }


    }
    public void enemyGunFire(Handler h){
        long t = System.currentTimeMillis();
        if(enemyBullets.size() != 0 && (t-timeLastFired) > 1000) {
            Bullet b = enemyBullets.pop();
            b.setValues(((float) ((x) + getRadius() * Math.cos(Math.toRadians(getAngle())))), (float)
                    (y  - getRadius() * Math.sin(Math.toRadians(getAngle()))), ObjectId.Bullet, (float) (b.initialVelocity * Math.cos(Math.toRadians(getAngle()))), this, h);

            h.addObject(b);
            timeLastFired = t;
        }

    }

    public void rotateIncreaseAngle(){
        angle += 10;
    }
    public void rotateDecreaseAngle(){
        angle -= 10;
    }
    public Stack<Bullet> getBullets(){
        return bullets;
    }
    public ArrayList<Bullet> getEnemyBullets1() {
        return enemyBullets1;
    }

}
