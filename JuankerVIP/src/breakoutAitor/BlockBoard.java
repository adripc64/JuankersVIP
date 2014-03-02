package breakoutAitor;

import fge.Color;
import fge.Render;
import fge.Texture;

public class BlockBoard {
	
	int totalBlocks;
	int xBlocks;
	int yBlocks;
	int x;
	int y;
	private Texture texturaBloque = new Texture("data/blockBreakOut.png");

	public BlockBoard(int x, int y) {
		xBlocks = x;
		yBlocks = y;
		totalBlocks = x * y;
	}

	public void draw() {
		for (int i = 0; i < xBlocks; i++) {
			x = i * 64;
			for (int j = 0; j < yBlocks; j++) {
				y = j * 64;
				Render.DrawTexture(texturaBloque, x, y, 64, 64, 0, new Color(255,255,255));
			}
		}

	}
}
