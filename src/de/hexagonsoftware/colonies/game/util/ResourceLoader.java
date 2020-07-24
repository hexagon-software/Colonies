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
		
		// Leave these commented until some images for them are added to the assets
		rm.addTexture("settlement", "/assets/img/buildings/settlement.png");
		rm.addTexture("sawmill", "/assets/img/buildings/sawmill.png");
		rm.addTexture("quarry", "/assets/img/buildings/quarry.png");
		rm.addTexture("ironmine", "/assets/img/buildings/iron_mine.png");
		// rm.addTexture("goldmine", "/assets/img/buildings/goldmine.png");
	}
	
	private static void loadSounds(ResourceManager rm) {
		rm.addSound("hexagonIntro", "/assets/sound/misc/splash.wav");
	}
}
