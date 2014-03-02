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
	private Invader[][] invaders;
	private Bunker bunker;
	private int score = 0;
	private final int COLUMNS = 11;
	private final int ROWS = 5;
	private float invaderSpeedX = 1;
	private float invaderSpeedY = 5;
	private boolean invaderLimit = false;
	private int invadersNumber;

	private Texture textureBackground;

	private Font font;

	@Override
	protected void onStart() {

		startGeneral();
		startCannon();
		startInvaders();

	}

	private void startGeneral() {

		textureBackground = new Texture(
				"data/spaceInvaders/spaceBackground.png");
		cannon = new Cannon();
		cannon.setX(Window.getW() / 2 - cannon.getTexture().getW() / 2);
		cannon.setY(Window.getH() - cannon.getTexture().getH() - 20);
		font = new Font("data/spaceInvaders/daville.ttf", 30.0f);
		EventMan.addListener(this);

	}

	private void startCannon() {

		cannon = new Cannon();
		cannon.setX(Window.getW() / 2 - cannon.getTexture().getW() / 2);
		cannon.setY(Window.getH() - cannon.getTexture().getH() - 20);

	}

	private void startInvaders() {

		invaders = new Invader[COLUMNS][ROWS];
		Invader invader;
		int coordinateX = Window.getW() / (COLUMNS + 4);
		for (int column = 0; column < COLUMNS; column++) {
			for (int row = 0; row < ROWS; row++) {
				if (row == 0) {
					invader = new OctopusInvader();
				} else if (row == 1 || row == 2) {
					invader = new CrabInvader();
				} else {
					invader = new SquidInvader();
				}
				invader.setX(coordinateX * column + 20);
				invader.setY(120 + row * 50);
				invaders[column][row] = invader;
			}
		}
		invadersNumber = COLUMNS*ROWS;
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
		physicsInvaders();

	}

	private void physicsCannon() {

		if (Keyboard.isKeyPressed(Keyboard.KEY_LEFT)) {
			cannon.setX(cannon.getX() - 5);
		}
		if (Keyboard.isKeyPressed(Keyboard.KEY_RIGHT)) {
			cannon.setX(cannon.getX() + 5);
		}
		if (cannon.getX() < 0) {
			cannon.setX(0);
		}
		if (cannon.getX() > Window.getW() - cannon.getTexture().getW()) {
			cannon.setX(Window.getW() - cannon.getTexture().getW());
		}

	}

	private void physicsInvaders() {
		Invader invader;
		invader = invaders[0][0];
		if (invader.getX() < 40) {
			invaderSpeedX = 1;
			invaderLimit = true;
		}
		invader = invaders[COLUMNS - 1][ROWS - 1];
		if (invader.getX() + invader.getTexture().getW() > Window.getW() - 40) {
			invaderSpeedX = -1;
			invaderLimit = true;
		}

		for (int column = 0; column < COLUMNS; column++) {
			for (int row = 0; row < ROWS; row++) {
				invader = invaders[column][row];
				invader.setX(invader.getX() + invaderSpeedX);
				if (invaderLimit) {
					if(invader.getY()>Window.getH()) invadersNumber=0; //Eliminar
					invader.setY(invader.getY() + invaderSpeedY);
				}
			}
		}
		invaderLimit = false;
		if(invadersNumber==0){
			startInvaders();
		}
	}

	@Override
	protected void onDraw() {

		drawGeneral();
		drawCannon();
		drawInvaders();

	}

	private void drawGeneral() {
		Render.DrawTexture(textureBackground, 0, 0, Window.getW(), Window.getH(), 0,
				new Color(255, 255, 255));
		Render.DrawText(font, 30, 16, "Score: " + score, new Color(0, 255, 0));

		Render.DrawText(font, Window.getW() - 150, 16,
				"Lives: " + cannon.getLives(), new Color(0, 255, 0));
	}

	private void drawCannon() {
		Texture cannonTexture = cannon.getTexture();
		float cannonX = cannon.getX();
		float cannonY = cannon.getY();
		int cannonW = cannon.getTexture().getW();
		int cannonH = cannon.getTexture().getH();
		Render.DrawTexture(cannonTexture, cannonX, cannonY, cannonW, cannonH, 0,
				new Color(255, 255, 255));
	}

	private void drawInvaders() {

		Texture invaderTexture;
		float invaderX;
		float invaderY;
		int invaderW;
		int invaderH;
		Invader invader;
		for (int column = 0; column < COLUMNS; column++) {
			for (int row = 0; row < ROWS; row++) {
				invader = invaders[column][row];
				invaderTexture = invader.getTexture();
				invaderX = invader.getX();
				invaderY = invader.getY();
				invaderW = invaderTexture.getW();
				invaderH = invaderTexture.getH();
				Render.DrawTexture(invaderTexture, invaderX, invaderY, invaderW, 0,
						invaderH, new Color(255, 255, 255));
			}
		}

	}

	@Override
	public boolean doEvent(Event e) {
		// TODO Auto-generated method stub
		return false;
	}

}
