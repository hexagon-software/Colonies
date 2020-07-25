package de.hexagonsoftware.colonies.game.states.playing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import de.hexagonsoftware.colonies.engine.graphics.polys.Hexagon;
import de.hexagonsoftware.colonies.game.Game;
import de.hexagonsoftware.colonies.game.states.PlayingState;
import de.hexagonsoftware.colonies.game.tiles.ITile;

public class MapRenderer {
	private static int tileNo = 0;
	
	public static void drawHexMap(Game game, Graphics g, Point origin, int size, int radius, int padding, int oval) {
		((PlayingState) game.getStateMachine().getActiveState()).clearHexMap();
		((PlayingState) game.getStateMachine().getActiveState()).clearTileMap();
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * (radius + padding);
        double yOff = Math.sin(ang30) * (radius + padding);
        int half = size / 2;
        
        int scale = 15;
        int ovalColor = 0x2980b9;
        
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
                
                int color = (int) ((ITile) game.getMap()[row+col]).getColor();
                ITile tile = (ITile) game.getMap()[row+col];
                tile.setX(x);
                tile.setY(y);
                
                drawHex(g, xLbl, yLbl, x, y, radius, color, game, tile); 
            }
        }
        
        tileNo = 0;
	}
	
	public static void drawHex(Graphics g, int posX, int posY, int x, int y, int r, int color, Game game, ITile tile) {
		tileNo++;
		Graphics2D g2d = (Graphics2D) g;

        Hexagon hex = new Hexagon(x, y, r);
        
       ((PlayingState) game.getStateMachine().getActiveState()).addHexagon(hex);
       ((PlayingState) game.getStateMachine().getActiveState()).addTile(tile);
        
        hex.draw(g2d, x, y, 0, color, true);
        hex.draw(g2d, x, y, 2, 0x000000, false);
        
        if (tile.getBuilding() != null)
        	g2d.drawImage(tile.getBuilding().getTexture(), x, y, 32, 32, null);
        	
        g2d.setColor(Color.BLACK);
        int feldX = x- (int)g.getFontMetrics().getStringBounds(String.valueOf(tileNo), g).getWidth()/2;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setFont(new Font("Courier New", Font.ITALIC, 18));
        g2d.drawString(String.valueOf(tileNo), feldX, y);
	}

}
