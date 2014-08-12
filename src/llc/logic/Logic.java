package llc.logic;

import llc.entity.Entity;
import llc.entity.EntityMovable;

public class Logic {

	private GameState gameState;
	private EntityMovable selectedEntity;

	public Logic(Grid grid) {
		this.setGameState(new GameState(grid));
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	private void clickCell(int x, int y) {
		Cell clickedCell = gameState.getGrid().getCellAt(x, y);
		if (clickedCell.containsEntity()) {
			selectEntity(selectedEntity);
		} else {
			unSelect();
		}
	}

	private void selectEntity(Entity toSelect) {
		if (toSelect instanceof EntityMovable) {
			this.selectedEntity = (EntityMovable) toSelect;
		}
	}

	private void unSelect() {
		this.selectedEntity = null;
	}

	private void attackCell(int x, int y) {

	}

	private void moveSelectedEntity(int x, int y) {

	}

	/**
	 * TODO implement the event triggers from {@link Input.class}
	 */
}
