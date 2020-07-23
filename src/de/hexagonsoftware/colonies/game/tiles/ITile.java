package de.hexagonsoftware.colonies.game.tiles;

import de.hexagonsoftware.colonies.game.buildings.IBuilding;

public interface ITile {
	int getColor();
	String getName();
	void setX(int x);
	void setY(int y);
	void setBuilding(IBuilding build);
	String[] getPossibleBuildings();
}
