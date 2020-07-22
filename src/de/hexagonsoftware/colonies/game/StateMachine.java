package de.hexagonsoftware.colonies.game;

import java.util.HashMap;
import java.util.Map;

import de.hexagonsoftware.colonies.Reference;
import de.hexagonsoftware.colonies.engine.Engine;
import de.hexagonsoftware.colonies.game.states.IState;
import de.hexagonsoftware.colonies.game.states.PlayingState;
import de.hexagonsoftware.colonies.game.states.SplashScreenState;

public class StateMachine {
	private IState activeState;
	private Map<String, IState> states;
	
	public StateMachine(Game game, Engine engine) {
		this.states = new HashMap<String, IState>();
		states.put("splash", new SplashScreenState(game, engine));
		states.put("playing", new PlayingState(game));
	}
	
	public IState getActiveState() {
		return activeState;
	}

	public void activateState(String name) {
		Reference.logger.info("Updating State to \""+name+"\"");
		this.activeState = states.get(name);
	}
}
