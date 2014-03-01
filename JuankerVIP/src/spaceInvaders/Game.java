package spaceInvaders;

import java.util.LinkedList;

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
	private LinkedList<Invader>[] invaders;
	private Bunker bunker;
	private int score = 0;
	private final int COLUMNS = 11;
	private final int ROWS = 1;

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

	@SuppressWarnings("unchecked")
	private void startInvaders() {

		invaders = (LinkedList<Invader>[]) new Object[COLUMNS];
		for (int column = 0; column < invaders.length; column++) {
			invaders[column] = new LinkedList<Invader>();
			Invader invader;
			for (int row = 0; row < ROWS; row++) {
				invader = new CrabInvader();
				invader.setX((Window.getW() / (COLUMNS + 4)) * column + 20);
				invader.setY(50 + row * 100);
				invaders[column].add(new CrabInvader());
			}
		}

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
		int speedX = 1;
		float speedY = 1;

		if (invaders[0].get(0).getX() < 5) {
			speedX = 1;
		}
		if (invaders[10].get(0).getX() > Window.getW() - 5) {
			speedX = -1;
		}
		for (int i = 0; i < invaders.length; i++) {
			for (Invader invader : invaders[i]) {
				invader.setX(invader.getX() + speedX);
			}
		}
	}

	@Override
	protected void onDraw() {

		Render.DrawTexture(textureBackground, 0, 0, Window.getW(), Window.getH(), 0,
				new Color(255, 255, 255));

		Texture cannonTexture = cannon.getTexture();
		float cannonX = cannon.getX();
		float cannonY = cannon.getY();
		int cannonW = cannon.getTexture().getW();
		int cannonH = cannon.getTexture().getH();
		Render.DrawTexture(cannonTexture, cannonX, cannonY, cannonW, cannonH, 0,
				new Color(255, 255, 255));

		Render.DrawText(font, 30, 16, "Score: " + score, new Color(0, 255, 0));

		Render.DrawText(font, Window.getW() - 150, 16,
				"Lives: " + cannon.getLives(), new Color(0, 255, 0));
		drawInvaders();
	}

	private void drawInvaders() {

		Texture invaderTexture;
		float invaderX;
		float invaderY;
		int invaderW;
		int invaderH;
		for (int i = 0; i < invaders.length; i++) {
			for (Invader invader : invaders[i]) {
				invaderTexture = invader.getTexture();
				invaderX = invader.getX();
				invaderY = invader.getY();
				invaderW = invaderTexture.getW();
				invaderH = invaderTexture.getH();
				Render.DrawTexture(invaderTexture, invaderX, invaderY, invaderW, 0,
						invaderH, new Color(0, 0, 255));
			}
		}

	}

	@Override
	public boolean doEvent(Event e) {
		// TODO Auto-generated method stub
		return false;
	}

}
