package de.hexagonsoftware.colonies.game.states;

import de.hexagonsoftware.colonies.engine.Engine;
import de.hexagonsoftware.colonies.engine.graphics.*;
import de.hexagonsoftware.colonies.engine.sound.Sound;
import de.hexagonsoftware.colonies.game.Game;

import javax.sound.sampled.Mixer;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class SplashScreenState implements IState {
    private Game game;
    private BufferedImage splash;
    private int counter;
    private int counter2;
    private double alpha;
    private boolean soundPlayed = false;
    private boolean imageFinished = false;
    private boolean textFinished = false;

    public SplashScreenState(Game game) {
        this.game = game;
        this.splash = ImageLoader.loadImage(getClass().getResource("/assets/img/splash.png"));
        this.counter = 0;
        this.counter2 = 0;
        this.alpha = 0;
    }

    @Override
    public void render(Graphics g, int fps) {
        g.setColor(Color.black);
        g.fillRect(0, 0, game.getWindow().getWidth(), game.getWindow().getHeight());
        int x = (game.getWindow().getWidth() - splash.getWidth(null)) / 2;
        int y = (game.getWindow().getHeight() - splash.getHeight(null)) / 2;
        if (counter >= 460) {
            g.drawImage(splash, x, y, Color.black, null);
        }

        if (counter >= 990) {
            counter = 0;
            imageFinished = true;
        }
        if (!imageFinished) {
            counter++;
        }

        if (imageFinished && counter2 < 790) {
            counter2 ++;
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.white);
    		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setFont(new Font("Calibri", Font.BOLD, 25));
            g2d.drawString("COLONIES BY HEXAGON SOFTWARE, COPYRIGHT (C) 2020 HEXAGON SOFTWARE.", 
            		1, g2d.getFontMetrics().getHeight());
            g2d.drawString("HEXAGON ENGINE V"+Engine.VERSION+" COPYRIGHT (C) 2020 HEXAGON SOFTWARE.", 
            		1, g2d.getFontMetrics().getHeight()*2);
        }

        if (counter2 == 790) {
            textFinished = true;
        }
    }

    @Override
    public void update() {
        if (counter >= 10 && !soundPlayed) {
            (new Sound(getClass().getResource("/assets/sound/misc/splash.wav"))).playSound();
            this.soundPlayed = true;
        }

        if (textFinished) {
            game.getStateMachine().activateState("playing");
        }
    }

	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
