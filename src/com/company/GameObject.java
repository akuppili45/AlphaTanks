package com.company;

import java.awt.*;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * All game object variables. GameObjects will follow the guidelines in this class.
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public abstract class GameObject {
	protected float x, y;
	protected ObjectId id;
	protected float velX = 0, velY = 0;
	protected int facing = 1;

	/**
	 * Constructor
	 * 
	 * @param x
	 *            position
	 * @param y
	 *            position
	 * @param id
	 *            object id
	 */
	public GameObject(float x, float y, ObjectId id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	/**
	 * constructor
	 * 
	 * @param id
	 *            object id
	 */
	public GameObject(ObjectId id) {
		this.id = id;
	}

	/**
	 * update
	 * 
	 * @param object
	 *            objects
	 */
	public abstract void tick(LinkedList<GameObject> object);

	/**
	 * draws
	 * 
	 * @param g
	 *            drawer
	 */
	public abstract void render(Graphics g);

	/**
	 * get x
	 * 
	 * @return x
	 */
	public float getX() {
		return x;
	}

	/**
	 * get y
	 * 
	 * @return y
	 */
	public float getY() {
		return y;
	}

	/**
	 * set x
	 * 
	 * @param x
	 *            the x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * set y
	 * 
	 * @param y
	 *            sets y
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * speed
	 * 
	 * @return float speed
	 */
	public float getVelX() {
		return velX;
	}

	/**
	 * speed
	 * 
	 * @return float v speed
	 */
	public float getVelY() {
		return velY;
	}

	/**
	 * set speed
	 * 
	 * @param x
	 *            the speed
	 */
	public void setVelX(float x) {
		this.velX = x;
	}

	/**
	 * the v speed
	 * 
	 * @param y
	 *            speed
	 */
	public void setVelY(float y) {
		this.velY = y;
	}

	/**
	 * facing
	 * 
	 * @return int direction
	 */
	public int getFacing() {
		return facing;
	}

	/**
	 * get id
	 * 
	 * @return ObjectId the id
	 */
	public ObjectId getID() {
		return id;
	}

	/**
	 * string
	 */
	public abstract String toString();

}
