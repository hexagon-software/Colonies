package de.hexagonsoftware.colonies.game.tiles;

import de.hexagonsoftware.colonies.game.buildings.IBuilding;

public class StoneTile implements ITile {
	@Override
	public int getColor() {
		return 0x7f8c8d;
	}

	@Override
	public String getName() {
		return "Stone";
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getPossibleBuildings() {
		return new String[] {
				"Quarry"
		};
	}
}
