package de.beheh.saucepan;

import de.beheh.saucepan.state.GameState;

public class GameTracker {

	private GameState gameState;

	public GameTracker(GameState initialState) {
		this.gameState = initialState;
	}

	public GameState getGameState() {
		return gameState;
	}
}
