package de.hexagonsoftware.colonies.engine;

import de.hexagonsoftware.colonies.engine.sound.Sound;

public class SoundResource implements IGameResource {
	private String path;
	private Sound sound;
	private String name;
	
	public SoundResource(String name) {
		this.name = name;
	}
	
	void setSoundPath(String path) {
		this.path = path;
	}
	
	void loadSound() {
		this.sound = new Sound(this.getClass().getResource(path));
	}
	
	Sound getSound() {
		return sound;
	}
	
	void playSound() {
		sound.playSound();
	}
	
	String getPath() {
		return path;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
