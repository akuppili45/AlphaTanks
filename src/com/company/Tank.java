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
    Gun gun;
    public Tank(float x, float y, ObjectId id, Handler handler) {
        super(x, y, id);
        h = handler;
        //gun = new Gun(400,180,ObjectId.Gun);
        gun = new Gun(x+30,y,ObjectId.Gun, 45);//x=120, y=468
        h.addObject(this);
        h.addObject(gun);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {

        gun.tick(object);
        x+=velX;
        //gun.tick(object);
    }

    @Override
    public String toString() {
        return "Tank";
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int) x, (int) y, (int)width, (int)height);
        //System.out.println("Gun Pos: " + gun.getX() + "," + gun.getY());
        //System.out.println("Tank Pos: " + this.getX() + "," + this.getY());

        gun.render(g);
        //g.setColor(Color.GREEN);
        //g.drawLine( 100,100,100,100);
        //g.drawOval(395,180, 100,100);



    }

}
