package de.hexagonsoftware.colonies.game.tiles;

import de.hexagonsoftware.colonies.engine.Engine;
import de.hexagonsoftware.colonies.game.Game;
import de.hexagonsoftware.colonies.game.buildings.Buildings;
import de.hexagonsoftware.colonies.game.buildings.IBuilding;

public class GrassTile implements ITile {
	private IBuilding build = null;
	private boolean highlited = false;
	private Engine engine;
	
	private int x, y;
	
	public GrassTile(Game game) {
		this.engine = game.getEngine();
	}
	
	@Override
	public int getColor() {
		if (highlited)
			return 0xe74c3c;
		
		return 0x2ecc71;
	}

	@Override
	public String getName() {
		return "Grass Tile";
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int getX() { return this.x; }
	
	@Override
	public int getY() { return this.y; }

	@Override
	public void setBuilding(IBuilding build) {
		this.build = build;
	}
	
	@Override
	public IBuilding getBuilding() { return this.build; }

	@Override
	public String[] getPossibleBuildings() {
		return new String[] {
				"Settlement",
				"Sawmill"
		};
	}

	@Override
	public void createBuilding(int parseInt) {
		if (parseInt == 1) {
			this.setBuilding(new Buildings(engine).SAWMILL);
		}
	}
	
	@Override
	public void setHighlighted(boolean b) { this.highlited = b; }

	@Override
	public boolean hightlightActive() {
		return this.highlited;
	}	
}
