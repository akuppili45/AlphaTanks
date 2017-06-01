package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Stack;

/**
 * The tank the player will control.
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class PlayerTank extends Tank {
	/**
	 * the constructor
	 * 
	 * @param x
	 *            position
	 * @param y
	 *            position
	 * @param id
	 *            object id
	 * @param handler
	 *            handles game
	 * @param cam
	 *            camera
	 * @param game
	 *            game
	 */
	public PlayerTank(float x, float y, ObjectId id, Handler handler, Camera cam, Game game) {
		super(x, y, id, handler, cam, game);
	}

	/**
	 * constructor
	 * 
	 * @param id
	 *            object id
	 */
	public PlayerTank(ObjectId id) {
		super(id);
	}

	@Override
	/**
	 * updates
	 */
	public void tick(LinkedList<GameObject> object) {
		super.tick(object);
	}

	@Override
	/**
	 * draws
	 */
	public void render(Graphics g) {
		super.render(g);
	}
}
