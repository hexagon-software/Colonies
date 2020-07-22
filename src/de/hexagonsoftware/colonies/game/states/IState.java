package de.hexagonsoftware.colonies.game.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public interface IState {
	void render(Graphics g, int fps);
	void update();
	void mousePressed(int x, int y);
	void keyPressed(KeyEvent e);
	void keyReleased(KeyEvent e);
}
