package de.hexagonsoftware.colonies.engine;

import java.awt.image.BufferedImage;

import de.hexagonsoftware.colonies.engine.graphics.ImageLoader;

public class TextureResource implements IGameResource {
	private String path;
	private BufferedImage img;
	private String name;
	
	public TextureResource(String name) {
		this.name = name;
	}
	
	void setImagePath(String path) {
		this.path = path;
	}
	
	void loadImage() {
		this.img = ImageLoader.loadImage(this.getClass().getResource(path));
	}
	
	BufferedImage getImage() {
		return img;
	}
	
	String getPath() {
		return path;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
