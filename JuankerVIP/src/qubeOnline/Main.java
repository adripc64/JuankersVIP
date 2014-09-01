package qubeOnline;

import fge.App;
import fge.Color;
import fge.Event;
import fge.EventListener;
import fge.EventMan;
import fge.Keyboard;
import fge.Render;
import fge.Service;
import fge.Window;

public class Main extends Service implements EventListener {
	
	final float horizontalSpeed = 300.0f;
	final float jumpSpeed = 600.0f;
	final float gravity = 1200.0f;
		
	float playerX = 100;
	float playerY = 300;
	int playerW = 50;
	int playerH = 50;
	Color playerColor = new Color(0, 255, 0);
	float playerSpeedX = 0.0f;
	float playerSpeedY = 0.0f;
	boolean playerFalling = true;
	
	float groundX = 0;
	float groundY = 600;
	int groundW = 600;
	int groundH = 10;
	Color groundColor = new Color(0, 255, 0);
	
	public static void main(String[] args) {
		App.run(new Main(), 600, 800);
	}

	@Override
	protected void onStart() {
		EventMan.addListener(this);
	}

	@Override
	protected void onStop() {
		
	}

	@Override
	protected void onPause() {
		
	}

	@Override
	protected void onResume() {
		
	}

	@Override
	protected void onMove() {
		
		// Gravedad
		if (playerFalling) playerSpeedY += gravity * App.getFTime();
		
		playerX += playerSpeedX * App.getFTime(); // Movimiento horizontal
		playerY += playerSpeedY * App.getFTime(); // Movimiento vertical

		// Evita que se salga por los laterales de la ventana
		if (playerX < 0) playerX = 0;
		if (playerX + playerW > Window.getW()) playerX = Window.getW() - playerW;
		// Evita que pase del suelo
		if (playerY + playerH > groundY) {
			playerY = groundY - playerH;
			playerSpeedY = 0.0f;
			playerFalling = false;
		}
		
	}


	@Override
	protected void onDraw() {
		Render.DrawFilledRectangle(playerX, playerY, playerW, playerH, playerColor);
		Render.DrawFilledRectangle(groundX, groundY, groundW, groundH, groundColor);
	}

	@Override
	public boolean doEvent(Event e) {

		switch (e.getType()) {
			case KEY_PRESSED:
				if (e.getValue() == Keyboard.KEY_LEFT) playerSpeedX -= horizontalSpeed;
				if (e.getValue() == Keyboard.KEY_RIGHT) playerSpeedX += horizontalSpeed;
				if (e.getValue() == Keyboard.KEY_UP && !playerFalling) {
					playerFalling = true;
					playerSpeedY -= jumpSpeed; 
				}
				break;
			case KEY_RELEASED:
				if (e.getValue() == Keyboard.KEY_LEFT) playerSpeedX += horizontalSpeed;
				if (e.getValue() == Keyboard.KEY_RIGHT) playerSpeedX -= horizontalSpeed;
				break;
			default:
				break;
		}
		
		return false;
	}

}
