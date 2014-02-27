package buscaminas;

import fge.Color;
import fge.Font;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service {

	private Font font;
	private Board board;
	private Texture texBackground;

	private Minefield minefield;

	public void onStart() {

		texBackground = new Texture("PNG", "data/grey_wash_wall512.png");
		board = new Board(10, 10);
		minefield = new Minefield(16, 16, 20);
		System.out.println(minefield);
		font = new Font("data/COMIC.ttf", 48.0f);
	}

	public void onDraw() {
		Render.DrawTex(texBackground, 0, 0, Window.getW(), Window.getH(),
				new Color(255, 255, 255), 0, 0, 800 / 350.f, 600 / 259.f);
		board.draw();
		font.Draw(16, 16, "Buscaminas", new Color(255, 255, 0));
	}
}
