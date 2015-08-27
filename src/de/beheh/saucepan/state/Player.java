package de.beheh.saucepan.state;

import de.beheh.saucepan.state.card.Hero;
import de.beheh.saucepan.state.card.Weapon;
import de.beheh.saucepan.state.card.PlayableCard;
import de.beheh.saucepan.state.card.Minion;
import de.beheh.saucepan.state.card.Secret;

public final class Player {

	private final Hero hero;
	private final Weapon weapon;
	private final PlayableCard[] hand;
	private final PlayableCard[] deck;
	private final Minion[] field;
	private final Secret[] secrets;
	private final PlayableCard[] graveyard;

	public Player(final Hero hero, final PlayableCard[] deck) {
		this(hero, null, deck, new PlayableCard[0], new Minion[0], new Secret[0], new PlayableCard[0]);
	}

	public Player(final Hero hero, final Weapon weapon, final PlayableCard[] deck, final PlayableCard[] hand, final Minion[] field, final Secret[] secrets, final PlayableCard[] graveyard) {
		if (hero == null || deck == null || hand == null || field == null || secrets == null || graveyard == null) {
			throw new NullPointerException();
		}
		this.hero = hero;
		this.weapon = weapon;
		this.deck = deck;
		this.hand = hand;
		this.field = field;
		this.secrets = secrets;
		this.graveyard = graveyard;
	}

	public Hero getHero() {
		return hero;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public PlayableCard[] getDeck() {
		return deck;
	}

	public boolean isFatigued() {
		return deck.length == 0;
	}

	public PlayableCard[] getHand() {
		return hand;
	}

	public Minion[] getField() {
		return field;
	}

	public Secret[] getSecrets() {
		return secrets;
	}

	public boolean hasSecret() {
		return secrets.length == 0;
	}

	public boolean hasSecret(String id) {
		for (Secret secret : secrets) {
			if (secret.getUid().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public PlayableCard[] getGraveyard() {
		return graveyard;
	}

	public boolean hasMinionDiedThisGame() {
		for (PlayableCard card : graveyard) {
			if (card.getClass() == Minion.class) {
				return true;
			}
		}
		return false;
	}

}
