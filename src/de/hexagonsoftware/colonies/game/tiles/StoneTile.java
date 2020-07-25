package de.hexagonsoftware.colonies.game.tiles;

import de.hexagonsoftware.colonies.game.buildings.IBuilding;

public class StoneTile implements ITile {
	private IBuilding build;
	private boolean highlited = false;
	private int x, y;
	
	@Override
	public int getColor() {
		if (highlited)
			return 0xe74c3c;
		
		return 0x7f8c8d;
	}

	@Override
	public String getName() {
		return "Stone";
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
				"Quarry",
				"Iron Mine",
				"Gold Mine"
		};
	}

	@Override
	public void createBuilding(int parseInt) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setHighlighted(boolean b) { this.highlited = b; }
	
	@Override
	public boolean hightlightActive() {
		return this.highlited;
	}
}
