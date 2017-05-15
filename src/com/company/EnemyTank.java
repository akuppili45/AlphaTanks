package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class EnemyTank extends Tank {
    public EnemyTank(float x, float y, ObjectId id, Handler handler){
        super(x,y,id, handler);
    }
    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, (int)width, (int)height);
        gun.render(g);
    }
}
