package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Object that allows player to move to the next level.
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class Flag extends GameObject
{
    float gravity = -.3f;
    private Gun gun;
    int bulletWidth = 16;
    int bulletHeight = 16;
    public static int level = 1;

    Handler handler;
/**
 * Constructor
 * @param x location
 * @param y location
 * @param id Object id
 */
    public Flag(float x, float y, ObjectId id) {
        super(x, y, id);
    }
    //public Bullet(){
//        this = new Bullet(((float) ((gun.x) + gun.getRadius() * Math.cos(Math.toRadians(gun.getAngle())))), (float)
//                (gun.y - gun.getRadius() * Math.sin(Math.toRadians(gun.getAngle()))), ObjectId.Bullet, (float) (20 * Math.cos(Math.toRadians(gun.getAngle()))), gun, handler));
//    }
    /**
     * tick
     */
    public void tick(LinkedList<GameObject> object) {

    }
/**
 * draws
 */
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int) x, (int) y, 32, 32);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(0));
        g2D.setColor(Color.MAGENTA);
        //g2D.draw(getBounds());
    }
/**
 * returns null
 */
    public String toString() {
        return null;
    }
/**
 * the bounds
 * @return Rectangle the bounds
 */
    public Rectangle getBounds() {
        return new Rectangle((int)x + (bulletWidth/2)-((bulletWidth/2)/2), (int)y + (bulletHeight/2), bulletWidth /2, bulletHeight /2);
    }

}

