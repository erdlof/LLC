package llc.logic;

import java.io.Serializable;

import llc.engine.Camera;

public class GameState implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private Grid grid;
	private Camera camera;
	
	private Player player1, player2;
	private Cell townHall1, townHall2;
	
	public Cell hoveredCell, selectedCell;
	
	public int activePlayer;
	public int moveCount = 0;
	
	public boolean isGameOver = false;

	public Player winner;
	
	public GameState(Grid grid, Camera camera) {
		this.grid = grid;
		this.camera = camera;
		
		player1 = new Player(1, 100);
		player2 = new Player(2, 100);
	}
	
	public Grid getGrid() {
		return grid;
	}

	public void setActivePlayer(Player active) {
		if (player1.equals(active)) {
			activePlayer = 1;
		} else if (player2.equals(active)) {
			activePlayer = 2;
		} else {
			throw new IllegalArgumentException("Given Player argument does not exist");
		}
		
		this.camera.focusCell(this.getActivePlayerTownHallLocation(), true);
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
	public Player getActivePlayer() {
		if (activePlayer == 1) {
			return player1;
		} else {
			return player2;
		}
	}
	public Player getInActivePlayer() {
		if (activePlayer == 1) {
			return player2;
		} else {
			return player1;
		}
	}

	public Cell getTownHall1Cell() {
		return townHall1;
	}

	public void setTownHall1Cell(Cell townHall1) {
		this.townHall1 = townHall1;
	}

	public Cell getTownHall2Cell() {
		return townHall2;
	}

	public void setTownHall2Cell(Cell townHall2) {
		this.townHall2 = townHall2;
	}
	
	public Cell getActivePlayerTownHallLocation() {
		if (activePlayer == 1) {
			return townHall1;
		}
		else {
			return townHall2;
		}
	}
}
