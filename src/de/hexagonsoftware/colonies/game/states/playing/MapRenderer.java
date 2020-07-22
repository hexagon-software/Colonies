package de.hexagonsoftware.colonies.game.states.playing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import de.hexagonsoftware.colonies.engine.graphics.polys.Hexagon;
import de.hexagonsoftware.colonies.game.Game;
import de.hexagonsoftware.colonies.game.tiles.ITile;
import de.hexagonsoftware.colonies.game.util.Vector3;
import de.hexagonsoftware.colonies.game.util.Vector3d;

public class MapRenderer {
	public static void drawHexMap(Game game, Graphics g, Point origin, int size, int radius, int padding, int oval) {
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * (radius + padding);
        double yOff = Math.sin(ang30) * (radius + padding);
        int half = size / 2;
        
        int scale = 15;
        int ovalColor = 0x2980b9;
        int c = 0;
        
        g.setColor(new Color(ovalColor));
        g.fillOval((game.getWindow().getWidth() / 2)-((oval*scale)/2), 
        (game.getWindow().getHeight() / 2)-((oval*scale)/2), oval*scale, oval*scale);
        for (int row = 0; row < size; row++) {
            int cols = size - java.lang.Math.abs(row - half);

            for (int col = 0; col < cols; col++) {
                int xLbl = row < half ? col - row : col - half;
                int yLbl = row - half;
                int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
                int y = (int) (origin.y + yOff * (row - half) * 3);
                
                int color = (int) ((ITile) game.getMap()[row+col].z).getColor();
                	
                drawHex(g, xLbl, yLbl, x, y, radius, color); 
                c++;
            }
            c++;
        }
	}
	
	public static void drawHex(Graphics g, int posX, int posY, int x, int y, int r, int color) {
		Graphics2D g2d = (Graphics2D) g;

        Hexagon hex = new Hexagon(x, y, r);
        
        hex.draw(g2d, x, y, 0, color, true);
        hex.draw(g2d, x, y, 2, 0x000000, false);
	}

}
