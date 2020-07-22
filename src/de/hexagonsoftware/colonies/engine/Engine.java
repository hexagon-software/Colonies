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
	
	public Engine(Game game, String title) {
		this.game = game;
		this.hge = new HexagonGraphicsEngine( new int[] {1920, 1080}, title, this);
	}
	
	public HexagonGraphicsEngine getHGE() { return this.hge; }
	public GameWindow getWin() { return this.hge.getGameWindow(); }
	public Game getGame() { return this.game; }
}
