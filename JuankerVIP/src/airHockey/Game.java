package airHockey;

import fge.App;
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
	private Font font;
	private Texture texBackground;
	private Ball ball;
	private Mazo mazo1;
	private Mazo mazo2;
	private float acceleracionX;
	private float acceleracionY;
	
	@Override
	public void onStart() {
		
		acceleracionX = 0.0f;
		acceleracionY = 0.0f;
		font = new Font("data/COMIC.ttf", 48.0f);
		
		// Fondo de pantalla
		texBackground = new Texture("data/airhockey/campo.png");
		
		// Pelota
		ball = new Ball();
		ball.setxBall((Window.getW() / 2.0f) - (ball.getTex().getW() / 2));
		ball.setyBall((Window.getH() / 2.0f) - (ball.getTex().getH() / 2));
		
		// Mazo 1
		mazo1 = new Mazo();
		mazo1.setxMazo(Window.getW() / 4.0f - mazo1.getTex().getW() / 2);
		mazo1.setyMazo(Window.getH() / 2.0f - mazo1.getTex().getH() / 2);
		
		
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
		// Movimiento de la pelota
		moveBall();
		
		// Movimiento del mazo 1
		moveMazo1();
	}
	
	private void moveBall(){
		if(ball.getyBall() < 0) {										// Parte de ARRIBA de la pantalla
			// Debe rebotar...
		}
		if(ball.getyBall() > Window.getH() - ball.getTex().getH()) {	// Parte de ABAJO de la pantalla
			// Debe rebotar...
		}
		if(ball.getxBall() - ball.getTex().getW() > Window.getW()) {	// Parte DERECHA de la pantalla
			ball.setxBall(Window.getW() - ball.getTex().getW());
			acceleracionX = 0.0f;
		}
		if(ball.getxBall() < 0)	{										// Parte IZQUIERDA de la pantalla
			ball.setxBall(0);
			acceleracionX = 0.0f;
		}
		
		// Choca el mazo 1 con la pelota por la DERECHA
		if( mazo1.getxMazo() == (ball.getxBall() - (ball.getTex().getW() / 2)) )
			acceleracionX = 250.0f;

		// Moviendo la pelota
		ball.setxBall(ball.getxBall() + acceleracionX * App.getFTime());	// Componente X
		ball.setyBall(ball.getyBall() + acceleracionY * App.getFTime());	// Componente Y
	}
	
	private void moveMazo1(){

		if(Keyboard.isKeyPressed(Keyboard.KEY_LEFT))
			mazo1.setxMazo(mazo1.getxMazo() - 5.0f);
		if(Keyboard.isKeyPressed(Keyboard.KEY_RIGHT))
			mazo1.setxMazo(mazo1.getxMazo() + 5.0f);
		if(Keyboard.isKeyPressed(Keyboard.KEY_UP))
			mazo1.setyMazo(mazo1.getyMazo() - 5.0f);
		if(Keyboard.isKeyPressed(Keyboard.KEY_DOWN))
			mazo1.setyMazo(mazo1.getyMazo() + 5.0f);
		
		if(mazo1.getxMazo() < 0)										// Parte izquierda de la pantalla
			mazo1.setxMazo(0);
		if(mazo1.getxMazo() + mazo1.getTex().getW() > Window.getW()/2)	// Si se sale de su CAMPO
			mazo1.setxMazo(Window.getW() / 2 - mazo1.getTex().getW());
		if(mazo1.getyMazo() < 0)										// Parte de ARRIBA de la pantalla
			mazo1.setyMazo(0);
		if(mazo1.getyMazo() > Window.getH() - mazo1.getTex().getH())	// Si se sale por la parte de ABAJO de la pantalla
			mazo1.setyMazo(Window.getH() - mazo1.getTex().getH());
	}

	@Override
	protected void onDraw() {
		// Dibujando fondo
		Render.DrawTexture(texBackground, 0, 0, Window.getW(), Window.getH(), 0, new Color(255, 255, 255));
		
		// Dibujando pelota
		int wB = ball.getTex().getW();
		int hB = ball.getTex().getH();
		float xB = ball.getxBall();
		float yB = ball.getyBall();
		Render.DrawTexture(ball.getTex(), xB, yB, wB, hB, 0, new Color(255, 255, 255));
		
		// Dibujando mazo 1
		int wM1 = mazo1.getTex().getW();
		int hM1 = mazo1.getTex().getH();
		float xM1 = mazo1.getxMazo();
		float yM1 = mazo1.getyMazo();
		Render.DrawTexture(mazo1.getTex(), xM1, yM1, wM1, hM1, 0, new Color(255, 255, 255));
		
		// Dibujando marcador
		Render.DrawText(font, (Window.getW() / 2) - 52, 10, mazo1.getGoles() + " - " + "0", 
				new Color(255, 255, 255));
	}
	
	public boolean doEvent(Event e){
		// TODO Auto-generated method stub
		return false;
	}

}
