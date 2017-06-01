package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Creates a window for the game
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class Window {
	JFrame frame;
	JLabel label;
	JLabel health;

	/**
	 * creates a window with the game
	 * 
	 * @param w
	 *            width
	 * @param h
	 *            height
	 * @param title
	 *            game title
	 * @param game
	 *            the actual game
	 */
	public Window(int w, int h, String title, Game game) {
		game.setPreferredSize(new Dimension(w, h));
		game.setMaximumSize(new Dimension(w, h));
		game.setMinimumSize(new Dimension(w, h));

		frame = new JFrame(title);

		label = new JLabel("Kills: " + Handler.score / 2);
		health = new JLabel("Health: " + Game.health);
		frame.getContentPane().add(label, BorderLayout.NORTH);
		frame.getContentPane().add(health, BorderLayout.AFTER_LAST_LINE);

		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
	}

	/**
	 * updates scoreboard
	 */
	public void update() {
		label.setText("Kills: " + Handler.score / 2);
		health.setText("Health: " + Game.health);
	}

}
