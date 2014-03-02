package buscaminas;

import fge.Color;
import fge.Font;
import fge.Render;
import fge.Texture;
import fge.Window;

public class Minefield {

	private int rows;
	private int cols;
	private int mines;
	private int x;
	private int y;
	private Texture celdaNoPulsada = new Texture(
			"data/buscaminas/noseleccionado.png");
	private Texture celdaPulsada = new Texture(
			"data/buscaminas/seleccionado.png");
	private Texture mina = new Texture("data/buscaminas/mina.png");
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
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				if (i >= 0 && i < rows && j >= 0 && j < cols
						&& field[i][j].hasMine())
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
				if (field[i][j].hasMine())
					sb.append("*|");
				else {
					int adjacentMines = field[i][j].getAjacentMines();
					if (adjacentMines > 0)
						sb.append(adjacentMines + "|");
					else
						sb.append(" |");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public void draw() {
		for (int i = 0; i < rows; i++) {
			x = i * 64;
			for (int j = 0; j < cols; j++) {
				y = j * 64 + 64;
				pintar(i, j, x, y);

			}
		}
	}

	private void pintar(int i, int j, int x, int y) {
		if (field[i][j].isSelected() && field[i][j].hasMine()) {
			Render.DrawTexture(mina, x, y, 64, 64, 0, new Color(255, 255, 255));
		} else {
			if (field[i][j].isSelected()) {
				Render.DrawTexture(celdaPulsada, x, y, 64, 64, 0, new Color(
						255, 255, 255));
				int adjacent = field[i][j].getAjacentMines();
				if (adjacent > 0) {
					Render.DrawText(new Font("data/COMIC.ttf", 48.0f), x + 16,
							y + 8, Integer.toString(adjacent), new Color(0, 0,
									0));
				} else {
					propagar(i, j);
				}
			} else {

				Render.DrawTexture(celdaNoPulsada, x, y, 64, 64, 0, new Color(
						255, 255, 255));
			}
		}

	}

	private void propagar(int x, int y) {
		for (int i = x - 1; i < x + 1 && i > 0 && i < rows; i++) {
			for (int j = y - 1; j < (y + 1) && j > 0 && j < cols; j++) {
				if (field[i][j].getAjacentMines() == 0) {
					pintar(i, j, i * 64, j * 64 + 64);
				}
			}
		}
	}

	public MinefieldCell[][] getField() {
		return field;
	}

	public void setField(MinefieldCell[][] field) {
		this.field = field;
	}

}
