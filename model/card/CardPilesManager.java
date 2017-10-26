package model.card;

import java.util.ArrayList;
import java.util.List;

import model.card.deck.IDeckStrategy;
import model.card.type.Card;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.Symbol;
import model.player.type.IPlayer;

public class CardPilesManager implements ICardPilesManager, IDeckStrategy {
	private ICardPile deck;
	private ICardPile discardPile;

	public CardPilesManager() {
		this.deck = createDeck();
		this.discardPile = new CardPile();
	}

	public void rebuildDeck() {
		ICard topOfTheDiscardPile = this.discardPile.popCard();
		this.discardPile.shuffle();
		this.discardPile.pushCards(deck);
		this.discardPile.pushCard(topOfTheDiscardPile);
	}

	public ICard drawCard() {
		return this.deck.popCard();
	}

	public int getDrawableCardsNumber() {
		return this.deck.getSize() + this.discardPile.getSize() - 1;
	}

	public ArrayList<ICard> drawCards(int cardsNumber) {
		ArrayList<ICard> cardsDrawed = new ArrayList<ICard>();
		for (int i = 1; i < cardsNumber; i++) {
			cardsDrawed.add(this.deck.popCard());
		}
		return cardsDrawed;
	}

	public ICard getCurrentPlayedCard() {
		return this.discardPile.popCard();
	}

	public void discard(ICard newCard) {
		this.discardPile.pushCard(newCard);
	}

	public ArrayList<ICard> addCardsToPlayer(IPlayer player, int number) {
		player.addToHand(drawCards(number));
		return drawCards(number);
	}

	public ICardPile createDeck() {
		ICardPile cardPile = new CardPile();
		Color[] colors = Color.getColors();
		Symbol[] symbols = Symbol.getSymbols();
		for (Symbol s : symbols) {
			for (Color c : colors) {
				cardPile.pushCard(new Card(c, s));
				if (s != Symbol.ZERO && s != Symbol.WILD
						&& s != Symbol.WILD_DRAW_FOUR) {
					cardPile.pushCard(new Card(c, s));
				}
			}
		}
		return cardPile;
	}

}
