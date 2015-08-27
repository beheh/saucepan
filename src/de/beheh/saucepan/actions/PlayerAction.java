package de.beheh.saucepan.actions;

import de.beheh.saucepan.Selector;
import de.beheh.saucepan.state.GameState;
import de.beheh.saucepan.state.Player;

public abstract class PlayerAction implements Action {

	protected final Selector<Player> selector;

	public PlayerAction(final Selector<Player> selector) {
		if (selector == null) {
			throw new NullPointerException();
		}
		this.selector = selector;
	}

	@Override
	public GameState apply(final GameState state) {
		final Player[] players = state.getPlayers();
		final Player[] newPlayers = new Player[players.length];
		for (int i = 0; i <= players.length; i++) {
			Player player = players[i];
			if (selector.matches(player)) {
				player = this.applyToPlayer(player);
			}
			newPlayers[i] = player;
		}
		return new GameState(newPlayers);
	}

	protected abstract Player applyToPlayer(final Player player);
}
