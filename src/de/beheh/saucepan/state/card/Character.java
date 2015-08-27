package de.beheh.saucepan.state.card;

/**
 *
 * @author benedict
 */
public abstract class Character extends PlayableCard {

	private final int attack;
	private final int health;

	public Character(final String uid, final int attack, final int health) {
		super(uid);
		this.attack = attack;
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public int getHealth() {
		return health;
	}

}
