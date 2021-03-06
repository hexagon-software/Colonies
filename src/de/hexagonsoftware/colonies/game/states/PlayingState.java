package de.hexagonsoftware.colonies.game.states;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import de.hexagonsoftware.colonies.Reference;
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
	private int buildingTile;
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
			choices = tiles.get(buildingTile).getPossibleBuildings();
		}
		
		// Building Choice Highlight activation
		// The highlight for some reason renders also for non highlighted tiles.
		// Please help me
		if (buildingChoiceActive && buildingTile != -1) {
			tiles.get(buildingTile).setHighlighted(true);
		}
	}

	@Override
	public void mousePressed(int x, int y) {
		Rectangle r = new Rectangle(x, y, 1, 1);
		
		// Go through the hexList and check if the player clicked any hexagon
		try {
			for (int i = 0; i < hexList.size(); i++) {
				if (hexList.get(i).intersects(r)) {
					buildingChoiceActive = true;
					buildingTile = i;
				} else {
					if (tiles.get(i).hightlightActive()) {
						tiles.get(i).setHighlighted(false);
					}
				}
			}
		} catch (ConcurrentModificationException e) {
			Reference.logger.error("An exception occured whilst handling the players input!");
			return;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char keyChar = e.getKeyChar();	
		
		// If Escape was pressed, close any menu
		if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
			buildingChoiceActive = false;
			choices = null;
		}
		
		// Building Choice Handling
		if (buildingChoiceActive && Character.isDigit(keyChar)) {
			if (tiles.size() < buildingTile+1)
				return;
			
			if (tiles.get(buildingTile) != null && buildingTile != -1) {
				int choice = Integer.parseInt(String.valueOf(keyChar));
				
				// Check if choice is possible
				if (choices.length < choice+1)
					return; // Return if not
				
				try {
					tiles.get(buildingTile).createBuilding(choice); // Tell the Tile to create the building of the given ID (choice)
					buildingChoiceActive = false; // Deactivate the choice menu
					tiles.get(buildingTile).setHighlighted(false);
					buildingTile = -1; // Set the building tile back to -1
				} catch (IndexOutOfBoundsException ex) {
					Reference.logger.error("An exception occured whilst handling the players input!");
					return;
				}
			}
		}
	}

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
