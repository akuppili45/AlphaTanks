package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/20/2017.
 */
public class Flag extends GameObject
{
    float gravity = -.3f;
    private Gun gun;
    int bulletWidth = 16;
    int bulletHeight = 16;

    Handler handler;

    public Flag(float x, float y, ObjectId id) {
        super(x, y, id);
    }
    //public Bullet(){
//        this = new Bullet(((float) ((gun.x) + gun.getRadius() * Math.cos(Math.toRadians(gun.getAngle())))), (float)
//                (gun.y - gun.getRadius() * Math.sin(Math.toRadians(gun.getAngle()))), ObjectId.Bullet, (float) (20 * Math.cos(Math.toRadians(gun.getAngle()))), gun, handler));
//    }
    public void tick(LinkedList<GameObject> object) {

    }

    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int) x, (int) y, 32, 32);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(0));
        g2D.setColor(Color.MAGENTA);
        //g2D.draw(getBounds());
    }
    public String toString() {
        return null;
    }
    public Rectangle getBounds() {
        return new Rectangle((int) ((int)x + (bulletWidth/2)-((bulletWidth/2)/2)),(int) ((int)y + (bulletHeight/2)),(int)bulletWidth/2,(int)bulletHeight/2);
    }

}

