package reversi;

import java.util.LinkedList;

import reversi.Board.Direction;

import fge.Color;
import fge.Render;

public class Cell {

	public enum CellState {
		EMPTY, BLACK, WHITE;
	}

	private CellState state = CellState.EMPTY;
	private LinkedList<Direction> flipDirections = new LinkedList<Direction>();
	
	public Cell() {
		
	}
	
	public Cell(Cell otherCell) {
		state = otherCell.state;
		flipDirections = new LinkedList<Direction>();
		flipDirections.addAll(otherCell.flipDirections);
	}
	
	public CellState getState() { return state; }
	public void setState(CellState cellState) {	state = cellState; }
	
	public LinkedList<Direction> getFlipDirections() { return flipDirections; }
	public void setFlipDirections(LinkedList<Direction> flipDirections) { this.flipDirections = flipDirections; }
	
	public boolean isValidMove() { return (flipDirections.size() > 0); }
	
	
	public void flip() {
		if (state == CellState.BLACK) state = CellState.WHITE;
		else if (state == CellState.WHITE) state = CellState.BLACK;
	}
	
	
	public void Draw(float x, float y) {
		if (state == CellState.BLACK)
			Render.DrawFilledCircle(x, y, 28, new Color(0,0,0));
		else if (state == CellState.WHITE)
			Render.DrawFilledCircle(x, y, 28, new Color(255,255,255));
		else if (state == CellState.EMPTY && flipDirections.size() > 0)
			Render.DrawFilledCircle(x, y, 16, new Color(255,0,0));
	}
}
