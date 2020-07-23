package de.hexagonsoftware.colonies.game.states;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import de.hexagonsoftware.colonies.engine.graphics.polys.Hexagon;
import de.hexagonsoftware.colonies.game.Game;
import de.hexagonsoftware.colonies.game.states.playing.ChoiceMenuRender;
import de.hexagonsoftware.colonies.game.states.playing.MapRenderer;
import de.hexagonsoftware.colonies.game.states.playing.StringRendering;
import de.hexagonsoftware.colonies.game.tiles.ITile;

/**
 * The Main Playing state.
 * 
 * @author Felix Eckert
 * */
public class PlayingState implements IState {
	private Game game;
	
	private List<Hexagon> hexList;
	private List<ITile> tiles;
	
	private boolean buildingChoiceActive = false;
	private String[] choices;
	
	public PlayingState(Game game) {
		this.game = game;
		this.hexList = new ArrayList<>();
		this.tiles = new ArrayList<>();
	}
	
	@Override
	public void render(Graphics g, int fps) {
		Point origin = new Point(game.getWindow().getWidth()/2, game.getWindow().getHeight()/2);
		MapRenderer.drawHexMap(game, g, origin, game.size, 50, 0, 50*game.size/8);
		StringRendering.render(g, game.getWindow().getWidth(), game.getWindow().getHeight(), fps);
		if (buildingChoiceActive)
			ChoiceMenuRender.render(g, game.getWindow().getWidth(), game.getWindow().getHeight(), choices);
	}

	@Override
	public void update() {
		if (buildingChoiceActive) {
		}
	}

	@Override
	public void mousePressed(int x, int y) {
		Rectangle r = new Rectangle(x, y, 1, 1);
		
		// Go through the hexList and check if the player clicked any hexagon
		try {
			for (int i = 0; i < hexList.size(); i++) {
				if (hexList.get(i).intersects(r))
					buildingChoiceActive = true;
			}
		} catch (ConcurrentModificationException e) {
			return;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	public void addHexagon(Hexagon hex) {
		hexList.add(hex);
	}

	public void clearHexMap() {
		hexList.clear();
	}

	public void addTile(ITile tile) {
		tiles.add(tile);
	} 
	
	public void clearTileMap() {
		tiles.clear();
	}
}
