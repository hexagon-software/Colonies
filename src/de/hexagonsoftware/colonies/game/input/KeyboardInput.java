package de.hexagonsoftware.colonies.game.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import de.hexagonsoftware.colonies.engine.Reference;
import de.hexagonsoftware.colonies.game.Game;

public class KeyboardInput extends KeyAdapter {
	private Game game;
	
	public KeyboardInput(Game game) {
		this.game = game;
		Reference.logger.info("New KeyboardInput added (from "+game.getClass().getName()+")");
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		game.handleKeyDown(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		game.handleKeyUp(e);
	}
}
