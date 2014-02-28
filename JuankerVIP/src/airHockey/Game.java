package airHockey;

import fge.Color;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service {
	
	private Texture texBackground;
	private Ball ball;
	
	
	
	@Override
	public void onStart() {
		// Inicializar variables
		ball = new Ball();
		
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
		int w = ball.getTex().getW();
		int h = ball.getTex().getH();
		float x = (Window.getW() / 2.0f) - (ball.getTex().getW() / 2);
		float y = (Window.getH() / 2.0f) - (ball.getTex().getH() / 2);
		Render.DrawTex(ball.getTex(), x, y, w, h, new Color(255, 255, 255));
		
	}

}
