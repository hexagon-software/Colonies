package de.hexagonsoftware.colonies.game.tiles;

import de.hexagonsoftware.colonies.game.buildings.IBuilding;

public interface ITile {
	// Basic Info
	int getColor();
	String getName();
	
	// Coordinates of tile
	void setX(int x);
	void setY(int y);
	int getX();
	int getY();
	
	// Buildings
	void setBuilding(IBuilding build);
	IBuilding getBuilding();
	String[] getPossibleBuildings();
	void createBuilding(int parseInt);
	
	// Hightlight
	void setHighlighted(boolean b);
	boolean hightlightActive();
}
