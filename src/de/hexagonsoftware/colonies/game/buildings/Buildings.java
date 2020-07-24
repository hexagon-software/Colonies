package de.hexagonsoftware.colonies.game.buildings;

import de.hexagonsoftware.colonies.engine.Engine;

public class Buildings {
	public IBuilding SAWMILL;
	
	public Buildings(Engine engine) {
		SAWMILL = new SawmillBuilding(engine);
	}
}
