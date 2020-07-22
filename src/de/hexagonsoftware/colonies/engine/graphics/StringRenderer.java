package de.hexagonsoftware.colonies.engine.graphics;

import java.awt.Graphics;

public class StringRenderer {
	public static int LEFT  = 0;
	public static int RIGHT = 1;
	
	public static void drawString(Graphics g, String s, int y, int cvsWidth, int alignment) {
		int x = 1;
		
		if (alignment == 1)
			x = cvsWidth - (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		
		g.drawString(s, x, y);
	}
}
