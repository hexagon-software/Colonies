package de.hexagonsoftware.colonies.game.buildings;

import java.awt.image.BufferedImage;

import de.hexagonsoftware.colonies.engine.Engine;
import de.hexagonsoftware.colonies.engine.TextureResource;

public class SawmillBuilding implements IBuilding {
	private Engine engine;
	private String textureResourceName = "sawmill";
	
	public SawmillBuilding(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public void update() {}

	@Override
	public void build() {}

	@Override
	public String getName() {
		return "Sawmill";
	}

	@Override
	public TextureResource getTextureResource() {
		return engine.getResourceManager().getTextureResource(textureResourceName);
	}

	@Override
	public BufferedImage getTexture() {
		return engine.getResourceManager().getTexture(textureResourceName);
	}

}
