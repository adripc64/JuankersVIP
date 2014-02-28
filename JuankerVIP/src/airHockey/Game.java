package airHockey;

import fge.Color;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service {
	
	private Texture texBackground;
	
	@Override
	public void onStart() {
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
		Render.DrawTex(texBackground, 0, 0, Window.getW(), Window.getH(),
				new Color(255, 255, 255));
		
	}

}
