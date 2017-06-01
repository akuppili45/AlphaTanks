package com.company;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Gun functions and movement.
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class Gun extends GameObject {
	private Stack<Bullet> bullets = new Stack<>();
	private Stack<Bullet> enemyBullets = new Stack<>();
	private ArrayList<Bullet> enemyBullets1 = new ArrayList<>();
	private float angle;
	private Tank tankID;
	private Handler h;
	private int numBullets = 10;
	long timeLastFired = System.currentTimeMillis();

	/**
	 * Constructor
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param id
	 *            object id
	 * @param gunAngle
	 *            gun angle
	 * @param tank
	 *            tanks
	 * @param handler
	 *            game handler
	 */
	public Gun(float x, float y, ObjectId id, float gunAngle, Tank tank, Handler handler) {
		super(x, y, id);
		angle = gunAngle;
		this.tankID = tank;
		h = handler;
		for (int i = 0; i < numBullets; i++) {
			bullets.push(new Bullet(ObjectId.Bullet));
		}
		for (int i = 0; i < 50; i++) {
			enemyBullets.push(new Bullet(ObjectId.Bullet));
		}
		for (int i = 0; i < 50; i++) {
			enemyBullets1.add(new Bullet(ObjectId.Bullet));
		}
	}

	@Override
	/**
	 * name of object
	 */
	public String toString() {
		return "Gun";
	}

	@Override
	/**
	 * updates
	 */
	public void tick(LinkedList<GameObject> object) {
		x += velX;
	}

	@Override
	/**
	 * draws
	 */
	public void render(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(10));
		g2D.drawLine((int) x, (int) y, (int) ((x) + getRadius() * Math.cos(Math.toRadians(angle))),
				(int) (y - getRadius() * Math.sin(Math.toRadians(angle))));

	}

	/**
	 * get radius
	 * 
	 * @return float the radius
	 */
	public float getRadius() {
		float dx = (int) (x + 5) - x;
		float dy = (int) (y - 20) - y;
		return (float) Math.sqrt(dx * dx + dy * dy);
	}

	/**
	 * angle
	 * 
	 * @return float the angle
	 */
	public float getAngle() {
		return angle;

	}

	/**
	 * sets angle
	 * 
	 * @param angle
	 *            the angle
	 */
	public void setAngle(float angle) {
		this.angle = angle;
	}

	/**
	 * the player
	 * 
	 * @return boolean if player
	 */
	public boolean isPlayerTank() {
		return tankID.isPlayer();
	}

	// For PlayerTank only. Make another method similar to this one but applies
	// only to EnemyTank.
	/**
	 * fires
	 * 
	 * @param h
	 *            handler
	 */
	public void fire(Handler h) {
		long t = System.currentTimeMillis();
		long temp = t - timeLastFired;
		if (bullets.size() != 0 && (t - timeLastFired) > 1000) {
			Bullet b = bullets.pop();
			b.setValues(((float) ((x) + getRadius() * Math.cos(Math.toRadians(getAngle())))),
					(float) (y - getRadius() * Math.sin(Math.toRadians(getAngle()))), ObjectId.Bullet,
					(float) (b.initialVelocity * Math.cos(Math.toRadians(getAngle()))), this, h);

			h.addObject(b);
			timeLastFired = t;
			// System.out.println(b.getX());
		}

	}

	// use a linked list of bullets instead of a stack. Get the first one to
	// fire, and for the second, getPrevious and see where that is and then
	// fire.
	/**
	 * also fires
	 * 
	 * @param h
	 *            handler
	 */
	public void enemyGunFire(Handler h) {
		long t = System.currentTimeMillis();
		long temp = t - timeLastFired;
		if (enemyBullets.size() != 0 && (t - timeLastFired) > 5000) {
			Bullet b = enemyBullets.pop();
			b.setValues(((float) ((x) + getRadius() * Math.cos(Math.toRadians(getAngle())))),
					(float) (y - getRadius() * Math.sin(Math.toRadians(getAngle()))), ObjectId.Bullet,
					(float) (b.initialVelocity * Math.cos(Math.toRadians(getAngle()))), this, h);

			h.addObject(b);
			timeLastFired = t;
		}

	}

	/**
	 * rotates gun
	 */
	public void rotateIncreaseAngle() {
		angle += 10;
	}

	/**
	 * rotates gun
	 */
	public void rotateDecreaseAngle() {
		angle -= 10;
	}

	/**
	 * returns bullets
	 * 
	 * @return Stack of bullets
	 */
	public Stack<Bullet> getBullets() {
		return bullets;
	}

	/**
	 * returns bullets
	 * 
	 * @return ArrayList of bullets
	 */
	public ArrayList<Bullet> getEnemyBullets1() {
		return enemyBullets1;
	}

}
