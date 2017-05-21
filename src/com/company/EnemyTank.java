package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class EnemyTank extends Tank {
    PlayerTank tankData;
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
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, (int)width, (int)height);
        gun.render(g);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.GREEN);
        g2D.draw(getBounds());
    }
    public void aim(PlayerTank tank){
        //Get PlayerTank position
        float playerX = tank.getX();
        float playerY = tank.getY();
        float dx = playerX - x;
        float dy = playerY - y;
        float distance = (float) Math.sqrt(dx*dx + dy * dy);
        float angleToPlayer = (float) Math.toDegrees(Math.atan(dy/dx));
    }
    public void fire(){
        getGun().fire(h);
    }

}
