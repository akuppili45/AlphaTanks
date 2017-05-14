package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Bullet extends GameObject {
	public Bullet(float x, float y, ObjectId id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> object) {
		x += velX;
	}

	public void render(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect((int) x, (int) y, 16, 16);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 16, 16);
	}

	public String toString() {
		return null;
	}

}
