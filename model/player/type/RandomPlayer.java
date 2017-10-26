package model.player.type;

import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import controller.IController;

public class RandomPlayer extends AbstractPlayer {
	public RandomPlayer() {
		super();
	}

	@Override
	public ICard getCardToPlay(IGameLogic game, IController ctrl) {
	//
		return null;
	}

	@Override
	public Color selectColor(IGameLogic game, IController ctrl) {
	//
		return null;
	}

}
