package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class EnemyTank extends Tank {
    PlayerTank tankData;
    public EnemyTank(float x, float y, ObjectId id, Handler handler, PlayerTank tank){
        super(x,y,id, handler);
        this.setHealth(1);
        tankData = tank;
    }
    @Override
    public void tick(LinkedList<GameObject> object) {
        if(getHealth() == 0)
            h.removeObject(this);
            h.removeObject(this.gun);
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
    public float getDistanceToOtherTank(){
        return Math.abs(tankData.getX() - this.getX());

    }

}
