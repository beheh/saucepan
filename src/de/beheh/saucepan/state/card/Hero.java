package de.beheh.saucepan.state.card;

public final class Hero extends Character {

	public Hero(final String uid, final int health) {
		this(uid, 0, health);
	}

	public Hero(final String uid, final int attack, final int health) {
		super(uid, attack, health);
	}

}
