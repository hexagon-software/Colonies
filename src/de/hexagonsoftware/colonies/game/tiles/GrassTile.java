package de.hexagonsoftware.colonies.game.tiles;

import de.hexagonsoftware.colonies.game.buildings.IBuilding;

public class GrassTile implements ITile {
	private IBuilding build;
	private boolean highlited = false;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

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
		
	}
	
	@Override
	public void setHighlited(boolean b) { this.highlited = b; }
}
