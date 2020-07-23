package de.hexagonsoftware.colonies.engine.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import de.hexagonsoftware.colonies.engine.Reference;

public class ImageLoader {
	
	/**
	 * Loads an Image from a given path.
	 * 
	 * @param path The path to the image to be loaded (URL)
	 * @return BufferedImage The loaded image.
	 * 
	 * @author Felix Eckert
	 * */
	public static BufferedImage loadImage(URL path) {
		BufferedImage img = null;
		
		if (path == null) {
			Reference.logger.error("The file \""+path+"\"");
			return null;
		}
		
		try {
			img = ImageIO.read(path);
		} catch (IOException e) {
			Reference.logger.error("A critical error occured whilst trying to load the Image, details are listed below!");
			e.printStackTrace();
			return null;
		}
		
		if (img != null) {
			return img;
		} else {
			return null;
		}	
	}
}
