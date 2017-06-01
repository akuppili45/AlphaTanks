package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Loads the image for processing
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class BufferedImageLoader {
	private BufferedImage image;

	/**
	 * loads the image of the level
	 * 
	 * @param path
	 *            of the image
	 * @return returns the image given by the path
	 */
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {

		}
		return image;
	}
}
