package de.hexagonsoftware.colonies.game.states.playing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class ChoiceMenuRender {
	public static void render(Graphics g, int width, int height, String[] choices) {
		Graphics2D g2d = (Graphics2D) g;
		
		// Draw the title of the Box
		g2d.setColor(Color.black);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setFont(new Font("Courier New", Font.PLAIN, 25));
		g2d.drawString("Buildings", 150, height-(240-g.getFontMetrics().getHeight()));
		
		// Initialise the Box in Which the Choices are Displayed
		g2d.setColor(new Color(0xecf0f1));
		g2d.fillRect(100, height-200, width/4, 300);
		g2d.setColor(Color.black);
		g2d.drawRect(100, height-200, width/4, 300);
		
		// Draw the Options
		g2d.drawString("[ESC] Exit", 110, height-(200-(g.getFontMetrics().getHeight())));
		try {
			for (int i = 0; i < choices.length; i++) {
				g2d.drawString(i+": "+choices[i], 110,
						height-(200-(g.getFontMetrics().getHeight()*(i+2))));
			}
		} catch (NullPointerException e) {
			return;
		}
	}
}
