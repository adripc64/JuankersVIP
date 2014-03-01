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

	@Override
	public void onStart() {

		texBackground = new Texture("data/grey_wash_wall512.png");
		board = new Board(10, 10);
		minefield = new Minefield(16, 16, 20);
		System.out.println(minefield);
		font = new Font("data/COMIC.ttf", 48.0f);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMove() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onDraw() {
		Render.DrawTexture(texBackground, 0, 0, Window.getW(), Window.getH(), 0,
				new Color(255, 255, 255), 0, 0, 800 / 350.f, 600 / 259.f);
		board.draw();
		Render.DrawText(font, 16, 16, "Buscaminas", new Color(255, 255, 0));
	}
}
