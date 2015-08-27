package de.beheh.saucepan;

import de.beheh.saucepan.state.card.Card;

public class CardFactory {

	public Card build(String uid) {
		return new Card(uid);
	}
}
