package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Bullet extends GameObject {
    float gravity = -.3f;
    private Gun gun;

	public Bullet(float x, float y, ObjectId id, float velX, Gun gun) {
		super(x, y, id);
		this.velX = velX;
        this.gun = gun;
        velY = (float) (10 * Math.sin(Math.toRadians(gun.getAngle())));
	}


    public void tick(LinkedList<GameObject> object) {
        x += velX;
        velY += gravity;
        y -= velY ;

        //System.out.println("Gravity: " + gravity);
        //System.out.println("VelX: " + velX );
        //System.out.println("VelY: " + velY);
        //System.out.println("Angle: " + gun.getAngle());
        //System.out.println("X: " + x);
        //System.out.println("Y: " + y);




	}

	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect((int) x, (int) y, 16, 16);
	}
	
	//public Rectangle getBounds() {
	//	return new Rectangle((int)x,(int)y, 16, 16);
	//} **fix later

	public String toString() {
		return null;
	}

}
