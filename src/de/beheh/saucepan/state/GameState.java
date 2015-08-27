package de.beheh.saucepan.state;

public final class GameState {

	private final Player[] players;

	public GameState(Player[] players) {
		if (players == null) {
			throw new NullPointerException();
		}
		this.players = players;
	}

	public Player[] getPlayers() {
		return players;
	}

}
