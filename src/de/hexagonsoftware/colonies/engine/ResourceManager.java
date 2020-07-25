package de.hexagonsoftware.colonies.engine;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import de.hexagonsoftware.colonies.engine.sound.Sound;

public class ResourceManager {
	public Map<String, TextureResource> textures = new HashMap<>();
	public Map<String, SoundResource> sounds = new HashMap<>();
	
	
	public void addTexture(String name, String path) {
		TextureResource tempResource = new TextureResource(name);
		tempResource.setImagePath(path);
		tempResource.loadImage();
		textures.put(name, tempResource);
		Reference.logger.info("Registered new Texture Resource \""+name+"\" ("+textures.size()+")");
	}
	
	public void addSound(String name, String path) {
		SoundResource tempResource = new SoundResource(name);
		tempResource.setSoundPath(path);
		tempResource.loadSound();
		sounds.put(name, tempResource);
		Reference.logger.info("Registered new Sound Resource \""+name+"\" ("+sounds.size()+")");
	}

	public BufferedImage getTexture(String name) {
		return textures.get(name).getImage();
	}
	
	public TextureResource getTextureResource(String name) {
		return textures.get(name);
	}

	public Sound getSound(String name) {
		return sounds.get(name).getSound();
	}
	
	public SoundResource getSoundResource(String name) {
		return sounds.get(name);
	}
}
