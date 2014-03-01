package spaceInvaders;


import fge.Color;
import fge.Event;
import fge.EventListener;
import fge.EventMan;
import fge.Font;
import fge.Keyboard;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service implements EventListener {

	private Cannon cannon;
	private Invader invader;
	private Bunker bunker;
	private int score = 0;

	private Texture textureBackground;
	
	private Font font;

	@Override
	protected void onStart() {
		textureBackground = new Texture("data/spaceInvaders/spaceBackground.png");
		cannon = new Cannon();
		cannon.setX(Window.getW() / 2 - cannon.getTextura().getW() / 2);
		cannon.setY(Window.getH()-cannon.getTextura().getH()-20);
		font = new Font("data/spaceInvaders/daville.ttf", 30.0f);
		EventMan.addListener(this);
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
		
		physicsCannon();

	}

	private void physicsCannon() {
		if(Keyboard.isKeyPressed(Keyboard.KEY_LEFT)){
			cannon.setX(cannon.getX()-5);
		}
		if(Keyboard.isKeyPressed(Keyboard.KEY_RIGHT)){
			cannon.setX(cannon.getX()+5);
		}
		if(cannon.getX()<0){
			cannon.setX(0);
		}
		if(cannon.getX()>Window.getW()-cannon.getTextura().getW()){
			cannon.setX(Window.getW()-cannon.getTextura().getW());
		}
	}

	@Override
	protected void onDraw() {

		Render.DrawTex(textureBackground, 0, 0, Window.getW(), Window.getH(),
				new Color(255, 255, 255));

		Texture cannonTexture = cannon.getTextura();
		float cannonX = cannon.getX();
		float cannonY = cannon.getY();
		int cannonW = cannon.getTextura().getW();
		int cannonH = cannon.getTextura().getH();
		Render.DrawTex(cannonTexture, cannonX, cannonY, cannonW, cannonH,
				new Color(255, 255, 255));

		Render.DrawText(font, 30, 16, "Score: " + score, new Color(0,255,0));
		Render.DrawText(font, Window.getW()-150, 16, "Lives: " + cannon.getLives(), new Color(0,255,0));
	}

	@Override
	public boolean doEvent(Event e) {
		// TODO Auto-generated method stub
		return false;
	}

}
