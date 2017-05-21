package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/21/2017.
 */
public class PowerUp extends GameObject
{
    public PowerUp(float x, float y, ObjectId id) {
        super(x, y, id);
    }
    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int)x, (int)y, 32,32);

    }

    @Override
    public String toString() {
        return null;
    }
    public Rectangle getBounds(){
       return new Rectangle((int)x, (int)y, 4,4);
    }
}
