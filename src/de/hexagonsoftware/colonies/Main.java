package de.hexagonsoftware.colonies;

import de.hexagonsoftware.colonies.game.Game;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Colonies v"+Reference.VERSION+" | Copyright (c) Hexagon Software\n");
		
		boolean skipSplash = false;
		boolean fullscreen = false;
		
		for (String s : args) {
			if (s.matches("skipSplash"))
				skipSplash = true;
			
			if (s.matches("fullscreen"))
				fullscreen = true;
			
			if (s.matches("credits"))
				printCredits();
		}
		
		Reference.logger.info("Starting...");
		
		Game game = new Game(fullscreen);
		game.start(skipSplash);
	}

	private static void printCredits() {
		System.out.println("Colonies by Hexagon Software | CREDITS: \n");
		System.out.println("Felix Eckert: Project Lead");
		System.out.println("Kenney Vleugels: Placeholder Art");
		System.out.println("===================");
		System.out.println("Special thanks to all the people that helped the creation of this game in any way!");
		System.out.println();
	}
}
