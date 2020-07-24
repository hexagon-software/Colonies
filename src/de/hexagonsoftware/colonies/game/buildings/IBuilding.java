package de.hexagonsoftware.colonies.game.buildings;

import java.awt.image.BufferedImage;

import de.hexagonsoftware.colonies.engine.TextureResource;

public interface IBuilding {
	void update(); // This update function will add resources to the players inventory, when it exists.
	void build();
	
	String getName();
	
	TextureResource getTextureResource();
	BufferedImage getTexture();
}
