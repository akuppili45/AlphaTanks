package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Bullets used to shoot game objects. Manages hit and movement of bullets.
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class Bullet extends GameObject {
	// Add Handler object, loop through handler, check enum if it's a tank,
	// and getBounds of this class intersects a bounds of a tempObject in the
	// loop.
	private float gravity = -.3f;
	private Gun gun;
	private int bulletWidth = 16;
	private int bulletHeight = 16;
	float initialVelocity = 18;
	Handler handler;

	/**
	 * Sets values for below.
	 * 
	 * @param x
	 *            x position
	 * @param y
	 *            y position
	 * @param id
	 *            object id
	 * @param velX
	 *            speed
	 * @param gun
	 *            gun object
	 * @param handler
	 *            game handler
	 */
	public void setValues(float x, float y, ObjectId id, float velX, Gun gun, Handler handler) {
		// super(x, y, id);
		setX(x);
		setY(y);
		this.velX = velX;
		this.gun = gun;
		velY = (float) (initialVelocity * Math.sin(Math.toRadians(gun.getAngle())));
		this.handler = handler;
	}

	/**
	 * constructs a bullet with the id
	 * 
	 * @param id
	 *            of the object
	 */
	public Bullet(ObjectId id) {
		super(id);
	}

	/**
	 * Sets the initial velocity to 18
	 * 
	 * @param initialVelocity
	 *            the init vel
	 */
	public void setInitialVelocity(float initialVelocity) {
		this.initialVelocity = initialVelocity;
	}

	// public Bullet(){
	// this = new Bullet(((float) ((gun.x) + gun.getRadius() *
	// Math.cos(Math.toRadians(gun.getAngle())))), (float)
	// (gun.y - gun.getRadius() * Math.sin(Math.toRadians(gun.getAngle()))),
	// ObjectId.Bullet, (float) (20 * Math.cos(Math.toRadians(gun.getAngle()))),
	// gun, handler));
	// }
	/**
	 * updates
	 * 
	 * @param LinkedList<GameObject>
	 *            object the objects
	 */
	public void tick(LinkedList<GameObject> object) {
		x += velX;
		velY += gravity;
		y -= velY;
		if (hitTank() || hitPlatform()) {

			velX = 0;
			velY = 0;
			gravity = 0;
			handler.removeObject(this);
		}
	}

	/**
	 * renders the bullet
	 * 
	 * @param g
	 *            the graphics variable used to draw the shapes required to
	 *            render the bullet
	 */
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int) x, (int) y, 1, 1);
		Graphics2D g2D = (Graphics2D) g;
		g2D.draw(getBounds());
		g2D.draw(getBoundsTop());
		g2D.draw(getBoundsRight());
		g2D.draw(getBoundsLeft());

	}

	/**
	 * returns null
	 * 
	 * @return returns the string of the Bullet
	 */
	public String toString() {
		return null;
	}

	/**
	 * @return returns the bottom bounds of the bullet to recognize bottom
	 *         collision
	 */
	public Rectangle getBounds() {
		return new Rectangle((int) x + (bulletWidth / 2) - ((bulletWidth / 2) / 2), (int) y + (bulletHeight / 2),
				bulletWidth / 2, bulletHeight / 2);
	}

	/**
	 * @return returns the leftbounds of the bullet to recognize left collision
	 */
	public Rectangle getBoundsTop() {
		return new Rectangle((int) x + (bulletWidth / 2) - ((bulletWidth / 2) / 2), (int) y, bulletWidth / 2,
				bulletHeight / 2);
	}

	/**
	 * @return returns the rightbounds of the bullet to recognize right
	 *         collision
	 */
	public Rectangle getBoundsRight() {
		return new Rectangle((int) x + bulletWidth - 5, (int) y + 5, 5, bulletHeight - 10);
	}

	/**
	 * @return returns the top bounds of the bullet to recognize top collision
	 */
	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int) y + 5, 5, bulletHeight - 10);
	}

	/**
	 * @return returns true if the bullet hits a tank
	 */
	public boolean hitTank() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ObjectId.PlayerTank || tempObject.getID() == ObjectId.EnemyTank) {
				Tank t = (Tank) tempObject;
				if (t.getBounds().intersects(getBounds())) {
					t.setHealth(t.getHealth() - 1);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @return returns true if the bullet hits a platform
	 */
	public boolean hitPlatform() {
		// for(GameObject tempObject : handler.object){
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ObjectId.Platform) {
				Platform t = (Platform) tempObject;
				if (t.getBounds().intersects(getBounds())) {
					return true;
				}
			}
		}
		return false;
	}

}
