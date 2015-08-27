package de.beheh.saucepan.actions;

import de.beheh.saucepan.Selector;
import de.beheh.saucepan.state.Player;
import de.beheh.saucepan.state.card.Hero;
import de.beheh.saucepan.state.card.Minion;
import de.beheh.saucepan.state.card.PlayableCard;
import org.junit.Test;
import static org.junit.Assert.*;

public class DrawTest {

	@Test
	public void testDraw() {
		PlayableCard[] deck = {new Minion("Wisp", 1, 1)};
		Player player = new Player(new Hero("Mage", 30), deck);
		Draw instance = new Draw(new Selector<>());
		Player result = instance.applyToPlayer(player);
		assertArrayEquals(player.getDeck(), result.getHand());
		assertSame(player.getHero(), result.getHero());
		assertSame(player.getWeapon(), result.getWeapon());
		assertSame(player.getField(), result.getField());
		assertSame(player.getSecrets(), result.getSecrets());
		assertSame(player.getGraveyard(), result.getGraveyard());
	}

	@Test
	public void testOverdraw() {
		Player player = new Player(new Hero("Mage", 30), new PlayableCard[0]);
		Draw instance = new Draw(new Selector<>());
		assertSame(30, player.getHero().getHealth());
		Player result = instance.applyToPlayer(player);
		assertSame(29, result.getHero().getHealth());
		assertSame(player.getDeck(), result.getDeck());
		assertSame(player.getHand(), result.getHand());
		assertSame(player.getWeapon(), result.getWeapon());
		assertSame(player.getField(), result.getField());
		assertSame(player.getSecrets(), result.getSecrets());
		assertSame(player.getGraveyard(), result.getGraveyard());
	}

}
