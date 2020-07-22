package de.hexagonsoftware.colonies.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import de.hexagonsoftware.colonies.Reference;
import de.hexagonsoftware.colonies.engine.Engine;
import de.hexagonsoftware.colonies.engine.graphics.GameWindow;
import de.hexagonsoftware.colonies.game.tiles.*;
import de.hexagonsoftware.colonies.game.util.PerlinNoise;
import de.hexagonsoftware.colonies.game.util.ResourceLoader;
import de.hexagonsoftware.colonies.game.util.Vector3;
import de.hexagonsoftware.colonies.game.util.Vector3d;

public class Game implements Runnable {
	private Engine engine;
	private GameWindow window;
	private StateMachine stateMachine;
	
	private Thread t;
	private boolean running;
	
	public int size = 7;
	private Map<Integer, Vector3d> noiseMap;
	private Vector3[] tileMap = new Vector3[size*size];
	
	private static double time = 0;
	private static BufferedImage image;
	
	public Game() {
		Reference.logger.info("Initialising Game...");
		this.engine = new Engine(this, "Colonies "+Reference.VERSION);
		this.window = engine.getWin();
		this.stateMachine = new StateMachine(this, engine);
		
		Reference.logger.info("Loading Game Resources...");
		ResourceLoader.loadResources(engine);
		
		// Set the Icon for the Game Window
		window.getFrame().setIconImage(engine.getResourceManager().getTexture("icon"));
		
		Reference.logger.info("Generating Map...");
		image = new BufferedImage(window.getWidth(), window.getHeight(), BufferedImage.TYPE_INT_RGB);
		this.noiseMap = new HashMap<>();
		generateMap();
		translateMap();
	}
	
	public void start(boolean skipSplash) {
		this.t = new Thread(this, "COLONIES");
		running = true;
		Reference.logger.info("Init Finished, entering game!");
		
		this.stateMachine.activateState("playing");
		if (!skipSplash)
			this.stateMachine.activateState("splash");
		
		this.t.start();
	}
	
	@Override
	public void run() {
		
		long oldTimestamp = System.nanoTime();
		double ticks = 60.0;
		double ns = 1000000000 / ticks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		long now;
		int fps = 0;
		
		while(true) {
			now = System.nanoTime();
			
			delta += (now - oldTimestamp) / ns;
			oldTimestamp = now;
			
			while(delta > 1 ) {
				stateMachine.getActiveState().update();
				delta--;	
			}
			
			if (running)
				engine.getHGE().getRenderer().render(fps);
			
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				fps = frames;
				frames = 0;
			}
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void render(Graphics g, int frames) {
		stateMachine.getActiveState().render(g, frames);
	}
	
	private void generateMap() {
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				double dx = (double) x / window.getHeight();
				double dy = (double) y / window.getWidth();
				int frequency = ThreadLocalRandom.current().nextInt(10, 1000);
				double type = PerlinNoise.noise((dx * frequency) + time, (dy * frequency) + time);
				int b = (int)(type * 0xFF);
    			int r = b * 0x10000;
    			int finalValue = r;
        		image.setRGB(x, y, finalValue);
				
				noiseMap.put(x+y, new Vector3d(x, y, type));
			}
		}	
	}
	
	private void translateMap() {
		for (int i = 0; i < noiseMap.size(); i++) {
			Vector3d tile = noiseMap.get(i);
			double noise = tile.z;
			double x = tile.x;
			double y = tile.y;
			
			if (noise < 0) {
				tileMap[i] = new Vector3(x, y, new GrassTile());
			} else {
				tileMap[i] = new Vector3(x, y, new StoneTile());
			}
		}
	}
	
    public BufferedImage getNoiseImage(){
    	BufferedImage img = new BufferedImage(window.getWidth(), window.getHeight(), BufferedImage.TYPE_INT_RGB);
    	time += 0.01;
    	for(int y = 0; y < window.getHeight(); y++){
    		for(int x = 0; x < window.getWidth(); x++){
    			double dx = (double) x / window.getHeight();
    			double dy = (double) y / window.getWidth();
    			int frequency = 6;
    			double noise = PerlinNoise.noise((dx * frequency) + time, (dy * frequency) + time);
    			noise = (noise - 1) / 2;
    			int b = (int)(noise * 0xFF);
    			int r = b * 0x10000;
    			int finalValue = r;
        		img.setRGB(x, y, finalValue);
        	}
    	}
    	return img;
    }
	
	public GameWindow getWindow() { return this.window; }
	public Vector3[] getMap() { return this.tileMap; }

	public StateMachine getStateMachine() {
		return stateMachine;
	}
}
