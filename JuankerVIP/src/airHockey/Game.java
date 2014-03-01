package airHockey;

import fge.Color;
import fge.Event;
import fge.Event.EventType;
import fge.App;
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
	private Mazo mazo2;
	
	
	@Override
	public void onStart() {
		// Inicializar variables
		ball = new Ball();
		mazo1 = new Mazo();
		
		texBackground = new Texture("PNG", "data/airhockey/campo.png");
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
		if(ball.getyBall() < 0) {					// Si se sale por la parte de ARRIBA de la pantalla
			// Debe rebotar
		}
		if(ball.getyBall() > Window.getH()) {		// Si se sale por la parte de ABAJO de la pantalla
			// Debe rebotar
		}
		
		// Movimiento del mazo
		if(mazo1.getxMazo() < 0)					// Si se sale por la parte izquierda de la pantalla
			mazo1.setxMazo(0);
		if(mazo1.getxMazo() > Window.getW() / 2)	// Si se sale de su campo
			mazo1.setxMazo(Window.getW() / 2);
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
		float xM1 = (Window.getW() / 4.0f) - (mazo1.getTex().getW() / 2);
		float yM1 = (Window.getH() / 2.0f) - (mazo1.getTex().getH() / 2);
		Render.DrawTex(mazo1.getTex(), xM1, yM1, wM1, hM1, new Color(255, 255, 255));
		
	}
	
	public boolean doEvent(Event e){
		
		if (e.getType() == EventType.KEY_PRESSED) {
			
		 	if (e.getValue() == Keyboard.KEY_LEFT) {
		 		mazo1.setxMazo(mazo1.getxMazo() - 100);
		 	}
		}
		
		return false;
	}

}
