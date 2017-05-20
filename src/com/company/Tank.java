package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Tank extends GameObject
{
    protected int width = 64, height = 32;
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
        collision();
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
            Graphics2D g2D = (Graphics2D)g;
            g2D.setStroke(new BasicStroke(0));
            g2D.setColor(Color.MAGENTA);
            g2D.draw(getBoundsLeft());
            g2D.draw(getBoundsRight());
        System.out.println("Tank x: " + x);
        System.out.println("Gun x: " + gun.x);


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
    public Rectangle getBoundsLeft(){
        return new Rectangle((int)x, (int)y, width/32, height);
    }
    public Rectangle getBoundsRight(){
        return new Rectangle((int)(x + width), (int)y, width/32, height);
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
    private void collision(){
        for(GameObject a : h.object){
            if(a.getID() == ObjectId.Platform){
                Platform block = (Platform)a;
                if(getBoundsLeft().intersects(block.getBounds())){
                    x = block.getX() + 40;
                    //gun.setX(gun.getX() - 24.1f);

                }
                else if (getBoundsRight().intersects(block.getBounds())){
                    x = block.getX() - width;
                    //gun.setX(gun.getX() + width);
                }

            }
        }

}
}
