package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Tank extends GameObject
{
    protected float width = 64, height = 32;
    Handler h;
    Gun gun;
    private int health = 3;
    Tank enemyTankData;
    public Tank(float x, float y, ObjectId id, Handler handler) {
        super(x, y, id);
        h = handler;
        //gun = new Gun(400,180,ObjectId.Gun);
        gun = new Gun(x+30,y,ObjectId.Gun, 45, this, handler);//x=120, y=468
        h.addObject(this);
        h.addObject(gun);
    }
    public Tank(float x, float y, ObjectId id, Handler handler, Tank tank){
        super(x,y,id);
        enemyTankData = tank;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {

        gun.tick(object);
        x+=velX;
        if(getHealth() == 0)
            h.removeObject(this);
    }

    @Override
    public String toString() {
        return "Tank";
    }

    @Override
    public void render(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect((int) x, (int) y, (int) width, (int) height);
            gun.render(g);


    }
    public boolean isPlayer(){
        return this.getID() == ObjectId.PlayerTank;
    }
    public Gun getGun(){
        return gun;
    }
    public Rectangle getBounds(){
        return new Rectangle((int) (x+5), (int) (y-10), (int)(width - 10), 5);
    }
    public Tank getEnemyTankData(){
        return enemyTankData;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
