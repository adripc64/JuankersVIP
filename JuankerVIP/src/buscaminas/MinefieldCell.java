package buscaminas;

public class MinefieldCell {
	
	private boolean hasMine;
	private int adjacentMines;
	private boolean selected;
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void setMine(boolean b) {
		hasMine = b;
	}
	
	public boolean hasMine() {
		return hasMine;
	}
	
	public void setAdjacentMines(int n) {
		adjacentMines = n;
	}
	
	public int getAjacentMines() {
		return adjacentMines;
	}

}
