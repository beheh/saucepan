package de.beheh.saucepan.state.card;

public class Weapon extends PlayableCard {

	private final int attack;
	private final int durability;

	public Weapon(String uid, final int attack, final int durability) {
		super(uid);
		this.attack = attack;
		this.durability = durability;
	}

	public int getAttack() {
		return attack;
	}

	public int getDurability() {
		return durability;
	}

}
