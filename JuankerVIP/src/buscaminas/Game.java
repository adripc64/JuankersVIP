package buscaminas;

import org.lwjgl.input.Mouse;

import fge.Color;
import fge.Event;
import fge.Event.EventType;
import fge.EventListener;
import fge.EventMan;
import fge.Font;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service implements EventListener {

	private Font font;
	private Texture texBackground;

	private Minefield minefield;

	@Override
	public void onStart() {
		EventMan.addListener(this);
		texBackground = new Texture("data/grey_wash_wall512.png");

		minefield = new Minefield(10, 10, 20);
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
		Render.DrawTexture(texBackground, 0, 0, Window.getW(), Window.getH(),
				0, new Color(255, 255, 255), 0, 0, 800 / 350.f, 600 / 259.f);
		minefield.draw();
		Render.DrawText(font, Window.getW() / 3, 0, "Buscaminas", new Color(
				255, 255, 0));
	}

	@Override
	public boolean doEvent(Event e) {
		int x, y;
		if (e.getType() == EventType.MOUSE_PRESSED) {
			x = Mouse.getX() / 64;
			y = (Window.getH() - Mouse.getY() - 64) / 64;
			MinefieldCell[][] matriz = minefield.getField();
			if(matriz[x][y].hasMine()){
				
			}
			if(!matriz[x][y].isSelected()){
				matriz[x][y].setSelected(true);
			}
		}
		return false;
	}
}
