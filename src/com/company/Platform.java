package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Platform Object
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class Platform extends GameObject {

	// Create a new Platform in game in the render method. Pass in this to the
	// game parameter in the constructor.
	// Pass in gunSpeed and y parameters for the gunSpeed location and the y
	// location(use player position for that)
	Game game;

	/**
	 * Constructor
	 * 
	 * @param x
	 *            position
	 * @param y
	 *            position
	 * @param id
	 *            object id
	 * @param game
	 *            the game
	 */
	public Platform(float x, float y, ObjectId id, Game game) {
		super(x, y, id);
		this.game = game;
	}

	@Override
	/**
	 * update
	 */
	public void tick(LinkedList<GameObject> object) {

	}

	@Override
	/**
	 * String name
	 */
	public String toString() {
		return "Platform";
	}

	@Override
	/**
	 * graphics drawing
	 */
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect((int) x, (int) y, 32, 32);
	}

	/**
	 * Bounds
	 * 
	 * @return Rectangle the bounds
	 */
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
}
