package de.hexagonsoftware.colonies.engine.graphics;

import java.awt.Canvas;

import javax.swing.JFrame;

public class GameWindow extends Canvas {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	public GameWindow(int[] res, String title, boolean fullscreen) {
		this.frame = new JFrame(title);
		frame.setSize(res[0], res[1]);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(res[0], res[1]);
		
		if (fullscreen)
			frame.setUndecorated(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frame.add(this);
		frame.setVisible(true);
	}

	public JFrame getFrame() { return this.frame; }
}
