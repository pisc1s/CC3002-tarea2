package model.player.type;

import java.util.ArrayList;

import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import controller.IController;

public abstract class AbstractPlayer implements IPlayer {
	private ArrayList<ICard> hand;
	private boolean status;

	public AbstractPlayer() {
		hand = new ArrayList<ICard>();
		status = false;
	}

	public void addToHand(ArrayList<ICard> hand) {
		this.hand.addAll(hand);
	}

	public boolean hasWon() {
		return this.hand.isEmpty();
	}

	public abstract ICard getCardToPlay(IGameLogic game, IController ctrl);

	public abstract Color selectColor(IGameLogic game, IController ctrl);

	public int getHandSize() {
		return this.hand.size();
	}

	public boolean hasOneCard() {
		return this.getHandSize() == 1;
	}

	public ArrayList<ICard> getHand() {
		return this.hand;
	}

	public void setSaidUNO(boolean status) {
		this.status = status;
	}

	public boolean hasSaidUNO() {
		return this.status;
	}

	public void removeCardFromHand(ICard card) {
		this.hand.remove(card);
	}

	public boolean needsToDrawCard(ICard currentCard) {
		boolean answer = true;
		for (ICard card : this.hand) {
			answer = !card.isPlayableOver(currentCard);
		}
		return answer;
	}

	public ICard getCardFromHand(int number) {
		if (number < this.getHandSize() && number >= 0) {
			return this.hand.get(number);
		}
		return null;
	}
}
