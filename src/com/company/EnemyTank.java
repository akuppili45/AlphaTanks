package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class EnemyTank extends Tank {
    PlayerTank tankData;
    float gravity = -.3f;
    float velocity = getGun().getBullets().peek().initialVelocity;
    // (Math.asin(gravity * dx/(velocity*velocity)))/2
    public EnemyTank(float x, float y, ObjectId id, Handler handler, Camera cam, Game game){
        super(x,y,id, handler, cam, game);
        this.setHealth(1);
        //tankData = tank;
    }
    @Override
    public void tick(LinkedList<GameObject> object) {
        if(getHealth() == 0) {
            h.removeObject(this);
            h.removeObject(this.gun);
        }
        aim();
        //fire();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, width, height);
        gun.render(g);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.GREEN);
        //g2D.draw(getBounds());
    }
    public void aim(){
        //Get PlayerTank position
        float playerX = 0;
        float playerY = 0;
        int time = 3;
        for(GameObject o : h.object){
            if(o.getID() == ObjectId.PlayerTank){
                playerX = o.x;
                playerY = o.y;
            }
        }
        float dx = playerX - x;
        float dy = y - playerY;
        float angle;
        if(y == playerY){
             angle = (float)(180 - (Math.toDegrees(Math.asin(gravity * dx/(velocity*velocity)))/2));
             gun.setAngle(angle);
             fire();
        }
//        if (y < playerY && dx < 0){
//            angle = 10;
//            float t = (float)Math.sqrt(2 * dy / gravity);
//            gun.setAngle(angle);
//            gun.getBullets().peek().setInitialVelocity(dx / t);
//            fire();
//
//        }


    }
    public void fire(){
        getGun().fire(h);
    }

}
