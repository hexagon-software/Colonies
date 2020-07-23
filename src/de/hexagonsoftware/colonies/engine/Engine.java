package de.hexagonsoftware.colonies.engine;

import de.hexagonsoftware.colonies.engine.graphics.GameWindow;
import de.hexagonsoftware.colonies.engine.graphics.HexagonGraphicsEngine;
import de.hexagonsoftware.colonies.game.Game;

public class Engine {
	// Info Variables
	private final String ENGINE_VERSION = "1.1";
	public final String ENGINE_NAME = "Hexagon Engine v"+ENGINE_VERSION;
	public static final String VERSION = "1.1";
	
	// Engine Vars
	private Game game;
	private HexagonGraphicsEngine hge;
	private ResourceManager resourceManager;
	
	private boolean fullscreen;
	
	/**
	 * Constructor for the Engine.
	 * 
	 * @param game An instance of a Game-Class required by sub-parts of the Engine.
	 * @param title The title of the Game Window
	 * @param fullscreen Sets if the window should be (true) fullscreen or not.
	 * 
	 * @author Felix Eckert
	 * */
	public Engine(Game game, String title, boolean fullscreen) {
		Reference.logger.info("Initialising engine...");
		this.fullscreen = fullscreen;
		this.game = game;
		this.hge = new HexagonGraphicsEngine(new int[] {1920, 1080}, title, this); // Create a new Graphics Engine
		this.resourceManager = new ResourceManager(); // Create a new Resource Manager, responsible for storing and creating
													  // New resources.
	}
	
	/* Getters Below */
	
	public boolean getFullscreen() { return this.fullscreen; }
	
	public HexagonGraphicsEngine getHGE() { return this.hge; }
	public GameWindow getWin() { return this.hge.getGameWindow(); }
	public Game getGame() { return this.game; }
	public ResourceManager getResourceManager() { return this.resourceManager; }
}
