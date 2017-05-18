package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Bullet extends GameObject {
    //Add Handler object, loop through handler, check enum if it's a tank,
    // and getBounds of this class intersects a bounds of a tempObject in the loop.
    float gravity = -.3f;
    private Gun gun;
    int bulletWidth = 16;
    int bulletHeight = 16;

	public Bullet(float x, float y, ObjectId id, float velX, Gun gun) {
		super(x, y, id);
		this.velX = velX;
        this.gun = gun;
        velY = (float) (10 * Math.sin(Math.toRadians(gun.getAngle())));
	}
    public void tick(LinkedList<GameObject> object) {
        if(y > 575){
        x += velX;
        velY += gravity;
        y -= velY ;}
	}

	public void render(Graphics g) {
		g.setColor(Color.BLUE );
		g.fillRect((int) x, (int) y, 16, 16);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.RED);
        g2D.draw(getBounds());
        g2D.draw(getBoundsTop());
        g2D.draw(getBoundsRight());
        g2D.draw(getBoundsLeft());
	}
	
	//public Rectangle getBounds() {
	//	return new Rectangle((int)x,(int)y, 16, 16);
	//} **fix later

	public String toString() {
		return null;
	}
    public Rectangle getBounds() {
        return new Rectangle((int) ((int)x + (bulletWidth/2)-((bulletWidth/2)/2)),(int) ((int)y + (bulletHeight/2)),(int)bulletWidth/2,(int)bulletHeight/2);
    }
    public Rectangle getBoundsTop() {
        return new Rectangle((int)((int)x+(bulletWidth/2)-((bulletWidth/2)/2)),(int)y,(int)bulletWidth/2, (int)bulletHeight/2);
    }
    public Rectangle getBoundsRight() {
        return new Rectangle((int) ((int)x+bulletWidth-5), (int)y+5,(int)5,(int)bulletHeight-10);
    }
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x,(int)y+5,(int)5,(int)bulletHeight-10);
    }
    public boolean hitTank(Tank tank){
        return false;
    }
}
