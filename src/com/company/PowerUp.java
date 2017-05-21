package com.company;

import jdk.internal.org.objectweb.asm.Handle;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/21/2017.
 */
public class PowerUp extends GameObject
{
    boolean remove = false;
    Handler handler;

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public PowerUp(float x, float y, ObjectId id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }
    @Override
    public void tick(LinkedList<GameObject> object) {
            if(remove)
                handler.removeObject(this);
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
