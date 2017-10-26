package model.player.type;

import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import controller.IController;

public class HumanPlayer extends AbstractPlayer {
	public HumanPlayer() {
		super();
	}
	
	@Override
	public ICard getCardToPlay(IGameLogic game, IController ctrl) {
		return this.getCardFromHand(ctrl.AskForCardFromHand(this));	
	}

	@Override
	public Color selectColor(IGameLogic game, IController ctrl) {
		return ctrl.askForColor();
	}

}
