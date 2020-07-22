package de.hexagonsoftware.colonies.game.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import de.hexagonsoftware.colonies.Reference;

public class ImageWriter {
	public static void write(BufferedImage img) {
		try {
			Reference.logger.info("Writing noise image...");
			String wd = ImageWriter.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
			if (!(new File(wd+"/img")).exists())
				(new File(wd+"/img")).mkdir();
			
			
		    File outputfile = new File(wd+"/img/noise.png");
		    outputfile.createNewFile();
		    ImageIO.write(img, "png", outputfile);
		} catch (IOException | URISyntaxException e) {
		    e.printStackTrace();
		}
	}
}
