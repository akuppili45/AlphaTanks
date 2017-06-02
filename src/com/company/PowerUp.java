package com.company;

import jdk.internal.org.objectweb.asm.Handle;

import java.awt.*;
import java.util.LinkedList;

/**
 * Creates and manages the power up.
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class PowerUp extends GameObject {
	boolean remove = false;
	Handler handler;

	/**
	 * to be removed
	 * 
	 * @param remove
	 *            to remove or not
	 */
	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	/**
	 * constructor
	 * 
	 * @param x
	 *            position
	 * @param y
	 *            position
	 * @param id
	 *            object id
	 * @param handler
	 *            the handler
	 */
	public PowerUp(float x, float y, ObjectId id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

	}

	@Override
	/**
	 * updates
	 */
	public void tick(LinkedList<GameObject> object) {
		if (remove)
			handler.removeObject(this);
	}

	@Override
	/**
	 * draws
	 */
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int) x, (int) y, 32, 32);

	}

	@Override
	/**
	 * name returns null
	 */
	public String toString() {
		return null;
	}

	/**
	 * gets bounds
	 * 
	 * @return Rectangle the bounds
	 */
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 4, 4);
	}
}
