package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Bullet extends GameObject {
	public Bullet(float x, float y, ObjectId id, int velX) {
		super(x, y, id);
		this.velX = velX;
	}

	public void tick(LinkedList<GameObject> object) {
		x += velX;
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
