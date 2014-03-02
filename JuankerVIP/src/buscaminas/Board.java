package buscaminas;

import fge.Color;
import fge.Render;
import fge.Texture;

public class Board {

	private Texture celdaNoPulsada = new Texture("data/piece_white64.png");
	// private Texture celdaPulsada;
	// private Texture mina;
	int boardCells;
	int xCells;
	int yCells;
	int x;
	int y;

	public Board(int x, int y) {
		xCells = x;
		yCells = y;
		boardCells = x * y;
	}

	public void draw() {
		for (int i = 0; i < xCells; i++) {
			x = i * 64;
			for (int j = 0; j < yCells; j++) {
				y = j * 64;
				Render.DrawTexture(celdaNoPulsada, x, y, 64, 64, 0, new Color(255,
						255, 255));
			}
		}

	}
}
