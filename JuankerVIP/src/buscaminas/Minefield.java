package buscaminas;

public class Minefield {
	
	private int rows;
	private int cols;
	private int mines;
	private MinefieldCell[][] field;
	
	public Minefield(int rows, int cols, int mines) {
		this.rows = rows;
		this.cols = cols;
		this.mines = mines;
		
		generateField();
	}
	
	private void generateField() {
		
		field = new MinefieldCell[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				field[i][j] = new MinefieldCell();
		
		for (int i = 0; i < mines; i++) {
			
			int row = (int) (Math.random() * rows);
			int col = (int) (Math.random() * cols);
			
			while (field[row][col].hasMine()) {
				row = (int) (Math.random() * rows);
				col = (int) (Math.random() * cols);
			}
			
			field[row][col].setMine(true);
			
		}
		
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				field[i][j].setAdjacentMines(countAdjacentMines(i, j));
		
	}
	
	private int countAdjacentMines(int row, int col) {
		int adjacentMines = 0;
		for (int i = row-1; i <= row+1; i++) {
			for (int j = col-1; j <= col+1; j++) {
				if (i >= 0 && i < rows && j >= 0 && j < cols && field[i][j].hasMine())
					adjacentMines++;
			}
		}
		return adjacentMines;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			sb.append("|");
			for (int j = 0; j < cols; j++) {
				if (field[i][j].hasMine()) sb.append("*|");
				else {
					int adjacentMines = field[i][j].getAjacentMines();
					if (adjacentMines > 0) sb.append(adjacentMines+"|");
					else sb.append(" |");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
