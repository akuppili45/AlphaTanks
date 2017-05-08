package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Tank extends GameObject
{
    private float width = 64, height = 32;
    Handler h;
    public Tank(float x, float y, ObjectId id, Handler handler) {
        super(x, y, id);
        h = handler;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        x+=velX;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int) x, (int) y, (int)width, (int)height);
    }
}
