package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Tank extends GameObject
{
    public static float width = 64, height = 32;
    Handler h;
    Gun gun;
    public Tank(float x, float y, ObjectId id, Handler handler) {
        super(x, y, id);
        h = handler;
        //gun = new Gun(400,180,ObjectId.Gun);
        gun = new Gun(x+30,y,ObjectId.Gun, 45, this);//x=120, y=468
        h.addObject(this);
        h.addObject(gun);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {

        gun.tick(object);
        x+=velX;

    }

    @Override
    public String toString() {
        return "Tank";
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int) x, (int) y, (int)width, (int)height);
        gun.render(g);

    }
    public boolean isPlayer(){
        return this.getID() == ObjectId.PlayerTank;
    }

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x + (width/2)-((width/2)/2)), (int) ((int)y+(height/2)-6), (int)width/2, (int)height/2);
	}
}
