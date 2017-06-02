package com.company;

/**
 * The camera that moves with the player.
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class Camera {
	private float x;
	private float y;

	/**
	 * @param xx
	 *            position of camera
	 * @param yy
	 *            position of the camera
	 */
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return returns y coordinate of the camera 
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y
	 *            y coordinate to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return returns x coordinate of the camera
	 */
	public float getX() {

		return x;
	}

	/**
	 * @param x
	 *            x coordinate to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * updates
	 */
	public void tick(GameObject player) {
		x = -player.getX() + Game.WIDTH / 2;
	}
}
