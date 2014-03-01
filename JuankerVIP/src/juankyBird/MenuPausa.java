package juankyBird;

import fge.Color;
import fge.Event;
import fge.EventListener;
import fge.Mouse;
import fge.Render;
import fge.Service;
import fge.ServiceMan;
import fge.Texture;
import fge.Window;
import fge.Event.EventType;

public class MenuPausa extends Service implements EventListener {
	private Texture texReini;
	
	public MenuPausa() {
		texReini = new Texture("PNG", "data/piece_white.png");
	}
	
	@Override
	public void onStart() {
		
	}

	@Override
	public boolean doEvent(Event e) {
		if (!isRunning()) return false;
		if (e.getType() == EventType.MOUSE_PRESSED) {

			int mx = Mouse.getX();
			int my = Mouse.getY();
			if(mx>=Window.getW()/2&&mx<Window.getW()-30 && my>=Window.getH()/2 && my<Window.getH()+30 ){
				stop();
				// Aquí lo que vullges que pase quan fas click al boto... reiniciar el joc per exemple?
			}

		}
		return false;
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPause() {
		
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMove() {
		
	}

	@Override
	protected void onDraw() {
		Render.DrawTex(texReini, Window.getW()/2, Window.getH()/2, 30, 30, new Color(255, 255, 255));
		
	}
}
