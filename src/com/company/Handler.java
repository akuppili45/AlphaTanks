package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Handles all the game's objects.
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class Handler {
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	private GameObject tempObject;
	int currentLevel = 1;
	public boolean clear = false;
	public BufferedImage level = null;
	private int count = 0;
	public static int score = 0;

	/**
	 * updates
	 */
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.tick(object);
		}
	}

	/**
	 * set level
	 * 
	 * @param currentLevel
	 *            level
	 */
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * draws
	 * 
	 * @param g
	 *            drawer
	 */
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.render(g);

		}
	}

	/**
	 * adds
	 * 
	 * @param object
	 *            to add
	 */
	public void addObject(GameObject object) {
		this.object.add(object);
	}

	/**
	 * remove
	 * 
	 * @param object
	 *            to remove
	 */
	public void removeObject(GameObject object) {
		if (object.getID() == ObjectId.PlayerTank) {
			count++;
			if (count == 2) {
				JFrame frame = new JFrame("Game Over");
				JLabel label = new JLabel("Kills: " + score / 2, SwingConstants.CENTER);
				JLabel label2 = new JLabel("Press ESC to exit...", SwingConstants.CENTER);
				label.setPreferredSize(new Dimension(300, 100));
				label2.setPreferredSize(new Dimension(300, 100));
				frame.getContentPane().add(label, BorderLayout.CENTER);
				frame.getContentPane().add(label2, BorderLayout.AFTER_LAST_LINE);
				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);
			}
		} else if (object.getID() == ObjectId.EnemyTank) {
			score++;
		}
		this.object.remove(object);
	}

	/**
	 * clear level
	 */
	public void clearLevel() {
		object.clear();
		clear = true;
	}

	/**
	 * decide level
	 */
	public void decideLevel() {
		BufferedImageLoader loader = new BufferedImageLoader();
		switch (currentLevel) {
		case 1:
			level = loader.loadImage("/level1.png");
			break;
		case 2:
			level = loader.loadImage("/2.png");
			break;
		case 3:
			level = loader.loadImage("/3.png");
			break;
		case 4:
			level = loader.loadImage("/4.png");
			break;
		}
	}

}
