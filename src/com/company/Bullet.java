package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Bullet extends GameObject {
    float gravity = 10;
    private Gun gun;
	public Bullet(float x, float y, ObjectId id, int velX, Gun gun) {
		super(x, y, id);
		this.velX = velX;
        this.gun = gun;
	}

	public void tick(LinkedList<GameObject> object) {
		x += velX * Math.cos(Math.toRadians(gun.getAngle()));
        y -= velX * Math.sin(Math.toRadians(gun.getAngle()));

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
