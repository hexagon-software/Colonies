package de.hexagonsoftware.colonies.game.states;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

import de.hexagonsoftware.colonies.game.Game;
import de.hexagonsoftware.colonies.game.states.playing.MapRenderer;
import de.hexagonsoftware.colonies.game.states.playing.StringRendering;

public class PlayingState implements IState {
	private Game game;
	
	public PlayingState(Game game) {
		this.game = game;
	}
	
	@Override
	public void render(Graphics g, int fps) {
		Point origin = new Point(game.getWindow().getWidth()/2, game.getWindow().getHeight()/2);
		MapRenderer.drawHexMap(game, g, origin, game.size, 50, 0, 50*game.size/8);
		StringRendering.render(g, game.getWindow().getWidth(), game.getWindow().getHeight(), fps);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void mousePressed(int x, int y) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
