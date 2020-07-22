package de.hexagonsoftware.colonies.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import de.hexagonsoftware.colonies.engine.Reference;
import de.hexagonsoftware.colonies.game.Game;

public class MouseInput implements MouseListener {
	private Game game;
	
	public MouseInput(Game game) {
		this.game = game;
		Reference.logger.info("New MouseInput added (from "+game.getClass().getName()+")");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			game.handleMouse(e);
		} catch (NullPointerException ex) {
			return;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
			
	}

}
