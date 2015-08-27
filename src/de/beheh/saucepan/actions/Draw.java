package de.beheh.saucepan.actions;

import de.beheh.saucepan.Selector;
import de.beheh.saucepan.state.Player;
import de.beheh.saucepan.state.card.PlayableCard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Draw extends PlayerAction {

	public Draw(final Selector<Player> selector) {
		super(selector);
	}

	@Override
	protected Player applyToPlayer(final Player player) {
		PlayableCard[] deck = player.getDeck();
		PlayableCard[] hand = player.getHand();
		if (deck.length > 0) {
			List<PlayableCard> deckList = new ArrayList<>(Arrays.asList(deck));
			List<PlayableCard> handList = new ArrayList<>(Arrays.asList(hand));

			// take the first card from deck and move it to the last position in hand
			handList.add(deckList.remove(0));

			deck = deckList.toArray(new PlayableCard[0]);
			hand = handList.toArray(new PlayableCard[0]);
		} else {
			// new Hit()
			throw new UnsupportedOperationException("not yet implemented");
		}
		return new Player(player.getHero(), player.getWeapon(), deck, hand, player.getField(), player.getSecrets(), player.getGraveyard());

	}

}
