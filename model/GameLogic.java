package model;

import java.util.ArrayList;

import model.card.CardPile;
import model.card.CardPilesManager;
import model.card.ICardPile;
import model.card.type.ICard;
import model.player.PlayerManager;
import model.player.type.IPlayer;
import controller.IController;

public class GameLogic implements IGameLogic {
	private PlayerManager playerManager;
	private CardPilesManager cardPilesManager;
	private ArrayList<ICard> drawWell;
	private IPlayer winner;

	public GameLogic(PlayerManager playerManager,
			CardPilesManager cardPilesManager) {
		this.playerManager = playerManager;
		this.cardPilesManager = cardPilesManager;
		this.drawWell = new ArrayList<ICard>();
	}

	public boolean hasEnded() {
		ArrayList<IPlayer> playerList = this.playerManager.getPlayers();
		for (IPlayer p : playerList) {
			if (p.hasWon()) {
				this.winner = p;
				return true;
			}
		}
		return false;
	}

	public IPlayer getCurrentPlayer() {
		return this.playerManager.getCurrentPlayer();
	}

	public ICard getCurrentPlayedCard() {
		return this.cardPilesManager.getCurrentPlayedCard();
	}

	public void autoShoutUNO(IController ctrl) {

	}

	public void startTurn(IController ctrl) {
		this.playerManager.startTurn();
	}

	public void skipPlayer() {
		this.playerManager.skipPlayer();
	}

	public void addToDrawWell(int number) {
		this.drawWell.addAll(this.cardPilesManager.drawCards(number));
	}

	public void resetDrawWell() {
		this.drawWell.clear();
	}

	public boolean isDrawWellEmpty() {
		return this.drawWell.isEmpty();
	}

	public void drawCardsFromWell(IPlayer player, IController ctrl) {
	//	
	}

	public void invertDirection() {
		this.playerManager.invertDirection();
	}

	public boolean playCard(ICard playedCard, IController ctrl) {
	//
		return false;
	}

	public ICard drawOneCard(IPlayer player) {
	//
		return null;
	}

	public void announceWinner(IController ctrl) {
		if (this.hasEnded()) {
			ctrl.showMessage("Player" + this.winner + "has won the game!");
		}
	}

}
