package de.hexagonsoftware.colonies.game.states.playing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import de.hexagonsoftware.colonies.Reference;
import de.hexagonsoftware.colonies.engine.graphics.StringRenderer;

public class StringRendering {
	public static void render(Graphics g, int width, int height, int fps) {
		// Font Rendering Init Stuff
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setFont(new Font("Source Code Pro", Font.PLAIN, 30));
		g2d.setColor(Color.black);
		
		// Actually drawing it
		g2d.drawString("Colonies v"+Reference.VERSION, 5, 1+g2d.getFontMetrics().getHeight());
		g2d.drawString("Copyright © 2020 Hexagon Software.", 5, 1+g2d.getFontMetrics().getHeight()*2);
		StringRenderer.drawString(g, "FPS: "+fps, 1+g2d.getFontMetrics().getHeight(),
				width, StringRenderer.RIGHT);
	}
}
