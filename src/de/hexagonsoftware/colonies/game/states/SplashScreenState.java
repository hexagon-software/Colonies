package de.hexagonsoftware.colonies.game.states;

import de.hexagonsoftware.colonies.engine.Engine;
import de.hexagonsoftware.colonies.engine.graphics.StringRenderer;
import de.hexagonsoftware.colonies.engine.sound.Sound;
import de.hexagonsoftware.colonies.game.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class SplashScreenState implements IState {
    private Game game;
    private Engine engine;
    private BufferedImage splash;
    private BufferedImage text;
    private int counter;
    private int counter2;
    private boolean soundPlayed = false;
    private boolean imageFinished = false;
    private boolean textFinished = false;
    private boolean imageLoaded = false;
    private boolean textLoaded = false;
    private boolean soundLoaded = false;
    private Sound splashSound;
    
    public SplashScreenState(Game game, Engine engine) {
        this.game = game;
        this.engine = engine;
        this.counter = 0;
        this.counter2 = 0;
    }

    @Override
    public void render(Graphics g, int fps) {
    	if (!imageLoaded)
    		this.splash = engine.getResourceManager().getTexture("splash");
    	
    	if (!textLoaded)
    		this.text = engine.getResourceManager().getTexture("splashHEGE");
    	
    	if (!soundLoaded)
            this.splashSound = engine.getResourceManager().getSound("hexagonIntro");
    	
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWindow().getWidth(), game.getWindow().getHeight());
        int x = (game.getWindow().getWidth() - splash.getWidth(null)) / 2;
        int y = (game.getWindow().getHeight() - splash.getHeight(null)) / 2;
        if (splashSound.getTimeInSeconds() > 7.000748E12 && !imageFinished) {
            g.drawImage(splash, x, y, Color.black, null);
        }
        
        if (splashSound.getTimeInSeconds() > 1.3570748E13) {
            counter = 0;
            imageFinished = true;
        }
        if (!imageFinished) {
            counter++;
        }

        if (imageFinished && splashSound.getTimeInSeconds() > 1.3570748E13) {
        	x = (game.getWindow().getWidth() - text.getWidth(null)) / 2;
            y = (game.getWindow().getHeight() - text.getHeight(null)) / 2;
        	
            g.drawImage(text, 0, 0, game.getWindow().getWidth(), game.getWindow().getHeight(), null);
        }

        if (!splashSound.isOpen() && soundPlayed) {
            textFinished = true;
        }
        imageLoaded = true;
        textLoaded = true;
        soundLoaded = true;
    }

    @Override
    public void update() {
    	if (!soundLoaded) {
            this.splashSound = engine.getResourceManager().getSound("hexagonIntro");
    		soundLoaded = true;
    	}
    	
        if (counter >= 10 && !soundPlayed) {
        	this.splashSound.playSound();
            this.soundPlayed = true;
        }

        if (textFinished) {
            game.getStateMachine().activateState("playing");
        }
    }

	@Override
	public void mousePressed(int x, int y) {
		textFinished = true;
		engine.getResourceManager().getSound("hexagonIntro").stopSound();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		textFinished = true;
		engine.getResourceManager().getSound("hexagonIntro").stopSound();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
