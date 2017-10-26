package model.card;

import java.util.Collections;
import java.util.Stack;

import model.card.type.Card;
import model.card.type.ICard;

public class CardPile implements ICardPile {
	private Stack cardPile;

	public CardPile() {
		cardPile = new Stack();
	}

	public int getSize() {
		return this.cardPile.size();
	}

	public ICard pushCard(ICard newCard) {
		this.cardPile.push(newCard);
		return newCard;
	}

	public ICard popCard() {
		return (ICard) this.cardPile.pop();
	}

	public ICard peekCard() {
		return (ICard) this.cardPile.peek();
	}

	public void shuffle() {
		Collections.shuffle(this.cardPile);
	}

	public boolean isEmpty() {
		return this.cardPile.isEmpty();
	}

	public void pushCards(ICardPile otherPile) {
		otherPile = new CardPile();
		while (!this.cardPile.isEmpty()) {
			otherPile.pushCard(((ICardPile) this.cardPile).popCard());
		}
	}
}
