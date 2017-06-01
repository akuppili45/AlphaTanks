package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Creates and manages the tank and its values.
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class Tank extends GameObject {
	protected int width = 64, height = 32;
	Handler h;
	Gun gun;
	private int health = 3;
	Tank enemyTankData;
	Camera cam;
	Game game;
	boolean rightCrashed = false;
	float gravity = -.3f;

	/**
	 * The constructor
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            position
	 * @param id
	 *            object id
	 * @param handler
	 *            handler
	 * @param cam
	 *            camera
	 * @param game
	 *            the game
	 */
	public Tank(float x, float y, ObjectId id, Handler handler, Camera cam, Game game) {
		super(x, y, id);
		h = handler;
		// gun = new Gun(400,180,ObjectId.Gun);
		// x=120, y=468 // move this to render.
		h.addObject(this);
		gun = new Gun(x + 30, y, ObjectId.Gun, 45, this, h);
		h.addObject(gun);
		this.cam = cam;
		this.game = game;

	}

	/**
	 * constructor
	 * 
	 * @param id
	 *            ObjectId
	 */
	public Tank(ObjectId id) {
		super(id);
	}

	@Override
	/**
	 * updates
	 */
	public void tick(LinkedList<GameObject> object) {

		gun.setX(x + 30);
		x += velX;
		collision();
		if (getHealth() == 0)
			h.removeObject(this);

	}

	@Override
	/**
	 * string name of object
	 */
	public String toString() {
		return "Tank";
	}

	@Override
	/**
	 * draws objects
	 */
	public void render(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, width, height);
		gun.render(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(0));
		// g2D.setColor(Color.MAGENTA);
		g2D.draw(getBoundsLeft());
		g2D.draw(getBoundsRight());
		// Rectangle rectangle = new Rectangle(900,(int)y,46,34);

		// g2D.setStroke(new BasicStroke(0));
		// g2D.draw(rectangle);
	}

	/**
	 * if player
	 * 
	 * @return boolean is player
	 */
	public boolean isPlayer() {
		return this.getID() == ObjectId.PlayerTank;
	}

	/**
	 * the Gun
	 * 
	 * @return Gun the gun
	 */
	public Gun getGun() {
		return gun;
	}

	/**
	 * Bounds
	 * 
	 * @return Rectangle the top bounds
	 */
	public Rectangle getBounds() {
		return new Rectangle((int) (x + 5), (int) (y - 10), width - 10, 5);
	}

	/**
	 * Bounds
	 * 
	 * @return Rectangle the left bounds
	 */
	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int) y, width / 32, height);
	}

	/**
	 * Bounds
	 * 
	 * @return Rectangle the right bounds
	 */
	public Rectangle getBoundsRight() {
		return new Rectangle((int) (x + width), (int) y, width / 32, height);
	}

	/**
	 * the enemy tank data
	 * 
	 * @return Tank the enemy tank
	 */
	public Tank getEnemyTankData() {
		return enemyTankData;
	}

	/**
	 * the health
	 * 
	 * @return the amount of health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * sets health
	 * 
	 * @param health
	 *            the health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * whether it collided or not
	 */
	public void collision() {
		for (int i = 0; i < h.object.size(); i++) {
			GameObject a = h.object.get(i);
			if (a.getID() == ObjectId.Platform) {
				Platform block = (Platform) a;
				if (getBoundsLeft().intersects(block.getBounds())) {
					x = block.getX() + 40;
					// gun.setX(gun.getX() - 24.1f);

				} else if (getBoundsRight().intersects(block.getBounds())) {
					x = block.getX() - width;
					// gun.setX(gun.getX() + width);
				}

			} else if (this.getID() == ObjectId.PlayerTank && a.getID() == ObjectId.Flag) {
				Flag f = (Flag) a;
				if (getBoundsRight().intersects(f.getBounds())) {
					h.clearLevel();
					cam.setX(0);
					if (Flag.level == 4)
						Flag.level = 1;
					else
						Flag.level++;
					game.setCurrentLevel(Flag.level);
					game.init();
				}
			} else if (this.getID() == ObjectId.PlayerTank && a.getID() == ObjectId.PowerUp) {
				PowerUp p = (PowerUp) a;
				if (getBoundsRight().intersects(p.getBounds())) {
					p.setRemove(true);
					for (int j = 0; j < 10; j++)
						getGun().getBullets().push(new Bullet(ObjectId.Bullet));

				}

			} else if (this.getID() == ObjectId.PlayerTank && a.getID() == ObjectId.EnemyTank) {
				EnemyTank enemy = (EnemyTank) a;

				if (getBoundsRight().intersects(enemy.getBoundsLeft())) {
					rightCrashed = true;
					enemy.setVelX(3);
					x = enemy.getX() - 70;

				}
			}
		}

	}

	/**
	 * if right side is hit
	 * 
	 * @return boolean if it is hit
	 */
	public boolean isRightCrashed() {
		return rightCrashed;
	}
}
