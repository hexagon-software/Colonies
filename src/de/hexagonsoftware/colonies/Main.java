package de.hexagonsoftware.colonies;

import de.hexagonsoftware.colonies.game.Game;

public class Main {
	public static void main(String[] args) {
		System.out.println("Colonies v"+Reference.VERSION+" | Copyright (c) Hexagon Software\n");
		Reference.logger.info("Starting...");
		
		boolean skipSplash = false;
		
		for (String s : args) {
			if (s.matches("skipSplash"))
				skipSplash = true;
		}
		
		Game game = new Game();
		game.start(skipSplash);
	}
}
