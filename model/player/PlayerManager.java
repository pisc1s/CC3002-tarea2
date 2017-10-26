package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

public class PlayerManager implements IPlayerManager, IPlayerListBuilder {
	private ArrayList<IPlayer> playerList;
	private IPlayer currentPlayer;
	private IPlayer nextPlayer;
	private Direction direction;

	public PlayerManager() {
		playerList = new ArrayList<IPlayer>();
		currentPlayer = null;
		nextPlayer = null;
		direction = Direction.COUNTERCLOCKWISE;
	}

	public IPlayer getCurrentPlayer() {
		return this.currentPlayer;
	}

	public ArrayList<IPlayer> getPlayers() {
		return this.playerList;
	}
	
	public void invertDirection() {
		switch (this.direction) {
		case COUNTERCLOCKWISE:
			this.direction = Direction.CLOCKWISE;
			break;
		default:
			this.direction = Direction.COUNTERCLOCKWISE;
			break;
		}
	}

	public void startTurn() {
		switch (this.direction) {
		case COUNTERCLOCKWISE:
			this.currentPlayer = playerList.get(0);
			this.nextPlayer = playerList.get(1);
			break;
		default:
			this.currentPlayer = playerList.get(playerList.size() - 1);
			this.nextPlayer = playerList.get(playerList.size() - 2);
			break;
		}
	}

	public void skipPlayer() {
		int nextPlayersPosition = this.playerList.indexOf(this.nextPlayer);
		int size = this.playerList.size();
		if (nextPlayersPosition == size - 1
				&& this.direction == Direction.COUNTERCLOCKWISE) {
			this.nextPlayer = this.playerList.get(0);
		} else if (nextPlayersPosition == 0
				&& this.direction == Direction.CLOCKWISE) {
			this.nextPlayer = this.playerList.get(size - 1);
		} else {
			switch (this.direction) {
			case COUNTERCLOCKWISE:
				this.nextPlayer = this.playerList.get(nextPlayersPosition + 1);
				break;
			default:
				this.nextPlayer = this.playerList.get(nextPlayersPosition - 1);
				break;
			}
		}
	}

	public void addPlayer(IPlayer player) {
		this.playerList.add(player);
	}

	public ArrayList<IPlayer> buildPlayerList() {
		ArrayList<IPlayer> returnedObject = this.playerList;
		this.playerList.clear();
		return returnedObject;
	}

}
