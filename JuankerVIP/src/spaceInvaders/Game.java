package spaceInvaders;


import fge.Color;
import fge.Event;
import fge.EventMan;
import fge.Font;
import fge.Keyboard;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service {

	private Cannon cannon;
	private Invader invader;
	private Bunker bunker;

	private Texture textureBackground;
	
	private Font font;

	@Override
	protected void onStart() {
		textureBackground = new Texture("PNG",
				"data/spaceInvaders/spaceBackground.png");
		cannon = new Cannon();
		cannon.setX(Window.getW() / 2 - cannon.getTextura().getW() / 2);
		font = new Font("data/spaceInvaders/daville.ttf", 48.0f);
		EventMan.addListener(this); // No se pa k val
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
	protected void onDraw() {

		Render.DrawTex(textureBackground, 0, 0, Window.getW(), Window.getH(),
				new Color(255, 255, 255));

		Texture cannonTexture = cannon.getTextura();
		float cannonX = cannon.getX();
		float cannonY = 20;
		int cannonW = cannon.getTextura().getW();
		int cannonH = cannon.getTextura().getH();
		Render.DrawTex(cannonTexture, cannonX, cannonY, cannonW, cannonH,
				new Color(255, 255, 255));

		font.Draw(16, 16, "Lives: " + cannon.getLives(), new Color(255,0,0));
	}

	public boolean doEvent(Event e) {
		if (e.getValue() == Keyboard.KEY_LEFT) {
			
		}
		if (e.getValue() == Keyboard.KEY_RIGHT) {

		}
		if (e.getValue() == Keyboard.KEY_SPACE) {

		}
		return false;
	}

}
