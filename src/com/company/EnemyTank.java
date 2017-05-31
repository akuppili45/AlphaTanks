package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class EnemyTank extends Tank {
    //PlayerTank tankData;
    float gravity = -.3f;
    float velocity = getGun().getBullets().peek().initialVelocity;
    // (Math.asin(gravity * dx/(velocity*velocity)))/2
    public EnemyTank(float x, float y, ObjectId id, Handler handler, Camera cam, Game game){
        super(x,y,id, handler, cam, game);
        this.setHealth(1);
        //tankData = tank;
    }
    public EnemyTank(ObjectId id){
        super(id);
    }
    @Override
    public void tick(LinkedList<GameObject> object) {
        if(getHealth() == 0) {
            h.removeObject(this);
            h.removeObject(this.gun);
        }
        gun.setX(x+30);
        x += velX;
        //System.out.println(x);
        //aim();
        //fire();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, width, height);
        gun.render(g);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(0));
        g2D.draw(getBoundsLeft());
        g2D.draw(getBoundsRight());
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
    }
    public void fire(){
        getGun().fire(h);
    }
    public void horizontalEnemyAction(PlayerTank tank){
        float playerRightX = (float) tank.getBoundsRight().getX();
        float playerX = tank.getX();
        float playerY = tank.getY();
        float enemyX = this.x;
        float enemyY = this.y;
        float dx = Math.abs(enemyX - playerX);

        if(dx < 525 && dx > 515){
        	this.setVelX(0);
            //float angle = (float)(180 - (Math.toDegrees(Math.asin(gravity * dx/(velocity*velocity)))/2)); //dont need - changed to shoot at a certain distance
            gun.setAngle(165);
            //gun.fire(h);
//          try {
//          Thread.sleep(50);
//          gun.enemyGunFire(h);
//          //Thread.sleep(50);
//          }
//          catch (Exception e){
//
//          }
                gun.enemyGunFire(h);
        	}
        else if (dx < 500){
        	this.setVelX(3);
        	}
        else if (dx > 600){
        	this.setVelX(-3);
        	}

        }

    public void platformEnemyAction(PlayerTank tank){
        float playerRightX = (float) tank.getBoundsRight().getX();
        float playerX = tank.getX();
        float playerY = tank.getY();
        float enemyX = this.x;
        float enemyY = this.y;
        float dx = enemyX - playerX;
        //System.out.println(enemyX - playerX);
      
        if(dx < 550 && dx > 200)//aggro distance
        {
        	float angle = (float) ((float) -(((Math.pow(Math.abs(dx)-500, 2)))/8500)+102);
        	gun.setAngle(angle);
        	gun.enemyGunFire(h);
        }
        
        else if(dx < -225 && dx > -350)
        {
        	float angle = (float) -(((Math.pow(Math.abs(dx), 2)))/4000)+110;
        	gun.setAngle(angle);
        	gun.enemyGunFire(h);
        }
        
    }
}
