package juankyBird;

import fge.App;
import fge.Color;
import fge.Event;
import fge.EventMan;
import fge.Render;
import fge.Service;
import fge.Window;

public class Game extends Service {
	
	private Pardal pardal;
	private float aceleracion;
	
	@Override
	public void onStart() {
		
		aceleracion = 0.0f;
		pardal = new Pardal();
		pardal.setAltura(Window.getH()/2.0f);
		
		EventMan.addListener(this);
	}
	
	@Override
	public void onStop() {
		
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
	public void onMove() {//constante descendente y implementacion de  onUp
	
		if(pardal.getAltura() >= 0){
			aceleracion += 750.0f * App.getFTime();
			if (aceleracion > 250) aceleracion = 250.0f;
			pardal.setAltura(pardal.getAltura() - aceleracion * App.getFTime());
		}
		if(pardal.getAltura() < 0){
			pardal.setAltura(0);
		}
		if(pardal.getAltura() > Window.getH()-64){
			pardal.setAltura(Window.getH()-64);
		}
	}

	@Override
	public void onDraw() {
		
		int w = pardal.getTextura().getW();
		int h = pardal.getTextura().getH();
		float x = (Window.getW() - w) / 2.0f;
		float y = Window.getH() - h - pardal.getAltura();
		
		Render.DrawTex(pardal.getTextura(), x, y, w, h, new Color(255, 255, 255));

	}
	
	public boolean doEvent(Event e) {
		
		if (e.getType() == Event.MOUSE_PRESSED || e.getType() == Event.KEY_PRESSED) {
			
			//int mx = Mouse.getX();
			//int my = Mouse.getY();
			
			// Ací es cuan li has de donar el empuje...
			aceleracion = -400.0f;
			
		}
		
		return false;
		
	}

}
