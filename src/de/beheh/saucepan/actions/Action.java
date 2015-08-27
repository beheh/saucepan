package de.beheh.saucepan.actions;

import de.beheh.saucepan.state.GameState;

public interface Action {

	public GameState apply(GameState state);
}
