package model.card.type;

import model.IGameLogic;
import controller.IController;

public class Card implements ICard {
	Color color;
	Symbol symbol;
	
	public Card(Color color, Symbol symbol){
		this.color = color;
		this.symbol = symbol;
	}

	public boolean isPlayableOver(ICard otherCard) {
		switch (this.symbol) {
		case WILD:
		case WILD_DRAW_FOUR:
			return true;
		default:

			return this.color == otherCard.getColor()
					|| this.symbol == otherCard.getSymbol();
		}

	}

	public boolean isFirstPlayable() {
		switch (this.symbol) {
		case WILD:
		case WILD_DRAW_FOUR:
			return false;
		default:
			return true;
		}
	}

	public Color getColor() {
		return this.color;
	}

	public Symbol getSymbol() {
		return this.symbol;
	}

	public void executeAction(IGameLogic game, IController ctrl) {
		game.playCard(game.getCurrentPlayedCard(), ctrl);
	}

	public boolean isDiscardable() {
		return true;
	}

}
