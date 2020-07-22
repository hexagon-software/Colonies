package de.hexagonsoftware.colonies.game.util;

import de.hexagonsoftware.colonies.engine.Engine;
import de.hexagonsoftware.colonies.engine.ResourceManager;

/**
 * This class is responsible for loading all Game Resources.
 * */
public class ResourceLoader {
	public static void loadResources(Engine engine) {
		ResourceManager rm = engine.getResourceManager(); // Resource Manager of the Engine used to load new Resources
		
		loadTextures(rm);
		loadSounds(rm);
	}
	
	// Loads all textures
	private static void loadTextures(ResourceManager rm) {
		rm.addTexture("splash", "/assets/img/splash.png");
		rm.addTexture("icon", "/assets/img/icon.png");
	}
	
	private static void loadSounds(ResourceManager rm) {
		rm.addSound("hexagonIntro", "/assets/sound/misc/splash.wav");
	}
}
