package reversi;

import reversi.Board.PieceColor;

public class Player {
	
	private String name;
	private PieceColor color;
	private boolean isHuman;
	
	public Player(String name, PieceColor color, boolean isHuman) {
		this.name = name;
		this.color = color;
		this.isHuman = isHuman;
	}
	
	public String getName() { return name; }
	public PieceColor getColor() { return color; }
	public boolean isHuman() { return isHuman; }
	
	public int calcMove(Board board) {
		return 0;
	}
	
	public void chooseLegalMove(Board board) {
		/*for (int i = 0; i < board.getc)
		System.out.println("Cell: " + i + " -> " + p);*/
	}
	
}
