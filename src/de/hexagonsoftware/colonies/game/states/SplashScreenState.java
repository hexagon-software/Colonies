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
    private int counter;
    private int counter2;
    private boolean soundPlayed = false;
    private boolean imageFinished = false;
    private boolean textFinished = false;
    private boolean imageLoaded = false;
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
            counter2 ++;
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.white);
    		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setFont(new Font("Calibri", Font.BOLD, 25));
            g2d.drawString("COLONIES BY HEXAGON SOFTWARE, COPYRIGHT (C) 2020 HEXAGON SOFTWARE.", 
            		1, g2d.getFontMetrics().getHeight());
            g2d.drawString("HEXAGON ENGINE V"+Engine.VERSION+" COPYRIGHT (C) 2020 HEXAGON SOFTWARE.", 
            		1, g2d.getFontMetrics().getHeight()*2);
            
            String[] strings = new String[] {
            		"Powered by HEGE",
            		"(C) 2020 HEXAGON SOFTWARE. The Hexagon Engine alongside Colonies lie under the 3-Clause BSD License.",
            		"The license file can be found at https://t1p.de/0fs8 (Github Redirect).",
            		"The Hexagon Software Logo belongs to Hexagon Software and may not be claimed as your own!"
            };
            
            g2d.setFont(new Font("Calibri", Font.BOLD, 50));
            
            for (int i = 0; i < strings.length; i++)
            	StringRenderer.drawString(g2d, strings[i], y*4+(g2d.getFontMetrics().getHeight()*(i+1)), game.getWindow().getWidth(), StringRenderer.CENTER);
        }

        if (!splashSound.isOpen() && soundPlayed) {
            textFinished = true;
        }
        imageLoaded = true;
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
