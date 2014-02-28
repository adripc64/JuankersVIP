package airHockey;

import fge.Color;
import fge.Event;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service {
	
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
		float xM1 = (Window.getW() / 4.0f);
		float yM1 = (Window.getH() / 2.0f) - (ball.getTex().getH() / 2);
		Render.DrawTex(mazo1.getTex(), xM1, yM1, wM1, hM1, new Color(255, 255, 255));
		
	}
	
	public boolean doEvent(Event e){
		
//		Adrian Puertas Cabedo	18:48
//		if (e.getType() == Event.KEY_PRESSED) {
//		 	if (e.getValue() == Keyboard.KEY_LEFT) {
//		   
//		 	}
//		}
		
		return true;
	}

}
