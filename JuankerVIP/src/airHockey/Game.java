package airHockey;

import fge.Color;
import fge.Event;
import fge.EventListener;
import fge.EventMan;
import fge.Keyboard;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service implements EventListener {
	
	private Texture texBackground;
	private Ball ball;
	private Mazo mazo1;
//	private Mazo mazo2;
	
	
	@Override
	public void onStart() {
		// Fondo de pantalla
		texBackground = new Texture("PNG", "data/airhockey/campo.png");
		
		// Pelota
		ball = new Ball();
		ball.setxBall((Window.getW() / 2.0f) - (ball.getTex().getW() / 2));
		ball.setyBall((Window.getH() / 2.0f) - (ball.getTex().getH() / 2));
		
		// Mazo 1
		mazo1 = new Mazo();
		mazo1.setxMazo(Window.getW() / 4 - mazo1.getTex().getW() / 2);
		mazo1.setyMazo(Window.getH() / 2 - mazo1.getTex().getH() / 2);
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
		if(ball.getyBall() < 0) {					// Si se sale por la parte de ARRIBA de la pantalla
			// Debe rebotar...
		}
		if(ball.getyBall() > Window.getH()) {		// Si se sale por la parte de ABAJO de la pantalla
			// Debe rebotar...
		}
	}
	
	private void moveMazo1(){

		if(Keyboard.isKeyPressed(Keyboard.KEY_LEFT))
			mazo1.setxMazo(mazo1.getxMazo() - 5.0f);
		if(Keyboard.isKeyPressed(Keyboard.KEY_RIGHT))
			mazo1.setxMazo(mazo1.getxMazo() + 5.0f);
		
		if(mazo1.getxMazo() < 0)					// Si se sale por la parte izquierda de la pantalla
			mazo1.setxMazo(0);
		if(mazo1.getxMazo()+mazo1.getTex().getW() > Window.getW() / 2)	// Si se sale de su campo
			mazo1.setxMazo(Window.getW() / 2 - mazo1.getTex().getW());
		if(mazo1.getyMazo() < 0)					// Si se sale por la parte de ARRIBA de la pantalla
			mazo1.setyMazo(0);
		if(mazo1.getyMazo() > Window.getH())		// Si se sale por la parte de ABAJO de la pantalla
			mazo1.setyMazo(Window.getH());
	}

	@Override
	protected void onDraw() {
		// Dibujando fondo
		Render.DrawTex(texBackground, 0, 0, Window.getW(), Window.getH(), new Color(255, 255, 255));
		
		// Dibujando pelota
		int wB = ball.getTex().getW();
		int hB = ball.getTex().getH();
		float xB = (Window.getW() / 2.0f) - (ball.getTex().getW() / 2);
		float yB = (Window.getH() / 2.0f) - (ball.getTex().getH() / 2);
		Render.DrawTex(ball.getTex(), xB, yB, wB, hB, new Color(255, 255, 255));
		
		// Dibujando mazo 1
		int wM1 = mazo1.getTex().getW();
		int hM1 = mazo1.getTex().getH();
		float xM1 = mazo1.getxMazo();
		float yM1 = mazo1.getyMazo();
		Render.DrawTex(mazo1.getTex(), xM1, yM1, wM1, hM1, new Color(255, 255, 255));
	}
	
	public boolean doEvent(Event e){
		// TODO Auto-generated method stub
		return false;
	}

}
