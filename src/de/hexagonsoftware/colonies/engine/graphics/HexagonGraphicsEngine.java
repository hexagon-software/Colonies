package de.hexagonsoftware.colonies.engine.graphics;

import de.hexagonsoftware.colonies.engine.Engine;
import de.hexagonsoftware.colonies.engine.Reference;

public class HexagonGraphicsEngine {
	private int[] resolution;
	private GameWindow gameWindow;
	private MainRenderer renderer;
	private AnimationRegistry animationRegistry;
	
	public HexagonGraphicsEngine(int[] resolution, String title, Engine engine) {
		Reference.logger.info("Initialising Graphics engine...");
		this.resolution = resolution;
		if (this.resolution == null) {
			Reference.logger.warn("THE CLIENT DID NOT SPECIFY THE RESOLUTION; SETTING RESOLUTION TO 1024x512!");
			this.resolution = new int[] {1024, 512};
		}
		
		this.gameWindow = new GameWindow(resolution, title, engine.getFullscreen());
		this.animationRegistry = new AnimationRegistry();
		this.renderer = new MainRenderer(engine, gameWindow);
	}
	
	public GameWindow getGameWindow() { return this.gameWindow; }
	public MainRenderer getRenderer() { return this.renderer; }
	public AnimationRegistry getAnimationRegistry() { return this.animationRegistry; }
}
