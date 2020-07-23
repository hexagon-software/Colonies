package de.hexagonsoftware.colonies.engine.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class StringRenderer {
	public static int LEFT  = 0;
	public static int RIGHT = 1;
	public static int CENTER = 2;
	
	public static void drawString(Graphics g, String s, int y, int cvsWidth, int alignment) {
		int x = 1;
		
		switch (alignment) {
		case 1:
			x = cvsWidth - (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			break;
		case 2:
			x = (cvsWidth / 2) - (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		}
		
		g.drawString(s, x, y);
	}
	
	public static void drawString(Graphics2D g, String s, int y, int cvsWidth, int alignment) {
		int x = 1;
		
		switch (alignment) {
		case 1:
			x = cvsWidth - (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			break;
		case 2:
			x = (cvsWidth / 2) - (int) g.getFontMetrics().getStringBounds(s, g).getWidth()/2;
		}
		
		g.drawString(s, x, y);
	}
}
